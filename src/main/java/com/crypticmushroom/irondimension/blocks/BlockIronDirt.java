package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.fabricmc.fabric.tags.FabricItemTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

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
