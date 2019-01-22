package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.world.gen.WorldGenHornbeamTree;
import com.crypticmushroom.irondimension.world.gen.WorldGenIronTree;
import com.crypticmushroom.irondimension.world.gen.WorldGenNoTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeIronForest extends BiomeIronDimension {

    private WorldGenAbstractTree genIronTree, genHornbeamTree;

    public BiomeIronForest(Biome.BiomeProperties props) {
        super(props);

        genIronTree = new WorldGenIronTree(false);
        genHornbeamTree = new WorldGenHornbeamTree(false);

        decorator.treesPerChunk = 5;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random random) {
        if (random.nextInt(5) == 0) {
            if (random.nextInt(5) == 0) {
                return genHornbeamTree;
            } else {
                return genIronTree;
            }
        } else {
            return new WorldGenNoTree();
        }
    }
}
