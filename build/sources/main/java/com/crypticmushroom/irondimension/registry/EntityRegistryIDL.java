package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.entities.EntityIronCow;
import com.crypticmushroom.irondimension.entities.EntityIronPig;
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

        entity.registerEntity(EntityIDL.IRON_PIG, EntityIronPig.class, EntityIronPig::new, 0xc0c0c0, 0x808080);
        entity.registerEntity(EntityIDL.IRON_COW, EntityIronCow.class, EntityIronCow::new, 0xc0c0c0, 0x808080);
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
