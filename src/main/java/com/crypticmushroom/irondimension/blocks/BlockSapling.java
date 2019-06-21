package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.registry.BlocksID;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSapling extends SaplingBlock {

    public BlockSapling(SaplingGenerator saplingGenerator_1) {
        super(saplingGenerator_1, FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).build());
    }

    @Override
    protected boolean canPlantOnTop(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        Block block_1 = blockState_1.getBlock();
        return block_1 == Blocks.GRASS_BLOCK || block_1 == Blocks.DIRT || block_1 == Blocks.COARSE_DIRT || block_1 == Blocks.PODZOL || block_1 == Blocks.FARMLAND || block_1 == BlocksID.iron_grass || block_1 == BlocksID.iron_dirt || block_1 == BlocksID.coarse_iron_dirt;
    }

}
