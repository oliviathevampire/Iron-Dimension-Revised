package com.crypticmushroom.irondimension;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabIDL {

    public static void init() {
        //sshhh...
    }

    public static final CreativeTabs tabIDL = new CreativeTabs("iron_dimension") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlocksIDL.iron_grass);
        }
    };
}
