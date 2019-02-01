package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.player.PlayerIron;
import com.crypticmushroom.irondimension.utils.player.IEntityPlayerIron;
import com.crypticmushroom.irondimension.utils.player.IPlayerIron;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity implements IEntityPlayerIron {
    private PlayerIron playerIron;

    protected MixinPlayerEntity(EntityType<?> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    public void playerInit(CallbackInfo ci)
    {
        this.playerIron = new PlayerIron((PlayerEntity) (Object) this);
    }

    @Override
    public PlayerIron getPlayerIron()
    {
        return this.playerIron;
    }

    @Override
    public Entity getInstance()
    {
        return (PlayerEntity) (Object) this;
    }

    @Inject(method = "update", at = @At("RETURN"))
    public void playerUpdate(CallbackInfo ci)
    {
        this.playerIron.tick();
    }
}
