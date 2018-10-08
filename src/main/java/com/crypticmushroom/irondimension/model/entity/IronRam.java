package com.crypticmushroom.irondimension.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Iron Ram - Anomalocaris101
 * Created using Tabula 7.0.0
 */
public class IronRam extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Leg1;
    public ModelRenderer Leg2;
    public ModelRenderer Leg3;
    public ModelRenderer Leg4;
    public ModelRenderer Head;
    public ModelRenderer Tail;
    public ModelRenderer snout;
    public ModelRenderer lefthorn;
    public ModelRenderer Righthorn;
    public ModelRenderer Lefthorn2;
    public ModelRenderer Lefthorn3;
    public ModelRenderer Righthorn2;
    public ModelRenderer Righthorn3;

    public IronRam() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.lefthorn = new ModelRenderer(this, 50, 21);
        this.lefthorn.setRotationPoint(3.0F, -6.2F, -5.0F);
        this.lefthorn.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(lefthorn, 0.0F, 0.17453292519943295F, 0.0F);
        this.Lefthorn3 = new ModelRenderer(this, 50, 21);
        this.Lefthorn3.setRotationPoint(0.0F, -0.5F, -4.0F);
        this.Lefthorn3.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Lefthorn3, -1.1344640137963142F, 0.0F, 0.0F);
        this.Leg4 = new ModelRenderer(this, 0, 10);
        this.Leg4.setRotationPoint(-2.7F, 4.5F, 6.0F);
        this.Leg4.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.Leg1 = new ModelRenderer(this, 0, 10);
        this.Leg1.setRotationPoint(2.7F, 4.5F, -6.0F);
        this.Leg1.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.snout = new ModelRenderer(this, 0, 1);
        this.snout.setRotationPoint(0.0F, -1.7F, -5.5F);
        this.snout.addBox(-2.0F, -2.5F, -4.0F, 4, 5, 4, 0.0F);
        this.Leg2 = new ModelRenderer(this, 0, 10);
        this.Leg2.setRotationPoint(-2.7F, 4.5F, -6.0F);
        this.Leg2.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.Lefthorn2 = new ModelRenderer(this, 50, 21);
        this.Lefthorn2.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.Lefthorn2.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Lefthorn2, 1.5707963267948966F, -0.5235987755982988F, 0.0F);
        this.Righthorn = new ModelRenderer(this, 50, 21);
        this.Righthorn.setRotationPoint(-3.0F, -6.2F, -5.0F);
        this.Righthorn.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Righthorn, 0.0F, -0.17453292519943295F, 0.0F);
        this.Leg3 = new ModelRenderer(this, 0, 10);
        this.Leg3.setRotationPoint(2.7F, 4.5F, 6.0F);
        this.Leg3.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.Head = new ModelRenderer(this, 34, 8);
        this.Head.setRotationPoint(0.0F, -1.0F, -6.5F);
        this.Head.addBox(-3.0F, -6.0F, -6.0F, 6, 7, 6, 0.0F);
        this.Righthorn3 = new ModelRenderer(this, 50, 21);
        this.Righthorn3.setRotationPoint(0.0F, -0.5F, -4.0F);
        this.Righthorn3.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Righthorn3, -1.1344640137963142F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 5);
        this.Body.setRotationPoint(0.0F, 11.5F, 0.0F);
        this.Body.addBox(-4.5F, -5.5F, -8.0F, 9, 11, 16, 0.0F);
        this.Tail = new ModelRenderer(this, 34, 2);
        this.Tail.setRotationPoint(0.0F, -5.0F, 7.0F);
        this.Tail.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 2, 0.0F);
        this.Righthorn2 = new ModelRenderer(this, 50, 21);
        this.Righthorn2.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.Righthorn2.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Righthorn2, 1.5707963267948966F, 0.5235987755982988F, 0.0F);
        this.Head.addChild(this.lefthorn);
        this.Lefthorn2.addChild(this.Lefthorn3);
        this.Body.addChild(this.Leg4);
        this.Body.addChild(this.Leg1);
        this.Head.addChild(this.snout);
        this.Body.addChild(this.Leg2);
        this.lefthorn.addChild(this.Lefthorn2);
        this.Head.addChild(this.Righthorn);
        this.Body.addChild(this.Leg3);
        this.Body.addChild(this.Head);
        this.Righthorn2.addChild(this.Righthorn3);
        this.Body.addChild(this.Tail);
        this.Righthorn.addChild(this.Righthorn2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Head.rotateAngleX = headPitch * 0.017453292F;
        this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.Leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
