package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCompact extends Block implements RegisterModelUtil {

    public BlockCompact() {
        super(Material.IRON);

        setHardness(5.0F);
        setResistance(10.0F);
        setCreativeTab(TabIDL.tabIDL);
    }
}
