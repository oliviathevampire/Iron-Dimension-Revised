package com.crypticmushroom.irondimension.player;

import com.crypticmushroom.irondimension.utils.player.IPlayerIron;
import com.crypticmushroom.irondimension.utils.portal.IronTeleportation;
import com.crypticmushroom.irondimension.world.TeleporterIron;
import com.crypticmushroom.irondimension.world.WorldIronDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.dimension.DimensionType;

public class PlayerIron implements IPlayerIron {
    private PlayerEntity playerEntity;

    public float prevPortalAnimTime, portalAnimTime;

    public int timeInPortal;

    public boolean hasTeleported = false, inPortal = false;

    public PlayerIron(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public void tick()
    {
        if (this.getPlayerEntity().dimension == WorldIronDimension.IRON_DIMENSION && this.getPlayerEntity().y <= -10.0F)
        {
            this.teleportPlayer(false);
        }

        if (this.getPlayerEntity().world.isClient)
        {
            this.prevPortalAnimTime = this.portalAnimTime;

            if (this.inPortal)
            {
                this.portalAnimTime += 0.0125F;
                this.inPortal = false;
            }
            else
            {
                if (this.portalAnimTime > 0.0F)
                {
                    this.portalAnimTime -= 0.05F;
                }

                if (this.portalAnimTime < 0.0F)
                {
                    this.portalAnimTime = 0.0F;
                }
            }
        }
        else
        {
            if (this.inPortal && this.playerEntity.portalCooldown <= 0)
            {
                int limit = 80;

                if (this.timeInPortal++ >= limit)
                {
                    this.timeInPortal = limit;
                    this.playerEntity.portalCooldown = this.playerEntity.getDefaultPortalCooldown();
                    this.teleportPlayer(true);
                }

                this.inPortal = false;
            }
            else
            {
                if (this.timeInPortal > 0)
                {
                    this.timeInPortal -= 4;
                }

                if (this.timeInPortal < 0)
                {
                    this.timeInPortal = 0;
                }

                if (this.playerEntity.portalCooldown > 0)
                {
                    --this.playerEntity.portalCooldown;
                }
            }
        }
    }

    private void teleportPlayer(boolean shouldSpawnPortal)
    {
        if (!this.playerEntity.world.isClient)
        {
            MinecraftServer server = this.playerEntity.getServer();
            DimensionType dimensionToTravel = this.playerEntity.dimension == WorldIronDimension.IRON_DIMENSION ? DimensionType.OVERWORLD : WorldIronDimension.IRON_DIMENSION;

            if (server != null)
            {
                IronTeleportation.instance().teleportPlayer((ServerPlayerEntity) this.playerEntity, dimensionToTravel, new TeleporterIron(shouldSpawnPortal, server.getWorld(dimensionToTravel)));
            }
        }
    }

    @Override
    public void setInPortal()
    {
        if (this.playerEntity.portalCooldown > 0)
        {
            this.playerEntity.portalCooldown = this.playerEntity.getDefaultPortalCooldown();
        }
        else
        {
            this.inPortal = true;
        }
    }

    @Override
    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }
}
