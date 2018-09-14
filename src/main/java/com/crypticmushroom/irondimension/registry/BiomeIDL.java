package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.world.BiomeIronDimension;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(IronDimension.MODID)
@Mod.EventBusSubscriber(modid = IronDimension.MODID)
public class BiomeIDL {

    public static final Biome iron_dimension = new BiomeIronDimension(new Biome.BiomeProperties("Iron Dimension")
            .setRainDisabled()
            .setRainfall(0)
            .setTemperature(0.7F)
            .setHeightVariation(0.1F)
            .setBaseHeight(0.05F));

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        final BiomeRegistry biomes = new BiomeRegistry(event.getRegistry());

        biomes.register("iron_dimension", iron_dimension, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY);
    }

    private static class BiomeRegistry {
        private final IForgeRegistry<Biome> registry;

        BiomeRegistry(IForgeRegistry<Biome> registry) {
            this.registry = registry;
        }

        public void register(String name, Biome biome, BiomeDictionary.Type... biomeTypes) {
            biome.setRegistryName(IronDimension.MODID, name);
            registry.register(biome);
            BiomeDictionary.addTypes(biome, biomeTypes);
        }
    }
}
