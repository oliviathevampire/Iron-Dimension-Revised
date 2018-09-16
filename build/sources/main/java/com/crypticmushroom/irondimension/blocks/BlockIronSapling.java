package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import com.crypticmushroom.irondimension.world.WorldGenIronTree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockIronSapling extends BlockBush implements RegisterModelUtil, IGrowable {
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

    public BlockIronSapling() {
        setCreativeTab(TabIDL.tabIDL);
        setSoundType(SoundType.PLANT);
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
        WorldGenerator treeGenerator;
        treeGenerator = new WorldGenIronTree(true);

        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);

        if (!treeGenerator.generate(world, rand, pos)) {
            world.setBlockState(pos, state, 4);
        }
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return (double) worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
                this.grow(worldIn, rand, pos, state);
            }
        }
    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return SAPLING_AABB;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        //noinspection ConstantConditions
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation((Item.getItemFromBlock(this)).getRegistryName(), "inventory"));
    }
}
