package com.crypticmushroom.irondimension.renderer;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;

public class EntityRenderRadioactiveIronSkeleton extends RenderSkeleton {
    private static final ResourceLocation textureLoc = new ResourceLocation(IronDimension.MODEL_DIR + "iron/radioactive_iron_skeleton.png");

    public EntityRenderRadioactiveIronSkeleton(RenderManager manager, float shadowSize) {
        super(manager);
        this.shadowSize = shadowSize;
    }

    @Override
    protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return textureLoc;
    }
}
