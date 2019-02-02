package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.world.gen.feature.IronFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.FeatureConfig;

public class IronPlains extends IronBiome {
    public IronPlains() {
        super(new Settings()
                .category(Category.PLAINS)
                .depth(0.00F)
                .precipitation(Precipitation.NONE)
                .temperature(0.65F)
                .scale(0.00F)
                .downfall(0.00F)
        );
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.IRON_TREE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(0, 0.1F, 1)));
    }
}
