package com.crypticmushroom.irondimension.world.gen.chunk;

import com.crypticmushroom.irondimension.registry.BlocksID;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

public class IronDimensionChunkGeneratorConfig extends ChunkGeneratorConfig {

    public IronDimensionChunkGeneratorConfig() {
        this.defaultBlock = BlocksID.ironstone.getDefaultState();
        this.defaultFluid = BlocksID.iron_water_block.getDefaultState();
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
