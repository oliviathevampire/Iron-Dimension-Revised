package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class BlockIronPortal extends Block {
    public BlockIronPortal() {
        super(FabricBlockSettings.copy(Blocks.NETHER_PORTAL).build());
    }

    @Override
    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity entity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
        if (!world_1.isClient) {
            if (entity_1.dimension == WorldIronDimension.IRON_DIMENSION) {
                entity_1.changeDimension(DimensionType.OVERWORLD);
            } else {
                entity_1.changeDimension(WorldIronDimension.IRON_DIMENSION);
            }
        }
        return true;
    }

    public enum State {
        ENABLE,
        DISABLE;
    }
}
