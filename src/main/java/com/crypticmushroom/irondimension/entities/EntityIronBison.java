package com.crypticmushroom.irondimension.entities;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class EntityIronBison extends CowEntity {
    public EntityIronBison(EntityType<? extends CowEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }
}
