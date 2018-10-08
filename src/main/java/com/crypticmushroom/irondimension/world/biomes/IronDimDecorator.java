package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import com.crypticmushroom.irondimension.world.gen.WorldGenIronLakes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * This class is for general decoration. Any biome-specific
 * generation can stay in the specified Biome classes.
 */
public class IronDimDecorator {

    private WorldGenIronLakes extraLavaLakes = new WorldGenIronLakes(BlocksIDL.liquid_iron_block);

    public BlockPos chunkPos;
    public ChunkGeneratorSettings chunkGeneratorSettings;

    public int treesPerChunk;
    public float lavaPoolChance;

    public void decorate(World world, Random rand, Biome biome, BlockPos pos) {
        this.chunkPos = pos;

        for (int i = 0; i < treesPerChunk; ++i) {
            int x = rand.nextInt(16) + 8;
            int z = rand.nextInt(16) + 8;
            WorldGenAbstractTree worldgenabstracttree = biome.getRandomTreeFeature(rand);
            worldgenabstracttree.setDecorationDefaults();
            BlockPos blockpos = world.getHeight(this.chunkPos.add(x, 0, z));

            if (worldgenabstracttree.generate(world, rand, blockpos)) {
                worldgenabstracttree.generateSaplings(world, rand, blockpos);
            }
        }

        genDecorations(biome, world, rand);
        decorateUnderground(world, rand, pos);
    }

    protected void genDecorations(Biome biome, World world, Random rand) {
        if (rand.nextFloat() <= lavaPoolChance) {
            int rx = chunkPos.getX() + rand.nextInt(16) + 8;
            int rz = chunkPos.getZ() + rand.nextInt(16) + 8;
            extraLavaLakes.generate(world, rand, world.getHeight(new BlockPos(rx, 0, rz)));
        }
    }

    protected void decorateUnderground(World world, Random rand, BlockPos pos) {
        for (int rarity = 0; rarity < 25; rarity++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(64);
            new WorldGenMinable(BlocksIDL.soft_iron.getDefaultState(), chunkGeneratorSettings.coalSize,
                    input -> input == BlocksIDL.ironstone.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }

        for (int rarity = 0; rarity < 10; rarity++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(64);
            new WorldGenMinable(BlocksIDL.super_iron_ore.getDefaultState(), chunkGeneratorSettings.ironSize,
                    input -> input == BlocksIDL.ironstone.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }

        for (int rarity = 0; rarity < 5; rarity++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(32);
            new WorldGenMinable(BlocksIDL.radioactive_iron_ore.getDefaultState(), chunkGeneratorSettings.diamondSize,
                    input -> input == BlocksIDL.ironstone.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }
    }
}
