package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenRavine;

import java.util.Random;

public class WorldGenIronRavines extends MapGenRavine {

    protected static final IBlockState FLOWING_LAVA = BlocksIDL.liquid_iron_block.getDefaultState();
    protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
    private final float[] rs = new float[1024];

    protected void addTunnel(long ravineSeed, int centerX, int centerZ, ChunkPrimer primer, double randX, double randY, double randZ, float ravineSize, float randPI, float angleGen, int loopOne, int loopEnd, double yScale) {
        Random random = new Random(ravineSeed);
        double pointX = (double)(centerX * 16 + 8);
        double pointZ = (double)(centerZ * 16 + 8);
        float f = 0.0F;
        float f1 = 0.0F;

        if (loopEnd <= 0) {
            int i = this.range * 16 - 16;
            loopEnd = i - random.nextInt(i / 4);
        }

        boolean flag1 = false;

        if (loopOne == -1) {
            loopOne = loopEnd / 2;
            flag1 = true;
        }

        float f2 = 1.0F;

        for (int worldHeight = 0; worldHeight < 256; ++worldHeight) {
            if (worldHeight == 0 || random.nextInt(3) == 0)
            {
                f2 = 1.0F + random.nextFloat() * random.nextFloat();
            }

            this.rs[worldHeight] = f2 * f2;
        }

        for (; loopOne < loopEnd; ++loopOne) {
            double d9 = 1.5D + (double)(MathHelper.sin((float)loopOne * (float)Math.PI / (float)loopEnd) * ravineSize);
            double d2 = d9 * yScale;
            d9 = d9 * ((double)random.nextFloat() * 0.25D + 0.75D);
            d2 = d2 * ((double)random.nextFloat() * 0.25D + 0.75D);
            float f3 = MathHelper.cos(angleGen);
            float f4 = MathHelper.sin(angleGen);
            randX += (double)(MathHelper.cos(randPI) * f3);
            randY += (double)f4;
            randZ += (double)(MathHelper.sin(randPI) * f3);
            angleGen = angleGen * 0.7F;
            angleGen = angleGen + f1 * 0.05F;
            randPI += f * 0.05F;
            f1 = f1 * 0.8F;
            f = f * 0.5F;
            f1 = f1 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f = f + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;

            if (flag1 || random.nextInt(4) != 0) {
                double areaX = randX - pointX;
                double areaZ = randZ - pointZ;
                double looping = (double)(loopEnd - loopOne);
                double size = (double)(ravineSize + 2.0F + 16.0F);

                //Is the total area bigger than the size required?
                if (areaX * areaX + areaZ * areaZ - looping * looping > size * size) {
                    return;
                }

                if (randX >= pointX - 16.0D - d9 * 2.0D && randZ >= pointZ - 16.0D - d9 * 2.0D && randX <= pointX + 16.0D + d9 * 2.0D && randZ <= pointZ + 16.0D + d9 * 2.0D) {
                    int k2 = MathHelper.floor(randX - d9) - centerX * 16 - 1;
                    int k = MathHelper.floor(randX + d9) - centerX * 16 + 1;
                    int l2 = MathHelper.floor(randY - d2) - 1;
                    int l = MathHelper.floor(randY + d2) + 1;
                    int i3 = MathHelper.floor(randZ - d9) - centerZ * 16 - 1;
                    int i1 = MathHelper.floor(randZ + d9) - centerZ * 16 + 1;

                    if (k2 < 0) {
                        k2 = 0;
                    }
                    if (k > 16) {
                        k = 16;
                    }
                    if (l2 < 1) {
                        l2 = 1;
                    }
                    if (l > 248) {
                        l = 248;
                    }
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    if (i1 > 16) {
                        i1 = 16;
                    }

                    boolean flag2 = false;

                    for (int j1 = k2; !flag2 && j1 < k; ++j1) {
                        for (int k1 = i3; !flag2 && k1 < i1; ++k1) {
                            for (int l1 = l + 1; !flag2 && l1 >= l2 - 1; --l1) {
                                if (l1 >= 0 && l1 < 256) {
                                    if (isOceanBlock(primer, j1, l1, k1, centerX, centerZ)) {
                                        flag2 = true;
                                    }

                                    if (l1 != l2 - 1 && j1 != k2 && j1 != k - 1 && k1 != i3 && k1 != i1 - 1) {
                                        l1 = l2;
                                    }
                                }
                            }
                        }
                    }

                    if (!flag2) {
                        for (int j3 = k2; j3 < k; ++j3) {
                            double d10 = ((double)(j3 + centerX * 16) + 0.5D - randX) / d9;

                            for (int i2 = i3; i2 < i1; ++i2) {
                                double d7 = ((double)(i2 + centerZ * 16) + 0.5D - randZ) / d9;
                                boolean flag = false;

                                if (d10 * d10 + d7 * d7 < 1.0D) {
                                    for (int j2 = l; j2 > l2; --j2) {
                                        double d8 = ((double)(j2 - 1) + 0.5D - randY) / d2;

                                        if ((d10 * d10 + d7 * d7) * (double)this.rs[j2 - 1] + d8 * d8 / 6.0D < 1.0D) {
                                            if (isTopBlock(primer, j3, j2, i2, centerX, centerZ)) {
                                                flag = true;
                                            }

                                            digBlock(primer, j3, j2, i2, centerX, centerZ, flag);
                                        }
                                    }
                                }
                            }
                        }

                        if (flag1) {
                            break;
                        }
                    }
                }
            }
        }
    }

    protected void recursiveGenerate(World worldIn, int chunkX, int chunkZ, int originalX, int originalZ, ChunkPrimer chunkPrimerIn) {
        if (this.rand.nextInt(50) == 0) {
            double d0 = (double)(chunkX * 16 + this.rand.nextInt(16));
            double d1 = (double)(this.rand.nextInt(this.rand.nextInt(40) + 8) + 20);
            double d2 = (double)(chunkZ * 16 + this.rand.nextInt(16));

            for (int j = 0; j < 1; ++j) {
                float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = (this.rand.nextFloat() * 2.0F + this.rand.nextFloat()) * 2.0F;
                this.addTunnel(this.rand.nextLong(), originalX, originalZ, chunkPrimerIn, d0, d1, d2, f2, f, f1, 0, 0, 3.0D);
            }
        }
    }

    protected boolean isOceanBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ) {
        net.minecraft.block.Block block = data.getBlockState(x, y, z).getBlock();

        return block == BlocksIDL.metallic_water_block;
    }

    private boolean isTopBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ) {
        net.minecraft.world.biome.Biome biome = world.getBiome(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
        IBlockState state = data.getBlockState(x, y, z);

        return state.getBlock() == biome.topBlock;
    }

    protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop) {
        net.minecraft.world.biome.Biome biome = world.getBiome(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
        IBlockState state = data.getBlockState(x, y, z);
        IBlockState top = biome.topBlock;
        IBlockState filler = biome.fillerBlock;

        if (state.getBlock() == BlocksIDL.soft_iron || state.getBlock() == top.getBlock() || state.getBlock() == filler.getBlock()) {
            if (y - 1 < 10) {
                data.setBlockState(x, y, z, FLOWING_LAVA);
            } else {
                data.setBlockState(x, y, z, AIR);

                if (foundTop && data.getBlockState(x, y - 1, z).getBlock() == filler.getBlock()) {
                    data.setBlockState(x, y - 1, z, top.getBlock().getDefaultState());
                }
            }
        }
    }
}
