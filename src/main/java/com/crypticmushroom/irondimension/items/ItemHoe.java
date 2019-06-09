package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class ItemHoe extends HoeItem {
    public ItemHoe(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 0.0F, new Item.Settings().group(IronDimension.IDL_ITEM_GROUP).maxCount(1));
    }
}
