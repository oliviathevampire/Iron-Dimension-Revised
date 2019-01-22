package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.item.ItemHoe;

public class ItemSuperIronHoe extends ItemHoe implements RegisterModelUtil {

    public ItemSuperIronHoe(ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(TabIDL.tabIDL);
    }
}
