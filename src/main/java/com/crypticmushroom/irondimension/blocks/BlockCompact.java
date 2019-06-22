package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class BlockCompact extends Block {
    public BlockCompact(FabricBlockSettings settings) {
        super(settings.sounds(BlockSoundGroup.METAL)
                .hardness(5.0F)
                .resistance(10.0F)
                .build());
    }
}
