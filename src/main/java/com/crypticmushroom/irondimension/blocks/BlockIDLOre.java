package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIDLOre extends Block {
    public BlockIDLOre() {
        super(FabricBlockSettings
                .of(Material.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 2)
                .sounds(BlockSoundGroup.STONE)
                .hardness(3.0F)
                .resistance(5.0F)
                .build());
    }
}
