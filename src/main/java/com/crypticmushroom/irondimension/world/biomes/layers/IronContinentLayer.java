package com.crypticmushroom.irondimension.world.biomes.layers;

import net.minecraft.world.biome.layer.InitLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public enum IronContinentLayer implements InitLayer {
    INSTANCE;

    public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1, int int_2) {
        if (int_1 == 0 && int_2 == 0) {
            return 1;
        } else {
            return layerRandomnessSource_1.nextInt(10) == 0 ? 1 : BiomeLayers.IRON_OCEAN_ID;
        }
    }
}
