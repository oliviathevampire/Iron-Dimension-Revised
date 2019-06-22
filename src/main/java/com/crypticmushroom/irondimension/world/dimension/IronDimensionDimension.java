package com.crypticmushroom.irondimension.world.dimension;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import com.crypticmushroom.irondimension.world.biomes.IronBiomeSourceConfig;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.*;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class IronDimensionDimension extends Dimension {

    public IronDimensionDimension(World world_1, DimensionType dimensionType_1) {
        super(world_1, dimensionType_1);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return WorldIronDimension.IRON_DIMENSION_CHUNK_GENERATOR.create(
                this.world, WorldIronDimension.IRON_BIOME_SOURCE_BIOME_SOURCE_TYPE.applyConfig(new IronBiomeSourceConfig()
                        .setLevelProperties(this.world.getLevelProperties()).setGeneratorSettings(WorldIronDimension.IRON_DIMENSION_CHUNK_GENERATOR.createSettings())),
                new IronDimensionChunkGeneratorConfig());
    }

    @Override
    public BlockPos getSpawningBlockInChunk(ChunkPos var1, boolean var2) {
        return null;
    }

    @Override
    public BlockPos getTopSpawningBlockPosition(int var1, int var2, boolean var3) {
        return null;
    }

    @Override
    public float getSkyAngle(long var1, float var3) {
        double double_1 = MathHelper.fractionalPart((double)var1 / 24000.0D - 0.25D);
        double double_2 = 0.5D - Math.cos(double_1 * 3.141592653589793D) / 2.0D;
        return (float)(double_1 * 2.0D + double_2) / 3.0F;
    }

    @Override
    public boolean hasVisibleSky() {
        return true;
    }

    @Override
    public Vec3d getFogColor(float var1, float var2) {
        int i = 0x8080a0;

        float f2 = MathHelper.cos(var1 * 3.141593F * 2.0F) * 2.0F + 0.5F;

        f2 = MathHelper.clamp(f2, 0.0F, 1.0F);

        float f3 = (i >> 16 & 0xff) / 255F;
        float f4 = (i >> 8 & 0xff) / 255F;
        float f5 = (i & 0xff) / 255F;

        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;

        return new Vec3d(f3, f4, f5);
    }

    @Override
    public boolean canPlayersSleep() {
        return true;
    }

    @Override
    public boolean shouldRenderFog(int var1, int var2) {
        return false;
    }

    @Override
    public DimensionType getType() {
        return WorldIronDimension.IRON_DIMENSION;
    }
}
