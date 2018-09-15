package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.entities.EntityIronCow;
import com.crypticmushroom.irondimension.entities.EntityIronPig;
import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import static net.minecraftforge.fml.common.eventhandler.Event.Result.DENY;

public class BiomeIronDimension extends Biome {

    private WorldGenAbstractTree genTree;

    public BiomeIronDimension(BiomeProperties props) {
        super(props);

        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();

        spawnableCreatureList.add(new SpawnListEntry(EntityIronCow.class, 20, 1, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityIronPig.class, 40, 2, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityIronGolem.class, 40, 2, 4));

        topBlock = BlocksIDL.iron_grass.getDefaultState();
        fillerBlock = BlocksIDL.iron_dirt.getDefaultState();

        genTree = new WorldGenIronTree(false);

        decorator.flowersPerChunk = -999;
        decorator.reedsPerChunk = 0;
        decorator.treesPerChunk = 3;
        decorator.grassPerChunk = -999;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xc0c0c0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xc0c0c0;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random par1Random) {
        return par1Random.nextInt(3) == 0 ? new WorldGenNoTree() : par1Random.nextInt(9) == 0 ? genTree : new WorldGenNoTree();
    }

    @Override
    public void genTerrainBlocks(World world, Random rand, ChunkPrimer primer, int x, int z, double noiseVal) {
        this.genIronDimTerrain(world, rand, primer, x, z, noiseVal);
    }

    public final void genIronDimTerrain(World world, Random random, ChunkPrimer chunkPrimer, int x, int z, double noiseVal) {
        IBlockState state1 = this.topBlock;
        IBlockState state2 = this.fillerBlock;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        int i = 63;
        int j = -1;
        int k = (int) (noiseVal / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int l = x & 15;
        int m = z & 15;

        for (int j1 = 255; j1 >= 0; --j1) {
            if (j1 <= random.nextInt(5)) {
                chunkPrimer.setBlockState(m, j1, l, BEDROCK);
            } else {
                IBlockState iblockstate2 = chunkPrimer.getBlockState(m, j1, l);

                if (iblockstate2.getMaterial() == Material.AIR) {
                    j = -1;
                } else if (iblockstate2.getBlock() == BlocksIDL.soft_iron) {
                    if (j == -1) {
                        if (k <= 0) {
                            state1 = AIR;
                            state2 = BlocksIDL.soft_iron.getDefaultState();
                        } else if (j1 >= i - 4 && j1 <= i + 1) {
                            state1 = this.topBlock;
                            state2 = this.fillerBlock;
                        }

                        if (j1 < i && (state1 == null || state1.getMaterial() == Material.AIR)) {
                            if (this.getTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F) {
                                state1 = ICE;
                            } else {
                                state1 = Blocks.WATER.getDefaultState();
                            }
                        }

                        j = k;

                        if (j1 >= i - 1) {
                            chunkPrimer.setBlockState(m, j1, l, state1);
                        } else if (j1 < i - 7 - k) {
                            state1 = AIR;
                            state2 = BlocksIDL.soft_iron.getDefaultState();
                            chunkPrimer.setBlockState(m, j1, l, BlocksIDL.iron_dirt.getDefaultState());
                        } else {
                            chunkPrimer.setBlockState(m, j1, l, state2);
                        }
                    } else if (j > 0) {
                        --j;
                        chunkPrimer.setBlockState(m, j1, l, state2);
                    }
                }
            }
        }
    }
}
