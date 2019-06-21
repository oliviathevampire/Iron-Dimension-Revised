package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.fluids.IronWater;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidsID {
    public static final IronWater FLOWING_IRON_WATER = new IronWater.Flowing();
    public static final IronWater IRON_WATER = new IronWater.Still();

    public static void init() {
        Registry.register(Registry.FLUID, new Identifier(IronDimension.MODID, "flowing_iron_water"), FLOWING_IRON_WATER);
        Registry.register(Registry.FLUID, new Identifier(IronDimension.MODID, "iron_water"), IRON_WATER);
    }
}
