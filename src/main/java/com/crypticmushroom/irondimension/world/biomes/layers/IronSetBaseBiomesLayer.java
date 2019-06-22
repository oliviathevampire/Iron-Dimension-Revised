package com.crypticmushroom.irondimension.world.biomes.layers;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.layer.IdentitySamplingLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;
import net.minecraft.world.level.LevelGeneratorType;

public class IronSetBaseBiomesLayer implements IdentitySamplingLayer {
    private static final int IRON_PLAINS_ID;
    private static final int IRON_HIGHLAND_ID;
    private static final int IRON_FOREST;
    private static final int[] GROUP_1;
    private final IronDimensionChunkGeneratorConfig config;
    private int[] chosenGroup1;

    public IronSetBaseBiomesLayer(LevelGeneratorType levelGeneratorType_1, IronDimensionChunkGeneratorConfig overworldChunkGeneratorConfig_1) {
        this.chosenGroup1 = GROUP_1;
        this.config = overworldChunkGeneratorConfig_1;

    }

    public int sample(LayerRandomnessSource layerRandomnessSource_1, int int_1) {
        if (this.config != null && this.config.getForcedBiome() >= 0) {
            return this.config.getForcedBiome();
        } else {
            return this.chosenGroup1[layerRandomnessSource_1.nextInt(this.chosenGroup1.length)];
        }
    }

    static {
        IRON_FOREST = Registry.BIOME.getRawId(WorldIronDimension.IRON_FOREST);
        IRON_HIGHLAND_ID = Registry.BIOME.getRawId(WorldIronDimension.IRON_HIGHLANDS);
        IRON_PLAINS_ID = Registry.BIOME.getRawId(WorldIronDimension.IRON_PLAINS);
        GROUP_1 = new int[]{IRON_PLAINS_ID,IRON_HIGHLAND_ID,IRON_FOREST};
    }
}
