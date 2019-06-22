package com.crypticmushroom.irondimension.world.biomes.layers;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.biome.layer.LayerSampler;
import net.minecraft.world.biome.layer.MergingLayer;
import net.minecraft.world.biome.layer.NorthWestCoordinateTransformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum IronAddHillsLayer implements MergingLayer, NorthWestCoordinateTransformer {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger();

    public int sample(LayerRandomnessSource layerRandomnessSource_1, LayerSampler layerSampler_1, LayerSampler layerSampler_2, int int_1, int int_2) {
        int int_3 = layerSampler_1.sample(this.transformX(int_1 + 1), this.transformZ(int_2 + 1));
        int int_4 = layerSampler_2.sample(this.transformX(int_1 + 1), this.transformZ(int_2 + 1));
        if (int_3 > 255) {
            LOGGER.debug("old! {}", int_3);
        }

        int int_5 = (int_4 - 2) % 29;
        Biome biome_3;
        if (!BiomeLayers.isShallowOcean(int_3) && int_4 >= 2 && int_5 == 1) {
            Biome biome_1 = (Biome)Registry.BIOME.get(int_3);
            if (biome_1 == null || !biome_1.hasParent()) {
                biome_3 = Biome.getParentBiome(biome_1);
                return biome_3 == null ? int_3 : Registry.BIOME.getRawId(WorldIronDimension.IRON_HIGHLANDS);
            }
        }

        if (layerRandomnessSource_1.nextInt(3) == 0 || int_5 == 0) {
            return Registry.BIOME.getRawId(WorldIronDimension.IRON_HIGHLANDS);
        }

        return int_3;
    }
}
