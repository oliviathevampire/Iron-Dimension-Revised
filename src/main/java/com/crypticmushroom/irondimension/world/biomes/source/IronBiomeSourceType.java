package com.crypticmushroom.irondimension.world.biomes.source;

import net.minecraft.world.biome.source.BiomeSourceType;

public class IronBiomeSourceType extends BiomeSourceType<IronBiomeSourceConfig, IronBiomeSource> {
    public IronBiomeSourceType() {
        super(IronBiomeSource::new, IronBiomeSourceConfig::new);
    }
}
