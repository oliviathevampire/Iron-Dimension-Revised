package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BlockCompact extends Block {
    public BlockCompact() {
        super(FabricBlockSettings
                .of(Material.METAL)
                .breakByTool(FabricItemTags.PICKAXES, 2)
                .sounds(BlockSoundGroup.METAL)
                .hardness(5.0F)
                .resistance(10.0F)
                .build());
    }
}
