package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class ItemAxe extends AxeItem {
    public ItemAxe(ToolMaterial toolMaterial_1, float float_1) {
        super(toolMaterial_1, float_1, -3.2F, new Item.Settings().itemGroup(IronDimension.IDL_ITEM_GROUP).stackSize(1));
    }
}
