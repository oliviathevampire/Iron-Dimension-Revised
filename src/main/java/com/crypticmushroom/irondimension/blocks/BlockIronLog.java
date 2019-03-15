package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.FabricItemTags;
import net.minecraft.block.LogBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronLog extends LogBlock {
    public BlockIronLog(MaterialColor materialColor_1) {
        super(materialColor_1, FabricBlockSettings
                .of(Material.WOOD, materialColor_1)
                .breakByTool(FabricItemTags.AXES, 2)
                .sounds(BlockSoundGroup.WOOD)
                .hardness(2.0F)
                .resistance(2.0F)
                .build());
    }
}
