package com.crypticmushroom.irondimension.world;

import net.minecraft.util.math.BlockPos;

public class IronPortalPos extends BlockPos {
    public long lastUpdateTime;

    public IronPortalPos(BlockPos pos, long lastUpdateTime)
    {
        super(pos.getX(), pos.getY(), pos.getZ());

        this.lastUpdateTime = lastUpdateTime;
    }
}
