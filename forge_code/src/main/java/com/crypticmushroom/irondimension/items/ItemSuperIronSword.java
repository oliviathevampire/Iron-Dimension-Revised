package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.item.ItemSword;

public class ItemSuperIronSword extends ItemSword implements RegisterModelUtil {

    public ItemSuperIronSword(ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(TabIDL.tabIDL);
    }
}
