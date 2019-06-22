package com.crypticmushroom.irondimension.world.gen.chunk;

import com.crypticmushroom.irondimension.registry.BlocksID;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

public class IronDimensionChunkGeneratorConfig extends ChunkGeneratorConfig {

    public IronDimensionChunkGeneratorConfig() {
        this.defaultBlock = BlocksID.ironstone.getDefaultState();
        this.defaultFluid = BlocksID.iron_water_block.getDefaultState();
    }

    public int getBiomeSize() {
        return 4;
    }

    public int getRiverSize() {
        return 4;
    }

    public int getForcedBiome() {
        return -1;
    }

    @Override
    public int getMinY() {
        return 0;
    }
}
