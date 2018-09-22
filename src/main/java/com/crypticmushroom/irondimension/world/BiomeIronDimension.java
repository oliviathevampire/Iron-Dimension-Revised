package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.entities.EntityIronCow;
import com.crypticmushroom.irondimension.entities.EntityIronPig;
import com.crypticmushroom.irondimension.entities.EntityPureIronGolem;
import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeIronDimension extends Biome {

    private WorldGenAbstractTree genTree;

    public BiomeIronDimension(BiomeProperties props) {
        super(props);

        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();

        spawnableCreatureList.add(new SpawnListEntry(EntityIronCow.class, 60, 2, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityIronPig.class, 60, 2, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityPureIronGolem.class, 60, 1, 4));

        topBlock = BlocksIDL.iron_grass.getDefaultState();
        fillerBlock = BlocksIDL.iron_dirt.getDefaultState();

        genTree = new WorldGenIronTree(false);

        decorator.flowersPerChunk = -999;
        decorator.reedsPerChunk = 0;
        decorator.treesPerChunk = 5;
        decorator.grassPerChunk = -999;
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {
        super.decorate(world, rand, pos);

        for (int ocean = 0; ocean < 15; ocean++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(64);
            new WorldGenMinable(BlocksIDL.super_iron_ore.getDefaultState(), 9,
                    input -> input == BlocksIDL.soft_iron.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }

        for (int ocean = 0; ocean < 10; ocean++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(32);
            new WorldGenMinable(BlocksIDL.radioactive_iron_ore.getDefaultState(), 8,
                    input -> input == BlocksIDL.soft_iron.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }
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
        return par1Random.nextInt(5) == 0 ? new WorldGenNoTree() : par1Random.nextInt(7) == 0 ? genTree : new WorldGenNoTree();
    }

    @Override
    public void genTerrainBlocks(World world, Random rand, ChunkPrimer primer, int x, int z, double noiseVal) {
        this.genIronDimTerrain(world, rand, primer, x, z, noiseVal);
    }

    public final void genIronDimTerrain(World world, Random random, ChunkPrimer chunkPrimer, int x, int z, double noiseVal) {
        IBlockState stateTop = this.topBlock;
        IBlockState stateFiller = this.fillerBlock;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        int ocean = 63;
        int j = -1;
        int depth = (int) (noiseVal / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int xChunk = x & 15;
        int zChunk = z & 15;

        for (int height = 255; height >= 0; --height) {
            //Is this roughly Bedrock height?
            if (height <= random.nextInt(5)) {
                chunkPrimer.setBlockState(zChunk, height, xChunk, BEDROCK);
            } else {
                //Move onto generating the actual blocks
                IBlockState state = chunkPrimer.getBlockState(zChunk, height, xChunk);

                if (state.getMaterial() == Material.AIR) {
                    j = -1;
                } else if (state.getBlock() == BlocksIDL.soft_iron) {
                    if (j == -1) {
                        if (depth <= 0) {
                            //We are below the noise depth
                            stateTop = AIR;
                            stateFiller = BlocksIDL.soft_iron.getDefaultState();
                        } else if (height >= ocean - 4 && height <= ocean + 1) /*Variable height is between 59 and 65*/ {
                            //This is the correct zone to generate the topBlock and fillerBlock
                            stateTop = this.topBlock;
                            stateFiller = this.fillerBlock;
                        }

                        if (height < ocean && (stateTop == null || stateTop.getMaterial() == Material.AIR)) /*Variable height is below ocean and topBlock is Air*/ {
                            if (this.getTemperature(blockpos$mutableblockpos.setPos(x, height, z)) < 0.15F) {
                                //Cold biomes have Ice
                                stateTop = ICE;
                            } else {
                                //Warmer biomes have Water
                                stateTop = Blocks.WATER.getDefaultState();
                            }
                        }

                        j = depth;

                        if (height >= ocean - 1) /*Variable height is equal and above 62*/ {
                            chunkPrimer.setBlockState(zChunk, height, xChunk, stateTop);
                        } else if (height < ocean - 7 - depth) /*Variable height is below the average of 54*/ {
                            stateTop = AIR;
                            stateFiller = BlocksIDL.soft_iron.getDefaultState();
                            chunkPrimer.setBlockState(zChunk, height, xChunk, BlocksIDL.iron_dirt.getDefaultState());
                        } else {
                            chunkPrimer.setBlockState(zChunk, height, xChunk, stateFiller);
                        }
                    } else if (j > 0) {
                        --j;
                        chunkPrimer.setBlockState(zChunk, height, xChunk, stateFiller);
                    }
                }
            }
        }
    }
}
