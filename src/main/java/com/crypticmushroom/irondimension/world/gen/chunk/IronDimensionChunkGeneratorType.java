package com.crypticmushroom.irondimension.world.gen.chunk;

import net.minecraft.world.World;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;

public class IronDimensionChunkGeneratorType extends ChunkGeneratorType<IronDimensionChunkGeneratorConfig, IronDimensionChunkGenerator> {
    public IronDimensionChunkGeneratorType() {
        super(null, true, IronDimensionChunkGeneratorConfig::new);
    }

    @Override
    public IronDimensionChunkGenerator create(World world_1, BiomeSource biomeSource_1, IronDimensionChunkGeneratorConfig chunkGeneratorConfig_1) {
        return new IronDimensionChunkGenerator(world_1, biomeSource_1, chunkGeneratorConfig_1);
    }
}
