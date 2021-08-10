package com.cartoonishvillain.coldsnaphorde.Entities.Projectiles;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember;
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

import static com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember.Infection;

public class GunnerProjectileEntity extends ProjectileItemEntity {



    public GunnerProjectileEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn, LivingEntity entity) {
        super(type, entity, worldIn);
    }

    public GunnerProjectileEntity(EntityType<GunnerProjectileEntity> gunnerProjectileEntityEntityType, World world) {
        super(gunnerProjectileEntityEntityType, world);
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack itemstack = this.func_213882_k();
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
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = 1 + world.getDifficulty().getId();
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), (float)i);
        int chance = rand.nextInt(20);
        if(this.getShooter() instanceof GenericHordeMember && entity instanceof LivingEntity && !this.world.isRemote()){
            GenericHordeMember member = (GenericHordeMember) this.getShooter();
            switch(member.getHordeVariant()){
                case 0 :
                    if(chance <= 3)  {((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 10*20, 0));}
                break;
                case 1:
                    int chance2 = rand.nextInt(100);
                    if (chance2 <= 75){entity.setFire(3);}
                    break;
                case 2:
                    int chance3 = rand.nextInt(20);
                    if(chance3 <= 2) ((LivingEntity) entity).attemptTeleport(entity.getPosX() + rand.nextInt(5+5)-5,entity.getPosY() + rand.nextInt(5+5)-5,entity.getPosZ() + rand.nextInt(5+5)-5, true);
                    else if(chance3 <=4) member.attemptTeleport(this.getPosX() + rand.nextInt(5+5)-5,this.getPosY() + rand.nextInt(5+5)-5,this.getPosZ() + rand.nextInt(5+5)-5, true);
                break;
                case 3:
                    Infection((LivingEntity) entity);
                    break;
            }
        }
        else if (entity instanceof LivingEntity && chance <= 3 && !this.world.isRemote()){((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 10*20, 0));}
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        this.remove();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
