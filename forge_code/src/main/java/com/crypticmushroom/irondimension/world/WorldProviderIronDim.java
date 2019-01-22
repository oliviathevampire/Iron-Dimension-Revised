package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.registry.BiomeIDL;
import com.crypticmushroom.irondimension.registry.ConfigIDL;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class WorldProviderIronDim extends WorldProviderSurface {

    public WorldProviderIronDim() {
        setDimension(ConfigIDL.dimension.dimensionID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1) {
        return world.getStarBrightnessBody(par1);
    }

    public float getCelestialAngle(float partialTicks) {
        return calculateCelestialAngle(this.getWorldTime(), partialTicks);
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        int entityX = (int)(worldTime % 24000L);
        float f = ((float)entityX + partialTicks) / 24000.0F - 0.25F;

        if (f < 0.0F) {
            ++f;
        }

        if (f > 1.0F) {
            --f;
        }

        float time = 1.0F - (float)((Math.cos((double)f * Math.PI) + 1.0D) / 2.0D);
        f = f + (time - f) / 3.0F;
        return f;
    }

    @Override
    public void init() {
        super.init();
        this.biomeProvider = new BiomeProviderIDL(world);
    }

    @Override
    public DimensionType getDimensionType() {
        return IronDimension.dimType;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProviderIronDim(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
    }

    //Let's see what can be done here...
    @Override
    public boolean isSkyColored() {
        return true;
    }

    @Override
    public double getHorizon() {
        return 63;
    }

    @Override
    public int getAverageGroundLevel() {
        return 64;
    }

    @Override
    public boolean canRespawnHere() {
        return world.getWorldInfo().isInitialized();
    }

    @Override
    public boolean isDaytime() {
        return world.getSkylightSubtracted() < 4;
    }

    @SideOnly(Side.CLIENT)
    public Vec3d getSkyColor(Entity entityIn, float partialTicks) {
        return getSkyColorBody(entityIn, partialTicks);
    }

    @SideOnly(Side.CLIENT)
    public Vec3d getSkyColorBody(Entity entityIn, float partialTicks) {
        float angle = this.getCelestialAngle(partialTicks);
        float time = MathHelper.cos(angle * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
        time = MathHelper.clamp(time, 0.0F, 1.0F);
        int entityX = MathHelper.floor(entityIn.posX);
        int entityY = MathHelper.floor(entityIn.posY);
        int entityZ = MathHelper.floor(entityIn.posZ);
        BlockPos blockpos = new BlockPos(entityX, entityY, entityZ);
        int l = net.minecraftforge.client.ForgeHooksClient.getSkyBlendColour(world, blockpos);
        float red = (float)(l >> 16 & 255) / 255.0F;
        float green = (float)(l >> 8 & 255) / 255.0F;
        float blue = (float)(l & 255) / 255.0F;
        red = red * time;
        green = green * time;
        blue = blue * time;
        float rainTime = world.getRainStrength(partialTicks);

        if (rainTime > 0.0F) {
            float f7 = (red * 0.3F + green * 0.59F + blue * 0.11F) * 0.6F;
            float f8 = 1.0F - rainTime * 0.75F;
            red = red * f8 + f7 * (1.0F - f8);
            green = green * f8 + f7 * (1.0F - f8);
            blue = blue * f8 + f7 * (1.0F - f8);
        }

        float thunderTime = world.getThunderStrength(partialTicks);

        if (thunderTime > 0.0F) {
            float red1 = (red * 0.3F + green * 0.59F + blue * 0.11F) * 0.2F;
            float f9 = 1.0F - thunderTime * 0.75F;
            red = red * f9 + red1 * (1.0F - f9);
            green = green * f9 + red1 * (1.0F - f9);
            blue = blue * f9 + red1 * (1.0F - f9);
        }

        return new Vec3d((double)red, (double)green, (double)blue);
    }

    @Override
    public Vec3d getFogColor(float value, float time) {

        float f = MathHelper.cos(value * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        float red = 0.7529412F;
        float green = 0.84705883F;
        float blue = 1.0F;
        red = red * (f * 0.94F + 0.06F);
        green = green * (f * 0.94F + 0.06F);
        blue = blue * (f * 0.91F + 0.09F);
        return new Vec3d((double)red, (double)green, (double)blue);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getCloudColor(float partialTicks) {
        return getCloudColorBody(partialTicks);
    }

    @SideOnly(Side.CLIENT)
    public Vec3d getCloudColorBody(float partialTicks) {
        float f = this.getCelestialAngle(partialTicks);
        float f1 = MathHelper.cos(f * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
        f1 = MathHelper.clamp(f1, 0.0F, 1.0F);
        float red = 1.0F;
        float green = 1.0F;
        float blue = 1.0F;
        float f5 = world.getRainStrength(partialTicks);

        if (f5 > 0.0F) {
            float f6 = (red * 0.3F + green * 0.59F + blue * 0.11F) * 0.6F;
            float f7 = 1.0F - f5 * 0.95F;
            red = red * f7 + f6 * (1.0F - f7);
            green = green * f7 + f6 * (1.0F - f7);
            blue = blue * f7 + f6 * (1.0F - f7);
        }

        red = red * (f1 * 0.9F + 0.1F);
        green = green * (f1 * 0.9F + 0.1F);
        blue = blue * (f1 * 0.85F + 0.15F);
        float f9 = world.getThunderStrength(partialTicks);

        if (f9 > 0.0F) {
            float f10 = (red * 0.3F + green * 0.59F + blue * 0.11F) * 0.2F;
            float f8 = 1.0F - f9 * 0.95F;
            red = red * f8 + f10 * (1.0F - f8);
            green = green * f8 + f10 * (1.0F - f8);
            blue = blue * f8 + f10 * (1.0F - f8);
        }

        return new Vec3d((double)red, (double)green, (double)blue);
    }

    @Override
    public Biome getBiomeForCoords(BlockPos pos) {
        Biome biome = super.getBiomeForCoords(pos);
        if (biome == null) {
            biome = BiomeIDL.iron_highlands;
        }
        return biome;
    }

    @Override
    public float getCloudHeight() {
        return 128.0F;
    }

    @Override
    public boolean canDoRainSnowIce(@Nullable Chunk chunk) {
        return false;
    }
}
