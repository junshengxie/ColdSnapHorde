package com.jedijoe.coldsnaphorde.Entities;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Register;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ColdSnapGunner extends MonsterEntity implements IRangedAttackMob {
    public ColdSnapGunner(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.targetSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new RangedBowAttackGoal<>(this, 0.75D, 30, 25.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, 10, true, false, this::shouldAttack));
    }

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2D);
    }

    public boolean shouldAttack(@Nullable LivingEntity entity){
        if (entity == null || entity.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(Register.TOPHAT.get().getItem())){
            return false;
        }else return true;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
        return spawnDataIn;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SNOW_GOLEM_AMBIENT;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SNOW_GOLEM_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SNOW_GOLEM_DEATH;
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        GunnerProjectileEntity snowballentity = new GunnerProjectileEntity(Register.GUNNERPROJECTILE.get(), this.world, this);
        double d0 = target.getPosYEye() - (double)1.1F;
        double d1 = target.getPosX() - this.getPosX();
        double d2 = d0 - snowballentity.getPosY();
        double d3 = target.getPosZ() - this.getPosZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        snowballentity.shoot(d1, d2 + (double)f, d3, 1.6F, 3.0F);
        this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 3.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(snowballentity);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {}

    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote) {
            int i = MathHelper.floor(this.getPosX());
            int j = MathHelper.floor(this.getPosY());
            int k = MathHelper.floor(this.getPosZ());
            if (shouldOverHeat(this.world.getBiome(this.getPosition()).getTemperature(), ColdSnapHorde.cconfig.HEATPROT.get())) {
                this.attackEntityFrom(DamageSource.ON_FIRE, 1.0F);
            }

            if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
                return;
            }

            BlockState blockstate = Blocks.SNOW.getDefaultState();

            for(int l = 0; l < 4; ++l) {
                i = MathHelper.floor(this.getPosX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = MathHelper.floor(this.getPosY());
                k = MathHelper.floor(this.getPosZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockpos = new BlockPos(i, j, k);
                if (this.world.isAirBlock(blockpos) && !shouldOverHeat(this.world.getBiome(this.getPosition()).getTemperature(), ColdSnapHorde.cconfig.SNOWTRAIL.get()) && blockstate.isValidPosition(this.world, blockpos)) {
                    this.world.setBlockState(blockpos, blockstate);
                }
            }
        }
    }

    protected boolean shouldOverHeat(float currentTemp, int protectionlevel){
        switch(protectionlevel){
            case 0:
                return currentTemp > 0.3f;
            case 1:
                return currentTemp > 0.9f;
            case 2:
                return currentTemp > 1.5f;
            case 3:
                return false;
            default:
                return true;
        }
    }
}
