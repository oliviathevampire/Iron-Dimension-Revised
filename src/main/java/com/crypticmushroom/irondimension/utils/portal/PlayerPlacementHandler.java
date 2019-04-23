package com.crypticmushroom.irondimension.utils.portal;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;

import java.util.HashSet;

public class PlayerPlacementHandler {

    public static void enterIron(Entity entity, ServerWorld serverWorld, ServerWorld newWorld) {
        if (newWorld.dimension.getType() == WorldIronDimension.IRON_DIMENSION) {
            BlockPos spawnPos = new BlockPos(entity.getPos().getX(), newWorld.getSpawnPos().getY(), entity.getPos().getZ());
            entity.setPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);
        }
    }

    public static void leaveIron(Entity entity, ServerWorld previousWorld, ServerWorld newWorld) {
        BlockPos spawnLocation = new BlockPos(entity.getPos().getX(), newWorld.getSpawnPos().getY(), entity.getPos().getZ());

        setEntityLocation(entity, spawnLocation);
    }

    public static void setEntityLocation(Entity entity, BlockPos pos) {
        if (entity instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) entity).networkHandler.teleportRequest(pos.getX(), pos.getY(), pos.getZ(), 0, 0, new HashSet<>());
            ((ServerPlayerEntity) entity).networkHandler.syncWithPlayerPosition();
        } else {
            entity.setPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
        }
    }
}
