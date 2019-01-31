package com.crypticmushroom.irondimension.world.biomes;

public class IronHighlands extends IronBiome {
    public IronHighlands() {
        super(new Settings()
                .category(Category.PLAINS)
                .depth(0.01F)
                .precipitation(Precipitation.NONE)
                .temperature(0.7F)
                .scale(0.00F)
                .downfall(0.01F)
        );
    }
}
