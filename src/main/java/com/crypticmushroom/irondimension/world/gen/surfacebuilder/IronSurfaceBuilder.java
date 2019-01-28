package com.crypticmushroom.irondimension.world.gen.surfacebuilder;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class IronSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
    public IronSurfaceBuilder() {
        super(TernarySurfaceConfig::deserialize);
    }

    @Override
    public void generate(Random random_1, Chunk chunk_1, Biome biome_1, int int_1, int int_2, int int_3, double double_1, BlockState blockState_1, BlockState blockState_2, int int_4, long long_1, TernarySurfaceConfig ternarySurfaceConfig_1) {
        this.generate(random_1, chunk_1, biome_1, int_1, int_2, int_3, double_1, blockState_1, blockState_2, ternarySurfaceConfig_1.getTopMaterial(), ternarySurfaceConfig_1.getUnderMaterial(), ternarySurfaceConfig_1.getUnderwaterMaterial(), int_4);
    }

    public void generate(Random random_1, Chunk chunk_1, Biome biome_1, int int_1, int int_2, int int_3, double double_1, BlockState blockState_1, BlockState blockState_2, BlockState blockState_3, BlockState blockState_4, BlockState blockState_5, int int_4) {
        BlockState blockState_6 = blockState_3;
        BlockState blockState_7 = blockState_4;
        BlockPos.Mutable blockPos$Mutable_1 = new BlockPos.Mutable();
        int int_5 = -1;
        int int_6 = (int)(double_1 / 3.0D + 3.0D + random_1.nextDouble() * 0.25D);
        int int_7 = int_1 & 15;
        int int_8 = int_2 & 15;

        for(int int_9 = int_3; int_9 >= 0; --int_9) {
            blockPos$Mutable_1.set(int_7, int_9, int_8);
            BlockState blockState_8 = chunk_1.getBlockState(blockPos$Mutable_1);
            if (blockState_8.isAir()) {
                int_5 = -1;
            } else if (blockState_8.getBlock() == blockState_1.getBlock()) {
                if (int_5 == -1) {
                    if (int_6 <= 0) {
                        blockState_6 = Blocks.AIR.getDefaultState();
                        blockState_7 = blockState_1;
                    } else if (int_9 >= int_4 - 4 && int_9 <= int_4 + 1) {
                        blockState_6 = blockState_3;
                        blockState_7 = blockState_4;
                    }

                    if (int_9 < int_4 && (blockState_6 == null || blockState_6.isAir())) {
                        if (biome_1.getTemperature(blockPos$Mutable_1.set(int_1, int_9, int_2)) < 0.15F) {
                            blockState_6 = Blocks.ICE.getDefaultState();
                        } else {
                            blockState_6 = blockState_2;
                        }

                        blockPos$Mutable_1.set(int_7, int_9, int_8);
                    }

                    int_5 = int_6;
                    if (int_9 >= int_4 - 1) {
                        chunk_1.setBlockState(blockPos$Mutable_1, blockState_6, false);
                    } else if (int_9 < int_4 - 7 - int_6) {
                        blockState_6 = Blocks.AIR.getDefaultState();
                        blockState_7 = blockState_1;
                        chunk_1.setBlockState(blockPos$Mutable_1, blockState_5, false);
                    } else {
                        chunk_1.setBlockState(blockPos$Mutable_1, blockState_7, false);
                    }
                } else if (int_5 > 0) {
                    --int_5;
                    chunk_1.setBlockState(blockPos$Mutable_1, blockState_7, false);
                    if (int_5 == 0 && blockState_7.getBlock() == Blocks.SAND && int_6 > 1) {
                        int_5 = random_1.nextInt(4) + Math.max(0, int_9 - 63);
                        blockState_7 = blockState_7.getBlock() == Blocks.RED_SAND ? Blocks.RED_SANDSTONE.getDefaultState() : Blocks.SANDSTONE.getDefaultState();
                    }
                }
            }
        }
    }
}
