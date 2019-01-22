package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.BlockModelUtils;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockIronBrickStairs extends BlockStairs implements RegisterModelUtil {

    public BlockIronBrickStairs(IBlockState state) {
        super(state);

        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(10.0F);
        setCreativeTab(TabIDL.tabIDL);
        setHarvestLevel("pickaxe", 2);

        this.useNeighborBrightness = true;
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, HALF, SHAPE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return super.getMetaFromState(state);
    }

    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        return super.getStateFromMeta(meta & 0b0111);
    }

    @Override
    public void getSubBlocks(CreativeTabs par2CreativeTabs, NonNullList<ItemStack> par3List) {
        par3List.add(new ItemStack(this, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        BlockModelUtils.registerToState(this, 0, getDefaultState().withProperty(FACING, EnumFacing.EAST));
    }
}
