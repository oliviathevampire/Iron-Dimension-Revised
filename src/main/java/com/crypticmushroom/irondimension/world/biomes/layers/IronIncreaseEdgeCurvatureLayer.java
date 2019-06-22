package com.crypticmushroom.irondimension.world.biomes.layers;

import net.minecraft.world.biome.layer.DiagonalCrossSamplingLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public enum IronIncreaseEdgeCurvatureLayer implements DiagonalCrossSamplingLayer {
    INSTANCE;

    public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1, int int_2, int int_3, int int_4, int int_5) {
        if (!BiomeLayers.isShallowOcean(int_5) || BiomeLayers.isShallowOcean(int_4) && BiomeLayers.isShallowOcean(int_3) && BiomeLayers.isShallowOcean(int_1) && BiomeLayers.isShallowOcean(int_2)) {
            if (!BiomeLayers.isShallowOcean(int_5) && (BiomeLayers.isShallowOcean(int_4) || BiomeLayers.isShallowOcean(int_1) || BiomeLayers.isShallowOcean(int_3) || BiomeLayers.isShallowOcean(int_2)) && layerRandomnessSource_1.nextInt(5) == 0) {
                if (BiomeLayers.isShallowOcean(int_4)) {
                    return int_5 == 4 ? 4 : int_4;
                }

                if (BiomeLayers.isShallowOcean(int_1)) {
                    return int_5 == 4 ? 4 : int_1;
                }

                if (BiomeLayers.isShallowOcean(int_3)) {
                    return int_5 == 4 ? 4 : int_3;
                }

                if (BiomeLayers.isShallowOcean(int_2)) {
                    return int_5 == 4 ? 4 : int_2;
                }
            }

            return int_5;
        } else {
            int int_6 = 1;
            int int_7 = 1;
            if (!BiomeLayers.isShallowOcean(int_4) && layerRandomnessSource_1.nextInt(int_6++) == 0) {
                int_7 = int_4;
            }

            if (!BiomeLayers.isShallowOcean(int_3) && layerRandomnessSource_1.nextInt(int_6++) == 0) {
                int_7 = int_3;
            }

            if (!BiomeLayers.isShallowOcean(int_1) && layerRandomnessSource_1.nextInt(int_6++) == 0) {
                int_7 = int_1;
            }

            if (!BiomeLayers.isShallowOcean(int_2) && layerRandomnessSource_1.nextInt(int_6++) == 0) {
                int_7 = int_2;
            }

            if (layerRandomnessSource_1.nextInt(3) == 0) {
                return int_7;
            } else {
                return int_7 == 4 ? 4 : int_5;
            }
        }
    }
}
