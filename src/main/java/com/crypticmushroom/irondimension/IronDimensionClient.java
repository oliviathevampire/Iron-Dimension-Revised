package com.crypticmushroom.irondimension;

import com.crypticmushroom.irondimension.entities.entity.IronBisonEntity;
import com.crypticmushroom.irondimension.entities.renderer.IronBisonRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;

/**
 * IronDimensionClient
 */
public class IronDimensionClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(IronBisonEntity.class, (entityRenderDispatcher, context) -> new IronBisonRenderer(entityRenderDispatcher));
    }
}