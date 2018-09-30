package com.crypticmushroom.irondimension.world.biomes;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeNoxiousPlains extends BiomeIronDimension {

    public BiomeNoxiousPlains(BiomeProperties props) {
        super(props);

        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableCaveCreatureList.clear();
        spawnableWaterCreatureList.clear();

        //spawnableCreatureList.add(new SpawnListEntry(EntityRadioactiveIronGolem.class, 60, 1, 4));

        decorator.treesPerChunk = 2;
    }

    //TODO:
    // 1. Generate boulders of Soft Iron, with occasional Radioactive Iron Ore
    // 2. Radioactive Trees?
    // 3. Radioactive Pools?

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0x66ff66;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0x66ff66;
    }

}
