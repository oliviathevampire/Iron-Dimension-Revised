package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronThatch extends Block {
    public BlockIronThatch() {
        super(FabricBlockSettings
                .of(Material.PLANT, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.AXES, 1)
                .sounds(BlockSoundGroup.GRASS)
                .hardness(1.0F)
                .resistance(0.4F)
                .build());
    }
}
