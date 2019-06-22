package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.registry.BlocksID;
import com.crypticmushroom.irondimension.world.biomes.*;
import com.crypticmushroom.irondimension.world.gen.carver.IronCarvers;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGenerator;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import com.crypticmushroom.irondimension.world.gen.feature.IronFeatures;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSourceType;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class WorldIronDimension {
    public static final DimensionType IRON_DIMENSION = Registry.DIMENSION.get(new Identifier(IronDimension.MODID,"iron_dimension"));

    @SuppressWarnings("unchecked")
    public static final ChunkGeneratorType<IronDimensionChunkGeneratorConfig, IronDimensionChunkGenerator> IRON_DIMENSION_CHUNK_GENERATOR =
            (ChunkGeneratorType<IronDimensionChunkGeneratorConfig, IronDimensionChunkGenerator>) Registry.CHUNK_GENERATOR_TYPE.get(new Identifier(IronDimension.MODID,
                    "iron_surface"));
    public static final BiomeSourceType<IronBiomeSourceConfig, IronBiomeSource> IRON_BIOME_SOURCE_BIOME_SOURCE_TYPE =
            (BiomeSourceType<IronBiomeSourceConfig, IronBiomeSource>)Registry.BIOME_SOURCE_TYPE.get(new Identifier(IronDimension.MODID, "iron_biome_source_type"));

    public static Biome IRON_PLAINS;
    public static Biome IRON_HIGHLANDS;
    public static Biome IRON_FOREST;
    public static Biome IRON_OCEAN;
    public static TernarySurfaceConfig GRASS_CONFIG;

    public static void registerWorld() {
        IronFeatures.init();
        IronCarvers.init();
        GRASS_CONFIG = new TernarySurfaceConfig(BlocksID.iron_grass.getDefaultState(), BlocksID.iron_dirt.getDefaultState(), BlocksID.iron_dirt.getDefaultState());
        IRON_PLAINS = Registry.register(Registry.BIOME, new Identifier(IronDimension.MODID, "iron_plains"), new IronPlains());
        IRON_HIGHLANDS = Registry.register(Registry.BIOME, new Identifier(IronDimension.MODID, "iron_highlands"), new IronHighlands());
        IRON_FOREST = Registry.register(Registry.BIOME, new Identifier(IronDimension.MODID, "iron_forest"), new IronForest());
        IRON_OCEAN = Registry.register(Registry.BIOME, new Identifier(IronDimension.MODID, "iron_ocean"), new IronOcean());
    }
}
