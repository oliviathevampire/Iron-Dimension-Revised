package com.crypticmushroom.irondimension.world.biomes;

public class BiomeIronPlains extends BiomeIronDimension {

    public BiomeIronPlains(BiomeProperties props) {
        super(props);

        decorator.treesPerChunk = 1;
    }

    //TODO: Grass?
}
