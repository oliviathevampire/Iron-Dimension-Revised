package com.crypticmushroom.irondimension.blocks;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockIronBricks extends Block implements RegisterModelUtil {

    public BlockIronBricks() {
        super(Material.ROCK, MapColor.SILVER);

        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(10.0F);
        setCreativeTab(TabIDL.tabIDL);
    }
}
