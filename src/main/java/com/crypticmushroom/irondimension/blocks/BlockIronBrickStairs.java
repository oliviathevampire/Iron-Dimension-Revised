package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronstoneStairs extends StairsBlock {
    public BlockIronstoneStairs(BlockState blockState) {
        super(blockState, FabricBlockSettings
                .of(Material.STONE, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.PICKAXES, 1)
                .sounds(BlockSoundGroup.STONE)
                .hardness(1.5F)
                .resistance(10.0F)
                .build());
    }
}
