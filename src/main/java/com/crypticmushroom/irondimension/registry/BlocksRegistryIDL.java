package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.blocks.*;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = IronDimension.MODID)
public final class BlocksRegistryIDL {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BlockRegistryHelper blocks = new BlockRegistryHelper(event.getRegistry());

        blocks.register("iron_dim_portal", new BlockIronDimPortal());
        blocks.register("iron_dirt", new BlockIronDirt());
        blocks.register("iron_grass", new BlockIronGrass());
        blocks.register("iron_log", new BlockIronLog());
        blocks.register("iron_leaves", new BlockIronLeaves());
        blocks.register("iron_sapling", new BlockIronSapling());
        blocks.register("soft_iron", new BlockSoftIron());
        blocks.register("iron_bricks", new BlockIronBricks());
        Block ironBrick = new BlockIronBricks();
        blocks.register("iron_brick_stairs", new BlockIronBrickStairs(ironBrick.getDefaultState()));
        blocks.register("super_iron_ore", new BlockIDLOre());
        blocks.register("super_iron_block", new BlockCompact());
        blocks.register("radioactive_iron_ore", new BlockIDLOre());
        blocks.register("radioactive_iron_block", new BlockCompact());
    }

    public static List<RegisterModelUtil> getBlockModels() {
        return ImmutableList.copyOf(BlockRegistryHelper.blockModels);
    }

    private static class BlockRegistryHelper {
        private final IForgeRegistry<Block> registry;

        private static List<RegisterModelUtil> blockModels = new ArrayList<>();

        BlockRegistryHelper(IForgeRegistry<Block> registry) {
            this.registry = registry;
        }

        private void register(String name, Block block) {
            block.setRegistryName(IronDimension.MODID, name);
            block.setTranslationKey(IronDimension.MODID + "." + name);

            if (block instanceof RegisterModelUtil) {
                blockModels.add((RegisterModelUtil) block);
            }
            registry.register(block);
        }
    }
}
