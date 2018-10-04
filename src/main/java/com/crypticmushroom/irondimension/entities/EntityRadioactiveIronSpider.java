package com.crypticmushroom.irondimension.entities;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityRadioactiveIronSpider extends EntitySpider {
    public static final ResourceLocation LOOT_TABLE = new ResourceLocation(IronDimension.MODID, "radioactive_spider");

    public EntityRadioactiveIronSpider(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 0.9F);
    }

    //TODO: It's going to be ridden by a generic Skeleton. Replace with our own later...

    @Override
    public ResourceLocation getLootTable() {
        return LOOT_TABLE;
    }
}
