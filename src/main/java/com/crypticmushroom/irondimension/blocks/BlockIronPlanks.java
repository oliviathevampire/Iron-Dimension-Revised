package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronPlanks extends Block {
    public BlockIronPlanks() {
        super(FabricBlockSettings
                .of(Material.WOOD, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.AXES, 2)
                .sounds(BlockSoundGroup.WOOD)
                .hardness(2.0F)
                .resistance(2.0F)
                .build());
    }
}
