package com.crypticmushroom.irondimension.world.biomes.layers;

import net.minecraft.world.biome.layer.CrossSamplingLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public enum IronAddIslandLayer implements CrossSamplingLayer {
    INSTANCE;

    public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1, int int_2, int int_3, int int_4, int int_5) {
        return BiomeLayers.isShallowOcean(int_5) && BiomeLayers.isShallowOcean(int_1) && BiomeLayers.isShallowOcean(int_2) && BiomeLayers.isShallowOcean(int_4) && BiomeLayers.isShallowOcean(int_3) && layerRandomnessSource_1.nextInt(2) == 0 ? 1 : int_5;
    }
}
