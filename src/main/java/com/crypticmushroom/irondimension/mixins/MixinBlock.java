package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.registry.BlocksID;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Block.class)
public class MixinBlock {

    /**
     * @author arthurbambou (aka. Cat Core)
     */
    @Overwrite
    public static boolean isNaturalDirt(Block block_1) {
        return block_1 == Blocks.DIRT || block_1 == Blocks.COARSE_DIRT || block_1 == Blocks.PODZOL || block_1 == BlocksID.iron_dirt || block_1 == BlocksID.iron_grass;
    }
}
