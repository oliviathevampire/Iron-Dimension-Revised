package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.blocks.*;
import com.crypticmushroom.irondimension.world.gen.saplinggenerator.HornbeamSaplingGenerator;
import com.crypticmushroom.irondimension.world.gen.saplinggenerator.IronwoodSaplingGenerator;
import com.crypticmushroom.irondimension.world.gen.saplinggenerator.RustyIronwoodSaplingGenerator;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksID {
    public static Block iron_dim_portal = null;
    public static Block iron_dirt = null;
    public static Block coarse_iron_dirt = null;
    public static Block scorching_dirt = null;
    public static Block iron_grass = null;
    public static Block ironwood_planks = null;
    public static Block rusty_ironwood_planks = null;
    public static Block hornbeam_planks = null;
    public static Block ironwood_log = null;
    public static Block stripped_ironwood_log = null;
    public static Block rusty_ironwood_log = null;
    public static Block stripped_rusty_ironwood_log = null;
    public static Block hornbeam_log = null;
    public static Block stripped_hornbeam_log = null;
    public static Block ironwood_leaves = null;
    public static Block rusty_ironwood_leaves = null;
    public static Block hornbeam_leaves = null;
    public static Block ironwood_sapling = null;
    public static Block rusty_ironwood_sapling = null;
    public static Block hornbeam_sapling = null;
    public static Block ironstone = null;
    public static Block chiselled_ironstone = null;
    public static Block chiselled_ironstone_stairs = null;
    public static Block chiselled_ironstone_slab = null;
    public static Block smooth_ironstone = null;
    public static Block smooth_ironstone_stairs = null;
    public static Block smooth_ironstone_slab = null;
    public static Block soft_iron = null;
    public static Block ironstone_bricks = null;
    public static Block ironstone_brick_stairs = null;
    public static Block ironstone_brick_slab = null;
    public static Block super_iron_ore = null;
    public static Block super_iron_block = null;
    public static Block radioactive_iron_ore = null;
    public static Block radioactive_iron_block = null;
    public static Block infernal_iron_ore = null;
    public static Block infernal_iron_block = null;
    public static Block lumen_iron_ore = null;
    public static Block lumen_iron_block = null;
    public static Block iron_thatch = null;
    public static Block rusty_iron_thatch = null;
    public static Block acidrose_bush = null;
    public static Block aerialweed = null;
    public static Block coilfern = null;
    public static Block corroshroom = null;
    public static Block ferric_flower = null;
    public static Block firepod = null;
    public static Block molten_daisy = null;
    public static Block steel_orchid = null;
    public static Block ironwood_sign = null;
    public static Block rusty_ironwood_sign = null;
    public static Block hornbeam_sign = null;
    public static Block ironwood_wall_sign = null;
    public static Block rusty_ironwood_wall_sign = null;
    public static Block hornbeam_wall_sign = null;

    public static Block metallic_water_block = null;
    public static Block iron_water_block = null;

    public static void init() {
        iron_dim_portal = register("iron_dim_portal", new BlockIronPortal());
        iron_dirt = register("iron_dirt", new BlockIronDirt());
        coarse_iron_dirt = register("coarse_iron_dirt", new BlockIronDirt());
        scorching_dirt = register("scorching_dirt", new BlockIronDirt());
        iron_grass = register("iron_grass", new BlockIronGrass());
        ironwood_planks = register("ironwood_planks", new BlockIronPlanks());
        rusty_ironwood_planks = register("rusty_ironwood_planks", new BlockIronPlanks());
        hornbeam_planks = register("hornbeam_planks", new BlockIronPlanks());
        ironwood_log = register("ironwood_log", new BlockIronLog(MaterialColor.IRON));
        stripped_ironwood_log = register("stripped_ironwood_log", new BlockIronLog(MaterialColor.IRON));
        rusty_ironwood_log = register("rusty_ironwood_log", new BlockIronLog(MaterialColor.IRON));
        stripped_rusty_ironwood_log = register("stripped_rusty_ironwood_log", new BlockIronLog(MaterialColor.IRON));
        hornbeam_log = register("hornbeam_log", new BlockIronLog(MaterialColor.BROWN));
        stripped_hornbeam_log = register("stripped_hornbeam_log", new BlockIronLog(MaterialColor.BROWN));
        ironwood_leaves = register("ironwood_leaves", new BlockIronLeaves());
        rusty_ironwood_leaves = register("rusty_ironwood_leaves", new BlockIronLeaves());
        hornbeam_leaves = register("hornbeam_leaves", new BlockIronLeaves());
        ironwood_sapling = register("ironwood_sapling", new BlockSapling(new IronwoodSaplingGenerator()));
        rusty_ironwood_sapling = register("rusty_ironwood_sapling", new BlockSapling(new RustyIronwoodSaplingGenerator()));
        hornbeam_sapling = register("hornbeam_sapling", new BlockSapling(new HornbeamSaplingGenerator()));
        ironstone = register("ironstone", new BlockIronStone());
        chiselled_ironstone = register("chiseled_ironstone", new BlockIronStone());
        chiselled_ironstone_stairs = register("chiseled_ironstone_stairs", new BlockIronstoneStairs(chiselled_ironstone.getDefaultState()));
        chiselled_ironstone_slab = register("chiseled_ironstone_slab", new BlockIronSlab(chiselled_ironstone));
        smooth_ironstone = register("smooth_ironstone", new BlockIronStone());
        smooth_ironstone_stairs = register("smooth_ironstone_stairs", new BlockIronstoneStairs(smooth_ironstone.getDefaultState()));
        smooth_ironstone_slab = register("smooth_ironstone_slab", new BlockIronSlab(smooth_ironstone));
        soft_iron = register("soft_iron", new BlockSoftIron());
        ironstone_bricks = register("ironstone_bricks", new BlockIronStone());
        ironstone_brick_stairs = register("ironstone_brick_stairs", new BlockIronstoneStairs(ironstone_bricks.getDefaultState()));
        ironstone_brick_slab = register("ironstone_brick_slab", new BlockIronSlab(ironstone_bricks));
        super_iron_ore = register("super_iron_ore", new BlockIDLOre());
        super_iron_block = register("super_iron_block", new BlockCompact(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2)));
        radioactive_iron_ore = register("radioactive_iron_ore", new BlockIDLOre());
        radioactive_iron_block = register("radioactive_iron_block", new BlockCompact(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2)));
        infernal_iron_ore = register("infernal_iron_ore", new BlockIDLOre());
        infernal_iron_block = register("infernal_iron_block", new BlockCompact(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2)));
        lumen_iron_ore = register("lumen_iron_ore", new BlockIDLOre());
        lumen_iron_block = register("lumen_iron_block", new BlockCompact(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2)));
        iron_thatch = register("iron_thatch", new BlockIronThatch());
        rusty_iron_thatch = register("rusty_iron_thatch", new BlockIronThatch());
        acidrose_bush = register("acidrose_bush", new IronPlant());
        aerialweed = register("aerialweed", new IronPlant());
        coilfern = register("coilfern", new IronPlant());
        corroshroom = register("corroshroom", new IronPlant());
        ferric_flower = register("ferric_flower", new IronPlant());
        firepod	= register("firepod", new IronPlant());
	    molten_daisy = register("molten_daisy", new IronPlant());
        steel_orchid = register("steel_orchid", new IronPlant());
        ironwood_sign = registerBlock("ironwood_sign", new IronSignBlock(ironwood_planks));
        rusty_ironwood_sign = registerBlock("rusty_ironwood_sign", new IronSignBlock(rusty_ironwood_planks));
        hornbeam_sign = registerBlock("hornbeam_sign", new IronSignBlock(hornbeam_planks));
        ironwood_wall_sign = registerBlock("ironwood_wall_sign", new IronWallSignBlock(ironwood_sign));
        rusty_ironwood_wall_sign = registerBlock("rusty_ironwood_wall_sign", new IronWallSignBlock(rusty_ironwood_sign));
        hornbeam_wall_sign = registerBlock("hornbeam_wall_sign", new IronWallSignBlock(hornbeam_sign));

        iron_water_block = registerBlock("iron_water_block", new BlockFluid(FluidsID.IRON_WATER, Block.Settings.copy(Blocks.WATER)));
    }

    private static Block register(String name, Block block) {
        Registry.register(Registry.BLOCK,new Identifier(IronDimension.MODID, name), block);
        Registry.register(Registry.ITEM,new Identifier(IronDimension.MODID, name), new BlockItem(block, new Item.Settings().group(IronDimension.IDL_ITEM_GROUP)));
        return block;
    }

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registry.BLOCK,new Identifier(IronDimension.MODID, name), block);
        return block;
    }
}
