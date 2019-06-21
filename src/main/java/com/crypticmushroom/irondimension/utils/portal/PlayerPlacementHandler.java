package com.crypticmushroom.irondimension.utils.portal;

import com.crypticmushroom.irondimension.blocks.BlockIronPortal;
import com.crypticmushroom.irondimension.registry.BlocksID;
import net.minecraft.block.AirBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.HashSet;

public class PlayerPlacementHandler {

    public static void enterIron(Entity entity, ServerWorld serverWorld, ServerWorld newWorld) {
        BlockPos spawnPos = getPos(newWorld, entity);
        entity.setPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);
        placePortalBlock(spawnPos, newWorld);
    }

    public static void leaveIron(Entity entity, ServerWorld previousWorld, ServerWorld newWorld) {
        BlockPos spawnLocation = getPos(newWorld, entity);

        setEntityLocation(entity, spawnLocation);
        placePortalBlock(spawnLocation, newWorld);
    }

    public static void setEntityLocation(Entity entity, BlockPos pos) {
        if (entity instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) entity).networkHandler.teleportRequest(pos.getX(), pos.getY(), pos.getZ(), 0, 0, new HashSet<>());
            ((ServerPlayerEntity) entity).networkHandler.syncWithPlayerPosition();
        } else {
            entity.setPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
        }
    }

    private static void placePortalBlock(BlockPos blockPos, ServerWorld serverWorld) {
        serverWorld.setBlockState(blockPos.down(), BlocksID.iron_dim_portal.getDefaultState().with(BlockIronPortal.TYPE, BlockIronPortal.State.ENABLE));
    }

    private static BlockPos getPos(ServerWorld serverWorld, Entity entity) {
        for (int i = 255; i > 0; i--) {
            BlockPos pos = new BlockPos(entity.getPos().x, i, entity.getPos().z);
            if (!(serverWorld.getBlockState(pos.down()).getBlock() instanceof AirBlock)) {
                return pos.up();
            }
        }
        return new BlockPos(entity.getPos()).up();
    }
}
