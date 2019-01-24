package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.blocks.*;
import com.crypticmushroom.irondimension.world.gen.saplinggenerator.HornbeamSaplingGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksIDL {
    public static Block iron_dim_portal = null;
    public static Block iron_dirt = null;
    public static Block iron_grass = null;
    public static Block ironwood_planks = null;
    public static Block hornbeam_planks = null;
    public static Block ironwood_log = null;
    public static Block hornbeam_log = null;
    public static Block ironwood_leaves = null;
    public static Block hornbeam_leaves = null;
    public static Block ironwood_sapling = null;
    public static Block hornbeam_sapling = null;
    public static Block ironstone = null;
    public static Block soft_iron = null;
    public static Block iron_bricks = null;
    public static Block iron_brick_stairs = null;
    public static Block super_iron_ore = null;
    public static Block super_iron_block = null;
    public static Block radioactive_iron_ore = null;
    public static Block radioactive_iron_block = null;
    public static Block fervid_iron_ore = null;

    public static Block metallic_water_block = null;
    public static Block liquid_iron_block = null;

    public static void init() {
        iron_dirt = register("iron_dirt", new BlockIronDirt());
        iron_grass = register("iron_grass", new BlockIronGrass());
        ironwood_planks = register("ironwood_planks", new BlockIronPlanks());
        hornbeam_planks = register("hornbeam_planks", new BlockIronPlanks());
        ironwood_log = register("ironwood_log", new BlockIronLog(MaterialColor.IRON));
        hornbeam_log = register("hornbeam_log", new BlockIronLog(MaterialColor.BROWN));
        ironwood_leaves = register("ironwood_leaves", new BlockIronLeaves());
        hornbeam_leaves = register("hornbeam_leaves", new BlockIronLeaves());
        hornbeam_sapling = register("hornbeam_sapling", new BlockSapling(new HornbeamSaplingGenerator()));
        ironstone = register("ironstone", new BlockIronStone());
        soft_iron = register("soft_iron", new BlockSoftIron());
        iron_bricks = register("iron_bricks", new BlockIronBrick());
        iron_brick_stairs = register("iron_brick_stairs", new BlockIronBrickStairs(iron_bricks.getDefaultState()));
        super_iron_ore = register("super_iron_ore", new BlockIDLOre());
        super_iron_block = register("super_iron_block", new BlockCompact());
        radioactive_iron_ore = register("radioactive_iron_ore", new BlockIDLOre());
        radioactive_iron_block = register("radioactive_iron_block", new BlockCompact());
        fervid_iron_ore = register("fervid_iron_ore", new BlockIDLOre());
    }

    private static Block register(String name, Block block) {
        Registry.BLOCK.register(new Identifier(IronDimension.MODID, name), block);
        Registry.ITEM.register(new Identifier(IronDimension.MODID, name), new BlockItem(block, new Item.Settings().itemGroup(IronDimension.IDL_ITEM_GROUP)));
        return block;
    }
}
