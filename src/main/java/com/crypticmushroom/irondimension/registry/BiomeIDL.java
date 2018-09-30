package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.world.biomes.*;
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

    public static final Biome iron_highlands = new BiomeIronDimension(new Biome.BiomeProperties("Iron Highlands")
            .setRainDisabled()
            .setRainfall(0)
            .setTemperature(0.7F)
            .setHeightVariation(0.1F)
            .setBaseHeight(0.5F));
    public static final Biome iron_forest = new BiomeIronForest(new Biome.BiomeProperties("Iron Forest")
            .setRainDisabled()
            .setRainfall(0)
            .setTemperature(0.60F)
            .setHeightVariation(0.2F)
            .setBaseHeight(0.5F));
    public static final Biome iron_plains = new BiomeIronPlains(new Biome.BiomeProperties("Iron Plains")
            .setRainDisabled()
            .setRainfall(0)
            .setTemperature(0.65F)
            .setHeightVariation(0.05F)
            .setBaseHeight(0.3F));
    public static final Biome glowing_cliffs = new BiomeGlowingCliffs(new Biome.BiomeProperties("Glowing Cliffs")
            .setRainDisabled()
            .setRainfall(0)
            .setTemperature(0.75F)
            .setHeightVariation(0.05F)
            .setBaseHeight(0.8F));
    public static final Biome noxious_swamp = new BiomeNoxiousSwamp(new Biome.BiomeProperties("Noxious Swamp")
            .setRainDisabled()
            .setRainfall(0)
            .setTemperature(0.75F)
            .setHeightVariation(0.05F)
            .setBaseHeight(0.5F));
    public static final Biome noxious_plains = new BiomeGlowingCliffs(new Biome.BiomeProperties("Noxious Plains")
            .setRainDisabled()
            .setRainfall(0)
            .setTemperature(0.70F)
            .setHeightVariation(0.05F)
            .setBaseHeight(0.3F));


    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        final BiomeRegistry biomes = new BiomeRegistry(event.getRegistry());

        biomes.register("iron_highlands", iron_highlands, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY);
        biomes.register("iron_forest", iron_forest, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE);
        biomes.register("iron_plains", iron_plains, BiomeDictionary.Type.PLAINS);
        biomes.register("glowing_cliffs", glowing_cliffs, BiomeDictionary.Type.MESA);
        biomes.register("noxious_swamp", noxious_swamp, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.WET);
        biomes.register("noxious_plains", noxious_plains, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.WASTELAND);
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
