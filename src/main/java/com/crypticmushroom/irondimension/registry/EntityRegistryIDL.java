package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.entities.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = IronDimension.MODID)
public class EntityRegistryIDL {

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        EntityRegistryHelper entity = new EntityRegistryHelper(event.getRegistry());

        entity.registerEntity(EntityIDL.IRON_PIG, EntityIronPig.class, EntityIronPig::new, 0xC0C0C0, 0x808080);
        entity.registerEntity(EntityIDL.IRON_COW, EntityIronCow.class, EntityIronCow::new, 0xC0C0C0, 0x808080);
        entity.registerEntity(EntityIDL.IRON_RAM, EntityIronRam.class, EntityIronRam::new, 0xC0C0C0, 0x808080);
        entity.registerEntity(EntityIDL.PURE_IRON_GOLEM, EntityPureIronGolem.class, EntityPureIronGolem::new, 0xF0F0F0, 0xC0C0C0);
        entity.registerEntity(EntityIDL.IRON_SPIDER, EntityIronSpider.class, EntityIronSpider::new, 0xC0C0C0, 0x900000);
        entity.registerEntity(EntityIDL.IRON_ZOMBIE, EntityIronZombie.class, EntityIronZombie::new, 0x808080, 0xFFFFFF);
        entity.registerEntity(EntityIDL.RADIOACTIVE_IRON_GOLEM, EntityRadioactiveIronGolem.class, EntityRadioactiveIronGolem::new, 0x408000, 0xC0FF00);
        entity.registerEntity(EntityIDL.RADIOACTIVE_IRON_SKELETON, EntityRadioactiveIronSkeleton.class, EntityRadioactiveIronSkeleton::new, 0x808000, 0xFFFF00);
        entity.registerEntity(EntityIDL.RADIOACTIVE_IRON_SPIDER, EntityRadioactiveIronSpider.class, EntityRadioactiveIronSpider::new, 0x909000, 0x900000);
        entity.registerEntity(EntityIDL.RADIOACTIVE_IRON_ZOMBIE, EntityRadioactiveIronZombie.class, EntityRadioactiveIronZombie::new, 0xd0d000, 0xFFFF00);
        entity.registerEntity(EntityIDL.RUSTY_SKELETON, EntityRustySkeleton.class, EntityRustySkeleton::new, 0x783720, 0xa26a57);
    }

    public static class EntityRegistryHelper {
        private final IForgeRegistry<EntityEntry> registry;

        private int id = 0;

        EntityRegistryHelper(IForgeRegistry<EntityEntry> registry) {
            this.registry = registry;
        }

        private static String toString(ResourceLocation name) {
            return name.getNamespace() + "." + name.getPath();
        }

        final <T extends Entity> EntityEntryBuilder<T> builder(ResourceLocation regName, Class<T> entity, Function<World, T> factory) {
            return EntityEntryBuilder.<T>create().id(regName, id++).name(toString(regName)).entity(entity).factory(factory);
        }

        final <T extends Entity> void registerEntity(ResourceLocation regName, Class<T> entity, Function<World, T> factory, int backgroundEggColour, int foregroundEggColour) {
            registerEntity(regName, entity, factory, backgroundEggColour, foregroundEggColour, 80, 3, true);
        }

        final <T extends Entity> void registerEntity(ResourceLocation regName, Class<T> entity, Function<World, T> factory, int backgroundEggColour, int foregroundEggColour, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
            registry.register(builder(regName, entity, factory).tracker(trackingRange, updateFrequency, sendsVelocityUpdates).egg(backgroundEggColour, foregroundEggColour).build());
        }
    }
}
