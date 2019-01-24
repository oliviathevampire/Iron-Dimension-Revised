package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class ItemArmor extends ArmorItem {
    public ItemArmor(ArmorMaterial armorMaterial_1, EquipmentSlot equipmentSlot_1) {
        super(armorMaterial_1, equipmentSlot_1, new Item.Settings().itemGroup(IronDimension.IDL_ITEM_GROUP).stackSize(1));
    }
}