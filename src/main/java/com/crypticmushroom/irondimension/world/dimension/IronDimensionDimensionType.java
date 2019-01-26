package com.crypticmushroom.irondimension.world.dimension;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;

import java.util.function.BiFunction;

public class IronDimensionDimensionType extends DimensionType {
    public IronDimensionDimensionType() {
        super(5, "_iron", "Iron-Dimension", IronDimensionDimension::new, true);
    }
}
