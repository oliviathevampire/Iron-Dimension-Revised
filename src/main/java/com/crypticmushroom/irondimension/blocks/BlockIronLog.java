package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class BlockIronLog extends BlockLog implements RegisterModelUtil {

    public BlockIronLog() {
        setHardness(2.0F);
        setResistance(2.0F);
        setCreativeTab(TabIDL.tabIDL);
        setDefaultState(getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y));
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LOG_AXIS);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = getDefaultState();

        switch (meta & 12) {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }
        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        switch (state.getValue(LOG_AXIS)) {
            case X:
                i |= 4;
                break;
            case Y:
                i |= 0;
                break;
            case Z:
                i |= 8;
                break;
            case NONE:
                i |= 12;
        }
        return i;
    }
}
