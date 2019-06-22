package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.SignBlock;
import net.minecraft.sound.BlockSoundGroup;

public class IronSignBlock extends SignBlock {
    public IronSignBlock(Block block) {
        super(FabricBlockSettings.of(block.getMaterial(block.getDefaultState()), block.getMaterial(block.getDefaultState()).getColor()).noCollision().hardness(1.0F).sounds(BlockSoundGroup.WOOD).build());
    }
}
