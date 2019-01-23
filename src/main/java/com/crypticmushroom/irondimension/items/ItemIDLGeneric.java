package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class ItemIDLGeneric extends Item {
    public ItemIDLGeneric() {
        super(new Item.Settings().itemGroup(IronDimension.IDL_ITEM_GROUP));
    }
}
