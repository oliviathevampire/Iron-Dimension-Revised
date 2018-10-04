package com.crypticmushroom.irondimension.world.biomes;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeGlowingCliffs extends BiomeIronDimension {

    public BiomeGlowingCliffs(BiomeProperties props) {
        super(props);
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {
        super.decorate(world, rand, pos);

        for (int ocean = 0; ocean < 10; ocean++) {
            int Xcoord = pos.getX() + rand.nextInt(16);
            int Zcoord = pos.getZ() + rand.nextInt(16);
            int Ycoord = rand.nextInt(128);
            new WorldGenMinable(BlocksIDL.fervid_iron_ore.getDefaultState(), 9,
                    input -> input == BlocksIDL.ironstone.getDefaultState()).generate(world, rand, new BlockPos(Xcoord, Ycoord, Zcoord));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        return 0xe0d0c0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) {
        return 0xe0d0c0;
    }
}
