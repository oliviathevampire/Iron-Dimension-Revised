package com.crypticmushroom.irondimension.renderer;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.entities.EntityMoltenIronCreature;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class EntityRenderMoltenIronCreature extends RenderLiving<EntityMoltenIronCreature> {
    private static final ResourceLocation textureLoc = new ResourceLocation(IronDimension.MODEL_DIR + "iron/soft_iron_creature.png");

    public EntityRenderMoltenIronCreature(RenderManager manager, ModelBase model, float shadowSize) {
        super(manager, model, shadowSize);
        this.shadowSize = shadowSize;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMoltenIronCreature entity) {
        return textureLoc;
    }
}
