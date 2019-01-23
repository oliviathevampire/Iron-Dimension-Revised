package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ItemShovel extends ShovelItem {
    public ItemShovel(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1.5F, -3.0F, new Item.Settings().itemGroup(IronDimension.IDL_ITEM_GROUP).stackSize(1));
    }
}
