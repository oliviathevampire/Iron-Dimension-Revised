package com.crypticmushroom.irondimension.world.biomes.layers;

import net.minecraft.world.biome.layer.IdentitySamplingLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public enum IronSimpleLandNoiseLayer implements IdentitySamplingLayer {
    INSTANCE;

    public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1) {
        return BiomeLayers.isShallowOcean(int_1) ? int_1 : layerRandomnessSource_1.nextInt(299999) + 2;
    }
}
