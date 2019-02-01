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
                BlockPos spawnLocation = new BlockPos(entity.getPos().getX(), newWorld.getChunkManager().getChunkGenerator().getSpawnHeight(), entity.getPos().getZ());
                BlockPos spawnPos = getSafeSpawningCoord(newWorld, spawnLocation);
                setEntityLocation(entity, spawnPos);
                return true;
            }
        }

        if (newWorld.dimension.getType() == WorldIronDimension.IRON_DIMENSION) {
            BlockPos spawnPostry = new BlockPos(entity.getPos().getX(), newWorld.getChunkManager().getChunkGenerator().getSpawnHeight(), entity.getPos().getZ());
            BlockPos spawnPos = getSafeSpawningCoord(newWorld, spawnPostry);
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

    private static BlockPos getSafeSpawningCoord(ServerWorld world, BlockPos blockPos) {
        for (int a = blockPos.getY(); a < 255; a++) {
            BlockPos blockPos1 = new BlockPos(blockPos.getX(), a, blockPos.getZ());
            if (hasPlaceForPlayerSpawning(world, blockPos1)) {
                return blockPos1;
            }
        }
        return blockPos;
    }

    private static boolean hasPlaceForPlayerSpawning(ServerWorld world, BlockPos blockPos) {
        if (world.isAir(blockPos) && world.isAir(new BlockPos(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ()))) {
            return true;
        } else {
            return false;
        }
    }
}
