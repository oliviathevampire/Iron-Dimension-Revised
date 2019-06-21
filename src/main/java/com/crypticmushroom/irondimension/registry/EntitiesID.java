package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.entities.entity.IronBisonEntity;

import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * EntitiesID
 */
public class EntitiesID {

    public static EntityType<Entity> IRONBISON;

    public static void init() {
        IRONBISON = (EntityType)Registry.register(Registry.ENTITY_TYPE, new Identifier(IronDimension.MODID, "iron_bison"), FabricEntityTypeBuilder.create(EntityCategory.AMBIENT, IronBisonEntity::new).size(0.9F, 1.4F).build());
        ItemsID.iron_bison_spawn_egg = register("iron_bison_spawn_egg", new SpawnEggItem(EntitiesID.IRONBISON, 4470310, 10592673, new Item.Settings().group(IronDimension.IDL_ITEM_GROUP)));
    }

    private static Item register(String name, Item item) {
        Registry.register(Registry.ITEM, IronDimension.MODID + ":" + name, item);
        return item;
    }
}