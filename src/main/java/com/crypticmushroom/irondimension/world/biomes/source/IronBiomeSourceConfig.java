package com.crypticmushroom.irondimension.world.biomes.source;

import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import net.minecraft.world.biome.source.BiomeSourceConfig;
import net.minecraft.world.level.LevelProperties;

public class IronBiomeSourceConfig implements BiomeSourceConfig {
    private LevelProperties levelProperties;
    private IronDimensionChunkGeneratorConfig generatorSettings;

    public IronBiomeSourceConfig setLevelProperties(LevelProperties levelProperties_1) {
        this.levelProperties = levelProperties_1;
        return this;
    }

    public IronBiomeSourceConfig setGeneratorSettings(IronDimensionChunkGeneratorConfig overworldChunkGeneratorConfig_1) {
        this.generatorSettings = overworldChunkGeneratorConfig_1;
        return this;
    }

    public LevelProperties getLevelProperties() {
        return this.levelProperties;
    }

    public IronDimensionChunkGeneratorConfig getGeneratorSettings() {
        return this.generatorSettings;
    }
}
