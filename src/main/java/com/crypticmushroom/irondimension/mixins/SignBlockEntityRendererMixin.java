package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.registry.BlocksID;
import net.minecraft.block.Block;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignBlockEntityRenderer.class)
public class SignBlockEntityRendererMixin {

    private Identifier IRONWOOD = new Identifier(IronDimension.MODID, "textures/entity/signs/ironwood.png");
    private Identifier RUSTY_IRONWOOD = new Identifier(IronDimension.MODID, "textures/entity/signs/rusty_ironwood.png");
    private Identifier HORNBEAM = new Identifier(IronDimension.MODID, "textures/entity/signs/hornbeam.png");

    @Inject(method = "getModelTexture(Lnet/minecraft/block/Block;)Lnet/minecraft/util/Identifier;", at = @At("RETURN"), cancellable = true)
    private void getModelTexture(Block block_1, CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if(block_1 == BlocksID.ironwood_sign || block_1 == BlocksID.ironwood_wall_sign) {
            callbackInfoReturnable.setReturnValue(IRONWOOD);
        } else if(block_1 == BlocksID.rusty_ironwood_sign || block_1 == BlocksID.rusty_ironwood_wall_sign) {
            callbackInfoReturnable.setReturnValue(RUSTY_IRONWOOD);
        } else {
            callbackInfoReturnable.setReturnValue(HORNBEAM);
        }
    }

}