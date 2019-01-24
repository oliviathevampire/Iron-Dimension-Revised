package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronStone extends Block {
    public BlockIronStone() {
        super(FabricBlockSettings
                .of(Material.STONE, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.PICKAXES, 1)
                .sounds(BlockSoundGroup.STONE)
                .hardness(1.5F)
                .resistance(10.0F)
                .build());
    }
}
