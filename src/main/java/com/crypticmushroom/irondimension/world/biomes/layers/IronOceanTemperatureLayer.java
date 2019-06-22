package com.crypticmushroom.irondimension.world.biomes.layers;

import net.minecraft.util.math.noise.PerlinNoiseSampler;
import net.minecraft.world.biome.layer.InitLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public enum IronOceanTemperatureLayer implements InitLayer {
    INSTANCE;

    public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1, int int_2) {
        PerlinNoiseSampler perlinNoiseSampler_1 = layerRandomnessSource_1.getNoiseSampler();
        double double_1 = perlinNoiseSampler_1.sample((double)int_1 / 8.0D, (double)int_2 / 8.0D, 0.0D, 0.0D, 0.0D);
        return BiomeLayers.IRON_OCEAN_ID;
    }
}
