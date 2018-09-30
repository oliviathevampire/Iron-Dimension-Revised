package com.crypticmushroom.irondimension.world;

import com.crypticmushroom.irondimension.registry.BiomeIDL;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerIDLBiomes extends GenLayer {

    private static final int UNCOMMON_BIOME_CHANCE = 4;
    private static final int RARE_BIOME_CHANCE = 8;
    protected Biome commonBiomes[] = (new Biome[] {
            BiomeIDL.iron_forest,
            BiomeIDL.iron_highlands,
            BiomeIDL.iron_plains,
    });
    protected Biome uncommonBiomes[] = (new Biome[] {
            BiomeIDL.glowing_cliffs,
            //BiomeIDL.corroded_hills,
            //BiomeIDL.corroded_desert,
            //BiomeIDL.scorching_bog,
    });
    protected Biome rareBiomes[] = (new Biome[] {
            BiomeIDL.noxious_swamp,
            BiomeIDL.noxious_plains,
            //BiomeIDL.molten_chasm,
            //BiomeIDL.molten_peaks
    });

    public GenLayerIDLBiomes(long l, GenLayer genlayer) {
        super(l);
        parent = genlayer;
    }

    public GenLayerIDLBiomes(long l) {
        super(l);
    }

    @Override
    public int[] getInts(int x, int z, int width, int depth) {
        int dest[] = IntCache.getIntCache(width * depth);
        for (int dz = 0; dz < depth; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + z);
                if (nextInt(RARE_BIOME_CHANCE) == 0) {
                    //magic number!
                    dest[dx + dz * width] = Biome.getIdForBiome(rareBiomes[nextInt(rareBiomes.length)]);
                } else if (nextInt(UNCOMMON_BIOME_CHANCE) == 0) {
                    //Well, it's no rare biome, but it will suffice
                    dest[dx + dz * width] = Biome.getIdForBiome(uncommonBiomes[nextInt(uncommonBiomes.length)]);
                } else {
                    //aww...
                    dest[dx + dz * width] = Biome.getIdForBiome(commonBiomes[nextInt(commonBiomes.length)]);
                }
            }
        }

        return dest;
    }
}
