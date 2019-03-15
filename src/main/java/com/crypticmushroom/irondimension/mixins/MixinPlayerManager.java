package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.utils.portal.PlayerPlacementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class MixinPlayerManager {

    @Inject(method = "method_14606", at = @At(value = "HEAD"), cancellable = true)
    public void method_14606(ServerPlayerEntity entity, ServerWorld serverWorld_1, CallbackInfo info) {
            if (PlayerPlacementHandler.placeInPortal(entity, entity.getServerWorld(), serverWorld_1)) {

                serverWorld_1.spawnEntity(entity);
//                serverWorld_1.method_8553(entity);
                entity.setWorld(serverWorld_1);

                info.cancel();
            }

    }

}