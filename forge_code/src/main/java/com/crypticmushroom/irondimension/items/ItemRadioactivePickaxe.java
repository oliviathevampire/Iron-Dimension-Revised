package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nonnull;

public class ItemRadioactivePickaxe extends ItemPickaxe implements RegisterModelUtil {

    public ItemRadioactivePickaxe(ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(TabIDL.tabIDL);
    }

    @Override
    @Nonnull
    public String getItemStackDisplayName(ItemStack stack) {
        return TextFormatting.GREEN + super.getItemStackDisplayName(stack);
    }
}
