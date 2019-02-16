package com.crypticmushroom.irondimension.utils.materials;


import com.crypticmushroom.irondimension.registry.ItemsID;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ArmorMaterial implements net.minecraft.item.ArmorMaterial {
    SUPER_IRON("super_iron", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, () -> {
        return Ingredient.ofItems(ItemsID.super_iron_ingot);
    }),
    INFERNAL("infernal", 1, new int[]{1, 1, 1, 1}, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, () -> {
        return Ingredient.ofItems(ItemsID.infernal_iron_ingot);
    }),
    RADIOACTIVE("radioactive", 44, new int[]{4, 7, 9, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
        return Ingredient.ofItems(ItemsID.radioactive_iron_ingot);
    });
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final Lazy<Ingredient> repairIngredientSupplier;
    private ArmorMaterial(String string_1, int int_1, int[] ints_1, int int_2, SoundEvent soundEvent_1, float float_1, Supplier<Ingredient> supplier_1) {
        this.name = string_1;
        this.durabilityMultiplier = int_1;
        this.protectionAmounts = ints_1;
        this.enchantability = int_2;
        this.equipSound = soundEvent_1;
        this.toughness = float_1;
        this.repairIngredientSupplier = new Lazy(supplier_1);
    }

    @Override
    public int getDurability(EquipmentSlot var1) {
        return BASE_DURABILITY[var1.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot var1) {
        return this.protectionAmounts[var1.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
