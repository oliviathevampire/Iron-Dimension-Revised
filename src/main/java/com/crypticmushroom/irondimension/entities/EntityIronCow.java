package com.crypticmushroom.irondimension.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.World;

public class EntityIronCow extends EntityCow {

    public EntityIronCow(World world) {
        super(world);
        this.setSize(0.9F, 1.4F);
    }

    @Override
    public EntityCow createChild(EntityAgeable entityanimal) {
        return new EntityIronCow(world);
    }
}
