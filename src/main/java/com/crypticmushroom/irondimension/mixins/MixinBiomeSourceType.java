package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.world.biomes.IronBiomeSource;
import com.crypticmushroom.irondimension.world.biomes.IronBiomeSourceConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.BiomeSourceConfig;
import net.minecraft.world.biome.source.BiomeSourceType;
import net.minecraft.world.biome.source.CheckerboardBiomeSourceConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Function;
import java.util.function.Supplier;

@Mixin(BiomeSourceType.class)
public class MixinBiomeSourceType {

    private static final BiomeSourceType<IronBiomeSourceConfig, IronBiomeSource> IRON_BIOME_SOURCE_BIOME_SOURCE_TYPE =
            Registry.register(Registry.BIOME_SOURCE_TYPE,IronDimension.MODID + ":iron_biome_source_type",
                    new BiomeSourceType<>((Function<IronBiomeSourceConfig, IronBiomeSource>) IronBiomeSource::new,
                            (Supplier<IronBiomeSourceConfig>)IronBiomeSourceConfig::new));
}
