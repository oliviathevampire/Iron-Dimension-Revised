package com.crypticmushroom.irondimension.world.gen.chunk;

import net.minecraft.entity.EntityCategory;
import net.minecraft.sortme.SpawnHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.List;

public class IronDimensionChunkGenerator extends SurfaceChunkGenerator<IronDimensionChunkGeneratorConfig> {

    public IronDimensionChunkGenerator(IWorld iWorld_1, BiomeSource biomeSource_1, IronDimensionChunkGeneratorConfig chunkGeneratorConfig_1) {
        super(iWorld_1, biomeSource_1, 4, 8, 256, chunkGeneratorConfig_1, true);
    }

    public void populateEntities(ChunkRegion chunkRegion_1) {
        int int_1 = chunkRegion_1.getCenterChunkX();
        int int_2 = chunkRegion_1.getCenterChunkZ();
        Biome biome_1 = chunkRegion_1.getChunk(int_1, int_2).getBiomeArray()[0];
        ChunkRandom chunkRandom_1 = new ChunkRandom();
        chunkRandom_1.setSeed(chunkRegion_1.getSeed(), int_1 << 4, int_2 << 4);
        SpawnHelper.populateEntities(chunkRegion_1, biome_1, int_1, int_2, chunkRandom_1);
    }

    protected void sampleNoiseColumn(double[] doubles_1, int int_1, int int_2) {
        double double_1 = 684.4119873046875D;
        double double_2 = 684.4119873046875D;
        double double_3 = 8.555149841308594D;
        double double_4 = 4.277574920654297D;
        int int_3 = 0;
        int int_4 = 0;
        this.sampleNoiseColumn(doubles_1, int_1, int_2, 684.4119873046875D, 684.4119873046875D, 8.555149841308594D, 4.277574920654297D, 3, -10);
    }

    @Override
    protected double[] computeNoiseRange(int var1, int var2) {
        return new double[0];
    }

    protected double computeNoiseFalloff(double double_1, double double_2, int int_1) {
        double double_3 = 8.5D;
        double double_4 = ((double)int_1 - (8.5D + double_1 * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D / double_2;
        if (double_4 < 0.0D) {
            double_4 *= 4.0D;
        }

        return double_4;
    }

    public List<Biome.SpawnEntry> getEntitySpawnList(EntityCategory entityCategory_1, BlockPos blockPos_1) {
        if (Feature.SWAMP_HUT.method_14029(this.world, blockPos_1)) {
        } else if (entityCategory_1 == EntityCategory.MONSTER) {
        }

        return super.getEntitySpawnList(entityCategory_1, blockPos_1);
    }

    public void spawnEntities(World world_1, boolean boolean_1, boolean boolean_2) {
    }

    public int getSpawnHeight() {
        return this.world.getSeaLevel() + 1;
    }

    public int method_16398() {
        return 63;
    }
}
