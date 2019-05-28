package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.registry.BlocksID;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.FabricItemTags;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.Random;

public class BlockIronGrass extends Block {
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
}
