package com.crypticmushroom.irondimension.world.gen.saplinggenerator;

import com.crypticmushroom.irondimension.world.gen.feature.HornbeamTreeFeature;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Random;

public class HornbeamSaplingGenerator extends SaplingGenerator {
    @Override
    protected AbstractTreeFeature<DefaultFeatureConfig> createTreeFeature(Random var1) {
        return new HornbeamTreeFeature(DefaultFeatureConfig::deserialize, true);
    }
}
