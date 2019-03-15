package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.world.dimension.IronDimensionDimensionType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DimensionType.class)
public class MixinDimensionType {

    @SuppressWarnings("unused")
    private static final DimensionType IRON_DIMENSION = Registry.register(Registry.DIMENSION,5, "iron_dimension", new IronDimensionDimensionType());
}
