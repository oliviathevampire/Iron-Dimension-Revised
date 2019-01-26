package com.crypticmushroom.irondimension.world.gen.chunk;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

public class IronDimensionChunkGeneratorConfig extends ChunkGeneratorConfig {

    public IronDimensionChunkGeneratorConfig() {
        this.defaultBlock = BlocksIDL.ironstone.getDefaultState();
    }
}
