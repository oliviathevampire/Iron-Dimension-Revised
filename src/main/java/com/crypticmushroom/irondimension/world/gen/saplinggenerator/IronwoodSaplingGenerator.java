package com.crypticmushroom.irondimension.world.gen.saplinggenerator;

import com.crypticmushroom.irondimension.world.gen.feature.HornbeamTreeFeature;
import com.crypticmushroom.irondimension.world.gen.feature.IronwoodTreeFeature;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Random;

public class IronwoodSaplingGenerator extends IronDimensionSaplingGenerator {
    @Override
    protected AbstractTreeFeature<DefaultFeatureConfig> createTreeFeature(Random var1) {
        return new IronwoodTreeFeature(DefaultFeatureConfig::deserialize, false);
    }
}
