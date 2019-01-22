package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.item.ItemAxe;

public class ItemSuperIronAxe extends ItemAxe implements RegisterModelUtil {

    public ItemSuperIronAxe(ToolMaterial material) {
        super(material, 9.0F, -3.2F);
        setMaxStackSize(1);
        setCreativeTab(TabIDL.tabIDL);
    }
}
