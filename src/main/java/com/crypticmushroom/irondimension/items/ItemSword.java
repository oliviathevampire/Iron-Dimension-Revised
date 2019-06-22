package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ItemSword extends SwordItem {
    public ItemSword(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 3, -2.4F, new Item.Settings().group(IronDimension.IDL_ITEM_GROUP));
    }
}
