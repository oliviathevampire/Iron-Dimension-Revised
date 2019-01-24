package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronBrick extends Block {
    public BlockIronBrick() {
        super(FabricBlockSettings
                .of(Material.STONE, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.PICKAXES, 2)
                .sounds(BlockSoundGroup.METAL)
                .hardness(5.0F)
                .resistance(10.0F)
                .build());
    }
}
