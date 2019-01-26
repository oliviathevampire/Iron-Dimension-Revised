package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGenerator;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorConfig;
import com.crypticmushroom.irondimension.world.gen.chunk.IronDimensionChunkGeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ChunkGeneratorType.class)
public class MixinChunkGeneratorType {

    @SuppressWarnings("unused")
    private static final ChunkGeneratorType<IronDimensionChunkGeneratorConfig, IronDimensionChunkGenerator> IRON_SURFACE = Registry.register(Registry.CHUNK_GENERATOR_TYPE, "iron_surface", new IronDimensionChunkGeneratorType());
}
