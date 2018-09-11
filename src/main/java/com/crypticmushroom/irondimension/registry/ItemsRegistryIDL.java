package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.items.*;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.crypticmushroom.irondimension.registry.ItemsIDL.*;
import static net.minecraft.inventory.EntityEquipmentSlot.*;

@Mod.EventBusSubscriber(modid = IronDimension.MODID)
public class ItemsRegistryIDL {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ItemRegistryHelper items = new ItemRegistryHelper(event.getRegistry());

        items.register("iron_stick", new ItemIDLGeneric());
        items.register("super_iron_ingot", new ItemIDLGeneric());
        items.register("radioactive_iron_ingot", new ItemRadioactive());

        items.register("super_iron_sword", new ItemSuperIronSword(TOOL_SUPER_IRON));
        items.register("super_iron_pickaxe", new ItemSuperIronPickaxe(TOOL_SUPER_IRON));
        items.register("super_iron_axe", new ItemSuperIronAxe(TOOL_SUPER_IRON));
        items.register("super_iron_shovel", new ItemSuperIronShovel(TOOL_SUPER_IRON));
        items.register("super_iron_hoe", new ItemSuperIronHoe(TOOL_SUPER_IRON));
        items.register("radioactive_sword", new ItemRadioactiveSword(TOOL_RADIOACTIVE));
        items.register("radioactive_pickaxe", new ItemRadioactivePickaxe(TOOL_RADIOACTIVE));
        items.register("radioactive_axe", new ItemRadioactiveAxe(TOOL_RADIOACTIVE));
        items.register("radioactive_shovel", new ItemRadioactiveShovel(TOOL_RADIOACTIVE));
        items.register("radioactive_hoe", new ItemRadioactiveHoe(TOOL_RADIOACTIVE));
        items.register("iron_flint_and_steel", new ItemIronFlintAndSteel());

        items.register("super_iron_helmet", new ItemSuperIronArmor(ARMOR_SUPER_IRON, HEAD));
        items.register("super_iron_chestplate", new ItemSuperIronArmor(ARMOR_SUPER_IRON, CHEST));
        items.register("super_iron_legs", new ItemSuperIronArmor(ARMOR_SUPER_IRON, LEGS));
        items.register("super_iron_boots", new ItemSuperIronArmor(ARMOR_SUPER_IRON, FEET));
        items.register("radioactive_iron_helmet", new ItemRadioactiveIronArmor(ARMOR_RADIOACTIVE, HEAD));
        items.register("radioactive_iron_chestplate", new ItemRadioactiveIronArmor(ARMOR_RADIOACTIVE, CHEST));
        items.register("radioactive_iron_legs", new ItemRadioactiveIronArmor(ARMOR_RADIOACTIVE, LEGS));
        items.register("radioactive_iron_boots", new ItemRadioactiveIronArmor(ARMOR_RADIOACTIVE, FEET));

        //Blocks
        //items.registerBlock(BlocksIDL.iron_dim_portal);
        items.registerBlock(BlocksIDL.iron_dirt);
        items.registerBlock(BlocksIDL.iron_grass);
        items.registerBlock(BlocksIDL.iron_log);
        items.registerBlock(BlocksIDL.iron_leaves);
        items.registerBlock(BlocksIDL.iron_sapling);
        items.registerBlock(BlocksIDL.soft_iron);
        items.registerBlock(BlocksIDL.iron_bricks);
        items.registerBlock(BlocksIDL.iron_brick_stairs);
        items.registerBlock(BlocksIDL.super_iron_ore);
        items.registerBlock(BlocksIDL.super_iron_block);
        items.registerBlock(BlocksIDL.radioactive_iron_ore);
        items.registerBlock(BlocksIDL.radioactive_iron_block);
    }

    public static class ItemRegistryHelper {
        private final IForgeRegistry<Item> registry;

        private static List<RegisterModelUtil> itemModels = new ArrayList<>();

        public static List<RegisterModelUtil> getItemModels() {
            return ImmutableList.copyOf(itemModels);
        }

        ItemRegistryHelper(IForgeRegistry<Item> registry) {
            this.registry = registry;
        }

        private void register(String name, Item item) {
            item.setRegistryName(IronDimension.MODID, name);
            item.setTranslationKey(IronDimension.MODID + "." + name);

            if (item instanceof RegisterModelUtil) {
                itemModels.add((RegisterModelUtil) item);
            }
            registry.register(item);
        }

        private void registerBlock(Block block) {
            ItemBlock metaItemBlock = new ItemBlock(block);
            register(metaItemBlock);
        }

        private void register(ItemBlock item) {
            //noinspection ConstantConditions
            item.setRegistryName(item.getBlock().getRegistryName());
            item.setTranslationKey(item.getBlock().getTranslationKey());
            registry.register(item);
        }
    }
}
