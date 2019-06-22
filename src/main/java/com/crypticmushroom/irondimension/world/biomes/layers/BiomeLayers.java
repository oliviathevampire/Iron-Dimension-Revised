package com.crypticmushroom.irondimension.world.biomes.layers;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import com.crypticmushroom.irondimension.world.biomes.IronBiomeSourceConfig;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.*;
import net.minecraft.world.level.LevelGeneratorType;

import java.util.function.LongFunction;

public class BiomeLayers {
    protected static final int IRON_OCEAN_ID;

    private static <T extends LayerSampler, C extends LayerSampleContext<T>> LayerFactory<T> stack(long long_1, ParentedLayer parentedLayer_1, LayerFactory<T> layerFactory_1, int int_1, LongFunction<C> longFunction_1) {
        LayerFactory<T> layerFactory_2 = layerFactory_1;

        for(int int_2 = 0; int_2 < int_1; ++int_2) {
            layerFactory_2 = parentedLayer_1.create((LayerSampleContext)longFunction_1.apply(long_1 + (long)int_2), layerFactory_2);
        }

        return layerFactory_2;
    }

    public static <T extends LayerSampler, C extends LayerSampleContext<T>> ImmutableList<LayerFactory<T>> build(LevelGeneratorType levelGeneratorType_1, IronDimensionChunkGeneratorConfig ironDimensionChunkGeneratorConfig, LongFunction<C> longFunction_1) {
        LayerFactory<T> layerFactory_1 = IronContinentLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1L));
        layerFactory_1 = ScaleLayer.FUZZY.create((LayerSampleContext)longFunction_1.apply(2000L), layerFactory_1);
        layerFactory_1 = IronIncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1L), layerFactory_1);
        layerFactory_1 = ScaleLayer.NORMAL.create((LayerSampleContext)longFunction_1.apply(2001L), layerFactory_1);
        layerFactory_1 = IronIncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
        layerFactory_1 = IronIncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(50L), layerFactory_1);
        layerFactory_1 = IronIncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(70L), layerFactory_1);
        layerFactory_1 = IronAddIslandLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
        LayerFactory<T> layerFactory_2 = IronOceanTemperatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L));
        layerFactory_2 = stack(2001L, ScaleLayer.NORMAL, layerFactory_2, 6, longFunction_1);
//        layerFactory_1 = IronAddColdClimatesLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
        layerFactory_1 = IronIncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(3L), layerFactory_1);
//        layerFactory_1 = IronAddClimateLayers.AddTemperateBiomesLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
//        layerFactory_1 = IronAddClimateLayers.AddCoolBiomesLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
//        layerFactory_1 = IronAddClimateLayers.AddSpecialBiomesLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(3L), layerFactory_1);
        layerFactory_1 = ScaleLayer.NORMAL.create((LayerSampleContext)longFunction_1.apply(2002L), layerFactory_1);
        layerFactory_1 = ScaleLayer.NORMAL.create((LayerSampleContext)longFunction_1.apply(2003L), layerFactory_1);
        layerFactory_1 = IronIncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(4L), layerFactory_1);
        layerFactory_1 = stack(1000L, ScaleLayer.NORMAL, layerFactory_1, 0, longFunction_1);
        int int_1 = 4;
        int int_2 = int_1;
        if (ironDimensionChunkGeneratorConfig != null) {
            int_1 = ironDimensionChunkGeneratorConfig.getBiomeSize();
            int_2 = ironDimensionChunkGeneratorConfig.getRiverSize();
        }

        if (levelGeneratorType_1 == LevelGeneratorType.LARGE_BIOMES) {
            int_1 = 6;
        }

        LayerFactory<T> layerFactory_3 = stack(1000L, ScaleLayer.NORMAL, layerFactory_1, 0, longFunction_1);
        layerFactory_3 = IronSimpleLandNoiseLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(100L), layerFactory_3);
        LayerFactory<T> layerFactory_4 = (new IronSetBaseBiomesLayer(levelGeneratorType_1, ironDimensionChunkGeneratorConfig)).create((LayerSampleContext)longFunction_1.apply(200L), layerFactory_1);
        layerFactory_4 = stack(1000L, ScaleLayer.NORMAL, layerFactory_4, 2, longFunction_1);
        layerFactory_4 = IronEaseBiomeEdgeLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1000L), layerFactory_4);
        LayerFactory<T> layerFactory_5 = stack(1000L, ScaleLayer.NORMAL, layerFactory_3, 2, longFunction_1);
        layerFactory_4 = IronAddHillsLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1000L), layerFactory_4, layerFactory_5);
        layerFactory_3 = stack(1000L, ScaleLayer.NORMAL, layerFactory_3, 2, longFunction_1);
        layerFactory_3 = stack(1000L, ScaleLayer.NORMAL, layerFactory_3, int_2, longFunction_1);

        for(int int_3 = 0; int_3 < int_1; ++int_3) {
            layerFactory_4 = ScaleLayer.NORMAL.create((LayerSampleContext)longFunction_1.apply((long)(1000 + int_3)), layerFactory_4);
            if (int_3 == 0) {
                layerFactory_4 = IronIncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(3L), layerFactory_4);
            }
        }

        LayerFactory<T> layerFactory_7 = CellScaleLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(10L), layerFactory_4);
        return ImmutableList.of(layerFactory_4, layerFactory_7, layerFactory_4);
    }

    public static BiomeLayerSampler[] build(long long_1, LevelGeneratorType levelGeneratorType_1, IronDimensionChunkGeneratorConfig ironDimensionChunkGeneratorConfig) {
        ImmutableList<LayerFactory<CachingLayerSampler>> immutableList_1 = build(levelGeneratorType_1, ironDimensionChunkGeneratorConfig, (long_2) -> {
            return new CachingLayerContext(25, long_1, long_2);
        });
        BiomeLayerSampler biomeLayerSampler_1 = new BiomeLayerSampler((LayerFactory)immutableList_1.get(0));
        BiomeLayerSampler biomeLayerSampler_2 = new BiomeLayerSampler((LayerFactory)immutableList_1.get(1));
        BiomeLayerSampler biomeLayerSampler_3 = new BiomeLayerSampler((LayerFactory)immutableList_1.get(2));
        return new BiomeLayerSampler[]{biomeLayerSampler_1, biomeLayerSampler_2, biomeLayerSampler_3};
    }

    public static boolean areSimilar(int int_1, int int_2) {
        if (int_1 == int_2) {
            return true;
        } else {
            return false;
        }
    }

    protected static boolean isOcean(int int_1) {
        return int_1 == IRON_OCEAN_ID ;
    }

    protected static boolean isShallowOcean(int int_1) {
        return int_1 == IRON_OCEAN_ID;
    }

    static {
        IRON_OCEAN_ID = Registry.BIOME.getRawId(WorldIronDimension.IRON_OCEAN);
    }
}
