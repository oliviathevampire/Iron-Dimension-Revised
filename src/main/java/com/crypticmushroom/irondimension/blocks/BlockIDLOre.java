package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIDLOre extends Block implements RegisterModelUtil {

    public BlockIDLOre() {
        super(Material.ROCK);

        setHardness(3.0F);
        setResistance(5.0F);
        setCreativeTab(TabIDL.tabIDL);
    }
}
