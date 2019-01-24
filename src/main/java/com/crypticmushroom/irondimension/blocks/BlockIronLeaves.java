package com.crypticmushroom.irondimension.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateFactory;
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
        return (Integer)blockState_1.get(field_11199) == 7 && !(Boolean)blockState_1.get(field_11200);
    }

    @Override
    public void randomTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
        if (!(Boolean)blockState_1.get(field_11200) && (Integer)blockState_1.get(field_11199) == 7) {
            dropStacks(blockState_1, world_1, blockPos_1);
            world_1.clearBlockState(blockPos_1);
        }

    }

    @Override
    public void scheduledTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
        world_1.setBlockState(blockPos_1, method_10300(blockState_1, world_1, blockPos_1), 3);
    }

    @Override
    public int getLightSubtracted(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return 1;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
        int int_1 = method_10302(blockState_2) + 1;
        if (int_1 != 1 || (Integer)blockState_1.get(field_11199) != int_1) {
            iWorld_1.getBlockTickScheduler().schedule(blockPos_1, this, 1);
        }

        return blockState_1;
    }

    private static BlockState method_10300(BlockState blockState_1, IWorld iWorld_1, BlockPos blockPos_1) {
        int int_1 = 7;
        BlockPos.PooledMutable blockPos$PooledMutable_1 = BlockPos.PooledMutable.get();
        Throwable var5 = null;

        try {
            Direction[] var6 = Direction.values();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                Direction direction_1 = var6[var8];
                blockPos$PooledMutable_1.set((Vec3i)blockPos_1).setOffset(direction_1);
                int_1 = Math.min(int_1, method_10302(iWorld_1.getBlockState(blockPos$PooledMutable_1)) + 1);
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

        return (BlockState)blockState_1.with(field_11199, int_1);
    }

    private static int method_10302(BlockState blockState_1) {
        if (blockState_1.getBlock() instanceof BlockIronLog) {
            return 0;
        } else {
            return blockState_1.getBlock() instanceof LeavesBlock ? (Integer)blockState_1.get(field_11199) : 7;
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1) {
        BlockPos blockPos_2 = blockPos_1.down();
        if (world_1.hasRain(blockPos_1.up()) && !world_1.getBlockState(blockPos_2).hasSolidTopSurface(world_1, blockPos_2) && random_1.nextInt(15) == 1) {
            double double_1 = (double)((float)blockPos_1.getX() + random_1.nextFloat());
            double double_2 = (double)blockPos_1.getY() - 0.05D;
            double double_3 = (double)((float)blockPos_1.getZ() + random_1.nextFloat());
            world_1.addParticle(ParticleTypes.DRIPPING_WATER, double_1, double_2, double_3, 0.0D, 0.0D, 0.0D);
        }

    }

    @Environment(EnvType.CLIENT)
    public static void setRenderingMode(boolean boolean_1) {
        translucentLeaves = boolean_1;
    }

    @Override
    public boolean isFullBoundsCubeForCulling(BlockState blockState_1) {
        return false;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return translucentLeaves ? BlockRenderLayer.MIPPED_CUTOUT : BlockRenderLayer.SOLID;
    }

    @Override
    public boolean canSuffocate(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return false;
    }

    @Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
        stateFactory$Builder_1.with(field_11199, field_11200);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        return method_10300((BlockState)this.getDefaultState().with(field_11200, true), itemPlacementContext_1.getWorld(), itemPlacementContext_1.getPos());
    }
}
