package com.crypticmushroom.irondimension.world.biomes;

public class IronHighlands extends IronBiome {
    public IronHighlands() {
        super(new Settings()
                .category(Category.PLAINS)
                .depth(0.45F)
                .precipitation(Precipitation.NONE)
                .temperature(0.7F)
                .scale(0.3F)
                .downfall(0.6F)
        );
    }
}
