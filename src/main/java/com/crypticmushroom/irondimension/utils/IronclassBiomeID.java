package com.crypticmushroom.irondimension.utils;

import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.minecraft.class_3630;
import net.minecraft.class_3663;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.core.Logger;

import java.util.Random;

public enum IronclassBiomeID implements class_3663 {
    INSTANCE;

    public final static int IRON_PLAINS_ID = Registry.BIOME.getRawId(WorldIronDimension.IRON_PLAINS);
    public final static int IRON_HIGHLAND_ID = Registry.BIOME.getRawId(WorldIronDimension.IRON_HIGHLANDS);

    @Override
    public int sample(class_3630 var1, int var2, int var3, int var4, int var5, int var6) {
        int random = new Random().nextInt(var2);
        int random2 = new Random().nextInt(var3);
        int random3 = new Random().nextInt(var4);
        int random4 = new Random().nextInt(var5);
        int random5 = new Random().nextInt(var6);
        int number = random + random2 + random3 + random4 + random5;
        return number;
    }
}
