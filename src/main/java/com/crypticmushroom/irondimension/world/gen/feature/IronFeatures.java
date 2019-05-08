package com.crypticmushroom.irondimension.world.gen.feature;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.registry.BlocksID;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class IronFeatures {
    public static Feature<DefaultFeatureConfig> IRON_TREE;
    public static Feature<IronOreFeatureConfig> IRON_ORE;

    public static void init() {
        IRON_TREE = Registry.register(Registry.FEATURE, new Identifier(IronDimension.MODID,"fancy_tree"), new HornbeamTreeFeature(DefaultFeatureConfig::deserialize, true));
        IRON_ORE = Registry.register(Registry.FEATURE, new Identifier(IronDimension.MODID, "ore"), new IronOreFeature(IronOreFeatureConfig::deserialize));
    }
}
