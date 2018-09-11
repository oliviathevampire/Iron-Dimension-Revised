package com.crypticmushroom.irondimension.proxy;

import com.crypticmushroom.irondimension.renderer.EntityRenderIronCow;
import com.crypticmushroom.irondimension.renderer.EntityRenderIronPig;
import com.crypticmushroom.irondimension.entities.EntityIronCow;
import com.crypticmushroom.irondimension.entities.EntityIronPig;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void doPreLoadRegistration() {

        RenderingRegistry.registerEntityRenderingHandler(EntityIronPig.class, m -> new EntityRenderIronPig(m, 0.625F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIronCow.class, m -> new EntityRenderIronCow(m, 0.625F));
    }
}
