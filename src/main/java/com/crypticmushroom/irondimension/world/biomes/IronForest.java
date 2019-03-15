package com.crypticmushroom.irondimension.world.biomes;

public class IronForest extends IronBiome {
    public IronForest() {
        super(new Settings()
                .category(Category.FOREST)
                .depth(0.1F)
                .precipitation(Precipitation.NONE)
                .temperature(0.60F)
                .scale(0.2F)
                .downfall(0.8F));
    }
}
