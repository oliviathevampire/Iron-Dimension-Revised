package com.crypticmushroom.irondimension.renderer;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.ResourceLocation;

public class EntityRenderRadioactiveIronGolem extends RenderIronGolem {
    private static final ResourceLocation textureLoc = new ResourceLocation(IronDimension.MODEL_DIR + "iron/radioactive_iron_golem.png");

    public EntityRenderRadioactiveIronGolem(RenderManager manager, float shadowSize) {
        super(manager);
        this.shadowSize = shadowSize;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityIronGolem entity) {
        return textureLoc;
    }
}