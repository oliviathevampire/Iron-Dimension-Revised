package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.registry.EntitiesID;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.SpawnRestrictionEntry;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(SpawnRestriction.class)
public class MixinSpawnRestriction {

    @Shadow
    protected static void register(EntityType<?> entityType_1, SpawnRestriction.Location spawnRestriction$Location_1, Heightmap.Type heightmap$Type_1) {
        mapping.put(entityType_1, new SpawnRestrictionEntry(heightmap$Type_1, spawnRestriction$Location_1));
    }

    @Shadow @Final private static Map<EntityType<?>, SpawnRestrictionEntry> mapping;

    static {
        register(EntitiesID.IRONBISON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES);
    }
}
