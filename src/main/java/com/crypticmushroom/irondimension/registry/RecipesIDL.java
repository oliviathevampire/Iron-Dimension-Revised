package com.crypticmushroom.irondimension.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber
public class RecipesIDL {

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        //---ORE DICTIONARY---//
        OreDictionary.registerOre("dirt", BlocksIDL.iron_dirt);
        OreDictionary.registerOre("grass", BlocksIDL.iron_grass);
        OreDictionary.registerOre("treeLeaves", BlocksIDL.iron_leaves);
        OreDictionary.registerOre("treeSapling", BlocksIDL.iron_sapling);

        GameRegistry.addSmelting(BlocksIDL.iron_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
        GameRegistry.addSmelting(BlocksIDL.soft_iron, new ItemStack(Items.IRON_INGOT, 1), 0.5F);
        GameRegistry.addSmelting(BlocksIDL.super_iron_ore, new ItemStack(ItemsIDL.super_iron_ingot, 1), 0.7F);
        GameRegistry.addSmelting(BlocksIDL.radioactive_iron_ore, new ItemStack(ItemsIDL.radioactive_iron_ingot, 1), 1.0F);
    }
}
