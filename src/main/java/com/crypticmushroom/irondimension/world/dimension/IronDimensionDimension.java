package com.crypticmushroom.irondimension.world.dimension;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.*;
import net.minecraft.world.chunk.ChunkPos;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class IronDimensionDimension extends Dimension {
    private final float[] sunriseSunsetColors = new float[4];
    private static Biome[] biomes;

    public IronDimensionDimension(World world_1, DimensionType dimensionType_1) {
        super(world_1, dimensionType_1);
        this.biomes = new Biome[] {
                WorldIronDimension.IRON_PLAINS,
                WorldIronDimension.IRON_HIGHLANDS,
                WorldIronDimension.IRON_FOREST
        };
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return WorldIronDimension.IRON_DIMENSION_CHUNK_GENERATOR.create(
                this.world,
                BiomeSourceType.CHECKERBOARD.applyConfig(new CheckerboardBiomeSourceConfig().method_8777(this.biomes).method_8780(this.biomes.length)),
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
        return 8.0F;
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

    @Environment(EnvType.CLIENT)
    public float[] method_12446(float var1, float var2)
    {
        float f2 = 0.4F;
        float f3 = MathHelper.cos(var1 * 3.141593F * 2.0F) - 0.0F;
        float f4 = -0F;

        if (f3 >= f4 - f2 && f3 <= f4 + f2)
        {
            float f5 = (f3 - f4) / f2 * 0.5F + 0.5F;
            float f6 = 1.0F - (1.0F - MathHelper.sin(f5 * 3.141593F)) * 0.99F;
            f6 *= f6;
            this.sunriseSunsetColors[0] = f5 * 0.3F + 0.1F;
            this.sunriseSunsetColors[1] = f5 * f5 * 0.7F + 0.2F;
            this.sunriseSunsetColors[2] = f5 * f5 * 0.7F + 0.2F;
            this.sunriseSunsetColors[3] = f6;

            return this.sunriseSunsetColors;
        }

        return null;
    }

    @Override
    public DimensionType getType() {
        return WorldIronDimension.IRON_DIMENSION;
    }
}
