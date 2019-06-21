package com.crypticmushroom.irondimension.world.biomes;

import com.google.common.collect.Sets;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.CheckerboardBiomeSourceConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class IronBiomeSource extends BiomeSource {
    private final Biome[] biomes;
    private final int gridSize;

    public IronBiomeSource(IronBiomeSourceConfig ironBiomeSourceConfig) {
        this.biomes = ironBiomeSourceConfig.getBiomes();
        this.gridSize = ironBiomeSourceConfig.getSize() + 4;
    }

    public Biome getBiome(int int_1, int int_2) {
        int random = new Random().nextInt(2);
        return this.biomes[Math.abs(((int_1 >> this.gridSize) + (int_2 >> this.gridSize) + random) % this.biomes.length)];
    }

    public Biome[] sampleBiomes(int int_1, int int_2, int int_3, int int_4, boolean boolean_1) {
        Biome[] biomes_1 = new Biome[int_3 * int_4];

        for(int int_5 = 0; int_5 < int_4; ++int_5) {
            for(int int_6 = 0; int_6 < int_3; ++int_6) {
                int random = new Random().nextInt(int_5 + int_6);
                int int_7 = Math.abs(((int_1 + int_5 >> this.gridSize) + (int_2 + int_6 >> this.gridSize) + random) % this.biomes.length);
                Biome biome_1 = this.biomes[int_7];
                biomes_1[int_5 * int_3 + int_6] = biome_1;
            }
        }

        return biomes_1;
    }

    public BlockPos locateBiome(int int_1, int int_2, int int_3, List<Biome> list_1, Random random_1) {
        return null;
    }

    public boolean hasStructureFeature(StructureFeature<?> structureFeature_1) {
        return (Boolean)this.structureFeatures.computeIfAbsent(structureFeature_1, (structureFeature_1x) -> {
            Biome[] var2 = this.biomes;
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Biome biome_1 = var2[var4];
                if (biome_1.hasStructureFeature(structureFeature_1x)) {
                    return true;
                }
            }

            return false;
        });
    }

    public Set<BlockState> getTopMaterials() {
        if (this.topMaterials.isEmpty()) {
            Biome[] var1 = this.biomes;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Biome biome_1 = var1[var3];
                this.topMaterials.add(biome_1.getSurfaceConfig().getTopMaterial());
            }
        }

        return this.topMaterials;
    }

    public Set<Biome> getBiomesInArea(int int_1, int int_2, int int_3) {
        return Sets.newHashSet(this.biomes);
    }
}
