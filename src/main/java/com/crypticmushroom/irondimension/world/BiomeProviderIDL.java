package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.registry.BiomeIDL;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class BiomeProviderIDL extends BiomeProvider {
    public BiomeProviderIDL(World world) {
        getBiomesToSpawnIn().clear();
        getBiomesToSpawnIn().add(BiomeIDL.iron_highlands);
        getBiomesToSpawnIn().add(BiomeIDL.iron_forest);
        getBiomesToSpawnIn().add(BiomeIDL.iron_plains);

        makeLayers(world.getSeed());
    }

    private void makeLayers(long seed) {
        GenLayer biomes = new GenLayerIDLBiomes(1L);

        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerZoom(1001, biomes);

        biomes = new GenLayerZoom(1002, biomes);
        biomes = new GenLayerZoom(1003, biomes);
        biomes = new GenLayerZoom(1004, biomes);
        biomes = new GenLayerZoom(1005, biomes);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

        biomes.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);

        genBiomes = biomes;
        biomeIndexLayer = genlayervoronoizoom;
    }
}
