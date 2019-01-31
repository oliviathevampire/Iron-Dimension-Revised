package com.crypticmushroom.irondimension.utils.portal;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;

public class PlayerPlacementHandler {
    public static boolean placeInPortal(Entity entity, ServerWorld previousWorld, ServerWorld newWorld) {
        if (previousWorld.dimension.getType() == WorldIronDimension.IRON_DIMENSION) {
            if (newWorld.dimension.getType() == DimensionType.OVERWORLD) {
                BlockPos spawnLocation = new BlockPos(entity.getPos().getX(), newWorld.getSpawnPos().getY(), entity.getPos().getZ());

                setEntityLocation(entity, spawnLocation);
                return true;
            }
        }

        if (newWorld.dimension.getType() == WorldIronDimension.IRON_DIMENSION) {
            BlockPos spawnPos = new BlockPos(entity.getPos().getX(), newWorld.getSpawnPos().getY(), entity.getPos().getZ());
            entity.setPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);
            return true;
        }

        return false;
    }

    public static void setEntityLocation(Entity entity, BlockPos pos) {
        if (entity instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) entity).networkHandler.teleportRequest(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
            ((ServerPlayerEntity) entity).networkHandler.syncWithPlayerPosition();
        } else {
            entity.setPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
        }
    }
}
