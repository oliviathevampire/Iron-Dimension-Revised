package com.crypticmushroom.irondimension.world.gen.carver;

import com.crypticmushroom.irondimension.registry.BlocksID;
import com.crypticmushroom.irondimension.registry.FluidsID;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.CaveCarver;

import java.util.BitSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class IronDimensionCarver extends CaveCarver {
   public IronDimensionCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> function_1) {
      super(function_1, 128);
      this.alwaysCarvableBlocks = ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DIRT, Blocks.COARSE_DIRT, new Block[]{Blocks.PODZOL, Blocks.GRASS_BLOCK, Blocks.NETHERRACK, BlocksID.iron_dirt, BlocksID.iron_grass, BlocksID.ironstone});
      this.carvableFluids = ImmutableSet.of(Fluids.LAVA, Fluids.WATER, FluidsID.IRON_WATER);
   }

   protected int getMaxCaveCount() {
      return 10;
   }

   protected float getTunnelSystemWidth(Random random_1) {
      return (random_1.nextFloat() * 2.0F + random_1.nextFloat()) * 2.0F;
   }

   protected double getTunnelSystemHeightWidthRatio() {
      return 5.0D;
   }

   protected int getCaveY(Random random_1) {
      return random_1.nextInt(this.heightLimit);
   }

   protected boolean carveAtPoint(Chunk chunk_1, BitSet bitSet_1, Random random_1, BlockPos.Mutable blockPos$Mutable_1, BlockPos.Mutable blockPos$Mutable_2, BlockPos.Mutable blockPos$Mutable_3, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7, int int_8, AtomicBoolean atomicBoolean_1) {
      int int_9 = int_6 | int_8 << 4 | int_7 << 8;
      if (bitSet_1.get(int_9)) {
         return false;
      } else {
         bitSet_1.set(int_9);
         blockPos$Mutable_1.set(int_4, int_7, int_5);
         if (this.canAlwaysCarveBlock(chunk_1.getBlockState(blockPos$Mutable_1))) {
            BlockState blockState_2;
            if (int_7 <= 31) {
               blockState_2 = LAVA.getBlockState();
            } else {
               blockState_2 = CAVE_AIR;
            }

            chunk_1.setBlockState(blockPos$Mutable_1, blockState_2, false);
            return true;
         } else {
            return false;
         }
      }
   }
}
