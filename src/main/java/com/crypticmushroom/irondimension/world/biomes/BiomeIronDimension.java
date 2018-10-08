package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.entities.EntityIronCow;
import com.crypticmushroom.irondimension.entities.EntityIronPig;
import com.crypticmushroom.irondimension.entities.EntityPureIronGolem;
import com.crypticmushroom.irondimension.registry.BlocksIDL;
import com.crypticmushroom.irondimension.world.gen.WorldGenIronTree;
import com.crypticmushroom.irondimension.world.gen.WorldGenNoTree;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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

    public IronDimDecorator decorator;
    private WorldGenAbstractTree genIronTree;

    public BiomeIronDimension(BiomeProperties props) {
        super(props);
        decorator = getBiomeDecorator();

        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();

        spawnableCreatureList.add(new SpawnListEntry(EntityIronCow.class, 60, 2, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityIronPig.class, 60, 2, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityPureIronGolem.class, 60, 1, 4));

        topBlock = BlocksIDL.iron_grass.getDefaultState();
        fillerBlock = BlocksIDL.iron_dirt.getDefaultState();

        genIronTree = new WorldGenIronTree(false);

        decorator.treesPerChunk = 2;
    }

    public IronDimDecorator getBiomeDecorator() {
        return new IronDimDecorator();
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {
        this.decorator.decorate(world, rand, this, pos);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xe0e0e0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xe0e0e0;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        return random.nextInt(8) == 0 ? new WorldGenNoTree() : random.nextInt(4) == 0 ? genIronTree : new WorldGenNoTree();
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
                } else if (state.getBlock() == BlocksIDL.ironstone) {
                    if (j == -1) {
                        if (depth <= 0) {
                            //We are below the noise depth
                            stateTop = AIR;
                            stateFiller = BlocksIDL.ironstone.getDefaultState();
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
                                stateTop = BlocksIDL.metallic_water_block.getDefaultState();
                            }
                        }

                        j = depth;

                        if (height >= ocean - 1) /*Variable height is equal and above 62*/ {
                            chunkPrimer.setBlockState(zChunk, height, xChunk, stateTop);
                        } else if (height < ocean - 7 - depth) /*Variable height is below the average of 54*/ {
                            stateTop = AIR;
                            stateFiller = BlocksIDL.ironstone.getDefaultState();
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
