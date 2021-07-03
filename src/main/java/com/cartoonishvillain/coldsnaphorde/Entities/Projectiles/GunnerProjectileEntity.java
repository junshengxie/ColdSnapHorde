package com.cartoonishvillain.coldsnaphorde.Entities.Projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class GunnerProjectileEntity extends ProjectileItemEntity {



    public GunnerProjectileEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn, LivingEntity entity) {
        super(type, entity, worldIn);
    }

    public GunnerProjectileEntity(EntityType<GunnerProjectileEntity> gunnerProjectileEntityEntityType, World world) {
        super(gunnerProjectileEntityEntityType, world);
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack itemstack = this.getItemRaw();
        return new ItemParticleData(ParticleTypes.ITEM, itemstack);
    }

    @Override
    protected Item getDefaultItem() {return Items.COAL;}

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return new ItemStack(Items.COAL);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = 1 + level.getDifficulty().getId();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
        int chance = random.nextInt(20);
        if (entity instanceof LivingEntity && chance <= 3 && !this.level.isClientSide()){((LivingEntity) entity).addEffect(new EffectInstance(Effects.BLINDNESS, 10*20, 0));}
    }

    @Override
    protected void onHit(RayTraceResult result) {
        super.onHit(result);
        this.remove();
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
