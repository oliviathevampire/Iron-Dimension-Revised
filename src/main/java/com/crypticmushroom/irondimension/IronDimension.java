package com.crypticmushroom.irondimension;

import com.crypticmushroom.irondimension.registry.ItemsIDL;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class IronDimension implements ModInitializer {

    public static final String MODID = "irondimension";

    public static final ItemGroup IDL_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "itemgroup"), () -> new ItemStack(Items.IRON_INGOT));

    @Override
    public void onInitialize() {
        ItemsIDL.init();
    }
}
