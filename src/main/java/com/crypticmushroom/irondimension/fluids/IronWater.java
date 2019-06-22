package com.crypticmushroom.irondimension.fluids;

import com.crypticmushroom.irondimension.registry.BlocksID;
import com.crypticmushroom.irondimension.registry.FluidsID;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;

public abstract class IronWater extends BaseFluid {
    @Override
    public Fluid getFlowing() {
        return FluidsID.FLOWING_IRON_WATER;
    }

    @Override
    public Fluid getStill() {
        return FluidsID.IRON_WATER;
    }

    @Override
    protected boolean isInfinite() {
        return true;
    }

    @Override
    protected void beforeBreakingBlock(IWorld var1, BlockPos var2, BlockState var3) {

    }

    @Override
    protected int method_15733(ViewableWorld var1) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(ViewableWorld var1) {
        return 1;
    }

    @Override
    protected BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public Item getBucketItem() {
        return null;
    }

    @Override
    protected boolean method_15777(FluidState var1, BlockView var2, BlockPos var3, Fluid var4, Direction var5) {
        return false;
    }

    @Override
    public boolean matchesType(Fluid other) {
        return other == FluidsID.IRON_WATER || other == FluidsID.FLOWING_IRON_WATER;
    }

    @Override
    public int getTickRate(ViewableWorld var1) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    protected BlockState toBlockState(FluidState var1) {
        return BlocksID.iron_water_block.getDefaultState().with(FluidBlock.LEVEL, method_15741(var1));
    }

    public static class Flowing extends IronWater {

        @Override
        protected void appendProperties(StateFactory.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public boolean isStill(FluidState var1) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }

    public static class Still extends IronWater {

        @Override
        public boolean isStill(FluidState var1) {
            return true;
        }

        @Override
        public int getLevel(FluidState var1) {
            return 8;
        }
    }
}
