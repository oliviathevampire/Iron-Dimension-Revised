package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.registry.BlocksID;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class IronPlant extends FlowerBlock {
    public IronPlant() {
        super(null, 0, FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.GRASS).build());
    }

    @Override
    protected boolean canPlantOnTop(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        Block block_1 = blockState_1.getBlock();
        return block_1 == BlocksID.iron_grass || block_1 == BlocksID.iron_dirt || block_1 == BlocksID.coarse_iron_dirt;
    }
}
