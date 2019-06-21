package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.registry.BlocksID;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowerFeature;

import java.util.List;
import java.util.Random;

public class BlockIronGrass extends GrassBlock {
    public BlockIronGrass() {
        super(FabricBlockSettings
                .of(Material.PLANT, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricToolTags.SHOVELS, 2)
                .sounds(BlockSoundGroup.GRASS)
                .hardness(0.5F)
                .ticksRandomly()
                .build());
    }

    @Override
    public void randomDisplayTick(BlockState blockState_1, World world, BlockPos pos, Random rand) {
        if (!world.isClient)
            if (world.getLightLevel(LightType.BLOCK,pos.up()) < 4 && world.getBlockState(pos.up()).getBlock().getLightSubtracted(world.getBlockState(pos.up()), world, pos.up()) > 2)
                world.setBlockState(pos, BlocksID.iron_dirt.getDefaultState());
            else if (world.getLightLevel(LightType.BLOCK,pos.up()) >= 9)
                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    Block block = world.getBlockState(blockpos.up()).getBlock();
                    BlockState iblockstate = world.getBlockState(blockpos);

                    if (iblockstate.getBlock() == BlocksID.iron_dirt && world.getLightLevel(LightType.BLOCK,blockpos.up()) >= 4 && block.getLightSubtracted(world.getBlockState(blockpos.up()), world, blockpos.up()) <= 2)
                        world.setBlockState(blockpos, BlocksID.iron_grass.getDefaultState());
                }
    }

    @Override
    public void grow(World world_1, Random random_1, BlockPos blockPos_1, BlockState blockState_1) {
        BlockPos blockPos_2 = blockPos_1.up();

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

            if (blockState_3.isAir()) {
                BlockState blockState_5;
                if (random_1.nextInt(8) == 0) {
                    List<ConfiguredFeature<?>> list_1 = world_1.getBiome(blockPos_3).getFlowerFeatures();
                    if (list_1.isEmpty()) {
                        continue;
                    }

                    blockState_5 = ((FlowerFeature)((DecoratedFeatureConfig)((ConfiguredFeature)list_1.get(0)).config).feature.feature).getFlowerToPlace(random_1, blockPos_3);
                } else {
                    continue;
                }

                if (blockState_5.canPlaceAt(world_1, blockPos_3)) {
                    world_1.setBlockState(blockPos_3, blockState_5, 3);
                }
            }
        }
    }
}
