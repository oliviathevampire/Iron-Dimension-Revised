package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.util.ResourceLocation;

public class EntityIDL {
    public static final ResourceLocation IRON_COW = prefix("iron_cow");
    public static final ResourceLocation IRON_PIG = prefix("iron_pig");
    public static final ResourceLocation PURE_IRON_GOLEM = prefix("pure_iron_golem");
    public static final ResourceLocation IRON_SPIDER = prefix("iron_spider");

    private static ResourceLocation prefix(String path) {
        return new ResourceLocation(IronDimension.MODID, path);
    }
}
