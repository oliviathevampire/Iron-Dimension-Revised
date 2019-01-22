package com.crypticmushroom.irondimension.registry.util;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.registry.BlocksRegistryIDL;
import com.crypticmushroom.irondimension.registry.ItemsRegistryIDL;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = IronDimension.MODID, value = Side.CLIENT)
public class ModelRendering {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (RegisterModelUtil b : BlocksRegistryIDL.getBlockModels()) b.registerModel();

        for (RegisterModelUtil i : ItemsRegistryIDL.ItemRegistryHelper.getItemModels()) i.registerModel();
    }
}
