package com.crypticmushroom.irondimension.world.gen.carver;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;

public class IronCarvers {
    public static Carver ID_CARVER;

    public static void init() {
        ID_CARVER = Registry.register(Registry.CARVER, new Identifier(IronDimension.MODID, "id_carver"), new IronDimensionCarver(ProbabilityConfig::deserialize));
    }

}
