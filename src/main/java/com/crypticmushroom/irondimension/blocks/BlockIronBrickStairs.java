package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronBrickStairs extends StairsBlock {
    public BlockIronBrickStairs(BlockState blockState) {
        super(blockState, FabricBlockSettings
                .of(Material.STONE, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.PICKAXES, 2)
                .sounds(BlockSoundGroup.METAL)
                .hardness(5.0F)
                .resistance(10.0F)
                .build());
    }
}
