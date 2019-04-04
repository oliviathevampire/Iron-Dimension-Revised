package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.WallSignBlock;
import net.minecraft.sound.BlockSoundGroup;

public class IronWallSignBlock extends WallSignBlock {
    public IronWallSignBlock(Block block) {
        super(FabricBlockSettings.of(Material.WOOD).noCollision().hardness(1.0F).sounds(BlockSoundGroup.WOOD).dropsLike(block).build());
    }
}
