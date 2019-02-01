package com.crypticmushroom.irondimension.mixins;

import com.crypticmushroom.irondimension.blocks.BlockIronPortal;
import com.crypticmushroom.irondimension.registry.BlocksIDL;
import net.minecraft.block.Blocks;
import net.minecraft.block.PortalBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public abstract class MixinEntity {

    @Shadow protected Direction field_6028;

    @Shadow protected Vec3d field_6020;

    @Shadow protected boolean inPortal;

    @Shadow public World world;

    @Shadow protected BlockPos lastPortalPosition;

    @Shadow public double z;

    @Shadow public double x;

    @Shadow public double y;

    @Shadow public abstract int getDefaultPortalCooldown();

    @Shadow public int portalCooldown;

    /**
     * @author arthurbambou
     */
    @Overwrite
    public void setInPortal(BlockPos blockPos_1) {
        if (this.portalCooldown > 0) {
            this.portalCooldown = this.getDefaultPortalCooldown();
        } else {
            if (!this.world.isClient && !blockPos_1.equals(this.lastPortalPosition)) {
                this.lastPortalPosition = new BlockPos(blockPos_1);
                BlockPattern.Result blockPattern$Result_1;
                if (this.world.getBlockState(this.lastPortalPosition).getBlock() == BlocksIDL.iron_dim_portal) {
                    blockPattern$Result_1 = ((BlockIronPortal) BlocksIDL.iron_dim_portal).method_10350(this.world, this.lastPortalPosition);
                } else {
                    blockPattern$Result_1 = ((PortalBlock) Blocks.NETHER_PORTAL).method_10350(this.world, this.lastPortalPosition);
                }
                double double_1 = blockPattern$Result_1.getForwards().getAxis() == Direction.Axis.X ? (double)blockPattern$Result_1.getFrontTopLeft().getZ() : (double)blockPattern$Result_1.getFrontTopLeft().getX();
                double double_2 = blockPattern$Result_1.getForwards().getAxis() == Direction.Axis.X ? this.z : this.x;
                double_2 = Math.abs(MathHelper.method_15370(double_2 - (double)(blockPattern$Result_1.getForwards().rotateYClockwise().getDirection() == Direction.AxisDirection.NEGATIVE ? 1 : 0), double_1, double_1 - (double)blockPattern$Result_1.getWidth()));
                double double_3 = MathHelper.method_15370(this.y - 1.0D, (double)blockPattern$Result_1.getFrontTopLeft().getY(), (double)(blockPattern$Result_1.getFrontTopLeft().getY() - blockPattern$Result_1.getHeight()));
                this.field_6020 = new Vec3d(double_2, double_3, 0.0D);
                this.field_6028 = blockPattern$Result_1.getForwards();
            }

            this.inPortal = true;
        }
    }
}
