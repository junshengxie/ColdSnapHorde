package com.villain.coldsnaphorde.entities.projectiles;

import com.villain.coldsnaphorde.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

public class LightningSnowEntity extends ThrowableItemProjectile {

    public LightningSnowEntity(EntityType<? extends ThrowableItemProjectile> type, Level worldIn, LivingEntity livingEntityIn) {
        super(type, livingEntityIn, worldIn);
    }

    public LightningSnowEntity(EntityType<LightningSnowEntity> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() { return new ItemStack(Register.LIGHTNINGSNOWBALL.get()); }

    @Override
    protected Item getDefaultItem() {
        {return Register.LIGHTNINGSNOWBALL.get();}
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if(!this.level.isClientSide()){
        EntityType.LIGHTNING_BOLT.spawn((ServerLevel) this.getCommandSenderWorld(), new ItemStack(Items.AIR), null, new BlockPos(result.getLocation()), MobSpawnType.TRIGGERED, true, false);}
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
