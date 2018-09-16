package com.crypticmushroom.irondimension;

import com.crypticmushroom.irondimension.proxy.CommonProxy;
import com.crypticmushroom.irondimension.registry.BlocksIDL;
import com.crypticmushroom.irondimension.registry.ConfigIDL;
import com.crypticmushroom.irondimension.registry.ItemsIDL;
import com.crypticmushroom.irondimension.world.WorldProviderIronDim;
import net.minecraft.init.Blocks;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = IronDimension.MODID,
        name = IronDimension.NAME,
        version = IronDimension.VERSION)

public class IronDimension {
    public static final String MODID = "irondimension";
    public static final String NAME = "Iron Dimension";
    public static final String VERSION = "1.0";

    public static final BlocksIDL blocks = new BlocksIDL();
    public static final ItemsIDL items = new ItemsIDL();
    public static final String ARMOR_DIR = "irondimension:textures/armor/";
    public static final String MODEL_DIR = "irondimension:textures/entity/";
    public static DimensionType dimType;

    private static Logger logger = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "com.crypticmushroom.irondimension.proxy.ClientProxy", serverSide = "com.crypticmushroom.irondimension.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        dimType = DimensionType.register("Iron Dimension", "_irondim", ConfigIDL.dimension.dimensionID, WorldProviderIronDim.class, false);

        proxy.doPreLoadRegistration();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        MinecraftForge.TERRAIN_GEN_BUS.register(new EventHandlerTerrainIDL());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (!DimensionManager.isDimensionRegistered(ConfigIDL.dimension.dimensionID)) {
            DimensionManager.registerDimension(ConfigIDL.dimension.dimensionID, IronDimension.dimType);
        } else {
            IronDimension.logger.error("Woah there, you've got a conflict between Iron Dimension and another dimension's ID! You will need to change the ID of either one of these dimensions via Config.");
        }
    }
}
