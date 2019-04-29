package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import com.crypticmushroom.irondimension.world.gen.carver.IronCarvers;
import com.crypticmushroom.irondimension.world.gen.surfacebuilder.IronSurfaceBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;

public class IronBiome extends Biome {
    public IronBiome(Settings settings) {
        super(settings
                .configureSurfaceBuilder(new IronSurfaceBuilder(), WorldIronDimension.GRASS_CONFIG)
                .waterColor(0xe0e0e0)
                .waterFogColor(0xe0e0e0)
        );
        this.addCarver(GenerationStep.Carver.AIR, Biome.configureCarver(IronCarvers.ID_CARVER, new ProbabilityConfig(0.14285715F)));
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
