package com.crypticmushroom.irondimension.world.gen.feature;

import com.crypticmushroom.irondimension.registry.BlocksID;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FlowerFeature;

import java.util.Random;
import java.util.function.Function;

public class IronFlowerFeature extends FlowerFeature {
    private static final Block[] FLOWERS;
    public IronFlowerFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1) {
        super(function_1);
    }

    @Override
    public boolean generate(IWorld var1, ChunkGenerator<? extends ChunkGeneratorConfig> var2, Random var3, BlockPos var4, DefaultFeatureConfig var5) {
        return method_13176(var1, var2, var3, var4, var5);
    }

    @Override
    public BlockState getFlowerToPlace(Random var1, BlockPos blockPos_1) {
        double double_1 = MathHelper.clamp((1.0D + Biome.FOLIAGE_NOISE.sample((double)blockPos_1.getX() / 48.0D, (double)blockPos_1.getZ() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
        Block block_1 = FLOWERS[(int)(double_1 * (double)FLOWERS.length)];
        return block_1.getDefaultState();
    }

    static {
        FLOWERS = new Block[]{
                BlocksID.acidrose_bush,
                BlocksID.aerialweed,
                BlocksID.steel_orchid,
                BlocksID.molten_daisy,
                BlocksID.firepod,
                BlocksID.ferric_flower,
                BlocksID.corroshroom,
                BlocksID.coilfern
        };
    }
}
