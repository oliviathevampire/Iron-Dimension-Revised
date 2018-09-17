package com.crypticmushroom.irondimension;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = IronDimension.MODID, value = Side.CLIENT)
public class EventHandlerClientIDL {

    @SubscribeEvent
    public static void textureStitch(TextureStitchEvent.Pre e) {
        TextureMap map = e.getMap();

        map.registerSprite(new ResourceLocation(IronDimension.MODID, "particle/iron_portal"));
    }
}
