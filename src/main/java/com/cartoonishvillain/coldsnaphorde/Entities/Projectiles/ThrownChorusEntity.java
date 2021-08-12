package com.cartoonishvillain.coldsnaphorde.Entities.Projectiles;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import static com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember.Infection;

public class ThrownChorusEntity extends ProjectileItemEntity {



    public ThrownChorusEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn, LivingEntity entity) {
        super(type, entity, worldIn);
    }

    public ThrownChorusEntity(EntityType<ThrownChorusEntity> gunnerProjectileEntityEntityType, World world) {
        super(gunnerProjectileEntityEntityType, world);
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack itemstack = this.func_213882_k();
        return new ItemParticleData(ParticleTypes.ITEM, itemstack);
    }

    @Override
    protected Item getDefaultItem() {return Items.CHORUS_FRUIT;}

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return new ItemStack(Items.CHORUS_FRUIT);
    }

    @Override
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 1;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), (float)i);
        int chance = rand.nextInt(20);
        if(this.getShooter() instanceof GenericHordeMember && entity instanceof LivingEntity && !this.world.isRemote()){
            GenericHordeMember member = (GenericHordeMember) this.getShooter();
            switch(member.getHordeVariant()){
                case 0:
                    if(chance <= 2)  {((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 5*20, 0));
                        if(chance == 1) ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 5*20, 0));}
                break;
                case 1:
                    int chance2 = rand.nextInt(100);
                    if (chance2 <= 75) {
                        ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*5, 1));
                    }
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
        else if (chance <= 2 && entity instanceof LivingEntity && !this.world.isRemote()){((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 5*20, 0));
            if (chance == 1) ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 5*20, 0));}
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        BlockState blockstate = Blocks.SNOW_BLOCK.getDefaultState();
        int snowchance = rand.nextInt(20);
        BlockPos blockpos = new BlockPos(result.getHitVec());
        if (this.world.isAirBlock(blockpos) && this.world.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.isValidPosition(this.world, blockpos) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) && snowchance == 1 && !world.isRemote()) {
            this.world.setBlockState(blockpos, blockstate);
        }
        this.remove();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
