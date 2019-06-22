package com.crypticmushroom.irondimension.world.biomes.layers;

import net.minecraft.world.biome.layer.CrossSamplingLayer;
import net.minecraft.world.biome.layer.IdentitySamplingLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public class IronAddClimateLayers {
    public static enum AddSpecialBiomesLayer implements IdentitySamplingLayer {
        INSTANCE;

        public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1) {
            if (!BiomeLayers.isShallowOcean(int_1) && layerRandomnessSource_1.nextInt(13) == 0) {
                int_1 |= 1 + layerRandomnessSource_1.nextInt(15) << 8 & 3840;
            }

            return int_1;
        }
    }

    public static enum AddCoolBiomesLayer implements CrossSamplingLayer {
        INSTANCE;

        public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1, int int_2, int int_3, int int_4, int int_5) {
            return int_5 != 4 || int_1 != 1 && int_2 != 1 && int_4 != 1 && int_3 != 1 && int_1 != 2 && int_2 != 2 && int_4 != 2 && int_3 != 2 ? int_5 : 3;
        }
    }

    public static enum AddTemperateBiomesLayer implements CrossSamplingLayer {
        INSTANCE;

        public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1, int int_2, int int_3, int int_4, int int_5) {
            return int_5 != 1 || int_1 != 3 && int_2 != 3 && int_4 != 3 && int_3 != 3 && int_1 != 4 && int_2 != 4 && int_4 != 4 && int_3 != 4 ? int_5 : 2;
        }
    }
}
