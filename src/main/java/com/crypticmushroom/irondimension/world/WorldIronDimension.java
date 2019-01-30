package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.registry.BlocksIDL;
import com.crypticmushroom.irondimension.world.biomes.IronBiome;
import com.crypticmushroom.irondimension.world.biomes.IronHighlands;
import com.crypticmushroom.irondimension.world.biomes.IronPlains;
import com.crypticmushroom.irondimension.world.biomes.source.IronBiomeSource;
import com.crypticmushroom.irondimension.world.biomes.source.IronBiomeSourceConfig;
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
    public static final DimensionType IRON_DIMENSION = Registry.DIMENSION.get(new Identifier("iron_dimension"));

    @SuppressWarnings("unchecked")
    public static final ChunkGeneratorType<IronDimensionChunkGeneratorConfig, IronDimensionChunkGenerator> IRON_DIMENSION_CHUNK_GENERATOR = (ChunkGeneratorType<IronDimensionChunkGeneratorConfig, IronDimensionChunkGenerator>) Registry.CHUNK_GENERATOR_TYPE.get(new Identifier(IronDimension.MODID,"iron_surface"));
    public static final BiomeSourceType<IronBiomeSourceConfig, IronBiomeSource> IRON_BIOME_SOURCE = (BiomeSourceType<IronBiomeSourceConfig, IronBiomeSource>) Registry.BIOME_SOURCE_TYPE.get(new Identifier(IronDimension.MODID, "iron"));

    public static Biome IRON_PLAINS;
    public static Biome IRON_HIGHLANDS;
    public static TernarySurfaceConfig GRASS_CONFIG;

    public static void registerWorld() {
        IronFeatures.init();
        GRASS_CONFIG = new TernarySurfaceConfig(BlocksIDL.iron_grass.getDefaultState(), BlocksIDL.iron_dirt.getDefaultState(), BlocksIDL.iron_dirt.getDefaultState());
        IRON_PLAINS = Registry.register(Registry.BIOME, new Identifier(IronDimension.MODID, "iron_plains"), new IronPlains());
        IRON_HIGHLANDS = Registry.register(Registry.BIOME, new Identifier(IronDimension.MODID, "iron_highlands"), new IronHighlands());
    }
}
