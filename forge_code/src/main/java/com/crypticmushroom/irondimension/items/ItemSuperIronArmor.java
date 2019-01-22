package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nonnull;

public class ItemSuperIronArmor extends ItemArmor implements RegisterModelUtil {

    public ItemSuperIronArmor(ArmorMaterial armorMaterial, EntityEquipmentSlot armorType) {
        super(armorMaterial, 0, armorType);
        setMaxStackSize(1);
        setCreativeTab(TabIDL.tabIDL);
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, EntityEquipmentSlot slot, String layer) {
        if (slot == EntityEquipmentSlot.LEGS) {
            return IronDimension.ARMOR_DIR + "super_iron_layer_2.png";
        } else {
            return IronDimension.ARMOR_DIR + "super_iron_layer_1.png";
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            ItemStack istack = new ItemStack(this);
            list.add(istack);
        }
    }
}
