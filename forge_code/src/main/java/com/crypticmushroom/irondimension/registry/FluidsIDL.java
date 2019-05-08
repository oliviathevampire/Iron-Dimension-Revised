package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FluidsIDL {

    public static final Fluid metallicWater = new Fluid("metallic_water",
            new ResourceLocation(IronDimension.MODID, "blocks/iron/liquid/metallic_water_still"),
            new ResourceLocation(IronDimension.MODID, "blocks/iron/liquid/metallic_water_flow"))
            .setDensity(1000).setViscosity(1500).setColor(0xCEC0C0C0);
    public static final Fluid liquidIron = new Fluid("liquid_iron",
            new ResourceLocation(IronDimension.MODID, "blocks/iron/liquid/metallic_water_still"),
            new ResourceLocation(IronDimension.MODID, "blocks/iron/liquid/metallic_water_flow"))
            .setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ItemsIDL.metallic_water_bucket = FluidUtil.getFilledBucket(new FluidStack(FluidsIDL.metallicWater, Fluid.BUCKET_VOLUME));
        ItemsIDL.liquid_iron_bucket = FluidUtil.getFilledBucket(new FluidStack(FluidsIDL.liquidIron, Fluid.BUCKET_VOLUME));
    }
}
