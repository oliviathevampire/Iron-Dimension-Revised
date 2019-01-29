package com.crypticmushroom.irondimension.utils;

import com.crypticmushroom.irondimension.world.biomes.layer.IronBiomeLayers;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import net.minecraft.class_3630;
import net.minecraft.class_3661;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.level.LevelGeneratorType;

public class IronClass_3640 implements class_3661 {
    private static final int field_16074;
    private static final int field_16073;
    private static final int field_16072;
    private static final int field_16071;
    private static final int field_16069;
    private static final int field_16067;
    private static final int field_16065;
    private static final int field_16063;
    private static final int field_16061;
    private static final int field_16083;
    private static final int field_16081;
    private static final int field_16080;
    private static final int field_16079;
    private static final int field_16078;
    private static final int field_16077;
    private static final int field_16076;
    private static final int[] field_16082;
    private static final int[] field_16064;
    private static final int[] field_16062;
    private static final int[] field_16068;
    private static final int[] field_16066;
    private final IronDimensionChunkGeneratorConfig field_16075;
    private int[] field_16070;

    public IronClass_3640(LevelGeneratorType levelGeneratorType_1, IronDimensionChunkGeneratorConfig overworldChunkGeneratorConfig_1) {
        this.field_16070 = field_16064;
        if (levelGeneratorType_1 == LevelGeneratorType.DEFAULT_1_1) {
            this.field_16070 = field_16082;
            this.field_16075 = null;
        } else {
            this.field_16075 = overworldChunkGeneratorConfig_1;
        }

    }

    public int method_15866(class_3630 class_3630_1, int int_1) {
        if (this.field_16075 != null && this.field_16075.method_12615() >= 0) {
            return this.field_16075.method_12615();
        } else {
            int int_2 = (int_1 & 3840) >> 8;
            int_1 &= -3841;
            if (!IronBiomeLayers.isOcean(int_1) && int_1 != field_16061) {
                switch(int_1) {
                    case 1:
                        if (int_2 > 0) {
                            return class_3630_1.nextInt(3) == 0 ? field_16065 : field_16063;
                        }

                        return this.field_16070[class_3630_1.nextInt(this.field_16070.length)];
                    case 2:
                        if (int_2 > 0) {
                            return field_16067;
                        }

                        return field_16062[class_3630_1.nextInt(field_16062.length)];
                    case 3:
                        if (int_2 > 0) {
                            return field_16081;
                        }

                        return field_16068[class_3630_1.nextInt(field_16068.length)];
                    case 4:
                        return field_16066[class_3630_1.nextInt(field_16066.length)];
                    default:
                        return field_16061;
                }
            } else {
                return int_1;
            }
        }
    }

    static {
        field_16074 = Registry.BIOME.getRawId(Biomes.BIRCH_FOREST);
        field_16073 = Registry.BIOME.getRawId(Biomes.DESERT);
        field_16072 = Registry.BIOME.getRawId(Biomes.MOUNTAINS);
        field_16071 = Registry.BIOME.getRawId(Biomes.FOREST);
        field_16069 = Registry.BIOME.getRawId(Biomes.SNOWY_TUNDRA);
        field_16067 = Registry.BIOME.getRawId(Biomes.JUNGLE);
        field_16065 = Registry.BIOME.getRawId(Biomes.BADLANDS_PLATEAU);
        field_16063 = Registry.BIOME.getRawId(Biomes.WOODED_BADLANDS_PLATEAU);
        field_16061 = Registry.BIOME.getRawId(Biomes.MUSHROOM_FIELDS);
        field_16083 = Registry.BIOME.getRawId(Biomes.PLAINS);
        field_16081 = Registry.BIOME.getRawId(Biomes.GIANT_TREE_TAIGA);
        field_16080 = Registry.BIOME.getRawId(Biomes.DARK_FOREST);
        field_16079 = Registry.BIOME.getRawId(Biomes.SAVANNA);
        field_16078 = Registry.BIOME.getRawId(Biomes.SWAMP);
        field_16077 = Registry.BIOME.getRawId(Biomes.TAIGA);
        field_16076 = Registry.BIOME.getRawId(Biomes.SNOWY_TAIGA);
        field_16082 = new int[]{field_16073, field_16071, field_16072, field_16078, field_16083, field_16077};
        field_16064 = new int[]{field_16073, field_16073, field_16073, field_16079, field_16079, field_16083};
        field_16062 = new int[]{field_16071, field_16080, field_16072, field_16083, field_16074, field_16078};
        field_16068 = new int[]{field_16071, field_16072, field_16077, field_16083};
        field_16066 = new int[]{field_16069, field_16069, field_16069, field_16076};
    }
}
