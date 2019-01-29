package com.crypticmushroom.irondimension.world.biomes.layer;

import com.crypticmushroom.irondimension.utils.IronClass_3640;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import com.google.common.collect.ImmutableList;
import net.minecraft.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.*;
import net.minecraft.world.level.LevelGeneratorType;

import java.util.function.LongFunction;

public class IronBiomeLayers {
    protected static final int WARM_OCEAN_ID;
    protected static final int LUKEWARM_OCEAN_ID;
    protected static final int OCEAN_ID;
    protected static final int COLD_OCEAN_ID;
    protected static final int FROZEN_OCEAN_ID;
    protected static final int DEEP_WARM_OCEAN_ID;
    protected static final int DEEP_LUKEWARM_OCEAN_ID;
    protected static final int DEEP_OCEAN_ID;
    protected static final int DEEP_COLD_OCEAN_ID;
    protected static final int DEEP_FROZEN_OCEAN_ID;

    private static <T extends LayerSampler, C extends LayerSampleContext<T>> LayerFactory<T> stack(long long_1, ParentedLayer parentedLayer_1, LayerFactory<T> layerFactory_1, int int_1, LongFunction<C> longFunction_1) {
        LayerFactory<T> layerFactory_2 = layerFactory_1;

        for(int int_2 = 0; int_2 < int_1; ++int_2) {
            layerFactory_2 = parentedLayer_1.create((LayerSampleContext)longFunction_1.apply(long_1 + (long)int_2), layerFactory_2);
        }

        return layerFactory_2;
    }

