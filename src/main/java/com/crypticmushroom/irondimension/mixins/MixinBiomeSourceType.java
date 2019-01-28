package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.world.biomes.source.IronBiomeSource;
import com.crypticmushroom.irondimension.world.biomes.source.IronBiomeSourceConfig;
import com.crypticmushroom.irondimension.world.biomes.source.IronBiomeSourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.source.BiomeSourceType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BiomeSourceType.class)
public class MixinBiomeSourceType {

    @SuppressWarnings("unused")
    private static final BiomeSourceType<IronBiomeSourceConfig, IronBiomeSource> IRON = Registry.register(Registry.BIOME_SOURCE_TYPE, new Identifier(IronDimension.MODID, "iron"), new IronBiomeSourceType());
}
