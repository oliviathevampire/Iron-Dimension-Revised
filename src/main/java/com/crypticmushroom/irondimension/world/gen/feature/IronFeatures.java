package com.crypticmushroom.irondimension.world.gen.feature;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class IronFeatures {
    public static Feature<DefaultFeatureConfig> IRON_TREE;
    public static void init() {
        IRON_TREE = Registry.register(Registry.FEATURE, new Identifier(IronDimension.MODID,"fancy_tree"), new HornbeamTreeFeature(DefaultFeatureConfig::deserialize, true));
    }
}
