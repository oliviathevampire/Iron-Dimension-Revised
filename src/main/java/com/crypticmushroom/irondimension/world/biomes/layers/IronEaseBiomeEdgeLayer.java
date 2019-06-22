package com.crypticmushroom.irondimension.world.biomes.layers;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.CrossSamplingLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public enum IronEaseBiomeEdgeLayer implements CrossSamplingLayer {
    INSTANCE;

    private static final int IRON_PLAINS = Registry.BIOME.getRawId(WorldIronDimension.IRON_PLAINS);
    private static final int IRON_HIGHLAND = Registry.BIOME.getRawId(WorldIronDimension.IRON_HIGHLANDS);
    private static final int IRON_FOREST = Registry.BIOME.getRawId(WorldIronDimension.IRON_FOREST);
    private static final int DESERT_ID = Registry.BIOME.getRawId(Biomes.DESERT);
    private static final int MOUNTAINS_ID = Registry.BIOME.getRawId(Biomes.MOUNTAINS);
    private static final int WOODED_MOUNTAINS_ID = Registry.BIOME.getRawId(Biomes.WOODED_MOUNTAINS);
    private static final int SNOWY_TUNDRA_ID = Registry.BIOME.getRawId(Biomes.SNOWY_TUNDRA);
    private static final int JUNGLE_ID = Registry.BIOME.getRawId(Biomes.JUNGLE);
    private static final int BAMBOO_JUNGLE_ID = Registry.BIOME.getRawId(Biomes.BAMBOO_JUNGLE);
    private static final int JUNGLE_EDGE_ID = Registry.BIOME.getRawId(Biomes.JUNGLE_EDGE);
    private static final int BALDANDS_ID = Registry.BIOME.getRawId(Biomes.BADLANDS);
    private static final int BADLANDS_PLATEAU_ID = Registry.BIOME.getRawId(Biomes.BADLANDS_PLATEAU);
    private static final int WOODED_BADLANDS_PLATEAU_ID = Registry.BIOME.getRawId(Biomes.WOODED_BADLANDS_PLATEAU);
    private static final int PLAINS_ID = Registry.BIOME.getRawId(Biomes.PLAINS);
    private static final int GIANT_TREE_TAIGA_ID = Registry.BIOME.getRawId(Biomes.GIANT_TREE_TAIGA);
    private static final int MOUNTAIN_EDGE_ID = Registry.BIOME.getRawId(Biomes.MOUNTAIN_EDGE);
    private static final int SWAMP_ID = Registry.BIOME.getRawId(Biomes.SWAMP);
    private static final int TAIGA_ID = Registry.BIOME.getRawId(Biomes.TAIGA);
    private static final int SNOWY_TAIGA_ID = Registry.BIOME.getRawId(Biomes.SNOWY_TAIGA);

    public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1, int int_2, int int_3, int int_4, int int_5) {
        int[] ints_1 = new int[1];
        if (!this.method_15841(ints_1, int_1, int_2, int_3, int_4, int_5, MOUNTAINS_ID, MOUNTAIN_EDGE_ID) && !this.method_15840(ints_1, int_1, int_2, int_3, int_4, int_5, WOODED_BADLANDS_PLATEAU_ID, BALDANDS_ID) && !this.method_15840(ints_1, int_1, int_2, int_3, int_4, int_5, BADLANDS_PLATEAU_ID, BALDANDS_ID) && !this.method_15840(ints_1, int_1, int_2, int_3, int_4, int_5, GIANT_TREE_TAIGA_ID, TAIGA_ID)) {
            if (int_5 == DESERT_ID && (int_1 == SNOWY_TUNDRA_ID || int_2 == SNOWY_TUNDRA_ID || int_4 == SNOWY_TUNDRA_ID || int_3 == SNOWY_TUNDRA_ID)) {
                return IRON_HIGHLAND;
            } else {
                if (int_5 == SWAMP_ID) {
                    if (int_1 == DESERT_ID || int_2 == DESERT_ID || int_4 == DESERT_ID || int_3 == DESERT_ID || int_1 == SNOWY_TAIGA_ID || int_2 == SNOWY_TAIGA_ID || int_4 == SNOWY_TAIGA_ID || int_3 == SNOWY_TAIGA_ID || int_1 == SNOWY_TUNDRA_ID || int_2 == SNOWY_TUNDRA_ID || int_4 == SNOWY_TUNDRA_ID || int_3 == SNOWY_TUNDRA_ID) {
                        return IRON_PLAINS;
                    }

                    if (int_1 == JUNGLE_ID || int_3 == JUNGLE_ID || int_2 == JUNGLE_ID || int_4 == JUNGLE_ID || int_1 == BAMBOO_JUNGLE_ID || int_3 == BAMBOO_JUNGLE_ID || int_2 == BAMBOO_JUNGLE_ID || int_4 == BAMBOO_JUNGLE_ID) {
                        return IRON_FOREST;
                    }
                }

                return int_5;
            }
        } else {
            return ints_1[0];
        }
    }

    private boolean method_15841(int[] ints_1, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
        if (!BiomeLayers.areSimilar(int_5, int_6)) {
            return false;
        } else {
            if (this.method_15839(int_1, int_6) && this.method_15839(int_2, int_6) && this.method_15839(int_4, int_6) && this.method_15839(int_3, int_6)) {
                ints_1[0] = int_5;
            } else {
                ints_1[0] = int_7;
            }

            return true;
        }
    }

    private boolean method_15840(int[] ints_1, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7) {
        if (int_5 != int_6) {
            return false;
        } else {
            if (BiomeLayers.areSimilar(int_1, int_6) && BiomeLayers.areSimilar(int_2, int_6) && BiomeLayers.areSimilar(int_4, int_6) && BiomeLayers.areSimilar(int_3, int_6)) {
                ints_1[0] = int_5;
            } else {
                ints_1[0] = int_7;
            }

            return true;
        }
    }

    private boolean method_15839(int int_1, int int_2) {
        if (BiomeLayers.areSimilar(int_1, int_2)) {
            return true;
        } else {
            Biome biome_1 = (Biome)Registry.BIOME.get(int_1);
            Biome biome_2 = (Biome)Registry.BIOME.get(int_2);
            if (biome_1 != null && biome_2 != null) {
                Biome.TemperatureGroup biome$TemperatureGroup_1 = biome_1.getTemperatureGroup();
                Biome.TemperatureGroup biome$TemperatureGroup_2 = biome_2.getTemperatureGroup();
                return biome$TemperatureGroup_1 == biome$TemperatureGroup_2 || biome$TemperatureGroup_1 == Biome.TemperatureGroup.MEDIUM || biome$TemperatureGroup_2 == Biome.TemperatureGroup.MEDIUM;
            } else {
                return false;
            }
        }
    }
}
