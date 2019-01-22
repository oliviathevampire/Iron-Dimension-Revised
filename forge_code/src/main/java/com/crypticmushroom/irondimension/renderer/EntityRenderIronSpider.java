package com.crypticmushroom.irondimension.renderer;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

public class EntityRenderIronSpider extends RenderSpider {
    private static final ResourceLocation textureLoc = new ResourceLocation(IronDimension.MODEL_DIR + "iron/iron_spider.png");

    public EntityRenderIronSpider(RenderManager manager, float shadowSize) {
        super(manager);
        this.shadowSize = shadowSize;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySpider entity) {
        return textureLoc;
    }
}
