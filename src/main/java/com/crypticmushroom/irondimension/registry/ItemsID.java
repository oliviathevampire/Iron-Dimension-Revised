package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.items.*;
import com.crypticmushroom.irondimension.utils.materials.ArmorMaterial;
import com.crypticmushroom.irondimension.utils.materials.ToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class ItemsID {

    public static Item iron_stick = null;
    public static Item bison_dung = null;
    public static Item super_iron_ingot = null;
    public static Item super_iron_nugget = null;
    public static Item radioactive_iron_ingot = null;
    public static Item radioactive_iron_nugget = null;
    public static Item infernal_iron_ingot = null;
    public static Item infernal_iron_nugget = null;
    public static Item lumen_iron_ingot = null;
    public static Item lumen_iron_nugget = null;
	public static Item iron_hide = null;
	
    public static Item super_iron_sword = null;
    public static Item super_iron_pickaxe = null;
    public static Item super_iron_axe = null;
    public static Item super_iron_shovel = null;
    public static Item super_iron_hoe = null;
    public static Item radioactive_sword = null;
    public static Item radioactive_pickaxe = null;
    public static Item radioactive_axe = null;
    public static Item radioactive_shovel = null;
    public static Item radioactive_hoe = null;
    public static Item infernal_sword = null;
    public static Item infernal_pickaxe = null;
    public static Item infernal_axe = null;
    public static Item infernal_shovel = null;
    public static Item infernal_hoe = null;
    public static Item ironwood_sword = null;
    public static Item ironwood_pickaxe = null;
    public static Item ironwood_axe = null;
    public static Item ironwood_shovel = null;
    public static Item ironwood_hoe = null;

    public static Item super_iron_helmet = null;
    public static Item super_iron_chestplate = null;
    public static Item super_iron_leggings = null;
    public static Item super_iron_boots = null;
    public static Item radioactive_iron_helmet = null;
    public static Item radioactive_iron_chestplate = null;
    public static Item radioactive_iron_leggings = null;
    public static Item radioactive_iron_boots = null;
    public static Item infernal_iron_helmet = null;
    public static Item infernal_iron_chestplate = null;
    public static Item infernal_iron_leggings = null;
    public static Item infernal_iron_boots = null;

    public static void init() {
        iron_stick = register("iron_stick", new ItemIDLGeneric());
        bison_dung = register("bison_dung", new ItemIDLGeneric());
        super_iron_ingot = register("super_iron_ingot", new ItemIDLGeneric());
        super_iron_ingot = register("super_iron_nugget", new ItemIDLGeneric());
        radioactive_iron_ingot = register("radioactive_iron_ingot", new ItemIDLGeneric());
        radioactive_iron_nugget = register("radioactive_iron_nugget",new ItemIDLGeneric());
        infernal_iron_ingot = register("infernal_iron_ingot",new ItemIDLGeneric());
        infernal_iron_nugget = register("infernal_iron_nugget",new ItemIDLGeneric());
        lumen_iron_ingot = register("lumen_iron_ingot",new ItemIDLGeneric());
        lumen_iron_nugget = register("lumen_iron_nugget",new ItemIDLGeneric());
        iron_hide = register("iron_hide",new ItemIDLGeneric());

        super_iron_sword = register("super_iron_sword", new ItemSword(ToolMaterials.SUPER_IRON));
        super_iron_pickaxe = register("super_iron_pickaxe", new ItemPickaxe(ToolMaterials.SUPER_IRON));
        super_iron_axe = register("super_iron_axe", new ItemAxe(ToolMaterials.SUPER_IRON, 9.0F));
        super_iron_shovel = register("super_iron_shovel", new ItemShovel(ToolMaterials.SUPER_IRON));
        super_iron_hoe = register("super_iron_hoe", new ItemHoe(ToolMaterials.SUPER_IRON));
        radioactive_sword = register("radioactive_sword", new ItemSword(ToolMaterials.RADIOACTIVE));
        radioactive_pickaxe = register("radioactive_pickaxe", new ItemPickaxe(ToolMaterials.RADIOACTIVE));
        radioactive_axe = register("radioactive_axe", new ItemAxe(ToolMaterials.RADIOACTIVE, 10.0F));
        radioactive_shovel = register("radioactive_shovel", new ItemShovel(ToolMaterials.RADIOACTIVE));
        radioactive_hoe = register("radioactive_hoe", new ItemHoe(ToolMaterials.RADIOACTIVE));
        infernal_sword = register("infernal_sword", new ItemSword(ToolMaterials.INFERNAL));
        infernal_pickaxe = register("infernal_pickaxe", new ItemPickaxe(ToolMaterials.INFERNAL));
        infernal_axe = register("infernal_axe", new ItemAxe(ToolMaterials.INFERNAL, 1.0F));
        infernal_shovel = register("infernal_shovel", new ItemShovel(ToolMaterials.INFERNAL));
        infernal_hoe = register("infernal_hoe", new ItemHoe(ToolMaterials.INFERNAL));
        ironwood_sword = register("ironwood_sword", new ItemSword(ToolMaterials.IRONWOOD));
        ironwood_pickaxe = register("ironwood_pickaxe", new ItemPickaxe(ToolMaterials.IRONWOOD));
        ironwood_axe = register("ironwood_axe", new ItemAxe(ToolMaterials.IRONWOOD, 1.0F));
        ironwood_shovel = register("ironwood_shovel", new ItemShovel(ToolMaterials.IRONWOOD));
        ironwood_hoe = register("ironwood_hoe", new ItemHoe(ToolMaterials.IRONWOOD));

        super_iron_helmet = register("super_iron_helmet",new ItemArmor(ArmorMaterial.SUPER_IRON, EquipmentSlot.HEAD));
        super_iron_chestplate = register("super_iron_chestplate",new ItemArmor(ArmorMaterial.SUPER_IRON, EquipmentSlot.CHEST));
        super_iron_leggings = register("super_iron_leggings",new ItemArmor(ArmorMaterial.SUPER_IRON, EquipmentSlot.LEGS));
        super_iron_boots = register("super_iron_boots",new ItemArmor(ArmorMaterial.SUPER_IRON, EquipmentSlot.FEET));
        radioactive_iron_helmet = register("radioactive_iron_helmet",new ItemArmor(ArmorMaterial.RADIOACTIVE, EquipmentSlot.HEAD));
        radioactive_iron_chestplate = register("radioactive_iron_chestplate",new ItemArmor(ArmorMaterial.RADIOACTIVE, EquipmentSlot.CHEST));
        radioactive_iron_leggings = register("radioactive_iron_leggings",new ItemArmor(ArmorMaterial.RADIOACTIVE, EquipmentSlot.LEGS));
        radioactive_iron_boots = register("radioactive_iron_boots",new ItemArmor(ArmorMaterial.RADIOACTIVE, EquipmentSlot.FEET));
        infernal_iron_helmet = register("infernal_iron_helmet",new ItemArmor(ArmorMaterial.INFERNAl, EquipmentSlot.HEAD));
        infernal_iron_chestplate = register("infernal_iron_chestplate",new ItemArmor(ArmorMaterial.INFERNAl, EquipmentSlot.CHEST));
        infernal_iron_leggings = register("infernal_iron_leggings",new ItemArmor(ArmorMaterial.INFERNAl, EquipmentSlot.LEGS));
        infernal_iron_boots = register("infernal_iron_boots",new ItemArmor(ArmorMaterial.INFERNAl, EquipmentSlot.FEET));
    }

    private static Item register(String name, Item item) {
        Registry.register(Registry.ITEM, IronDimension.MODID + ":" + name, item);
        return item;
    }
}
