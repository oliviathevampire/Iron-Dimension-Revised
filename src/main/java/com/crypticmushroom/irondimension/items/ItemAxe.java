package com.crypticmushroom.irondimension.items;

import com.crypticmushroom.irondimension.IronDimension;
import com.crypticmushroom.irondimension.registry.BlocksID;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.function.Consumer;

public class ItemAxe extends AxeItem {
    protected static final Map<Block, Block> BLOCK_TRANSFORMATIONS_MAP;
    public ItemAxe(ToolMaterial toolMaterial_1, float float_1) {
        super(toolMaterial_1, float_1, -3.2F, new Item.Settings().group(IronDimension.IDL_ITEM_GROUP).maxCount(1));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        World world_1 = itemUsageContext_1.getWorld();
        BlockPos blockPos_1 = itemUsageContext_1.getBlockPos();
        BlockState blockState_1 = world_1.getBlockState(blockPos_1);
        Block block_1 = BLOCK_TRANSFORMATIONS_MAP.get(blockState_1.getBlock());
        if (block_1 != null) {
            PlayerEntity playerEntity_1 = itemUsageContext_1.getPlayer();
            world_1.playSound(playerEntity_1, blockPos_1, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world_1.isClient) {
                world_1.setBlockState(blockPos_1, block_1.getDefaultState().with(PillarBlock.AXIS, blockState_1.get(PillarBlock.AXIS)), 11);
                if (playerEntity_1 != null) {
                    itemUsageContext_1.getStack().damage(1, playerEntity_1, (Consumer<LivingEntity>)
                            ((playerEntity_1x) -> playerEntity_1x.sendToolBreakStatus(itemUsageContext_1.getHand())));
                }
            }

            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    static {
            BLOCK_TRANSFORMATIONS_MAP = (new ImmutableMap.Builder())
                    .put(BlocksID.hornbeam_log, BlocksID.stripped_hornbeam_log)
                    .put(BlocksID.ironwood_log, BlocksID.stripped_ironwood_log)
                    .put(BlocksID.rusty_ironwood_log, BlocksID.stripped_rusty_ironwood_log).build();
        }
}
