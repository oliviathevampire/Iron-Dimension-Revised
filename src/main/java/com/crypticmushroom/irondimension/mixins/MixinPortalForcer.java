package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.utils.portal.PlayerPlacementHandler;
import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.minecraft.entity.Entity;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PortalForcer;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PortalForcer.class)
public class MixinPortalForcer {

    @Shadow
    @Final
    private ServerWorld world;

    @Inject(method = "method_8653", at = @At("HEAD"), cancellable = true)
    public void method_8653(Entity entity, float float_1, CallbackInfoReturnable<Boolean> infoReturnable) {
        //If going to the void world
        if(world.getDimension().getType() == WorldIronDimension.IRON_DIMENSION){
            PlayerPlacementHandler.enterIron(entity, (ServerWorld) entity.getEntityWorld(), world);
            infoReturnable.setReturnValue(true);
            infoReturnable.cancel();
        }

        //Coming from the void world
        if(entity.getEntityWorld().getDimension().getType() == WorldIronDimension.IRON_DIMENSION){
            PlayerPlacementHandler.leaveIron(entity, (ServerWorld) entity.getEntityWorld(), world);
            infoReturnable.setReturnValue(true);
            infoReturnable.cancel();
        }
    }

}