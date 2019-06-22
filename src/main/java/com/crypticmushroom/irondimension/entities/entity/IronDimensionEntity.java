package com.crypticmushroom.irondimension.entities.entity;

import com.crypticmushroom.irondimension.registry.BlocksID;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public abstract class IronDimensionEntity extends AnimalEntity {
    public IronDimensionEntity(EntityType<? extends IronDimensionEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
        this.spawningGround = BlocksID.iron_grass;
    }
}
