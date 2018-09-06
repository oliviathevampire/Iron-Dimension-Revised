package com.crypticmushroom.irondimension.registry;

import com.crypticmushroom.irondimension.IronDimension;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = IronDimension.MODID)
@Mod.EventBusSubscriber(modid = IronDimension.MODID)
public class ConfigIDL {

    @Config.Ignore
    private final static String config = IronDimension.MODID + ".config.";

    @Config.LangKey(config + "dimension")
    @Config.Comment("A restart is required if changes are made here.")
    public static Dimension dimension = new Dimension();

    public static class Dimension {
        @Config.LangKey(config + "dimension_id")
        @Config.RequiresMcRestart
        @Config.Comment("Changes the Iron Dimension's ID to whatever is specified here. Changing the ID should only be done if conflicts are present, and may cause some unwarranted side effects.")
        public int dimensionID = -12;
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(IronDimension.MODID));
        ConfigManager.sync(IronDimension.MODID, Config.Type.INSTANCE);
    }
}
