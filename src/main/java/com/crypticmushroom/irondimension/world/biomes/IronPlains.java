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
                .depth(0.125F)
                .precipitation(Precipitation.NONE)
                .temperature(0.65F)
                .scale(0.05F)
                .downfall(0.4F)
        );
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.IRON_TREE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(0, 0.1F, 1)));
    }
}
