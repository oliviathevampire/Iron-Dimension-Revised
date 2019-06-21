package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.registry.BlocksID;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.FabricItemTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowerFeature;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;
import java.util.Random;

public class BlockIronDirt extends Block implements Fertilizable {
    public BlockIronDirt() {
        super(FabricBlockSettings
                .of(Material.EARTH, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.SHOVELS, 2)
                .sounds(BlockSoundGroup.GRASS)
                .hardness(0.5F)
                .build());
    }

    @Overwrite
    public boolean isFertilizable(BlockView blockView_1, BlockPos blockPos_1, BlockState blockState_1, boolean boolean_1) {
        return blockView_1.getBlockState(blockPos_1.up()).isAir();
    }

    @Overwrite
    public boolean canGrow(World world_1, Random random_1, BlockPos blockPos_1, BlockState blockState_1) {
        return true;
    }

    @Override
    public void grow(World world_1, Random random_1, BlockPos blockPos_1, BlockState blockState_1) {
        BlockPos blockPos_2 = blockPos_1.up();
        BlockState blockState_2 = BlocksID.iron_grass.getDefaultState();

        label48:
        for(int int_1 = 0; int_1 < 128; ++int_1) {
            BlockPos blockPos_3 = blockPos_2;

            for(int int_2 = 0; int_2 < int_1 / 16; ++int_2) {
                blockPos_3 = blockPos_3.add(random_1.nextInt(3) - 1, (random_1.nextInt(3) - 1) * random_1.nextInt(3) / 2, random_1.nextInt(3) - 1);
                if (world_1.getBlockState(blockPos_3.down()).getBlock() != this || isShapeFullCube(world_1.getBlockState(blockPos_3).getCollisionShape(world_1, blockPos_3))) {
                    continue label48;
                }
            }

            BlockState blockState_3 = world_1.getBlockState(blockPos_3);
            if (blockState_3.getBlock() == blockState_2.getBlock() && random_1.nextInt(10) == 0) {
                ((Fertilizable)blockState_2.getBlock()).grow(world_1, random_1, blockPos_3, blockState_3);
            }

            if (blockState_3.isAir()) {
                BlockState blockState_5;
                if (random_1.nextInt(8) == 0) {
                    List<ConfiguredFeature<?>> list_1 = world_1.getBiome(blockPos_3).getFlowerFeatures();
                    if (list_1.isEmpty()) {
                        continue;
                    }

                    blockState_5 = ((FlowerFeature)((DecoratedFeatureConfig)((ConfiguredFeature)list_1.get(0)).config).feature.feature).getFlowerToPlace(random_1, blockPos_3);
                } else {
                    blockState_5 = blockState_2;
                }

                if (blockState_5.canPlaceAt(world_1, blockPos_3)) {
                    world_1.setBlockState(blockPos_3, blockState_5, 3);
                }
            }
        }
    }
}
