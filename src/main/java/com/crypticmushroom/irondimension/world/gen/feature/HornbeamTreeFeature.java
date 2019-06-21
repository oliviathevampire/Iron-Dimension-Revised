package com.crypticmushroom.irondimension.world.gen.feature;

import com.crypticmushroom.irondimension.registry.BlocksID;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class HornbeamTreeFeature extends IronDimensionTreeFeature<DefaultFeatureConfig> {
    private static final BlockState LOG;
    private static final BlockState LEAVES;

    public HornbeamTreeFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1, boolean boolean_1) {
        super(function_1, boolean_1);
    }

    @Override
    protected boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld modifiableTestableWorld_1, Random random_1, BlockPos blockPos_1, MutableIntBoundingBox var5) {
        int int_1 = random_1.nextInt(3) + 5;

        boolean boolean_1 = true;
        if (blockPos_1.getY() >= 1 && blockPos_1.getY() + int_1 + 1 <= 256) {
            int int_6;
            int int_9;
            int int_10;
            for(int_6 = blockPos_1.getY(); int_6 <= blockPos_1.getY() + 1 + int_1; ++int_6) {
                int int_3 = 1;
                if (int_6 == blockPos_1.getY()) {
                    int_3 = 0;
                }

                if (int_6 >= blockPos_1.getY() + 1 + int_1 - 2) {
                    int_3 = 2;
                }

                BlockPos.Mutable blockPos$Mutable_1 = new BlockPos.Mutable();

                for(int_9 = blockPos_1.getX() - int_3; int_9 <= blockPos_1.getX() + int_3 && boolean_1; ++int_9) {
                    for(int_10 = blockPos_1.getZ() - int_3; int_10 <= blockPos_1.getZ() + int_3 && boolean_1; ++int_10) {
                        if (int_6 >= 0 && int_6 < 256) {
                            if (!canTreeReplace(modifiableTestableWorld_1, blockPos$Mutable_1.set(int_9, int_6, int_10))) {
                                boolean_1 = false;
                            }
                        } else {
                            boolean_1 = false;
                        }
                    }
                }
            }

            if (!boolean_1) {
                return false;
            } else if (isDirtOrGrass(modifiableTestableWorld_1, blockPos_1.down()) && blockPos_1.getY() < 256 - int_1 - 1) {
                this.setToDirt(modifiableTestableWorld_1, blockPos_1.down());

                for(int_6 = blockPos_1.getY() - 3 + int_1; int_6 <= blockPos_1.getY() + int_1; ++int_6) {
                    int int_7 = int_6 - (blockPos_1.getY() + int_1);
                    int int_8 = 1 - int_7 / 2;

                    for(int_9 = blockPos_1.getX() - int_8; int_9 <= blockPos_1.getX() + int_8; ++int_9) {
                        int_10 = int_9 - blockPos_1.getX();

                        for(int int_11 = blockPos_1.getZ() - int_8; int_11 <= blockPos_1.getZ() + int_8; ++int_11) {
                            int int_12 = int_11 - blockPos_1.getZ();
                            if (Math.abs(int_10) != int_8 || Math.abs(int_12) != int_8 || random_1.nextInt(2) != 0 && int_7 != 0) {
                                BlockPos blockPos_2 = new BlockPos(int_9, int_6, int_11);
                                if (isAirOrLeaves(modifiableTestableWorld_1, blockPos_2)) {
                                    this.setBlockState(modifiableTestableWorld_1, blockPos_2, LEAVES);
                                }
                            }
                        }
                    }
                }

                for(int_6 = 0; int_6 < int_1; ++int_6) {
                    if (isAirOrLeaves(modifiableTestableWorld_1, blockPos_1.up(int_6))) {
                        this.setBlockState(set_1, modifiableTestableWorld_1, blockPos_1.up(int_6), LOG, var5);
                    }
                }

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    static {
        LOG = BlocksID.hornbeam_log.getDefaultState();
        LEAVES = BlocksID.hornbeam_leaves.getDefaultState();
    }
}
