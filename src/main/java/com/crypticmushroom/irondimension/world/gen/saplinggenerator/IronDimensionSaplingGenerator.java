package com.crypticmushroom.irondimension.world.gen.saplinggenerator;

import com.crypticmushroom.irondimension.world.gen.feature.HornbeamTreeFeature;
import com.crypticmushroom.irondimension.world.gen.feature.IronDimensionTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.Random;

public abstract class IronDimensionSaplingGenerator extends SaplingGenerator {

    @Override
    public boolean generate(IWorld iWorld_1, BlockPos blockPos_1, BlockState blockState_1, Random random_1) {
        IronDimensionTreeFeature<DefaultFeatureConfig> abstractTreeFeature_1 = (IronDimensionTreeFeature)this.createTreeFeature(random_1);
        if (abstractTreeFeature_1 == null) {
            return false;
        } else {
            iWorld_1.setBlockState(blockPos_1, Blocks.AIR.getDefaultState(), 4);
            if (abstractTreeFeature_1.ironDimensionGenerate((IWorld)iWorld_1, (ChunkGenerator)iWorld_1.getChunkManager().getChunkGenerator(), random_1, blockPos_1, FeatureConfig.DEFAULT)) {
                return true;
            } else {
                iWorld_1.setBlockState(blockPos_1, blockState_1, 4);
                return false;
            }
        }
    }
}
