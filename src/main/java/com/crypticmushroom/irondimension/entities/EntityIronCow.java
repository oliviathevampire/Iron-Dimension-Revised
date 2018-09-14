package com.crypticmushroom.irondimension.entities;

import com.crypticmushroom.irondimension.registry.BiomeIDL;
import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityIronCow extends EntityCow {

    public EntityIronCow(World world) {
        super(world);
        this.setSize(0.9F, 1.4F);
    }

    @Override
    public EntityCow createChild(EntityAgeable entityanimal) {
        return new EntityIronCow(world);
    }

    @Override
    public boolean getCanSpawnHere() {
        int x = MathHelper.floor(this.posX);
        int y = MathHelper.floor(this.getEntityBoundingBox().minY);
        int z = MathHelper.floor(this.posZ);
        BlockPos blockpos = new BlockPos(x, y, z);
        return this.world.getBlockState(blockpos.down()).getBlock() == BlocksIDL.iron_grass
                && this.world.getLight(blockpos) > 8
                && world.getBiome(new BlockPos(this)) == BiomeIDL.iron_dimension;
    }
}
