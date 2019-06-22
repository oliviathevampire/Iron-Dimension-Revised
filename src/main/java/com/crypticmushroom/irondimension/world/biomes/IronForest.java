package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.world.gen.feature.IronFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.FeatureConfig;

public class IronForest extends IronBiome {
    public IronForest() {
        super(new Settings()
                .category(Category.FOREST)
                .depth(0.1F)
                .precipitation(Precipitation.NONE)
                .temperature(0.60F)
                .scale(0.2F)
                .downfall(0.8F)
        );
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.HORNBEAM_TREE, FeatureConfig.DEFAULT,
                Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.1F, 1)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.IRONWOOD_TREE, FeatureConfig.DEFAULT,
                Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.1F, 1)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.RUSTY_IRONWOOD_TREE, FeatureConfig.DEFAULT,
                Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.1F, 1)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.FLOWER, FeatureConfig.DEFAULT,
                Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(10)));
    }
}
