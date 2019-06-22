package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.world.gen.feature.IronDimensionTreeFeature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(RandomFeatureEntry.class)
public class MixinRandomFeatureEntry<FC extends FeatureConfig> {

    @Shadow @Final public Feature<FC> feature;

    @Shadow @Final public FC config;

    public boolean generate(IWorld iWorld_1, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator_1, Random random_1, BlockPos blockPos_1) {
        if (this.feature instanceof IronDimensionTreeFeature) {
            return ((IronDimensionTreeFeature)this.feature).ironDimensionGenerate(iWorld_1, chunkGenerator_1, random_1, blockPos_1, this.config);
        } else {
            return this.feature.generate(iWorld_1, chunkGenerator_1, random_1, blockPos_1, this.config);
        }
    }
}
