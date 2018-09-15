package com.crypticmushroom.irondimension;

import com.crypticmushroom.irondimension.world.BiomeIronDimension;
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
        }
    }
}
