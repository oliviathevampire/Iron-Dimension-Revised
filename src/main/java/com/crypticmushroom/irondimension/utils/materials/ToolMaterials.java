package com.crypticmushroom.irondimension.utils.materials;

import com.crypticmushroom.irondimension.registry.ItemsID;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ToolMaterials implements ToolMaterial {
    SUPER_IRON(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(ItemsID.super_iron_ingot);
    }),
    INFERNAL(1, 1, 1.0F, 1.0F, 1, () -> {
        return Ingredient.ofItems(ItemsID.infernal_iron_ingot);
    }),
    RADIOACTIVE(3, 2001, 8.5F, 4.0F, 15, () -> {
        return Ingredient.ofItems(ItemsID.radioactive_iron_ingot);
    });

    private final int miningLevel;
    private final int durability;
    private final float blockBreakSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ToolMaterials(int int_1, int int_2, float float_1, float float_2, int int_3, Supplier<Ingredient> supplier_1) {
        this.miningLevel = int_1;
        this.durability = int_2;
        this.blockBreakSpeed = float_1;
        this.attackDamage = float_2;
        this.enchantability = int_3;
        this.repairIngredient = new Lazy(supplier_1);
    }

    public int getDurability() {
        return this.durability;
    }

    public float getBlockBreakingSpeed() {
        return this.blockBreakSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
