package com.cartoonishvillain.coldsnaphorde.Entities.Projectiles;

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

public class RockSnowballEntity extends ProjectileItemEntity {



    public RockSnowballEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn, LivingEntity entity) {
        super(type, entity, worldIn);
    }

    public RockSnowballEntity(EntityType<RockSnowballEntity> gunnerProjectileEntityEntityType, World world) {
        super(gunnerProjectileEntityEntityType, world);
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack itemstack = this.getItemRaw();
        return new ItemParticleData(ParticleTypes.ITEM, itemstack);
    }

    @Override
    protected Item getDefaultItem() {return Register.ROCKYSNOWBALL.get();}

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        return new ItemStack(Register.ROCKYSNOWBALL.get());
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 1;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
        int chance = random.nextInt(20);
        if (chance <= 2 && entity instanceof LivingEntity && !this.level.isClientSide()){((LivingEntity) entity).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 5*20, 0));
            if (chance == 1) ((LivingEntity) entity).addEffect(new EffectInstance(Effects.WEAKNESS, 5*20, 0));}
    }

    @Override
    protected void onHit(RayTraceResult result) {
        super.onHit(result);
        BlockState blockstate = Blocks.SNOW_BLOCK.defaultBlockState();
        int snowchance = random.nextInt(20);
        BlockPos blockpos = new BlockPos(result.getLocation());
        if (this.level.isEmptyBlock(blockpos) && this.level.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.canSurvive(this.level, blockpos) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) && snowchance == 1 && !level.isClientSide()) {
            this.level.setBlockAndUpdate(blockpos, blockstate);
        }
        this.remove();
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
