package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ItemPickaxe extends PickaxeItem {
    public ItemPickaxe(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -2.8F, new Item.Settings().maxCount(1).group(IronDimension.IDL_ITEM_GROUP));
    }
}
