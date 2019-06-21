package com.crypticmushroom.irondimension.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeSourceConfig;

public class IronBiomeSourceConfig implements BiomeSourceConfig {
    private Biome[] biomes;
    private int size;

    public IronBiomeSourceConfig() {
        this.biomes = new Biome[]{Biomes.PLAINS};
        this.size = 1;
    }

    public IronBiomeSourceConfig method_8777(Biome[] biomes_1) {
        this.biomes = biomes_1;
        return this;
    }

    public IronBiomeSourceConfig method_8780(int int_1) {
        this.size = int_1;
        return this;
    }

    public Biome[] getBiomes() {
        return this.biomes;
    }

    public int getSize() {
        return this.size;
    }
}
