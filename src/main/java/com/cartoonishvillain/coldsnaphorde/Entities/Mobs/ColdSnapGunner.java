package com.cartoonishvillain.coldsnaphorde.Entities.Mobs;

import com.cartoonishvillain.coldsnaphorde.Entities.Projectiles.GunnerProjectileEntity;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ColdSnapGunner extends GenericHordeMember implements IRangedAttackMob {
    public ColdSnapGunner(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.targetSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(3, new RangedBowAttackGoal<>(this, 0.75D, 30, 25.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, 10, true, false, this::shouldAttack));
    }

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 2D);
    }

    public boolean shouldAttack(@Nullable LivingEntity entity){
//        if (entity == null || entity.getItemBySlot(EquipmentSlotType.HEAD).getItem().equals(Register.TOPHAT.get().getItem()) || (entity instanceof PlayerEntity && ((PlayerEntity) entity).isCreative())){
//            return false;
//        }
        return true;
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
        return spawnDataIn;
    }

    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        GunnerProjectileEntity snowballentity = new GunnerProjectileEntity(Register.GUNNERPROJECTILE.get(), this.level, this);
        double d0 = target.getEyeY() - (double)1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - snowballentity.getY();
        double d3 = target.getZ() - this.getZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        snowballentity.shoot(d1, d2 + (double)f, d3, 1.6F, 3.0F);
        this.playSound(SoundEvents.GENERIC_EXPLODE, 0.5F, 3.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(snowballentity);
    }

    public void aiStep() {
        super.aiStep();
    }

}
