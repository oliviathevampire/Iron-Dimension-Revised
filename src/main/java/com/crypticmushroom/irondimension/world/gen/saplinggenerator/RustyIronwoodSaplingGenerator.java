package com.crypticmushroom.irondimension.world.gen.saplinggenerator;

import com.crypticmushroom.irondimension.world.gen.feature.IronwoodTreeFeature;
import com.crypticmushroom.irondimension.world.gen.feature.RustyIronwoodTreeFeature;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Random;

public class RustyIronwoodSaplingGenerator extends IronDimensionSaplingGenerator {
    @Override
    protected AbstractTreeFeature<DefaultFeatureConfig> createTreeFeature(Random var1) {
        return new RustyIronwoodTreeFeature(DefaultFeatureConfig::deserialize, false);
    }
}
