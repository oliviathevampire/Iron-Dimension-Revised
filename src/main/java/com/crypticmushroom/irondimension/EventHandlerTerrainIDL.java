package com.crypticmushroom.irondimension;

import com.crypticmushroom.irondimension.world.biomes.BiomeIronDimension;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerTerrainIDL {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onDecorate(DecorateBiomeEvent.Decorate e) {
        DecorateBiomeEvent.Decorate.EventType event_type = e.getType();

        if (e.getWorld().getBiome(e.getPos()) instanceof BiomeIronDimension) {
            if (event_type == DecorateBiomeEvent.Decorate.EventType.REED || event_type == DecorateBiomeEvent.Decorate.EventType.SHROOM) {
                e.setResult(Event.Result.DENY);
            }

            if (event_type == DecorateBiomeEvent.Decorate.EventType.LAKE_WATER) {
                for (int i = 0; i < 10; ++i) {
                    int posX = e.getRand().nextInt(16) + 8;
                    int posz = e.getRand().nextInt(16) + 8;
                    int randY = e.getRand().nextInt(248) + 8;

                    if (randY > 0) {
                        int posY = e.getRand().nextInt(randY);
                        BlockPos position = e.getPos().add(posX, posY, posz);
                        (new WorldGenLiquids(Blocks.FLOWING_WATER)).generate(e.getWorld(), e.getRand(), position);
                    }
                }
            }
        }
    }
}
