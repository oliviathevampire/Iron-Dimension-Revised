package com.crypticmushroom.irondimension.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.World;

public class EntityIronPig extends EntityPig {

    public EntityIronPig(World world) {
        super(world);
        this.setSize(0.9F, 0.9F);
    }

    @Override
    public EntityPig createChild(EntityAgeable entityanimal) {
        return new EntityIronPig(world);
    }
}
