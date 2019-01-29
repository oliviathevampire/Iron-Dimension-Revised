package com.crypticmushroom.irondimension.world.gen.chunk;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

public class IronDimensionChunkGeneratorConfig extends ChunkGeneratorConfig {

    private final int field_13224 = 4;
    private final int field_13223 = 4;
    private final int field_13222 = -1;
    private final int field_13221 = 63;

    public IronDimensionChunkGeneratorConfig() {
        this.defaultBlock = BlocksIDL.ironstone.getDefaultState();
    }

    public int method_12614() {
        return 4;
    }

    public int method_12616() {
        return 4;
    }

    public int method_12615() {
        return -1;
    }

    @Override
    public int getMinY() {
        return 0;
    }
}