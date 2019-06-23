package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.registry.EntitiesID;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.SpawnRestrictionEntry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(SpawnRestriction.class)
public class MixinSpawnRestriction {

    @Shadow
    protected static void method_20637(EntityType<?> entityType_1, SpawnRestriction.Location spawnRestriction$Location_1, Heightmap.Type heightmap$Type_1, SpawnRestriction.class_4306 spawnRestriction$class_4306_1) {
        mapping.put(entityType_1, new SpawnRestrictionEntry(heightmap$Type_1, spawnRestriction$Location_1, (entityType, iWorld, spawnType, blockPos, random) -> false));
    }

    @Shadow @Final private static Map<EntityType<?>, SpawnRestrictionEntry> mapping;

    static {
        method_20637(EntitiesID.IRONBISON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::method_20663);
    }
}
