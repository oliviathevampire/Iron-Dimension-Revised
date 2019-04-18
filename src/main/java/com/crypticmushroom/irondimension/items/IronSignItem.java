package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;

public class IronSignItem extends SignItem {
    public IronSignItem(Block block_1, Block block_2) {
        super(new Item.Settings().itemGroup(IronDimension.IDL_ITEM_GROUP).stackSize(16), block_1, block_2);
    }
}
