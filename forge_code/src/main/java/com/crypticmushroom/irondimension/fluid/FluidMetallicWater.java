package com.crypticmushroom.irondimension.fluid;

import com.crypticmushroom.irondimension.TabIDL;
import com.crypticmushroom.irondimension.registry.util.RegisterModelUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class FluidMetallicWater extends BlockFluidClassic implements RegisterModelUtil {

    public FluidMetallicWater(Fluid fluid, Material material) {
        super(fluid, material);
        setLightOpacity(3);
        setCreativeTab(TabIDL.tabIDL);
    }

    @Override
    public void registerModel() {
        final Item item = Item.getItemFromBlock(this);
        ModelBakery.registerItemVariants(item);
        String domain = getRegistryName() == null ? "minecraft" : getRegistryName().getNamespace();
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(domain + ":fluids", getFluid().getName());
        ModelLoader.setCustomMeshDefinition(item, stack -> modelResourceLocation);
        ModelLoader.setCustomStateMapper(this, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return modelResourceLocation;
            }
        });
    }
}
