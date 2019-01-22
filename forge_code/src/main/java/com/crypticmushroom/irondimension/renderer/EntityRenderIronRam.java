package com.crypticmushroom.irondimension.renderer;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.entities.EntityIronRam;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class EntityRenderIronRam extends RenderLiving<EntityIronRam> {
    private static final ResourceLocation textureLoc = new ResourceLocation(IronDimension.MODEL_DIR + "iron/iron_ram.png");

    public EntityRenderIronRam(RenderManager manager, ModelBase model, float shadowSize) {
        super(manager, model, shadowSize);
        this.shadowSize = shadowSize;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityIronRam entity) {
        return textureLoc;
    }
}
