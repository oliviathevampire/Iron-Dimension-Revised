package com.crypticmushroom.irondimension.world.biomes.layers;

import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.biome.layer.SouthEastSamplingLayer;

public enum IronAddColdClimatesLayer implements SouthEastSamplingLayer {
    INSTANCE;

    public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1) {
        if (BiomeLayers.isShallowOcean(int_1)) {
            return int_1;
        } else {
            int int_2 = layerRandomnessSource_1.nextInt(6);
            if (int_2 == 0) {
                return 4;
            } else {
                return int_2 == 1 ? 3 : 1;
            }
        }
    }
}
