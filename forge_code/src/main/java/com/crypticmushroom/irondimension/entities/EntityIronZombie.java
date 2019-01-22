package com.crypticmushroom.irondimension.entities;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityIronZombie extends EntityZombie {

    public static final ResourceLocation LOOT_TABLE = new ResourceLocation(IronDimension.MODID, "iron_zombie");

    public EntityIronZombie(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 0.9F);
    }

    @Override
    public ResourceLocation getLootTable() {
        return LOOT_TABLE;
    }
}
