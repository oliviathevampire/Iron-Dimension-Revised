package com.crypticmushroom.irondimension;

import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = IronDimension.MODID, value = Side.CLIENT)
public class EventHandlerClientIDL {

    @SubscribeEvent
    public static void registerBlockColors(ColorHandlerEvent.Block e) {
        BlockColors blocks = e.getBlockColors();

        blocks.registerBlockColorHandler((state, worldIn, pos, tintIndex) -> worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : 0xFFFFFF,
                BlocksIDL.iron_grass,
                BlocksIDL.ironwood_leaves,
                BlocksIDL.hornbeam_leaves);
    }

    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Item e) {
        BlockColors blocks = e.getBlockColors();
        ItemColors items = e.getItemColors();

        items.registerItemColorHandler((stack, tintIndex) -> blocks.colorMultiplier(((ItemBlock)stack.getItem()).getBlock().getDefaultState(), null, null, tintIndex),
                BlocksIDL.iron_grass,
                BlocksIDL.ironwood_leaves,
                BlocksIDL.hornbeam_leaves);
    }

    @SubscribeEvent
    public static void textureStitch(TextureStitchEvent.Pre e) {
        TextureMap map = e.getMap();

        map.registerSprite(new ResourceLocation(IronDimension.MODID, "particle/iron_portal"));
    }
}
