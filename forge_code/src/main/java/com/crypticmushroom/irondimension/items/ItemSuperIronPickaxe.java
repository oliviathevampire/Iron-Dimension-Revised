package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.item.ItemPickaxe;

public class ItemSuperIronPickaxe extends ItemPickaxe implements RegisterModelUtil {

    public ItemSuperIronPickaxe(ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(TabIDL.tabIDL);
    }
}