    public static <T extends LayerSampler, C extends LayerSampleContext<T>> ImmutableList<LayerFactory<T>> build(LevelGeneratorType levelGeneratorType_1, IronDimensionChunkGeneratorConfig overworldChunkGeneratorConfig_1, LongFunction<C> longFunction_1) {
        LayerFactory<T> layerFactory_1 = ContinentLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1L));
        layerFactory_1 = ScaleLayer.field_16198.create((LayerSampleContext)longFunction_1.apply(2000L), layerFactory_1);
        layerFactory_1 = class_3638.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1L), layerFactory_1);
        layerFactory_1 = ScaleLayer.NORMAL.create((LayerSampleContext)longFunction_1.apply(2001L), layerFactory_1);
        layerFactory_1 = class_3638.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
        layerFactory_1 = class_3638.INSTANCE.create((LayerSampleContext)longFunction_1.apply(50L), layerFactory_1);
        layerFactory_1 = class_3638.INSTANCE.create((LayerSampleContext)longFunction_1.apply(70L), layerFactory_1);
        layerFactory_1 = class_3651.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
        LayerFactory<T> layerFactory_2 = OceanTemperatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L));
        layerFactory_2 = stack(2001L, ScaleLayer.NORMAL, layerFactory_2, 6, longFunction_1);
        layerFactory_1 = class_3639.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
        layerFactory_1 = class_3638.INSTANCE.create((LayerSampleContext)longFunction_1.apply(3L), layerFactory_1);
        layerFactory_1 = class_3632.class_3926.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
        layerFactory_1 = class_3632.class_3927.INSTANCE.create((LayerSampleContext)longFunction_1.apply(2L), layerFactory_1);
        layerFactory_1 = class_3632.class_3635.INSTANCE.create((LayerSampleContext)longFunction_1.apply(3L), layerFactory_1);
        layerFactory_1 = ScaleLayer.NORMAL.create((LayerSampleContext)longFunction_1.apply(2002L), layerFactory_1);
        layerFactory_1 = ScaleLayer.NORMAL.create((LayerSampleContext)longFunction_1.apply(2003L), layerFactory_1);
        layerFactory_1 = class_3638.INSTANCE.create((LayerSampleContext)longFunction_1.apply(4L), layerFactory_1);
        layerFactory_1 = class_3637.INSTANCE.create((LayerSampleContext)longFunction_1.apply(5L), layerFactory_1);
        layerFactory_1 = class_3636.INSTANCE.create((LayerSampleContext)longFunction_1.apply(4L), layerFactory_1);
        layerFactory_1 = stack(1000L, ScaleLayer.NORMAL, layerFactory_1, 0, longFunction_1);
        int int_1 = 4;
        int int_2 = int_1;
        if (overworldChunkGeneratorConfig_1 != null) {
            int_1 = overworldChunkGeneratorConfig_1.method_12614();
            int_2 = overworldChunkGeneratorConfig_1.method_12616();
        }

        if (levelGeneratorType_1 == LevelGeneratorType.LARGE_BIOMES) {
            int_1 = 6;
        }

        LayerFactory<T> layerFactory_3 = stack(1000L, ScaleLayer.NORMAL, layerFactory_1, 0, longFunction_1);
        layerFactory_3 = class_3650.INSTANCE.create((LayerSampleContext)longFunction_1.apply(100L), layerFactory_3);
        LayerFactory<T> layerFactory_4 = (new IronClass_3640(levelGeneratorType_1, overworldChunkGeneratorConfig_1)).create((LayerSampleContext)longFunction_1.apply(200L), layerFactory_1);
        layerFactory_4 = BambooJungleReplaceLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1001L), layerFactory_4);
        layerFactory_4 = stack(1000L, ScaleLayer.NORMAL, layerFactory_4, 2, longFunction_1);
        layerFactory_4 = BiomeEdgeEaseLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1000L), layerFactory_4);
        LayerFactory<T> layerFactory_5 = stack(1000L, ScaleLayer.NORMAL, layerFactory_3, 2, longFunction_1);
        layerFactory_4 = class_3648.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1000L), layerFactory_4, layerFactory_5);
        layerFactory_3 = stack(1000L, ScaleLayer.NORMAL, layerFactory_3, 2, longFunction_1);
        layerFactory_3 = stack(1000L, ScaleLayer.NORMAL, layerFactory_3, int_2, longFunction_1);
        layerFactory_3 = class_3653.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1L), layerFactory_3);
        layerFactory_3 = class_3654.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1000L), layerFactory_3);
        layerFactory_4 = SunflowerPlainsReplaceLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1001L), layerFactory_4);

        for(int int_3 = 0; int_3 < int_1; ++int_3) {
            layerFactory_4 = ScaleLayer.NORMAL.create((LayerSampleContext)longFunction_1.apply((long)(1000 + int_3)), layerFactory_4);
            if (int_3 == 0) {
                layerFactory_4 = class_3638.INSTANCE.create((LayerSampleContext)longFunction_1.apply(3L), layerFactory_4);
            }

            if (int_3 == 1 || int_1 == 1) {
                layerFactory_4 = class_3655.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1000L), layerFactory_4);
            }
        }

        layerFactory_4 = class_3654.INSTANCE.create((LayerSampleContext)longFunction_1.apply(1000L), layerFactory_4);
        layerFactory_4 = class_3652.INSTANCE.create((LayerSampleContext)longFunction_1.apply(100L), layerFactory_4, layerFactory_3);
        layerFactory_4 = ApplyOceanTemperatureLayer.INSTANCE.create((LayerSampleContext)longFunction_1.apply(100L), layerFactory_4, layerFactory_2);
        LayerFactory<T> layerFactory_7 = class_3657.INSTANCE.create((LayerSampleContext)longFunction_1.apply(10L), layerFactory_4);
        return ImmutableList.of(layerFactory_4, layerFactory_7, layerFactory_4);
    }

    public static BiomeLayerSampler[] build(long long_1, LevelGeneratorType levelGeneratorType_1, IronDimensionChunkGeneratorConfig overworldChunkGeneratorConfig_1) {
        ImmutableList<LayerFactory<CachingLayerSampler>> immutableList_1 = build(levelGeneratorType_1, overworldChunkGeneratorConfig_1, (long_2) -> {
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
            Biome biome_1 = (Biome) Registry.BIOME.getInt(int_1);
            Biome biome_2 = (Biome)Registry.BIOME.getInt(int_2);
            if (biome_1 != null && biome_2 != null) {
                if (biome_1 != Biomes.WOODED_BADLANDS_PLATEAU && biome_1 != Biomes.BADLANDS_PLATEAU) {
                    if (biome_1.getCategory() != Biome.Category.NONE && biome_2.getCategory() != Biome.Category.NONE && biome_1.getCategory() == biome_2.getCategory()) {
                        return true;
                    } else {
                        return biome_1 == biome_2;
                    }
                } else {
                    return biome_2 == Biomes.WOODED_BADLANDS_PLATEAU || biome_2 == Biomes.BADLANDS_PLATEAU;
                }
            } else {
                return false;
            }
        }
    }

    public static boolean isOcean(int int_1) {
        return int_1 == WARM_OCEAN_ID || int_1 == LUKEWARM_OCEAN_ID || int_1 == OCEAN_ID || int_1 == COLD_OCEAN_ID || int_1 == FROZEN_OCEAN_ID || int_1 == DEEP_WARM_OCEAN_ID || int_1 == DEEP_LUKEWARM_OCEAN_ID || int_1 == DEEP_OCEAN_ID || int_1 == DEEP_COLD_OCEAN_ID || int_1 == DEEP_FROZEN_OCEAN_ID;
    }

    public static boolean isShallowOcean(int int_1) {
        return int_1 == WARM_OCEAN_ID || int_1 == LUKEWARM_OCEAN_ID || int_1 == OCEAN_ID || int_1 == COLD_OCEAN_ID || int_1 == FROZEN_OCEAN_ID;
    }

    static {
        WARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.WARM_OCEAN);
        LUKEWARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.LUKEWARM_OCEAN);
        OCEAN_ID = Registry.BIOME.getRawId(Biomes.OCEAN);
        COLD_OCEAN_ID = Registry.BIOME.getRawId(Biomes.COLD_OCEAN);
        FROZEN_OCEAN_ID = Registry.BIOME.getRawId(Biomes.FROZEN_OCEAN);
        DEEP_WARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_WARM_OCEAN);
        DEEP_LUKEWARM_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_LUKEWARM_OCEAN);
        DEEP_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_OCEAN);
        DEEP_COLD_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_COLD_OCEAN);
        DEEP_FROZEN_OCEAN_ID = Registry.BIOME.getRawId(Biomes.DEEP_FROZEN_OCEAN);
    }
}
