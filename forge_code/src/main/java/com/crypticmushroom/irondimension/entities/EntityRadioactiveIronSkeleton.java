package com.crypticmushroom.irondimension.entities;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityRadioactiveIronSkeleton extends EntitySkeleton {

    public static final ResourceLocation LOOT_TABLE = new ResourceLocation(IronDimension.MODID, "radioactive_skeleton");

    public EntityRadioactiveIronSkeleton(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 0.9F);
    }

    @Override
    public ResourceLocation getLootTable() {
        return LOOT_TABLE;
    }
}
