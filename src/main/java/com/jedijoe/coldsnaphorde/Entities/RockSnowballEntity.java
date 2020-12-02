package com.jedijoe.coldsnaphorde.Entities;

import com.jedijoe.coldsnaphorde.Register;
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
        ItemStack itemstack = this.func_213882_k();
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
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 1;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
        int chance = rand.nextInt(20);
        if (chance <= 2 && entity instanceof LivingEntity && !this.world.isRemote()){((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 5*20, 0));
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
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
