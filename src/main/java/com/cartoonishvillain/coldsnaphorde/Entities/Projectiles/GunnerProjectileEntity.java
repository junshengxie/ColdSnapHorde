package com.cartoonishvillain.coldsnaphorde.Entities.Projectiles;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
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

import static com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember.Infection;

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
        if(this.getOwner() instanceof GenericHordeMember && entity instanceof LivingEntity && !this.level.isClientSide()){
            GenericHordeMember member = (GenericHordeMember) this.getOwner();
            switch(member.getHordeVariant()){
                case 0 :
                    if(chance <= 3)  {((LivingEntity) entity).addEffect(new EffectInstance(Effects.BLINDNESS, 10*20, 0));}
                break;
                case 1:
                    int chance2 = random.nextInt(100);
                    if (chance2 <= 75) {
                        ((LivingEntity) entity).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*5, 1));
                    }
                    break;
                case 2:
                    int chance3 = random.nextInt(20);
                    if(chance3 <= 2) ((LivingEntity) entity).randomTeleport(entity.getX() + random.nextInt(5+5)-5,entity.getY() + random.nextInt(5+5)-5,entity.getZ() + random.nextInt(5+5)-5, true);
                    else if(chance3 <=4) member.randomTeleport(this.getX() + random.nextInt(5+5)-5,this.getY() + random.nextInt(5+5)-5,this.getZ() + random.nextInt(5+5)-5, true);
                break;
                case 3:
                    Infection((LivingEntity) entity);
                    break;
            }
        }
        else if (entity instanceof LivingEntity && chance <= 3 && !this.level.isClientSide()){((LivingEntity) entity).addEffect(new EffectInstance(Effects.BLINDNESS, 10*20, 0));}
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
