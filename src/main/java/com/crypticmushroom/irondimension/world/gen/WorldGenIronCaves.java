package com.crypticmushroom.irondimension.world.gen;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import com.google.common.base.MoreObjects;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenCaves;

import java.util.Random;

public class WorldGenIronCaves extends MapGenCaves {

    protected static final IBlockState CAVE_LAVA = BlocksIDL.liquid_iron_block.getDefaultState();
    protected static final IBlockState CAVE_AIR = Blocks.AIR.getDefaultState();


    protected void addRoom(long caveSeed, int centerX, int centerZ, ChunkPrimer blockStorage, double randX, double randY, double randZ) {
        this.addTunnel(caveSeed, centerX, centerZ, blockStorage, randX, randY, randZ, 1.0F + this.rand.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
    }

    protected void addTunnel(long tunnelSeed, int centerX, int centerZ, ChunkPrimer blockStorage, double randX, double randY, double randZ, float caveSize, float randPI, float angleGen, int loopOne, int loopEnd, double yScale) {
        double offsetX = (double)(centerX * 16 + 8);
        double offsetY = (double)(centerZ * 16 + 8);
        float f = 0.0F;
        float f1 = 0.0F;
        Random random = new Random(tunnelSeed);

        if (loopEnd <= 0) {
            int i = this.range * 16 - 16;
            loopEnd = i - random.nextInt(i / 4);
        }

        boolean flag2 = false;

        if (loopOne == -1) {
            loopOne = loopEnd / 2;
            flag2 = true;
        }

        int j = random.nextInt(loopEnd / 2) + loopEnd / 4;

        for (boolean flag = random.nextInt(6) == 0; loopOne < loopEnd; ++loopOne) {
            double offsetZ = 1.5D + (double)(MathHelper.sin((float)loopOne * (float)Math.PI / (float)loopEnd) * caveSize);
            double d3 = offsetZ * yScale;
            float angleCOS = MathHelper.cos(angleGen);
            float angleSIN = MathHelper.sin(angleGen);
            randX += (double)(MathHelper.cos(randPI) * angleCOS);
            randY += (double)angleSIN;
            randZ += (double)(MathHelper.sin(randPI) * angleCOS);

            if (flag) {
                angleGen = angleGen * 0.92F;
            } else {
                angleGen = angleGen * 0.7F;
            }

            angleGen = angleGen + f1 * 0.1F;
            randPI += f * 0.1F;
            f1 = f1 * 0.9F;
            f = f * 0.75F;
            f1 = f1 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f = f + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;

            if (!flag2 && loopOne == j && caveSize > 1.0F && loopEnd > 0) {
                this.addTunnel(random.nextLong(), centerX, centerZ, blockStorage, randX, randY, randZ, random.nextFloat() * 0.5F + 0.5F, randPI - ((float)Math.PI / 2F), angleGen / 3.0F, loopOne, loopEnd, 1.0D);
                this.addTunnel(random.nextLong(), centerX, centerZ, blockStorage, randX, randY, randZ, random.nextFloat() * 0.5F + 0.5F, randPI + ((float)Math.PI / 2F), angleGen / 3.0F, loopOne, loopEnd, 1.0D);
                return;
            }

            if (flag2 || random.nextInt(4) != 0) {
                double randoffXX = randX - offsetX;
                double randoffZY = randZ - offsetY;
                double loopPoint = (double)(loopEnd - loopOne);
                double maxSize = (double)(caveSize + 2.0F + 16.0F);

                if (randoffXX * randoffXX + randoffZY * randoffZY - loopPoint * loopPoint > maxSize * maxSize) {
                    return;
                }

                if (randX >= offsetX - 16.0D - offsetZ * 2.0D && randZ >= offsetY - 16.0D - offsetZ * 2.0D && randX <= offsetX + 16.0D + offsetZ * 2.0D && randZ <= offsetY + 16.0D + offsetZ * 2.0D) {
                    int subXZ = MathHelper.floor(randX - offsetZ) - centerX * 16 - 1;
                    int addXZ = MathHelper.floor(randX + offsetZ) - centerX * 16 + 1;
                    int subXYZ = MathHelper.floor(randY - d3) - 1;
                    int addXYZ = MathHelper.floor(randY + d3) + 1;
                    int subZZ = MathHelper.floor(randZ - offsetZ) - centerZ * 16 - 1;
                    int addZZ = MathHelper.floor(randZ + offsetZ) - centerZ * 16 + 1;

                    if (subXZ < 0) {
                        subXZ = 0;
                    }
                    if (addXZ > 16) {
                        addXZ = 16;
                    }
                    if (subXYZ < 1) {
                        subXYZ = 1;
                    }
                    if (addXYZ > 248) {
                        addXYZ = 248;
                    }
                    if (subZZ < 0) {
                        subZZ = 0;
                    }
                    if (addZZ > 16) {
                        addZZ = 16;
                    }

                    boolean flag3 = false;

                    for (int j1 = subXZ; !flag3 && j1 < addXZ; ++j1) {
                        for (int k1 = subZZ; !flag3 && k1 < addZZ; ++k1) {
                            for (int l1 = addXYZ + 1; !flag3 && l1 >= subXYZ - 1; --l1) {
                                if (l1 >= 0 && l1 < 256) {
                                    if (isOceanBlock(blockStorage, j1, l1, k1, centerX, centerZ)) {
                                        flag3 = true;
                                    }

                                    if (l1 != subXYZ - 1 && j1 != subXZ && j1 != addXZ - 1 && k1 != subZZ && k1 != addZZ - 1) {
                                        l1 = subXYZ;
                                    }
                                }
                            }
                        }
                    }

                    if (!flag3) {
                        for (int j3 = subXZ; j3 < addXZ; ++j3) {
                            double blockposX = ((double)(j3 + centerX * 16) + 0.5D - randX) / offsetZ;

                            for (int i2 = subZZ; i2 < addZZ; ++i2) {
                                double blockposZ = ((double)(i2 + centerZ * 16) + 0.5D - randZ) / offsetZ;
                                boolean flag1 = false;

                                if (blockposX * blockposX + blockposZ * blockposZ < 1.0D) {
                                    for (int j2 = addXYZ; j2 > subXYZ; --j2) {
                                        double d9 = ((double)(j2 - 1) + 0.5D - randY) / d3;

                                        if (d9 > -0.7D && blockposX * blockposX + d9 * d9 + blockposZ * blockposZ < 1.0D) {
                                            IBlockState iblockstate1 = blockStorage.getBlockState(j3, j2, i2);
                                            IBlockState iblockstate2 = MoreObjects.firstNonNull(blockStorage.getBlockState(j3, j2 + 1, i2), BLK_AIR);

                                            if (isTopBlock(blockStorage, j3, j2, i2, centerX, centerZ)) {
                                                flag1 = true;
                                            }

                                            digBlock(blockStorage, j3, j2, i2, centerX, centerZ, flag1, iblockstate1, iblockstate2);
                                        }
                                    }
                                }
                            }
                        }

                        if (flag2) {
                            break;
                        }
                    }
                }
            }
        }
    }

    protected boolean canReplaceBlock(IBlockState block, IBlockState material) {
        if (block.getBlock() == BlocksIDL.soft_iron) {
            return true;
        } else if (block.getBlock() == BlocksIDL.iron_dirt) {
            return true;
        } else if (block.getBlock() == BlocksIDL.iron_grass) {
            return true;
        } else {
            return material.getMaterial() != Material.WATER;
        }
    }

    /**
     * Recursively called by generate()
     */
    protected void recursiveGenerate(World worldIn, int chunkX, int chunkZ, int originalX, int originalZ, ChunkPrimer chunkPrimerIn) {
        int i = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);

        if (this.rand.nextInt(7) != 0) {
            i = 0;
        }

        for (int j = 0; j < i; ++j) {
            double offsetX = (double)(chunkX * 16 + this.rand.nextInt(16));
            double offsetY = (double)this.rand.nextInt(this.rand.nextInt(120) + 8);
            double offsetZ = (double)(chunkZ * 16 + this.rand.nextInt(16));
            int addXZ = 1;

            if (this.rand.nextInt(4) == 0) {
                this.addRoom(this.rand.nextLong(), originalX, originalZ, chunkPrimerIn, offsetX, offsetY, offsetZ);
                addXZ += this.rand.nextInt(4);
            }

            for (int addXYZ = 0; addXYZ < addXZ; ++addXYZ) {
                float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();

                if (this.rand.nextInt(10) == 0) {
                    f2 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F;
                }

                this.addTunnel(this.rand.nextLong(), originalX, originalZ, chunkPrimerIn, offsetX, offsetY, offsetZ, f2, f, f1, 0, 0, 1.0D);
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

    protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop, IBlockState state, IBlockState up) {
        net.minecraft.world.biome.Biome biome = world.getBiome(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
        IBlockState top = biome.topBlock;
        IBlockState filler = biome.fillerBlock;

        if (this.canReplaceBlock(state, up) || state.getBlock() == top.getBlock() || state.getBlock() == filler.getBlock()) {
            if (y - 1 < 10) {
                data.setBlockState(x, y, z, CAVE_LAVA);
            } else {
                data.setBlockState(x, y, z, CAVE_AIR);

                if (foundTop && data.getBlockState(x, y - 1, z).getBlock() == filler.getBlock()) {
                    data.setBlockState(x, y - 1, z, top.getBlock().getDefaultState());
                }
            }
        }
    }
}
