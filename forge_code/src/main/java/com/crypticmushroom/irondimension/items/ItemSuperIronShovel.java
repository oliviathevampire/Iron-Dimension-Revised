package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.item.ItemSpade;

public class ItemSuperIronShovel extends ItemSpade implements RegisterModelUtil {

    public ItemSuperIronShovel(ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(TabIDL.tabIDL);
    }
}
