package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.registry.BlocksID;
import com.crypticmushroom.irondimension.world.WorldIronDimension;
import com.crypticmushroom.irondimension.world.gen.carver.IronCarvers;
import com.crypticmushroom.irondimension.world.gen.feature.IronFeatures;
import com.crypticmushroom.irondimension.world.gen.feature.IronOreFeatureConfig;
import com.crypticmushroom.irondimension.world.gen.surfacebuilder.IronSurfaceBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class IronBiome extends Biome {
    public IronBiome(Settings settings) {
        super(settings
                .configureSurfaceBuilder(new IronSurfaceBuilder(), WorldIronDimension.GRASS_CONFIG)
                .waterColor(0xe0e0e0)
                .waterFogColor(0xe0e0e0)
        );
        this.addCarver(GenerationStep.Carver.AIR, Biome.configureCarver(IronCarvers.ID_CARVER, new ProbabilityConfig(0.14285715F)));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(IronFeatures.IRON_ORE,
                new IronOreFeatureConfig(IronOreFeatureConfig.Target.IRON, null, BlocksID.super_iron_ore.getDefaultState(), 14),
                Decorator.COUNT_RANGE, new RangeDecoratorConfig(16, 10, 20, 128)));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(IronFeatures.IRON_ORE,
                new IronOreFeatureConfig(IronOreFeatureConfig.Target.IRON, null, BlocksID.infernal_iron_ore.getDefaultState(), 14),
                Decorator.COUNT_RANGE, new RangeDecoratorConfig(16, 10, 20, 128)));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(IronFeatures.IRON_ORE,
                new IronOreFeatureConfig(IronOreFeatureConfig.Target.IRON, null, BlocksID.lumen_iron_ore.getDefaultState(), 14),
                Decorator.COUNT_RANGE, new RangeDecoratorConfig(16, 10, 20, 128)));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, configureFeature(IronFeatures.IRON_ORE,
                new IronOreFeatureConfig(IronOreFeatureConfig.Target.IRON, null, BlocksID.radioactive_iron_ore.getDefaultState(), 14),
                Decorator.COUNT_RANGE, new RangeDecoratorConfig(16, 10, 20, 128)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, configureFeature(IronFeatures.FLOWER, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(100)));
    }

    @Override
    public int getGrassColorAt(BlockPos blockPos_1) {
        return 0xe0e0e0;
    }

    @Override
    public int getFoliageColorAt(BlockPos blockPos_1) {
        return 0xe0e0e0;
    }
}
