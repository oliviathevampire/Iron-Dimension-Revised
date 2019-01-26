package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.world.biomes.IronPlains;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGenerator;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;

public class WorldIronDimension {
    public static final DimensionType IRON_DIMENSION = Registry.DIMENSION.get(new Identifier("iron_dimension"));

    @SuppressWarnings("unchecked")
    public static final ChunkGeneratorType<IronDimensionChunkGeneratorConfig, IronDimensionChunkGenerator> IRON_DIMENSION_CHUNK_GENERATOR = (ChunkGeneratorType<IronDimensionChunkGeneratorConfig, IronDimensionChunkGenerator>) Registry.CHUNK_GENERATOR_TYPE.get(new Identifier("iron_surface"));

    public static Biome IRON_PLAINS;

    public static void registerWorld() {
        IRON_PLAINS = Registry.register(Registry.BIOME, new Identifier(IronDimension.MODID, "iron_plains"), new IronPlains());
    }
}
