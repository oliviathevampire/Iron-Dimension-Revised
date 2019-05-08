package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class BlockIronLeaves extends LeavesBlock {
    public BlockIronLeaves() {
        super(FabricBlockSettings
                .of(Material.LEAVES)
                .sounds(BlockSoundGroup.GRASS)
                .hardness(0.2F)
                .ticksRandomly()
                .build());
    }

    @Override
    public boolean hasRandomTicks(BlockState blockState_1) {
        return (Integer)blockState_1.get(DISTANCE) == 7 && !(Boolean)blockState_1.get(PERSISTENT);
    }

    @Override
    public void onScheduledTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
        world_1.setBlockState(blockPos_1, updateDistamceFromLogs(blockState_1, world_1, blockPos_1), 3);
    }

    @Override
    public int getLightSubtracted(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return 1;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
        int int_1 = getDistanceFromLog(blockState_2) + 1;
        if (int_1 != 1 || (Integer)blockState_1.get(DISTANCE) != int_1) {
            iWorld_1.getBlockTickScheduler().schedule(blockPos_1, this, 1);
        }

        return blockState_1;
    }

    private static BlockState updateDistamceFromLogs(BlockState blockState_1, IWorld iWorld_1, BlockPos blockPos_1) {
        int int_1 = 7;
        BlockPos.PooledMutable blockPos$PooledMutable_1 = BlockPos.PooledMutable.get();
        Throwable var5 = null;

        try {
            Direction[] var6 = Direction.values();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                Direction direction_1 = var6[var8];
                blockPos$PooledMutable_1.set((Vec3i)blockPos_1).setOffset(direction_1);
                int_1 = Math.min(int_1, getDistanceFromLog(iWorld_1.getBlockState(blockPos$PooledMutable_1)) + 1);
                if (int_1 == 1) {
                    break;
                }
            }
        } catch (Throwable var17) {
            var5 = var17;
            throw var17;
        } finally {
            if (blockPos$PooledMutable_1 != null) {
                if (var5 != null) {
                    try {
                        blockPos$PooledMutable_1.close();
                    } catch (Throwable var16) {
                        var5.addSuppressed(var16);
                    }
                } else {
                    blockPos$PooledMutable_1.close();
                }
            }

        }

        return (BlockState)blockState_1.with(DISTANCE, int_1);
    }

    private static int getDistanceFromLog(BlockState blockState_1) {
        if (blockState_1.getBlock() instanceof LogBlock) {
            return 0;
        } else {
            return blockState_1.getBlock() instanceof LeavesBlock ? (Integer)blockState_1.get(DISTANCE) : 7;
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        return updateDistamceFromLogs((BlockState)this.getDefaultState().with(PERSISTENT, true), itemPlacementContext_1.getWorld(), itemPlacementContext_1.getBlockPos());
    }
}
