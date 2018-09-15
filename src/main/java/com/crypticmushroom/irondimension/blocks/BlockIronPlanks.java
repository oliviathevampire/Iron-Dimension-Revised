package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockIronPlanks extends Block implements RegisterModelUtil {

    public BlockIronPlanks() {
        super(Material.WOOD, MapColor.SILVER);
        setHardness(2.0F);
        setResistance(2.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(TabIDL.tabIDL);
    }
}
