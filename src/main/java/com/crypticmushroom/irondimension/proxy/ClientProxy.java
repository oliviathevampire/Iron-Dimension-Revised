package com.crypticmushroom.irondimension.proxy;

import com.crypticmushroom.irondimension.entities.*;
import com.crypticmushroom.irondimension.particles.ParticleIronPortal;
import com.crypticmushroom.irondimension.renderer.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void doPreLoadRegistration() {

        RenderingRegistry.registerEntityRenderingHandler(EntityIronPig.class, m -> new EntityRenderIronPig(m, 0.625F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIronCow.class, m -> new EntityRenderIronCow(m, 0.625F));
        RenderingRegistry.registerEntityRenderingHandler(EntityPureIronGolem.class, m -> new EntityRenderPureIronGolem(m, 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIronSpider.class, m -> new EntityRenderIronSpider(m, 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIronZombie.class, m -> new EntityRenderIronZombie(m, 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRadioactiveIronGolem.class, m -> new EntityRenderRadioactiveIronGolem(m, 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRadioactiveIronSkeleton.class, m -> new EntityRenderRadioactiveIronSkeleton(m, 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRadioactiveIronSpider.class, m -> new EntityRenderRadioactiveIronSpider(m, 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRadioactiveIronZombie.class, m -> new EntityRenderRadioactiveIronZombie(m, 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRustySkeleton.class, m -> new EntityRenderRustySkeleton(m, 0.5F));
    }

    @Override
    public World getClientWorld() {
        return FMLClientHandler.instance().getClient().world;
    }

    @Override
    public void spawnParticle(World world, ParticleIDL particle, double x, double y, double z, double speedX, double speedY, double speedZ) {
        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = mc.getRenderViewEntity();

        world = getClientWorld();

        if (entity != null && mc.effectRenderer != null) {
            int i = mc.gameSettings.particleSetting;

            if (i == 1 && world.rand.nextInt(3) == 0) {
                i = 2;
            }

            double dx = entity.posX - x;
            double dy = entity.posY - y;
            double dz = entity.posZ - z;

            if (dx * dx + dy * dy + dz * dz <= 1024D && i <= 1) {
                Particle part = null;

                switch (particle) {
                    case IRON_PORTAL:
                        part = new ParticleIronPortal(world, x, y, z, speedX, speedY, speedZ);
                }

                if (part != null) {
                    mc.effectRenderer.addEffect(part);
                }
            }
        }
    }

    public enum ParticleIDL {
        IRON_PORTAL,
    }
}
