package com.cartoonishvillain.coldsnaphorde.Entities.Projectiles;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class GunnerProjectileEntity extends ThrowableItemProjectile {



    public GunnerProjectileEntity(EntityType<? extends ThrowableItemProjectile> type, Level worldIn, LivingEntity entity) {
        super(type, entity, worldIn);
    }

    public GunnerProjectileEntity(EntityType<GunnerProjectileEntity> gunnerProjectileEntityEntityType, Level world) {
        super(gunnerProjectileEntityEntityType, world);
    }

    @OnlyIn(Dist.CLIENT)
    private ParticleOptions makeParticle() {
        ItemStack itemstack = this.getItemRaw();
        return new ItemParticleOption(ParticleTypes.ITEM, itemstack);
    }

    @Override
    protected Item getDefaultItem() {return Items.COAL;}

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return new ItemStack(Items.COAL);
    }

    @Override
    protected void onHitEntity(EntityHitResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = 1 + level.getDifficulty().getId();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
        int chance = random.nextInt(20);
        if (entity instanceof LivingEntity && chance <= 3 && !this.level.isClientSide()){((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10*20, 0));}
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        this.remove(false);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
