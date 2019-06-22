package com.crypticmushroom.irondimension.entities.renderer;

import com.crypticmushroom.irondimension.entities.entity.IronBisonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.util.Identifier;

public class IronBisonRenderer extends MobEntityRenderer<IronBisonEntity, CowEntityModel<IronBisonEntity>> {
    private static final Identifier SKIN = new Identifier("textures/entity/cow/cow.png");

    public IronBisonRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new CowEntityModel(), 0.7F);
    }

    @Override
    protected Identifier getTexture(IronBisonEntity var1) {
        return SKIN;
    }
}
