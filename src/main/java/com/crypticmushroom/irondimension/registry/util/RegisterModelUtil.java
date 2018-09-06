package com.crypticmushroom.irondimension.registry.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface RegisterModelUtil {

    @SideOnly(Side.CLIENT)
    default void registerModel() {
        //Register model for Items
        if (this instanceof Item) {
            ModelLoader.setCustomModelResourceLocation((Item) this, 0, new ModelResourceLocation(((Item) this).getRegistryName(), "inventory"));
        } else if (this instanceof Block) {
            BlockModelUtils.registerToState((Block) this, 0, ((Block) this).getDefaultState());
        }
    }
}
