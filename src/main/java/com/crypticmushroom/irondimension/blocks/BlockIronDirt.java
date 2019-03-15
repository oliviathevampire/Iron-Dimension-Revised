package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.FabricItemTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class BlockIronDirt extends Block {
    public BlockIronDirt() {
        super(FabricBlockSettings
                .of(Material.EARTH, MaterialColor.LIGHT_GRAY)
                .breakByTool(FabricItemTags.SHOVELS, 2)
                .sounds(BlockSoundGroup.GRASS)
                .hardness(0.5F)
                .build());
    }
}
