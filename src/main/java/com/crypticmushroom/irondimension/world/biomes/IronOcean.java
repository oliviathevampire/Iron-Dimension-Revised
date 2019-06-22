package com.crypticmushroom.irondimension.world.biomes;

import net.minecraft.world.biome.Biome;

public class IronOcean extends IronBiome {
    public IronOcean() {
        super(new Settings()
                .category(Biome.Category.OCEAN)
                .depth(-1.0F)
                .scale(0.1F)
                .temperature(0.5F)
                .downfall(0.5F)
                .precipitation(Precipitation.NONE));
    }
}
