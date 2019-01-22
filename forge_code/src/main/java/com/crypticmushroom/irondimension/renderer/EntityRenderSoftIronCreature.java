package com.crypticmushroom.irondimension.renderer;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.entities.EntitySoftIronCreature;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class EntityRenderSoftIronCreature extends RenderLiving<EntitySoftIronCreature> {

    private static final ResourceLocation textureLoc = new ResourceLocation(IronDimension.MODEL_DIR + "iron/soft_iron_creature.png");

    public EntityRenderSoftIronCreature(RenderManager manager, ModelBase model, float shadowSize) {
        super(manager, model, shadowSize);
        this.shadowSize = shadowSize;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySoftIronCreature entity) {
        return textureLoc;
    }
}
