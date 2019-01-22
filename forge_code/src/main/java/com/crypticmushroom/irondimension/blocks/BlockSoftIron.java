package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockSoftIron extends Block implements RegisterModelUtil {

    public BlockSoftIron() {
        super(Material.ROCK, MapColor.SILVER);

        setHardness(1.5F);
        setResistance(10.0F);
        setCreativeTab(TabIDL.tabIDL);
        setHarvestLevel("pickaxe", 2);
    }
}
