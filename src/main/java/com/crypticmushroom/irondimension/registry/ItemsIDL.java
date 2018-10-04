package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(IronDimension.MODID)
public class ItemsIDL {

    public static ItemArmor.ArmorMaterial ARMOR_SUPER_IRON = EnumHelper.addArmorMaterial("SUPER_IRON", "super_iron", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
    public static ItemArmor.ArmorMaterial ARMOR_RADIOACTIVE = EnumHelper.addArmorMaterial("RADIOACTIVE", "radioactive", 44, new int[]{4, 7, 9, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

    public static Item.ToolMaterial TOOL_SUPER_IRON = EnumHelper.addToolMaterial("SUPER_IRON", 3, 1561, 8.0F, 3.0F, 10);
    public static Item.ToolMaterial TOOL_RADIOACTIVE = EnumHelper.addToolMaterial("SUPER_IRON", 3, 2001, 8.5F, 4.0F, 15);

    public static final Item iron_stick = null;
    public static final Item iron_charcoal = null;
    public static final Item iron_silk = null;
    public static final Item radioactive_iron_silk = null;
    public static final Item super_iron_ingot = null;
    public static final Item radioactive_iron_ingot = null;
    public static final Item radioactive_iron_nugget = null;
    public static final Item fervid_iron_ingot = null;
    public static final Item frozen_iron_ingot = null;
    public static final Item lumen_iron_nugget = null;
    public static final Item ultra_iron_ingot = null;

    public static final Item super_iron_sword = null;
    public static final Item super_iron_pickaxe = null;
    public static final Item super_iron_axe = null;
    public static final Item super_iron_shovel = null;
    public static final Item super_iron_hoe = null;
    public static final Item radioactive_sword = null;
    public static final Item radioactive_pickaxe = null;
    public static final Item radioactive_axe = null;
    public static final Item radioactive_shovel = null;
    public static final Item radioactive_hoe = null;
    public static final Item iron_flint_and_steel = null;

    public static final Item super_iron_helmet = null;
    public static final Item super_iron_chestplate = null;
    public static final Item super_iron_legs = null;
    public static final Item super_iron_boots = null;
    public static final Item radioactive_iron_helmet = null;
    public static final Item radioactive_iron_chestplate = null;
    public static final Item radioactive_iron_legs = null;
    public static final Item radioactive_iron_boots = null;

    public static ItemStack metallic_water_bucket;
    public static ItemStack liquid_iron_bucket;

    public static void initRepairMaterials() {
        ARMOR_SUPER_IRON.setRepairItem(new ItemStack(ItemsIDL.super_iron_ingot));
        ARMOR_RADIOACTIVE.setRepairItem(new ItemStack(ItemsIDL.radioactive_iron_ingot));

        TOOL_SUPER_IRON.setRepairItem(new ItemStack(ItemsIDL.super_iron_ingot));
        TOOL_RADIOACTIVE.setRepairItem(new ItemStack(ItemsIDL.radioactive_iron_ingot));
    }
}
