package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.FabricItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.SnakeCaseIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class BlockIronPortal extends Block {
    public static EnumProperty<State> TYPE;
    protected static final VoxelShape OUTLINE_SHAPE;
    public BlockIronPortal() {
        super(FabricBlockSettings.copy(Blocks.OBSIDIAN).breakByTool(FabricItemTags.PICKAXES, 2).sounds(BlockSoundGroup.GLASS).build());
        this.setDefaultState((BlockState)this.getDefaultState().with(TYPE, State.DISABLE));
    }

    public static VoxelShape getOutlineShape() {
        return OUTLINE_SHAPE;
    }

    @Override
    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity entity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
        if (blockState_1.get(TYPE) == State.ENABLE) {
            if (entity_1.getMainHandStack().getItem() == Items.WATER_BUCKET) {
                world_1.setBlockState(blockPos_1, blockState_1.with(TYPE, State.DISABLE));
                return true;
            } else {
                if (!world_1.isClient) {
                    if (entity_1.dimension == WorldIronDimension.IRON_DIMENSION) {
                        entity_1.changeDimension(DimensionType.OVERWORLD);
                        return true;
                    } else {
                        entity_1.changeDimension(WorldIronDimension.IRON_DIMENSION);
                        return true;
                    }
                }
                return false;
            }
        } else if (entity_1.getMainHandStack().getItem() instanceof FlintAndSteelItem) {
            world_1.setBlockState(blockPos_1, blockState_1.with(TYPE, State.ENABLE));
            return true;
        } else {
            return false;
        }
    }

    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactory$Builder_1) {
        stateFactory$Builder_1.add(TYPE);
    }

    public enum State implements SnakeCaseIdentifiable {
        ENABLE,
        DISABLE;

        @Override
        public String toSnakeCase() {
            return this.toString().toLowerCase();
        }
    }

    static {
        TYPE = IronDimension.TYPE;
        OUTLINE_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D);
    }
}
