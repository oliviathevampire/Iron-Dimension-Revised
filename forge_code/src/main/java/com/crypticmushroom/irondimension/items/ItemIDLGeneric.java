package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.item.Item;

public class ItemIDLGeneric extends Item implements RegisterModelUtil {

    public ItemIDLGeneric() {
        setCreativeTab(TabIDL.tabIDL);
    }
}
