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
        OreDictionary.registerOre("treeLeaves", BlocksIDL.ironwood_leaves);
        OreDictionary.registerOre("treeLeaves", BlocksIDL.hornbeam_leaves);
        OreDictionary.registerOre("treeSapling", BlocksIDL.ironwood_sapling);
        OreDictionary.registerOre("treeSapling", BlocksIDL.hornbeam_sapling);
        OreDictionary.registerOre("planksIron", BlocksIDL.ironwood_planks);
        OreDictionary.registerOre("planksIron", BlocksIDL.hornbeam_planks);

        GameRegistry.addSmelting(BlocksIDL.ironwood_log, new ItemStack(ItemsIDL.iron_charcoal, 1, 1), 0.15F);
        GameRegistry.addSmelting(BlocksIDL.hornbeam_log, new ItemStack(ItemsIDL.iron_charcoal, 1, 1), 0.15F);
        GameRegistry.addSmelting(BlocksIDL.soft_iron, new ItemStack(Items.IRON_INGOT, 1), 0.5F);
        GameRegistry.addSmelting(BlocksIDL.super_iron_ore, new ItemStack(ItemsIDL.super_iron_ingot, 1), 0.7F);
        GameRegistry.addSmelting(BlocksIDL.radioactive_iron_ore, new ItemStack(ItemsIDL.radioactive_iron_ingot, 1), 1.0F);
    }
}
