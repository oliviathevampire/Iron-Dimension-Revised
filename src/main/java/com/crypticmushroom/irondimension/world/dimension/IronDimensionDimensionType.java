package com.crypticmushroom.irondimension.world.dimension;

import net.minecraft.world.dimension.DimensionType;

public class IronDimensionDimensionType extends DimensionType {
    public IronDimensionDimensionType() {
        super(5, "_iron", "Iron-Dimension", IronDimensionDimension::new, true);
    }
}
