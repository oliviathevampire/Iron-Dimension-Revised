package com.crypticmushroom.irondimension.renderer;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class EntityRenderIronZombie extends RenderZombie {
    private static final ResourceLocation textureLoc = new ResourceLocation(IronDimension.MODEL_DIR + "iron/iron_zombie.png");

    public EntityRenderIronZombie(RenderManager manager, float shadowSize) {
        super(manager);
        this.shadowSize = shadowSize;
    }

    protected ResourceLocation getEntityTexture(EntityZombie entity) {
        return textureLoc;
    }
}
