package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.util.ResourceLocation;

public class EntityIDL {
    public static final ResourceLocation IRON_COW = prefix("iron_cow");
    public static final ResourceLocation IRON_PIG = prefix("iron_pig");

    private static ResourceLocation prefix(String path) {
        return new ResourceLocation(IronDimension.MODID, path);
    }
}
