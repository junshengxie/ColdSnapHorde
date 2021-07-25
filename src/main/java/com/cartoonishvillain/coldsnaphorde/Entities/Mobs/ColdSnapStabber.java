package com.cartoonishvillain.coldsnaphorde.Entities.Mobs;

import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;


import javax.annotation.Nullable;

public class ColdSnapStabber extends GenericHordeMember {
    private static final DataParameter<Float> ANITIMER = EntityDataManager.defineId(ColdSnapStabber.class, DataSerializers.FLOAT);
//    private AnimationFactory factory = new AnimationFactory(this);

    public ColdSnapStabber(EntityType<? extends MonsterEntity> type, World worldIn) { super(type, worldIn);}

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.targetSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1D, false));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.5F));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, 10, true, false, this::shouldAttack));

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(ANITIMER, 0f);
    }

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 2D);
    }

    public boolean shouldAttack(@Nullable LivingEntity entity){
//        if (entity == null || entity.getItemBySlot(EquipmentSlotType.HEAD).getItem().equals(Register.TOPHAT.get().getItem())){
//            return false;
//        }else
            return true;
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if (entityIn instanceof LivingEntity && !this.level.isClientSide()){
            int chance = random.nextInt(100);
            if (chance <= 6){((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.CONFUSION, 10*20, 0));}

            this.getEntityData().set(ANITIMER, 50f);
        }
        return super.doHurtTarget(entityIn);
    }

    public void aiStep() {
        super.aiStep();
        if(!this.level.isClientSide()){
        float timer = getEntityData().get(ANITIMER);
        if (timer > -1) this.getEntityData().set(ANITIMER, timer -= 1f);
    }
    }

    //Old geckolib dependency stuff
//    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
//        if(getEntityData().get(ANITIMER) > 0){
//            event.getController().setAnimation(new AnimationBuilder().addAnimation("stab", true));
//            return PlayState.CONTINUE; }
//            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
//            return PlayState.CONTINUE;
//    }
//
//    @Override
//    public void registerControllers(AnimationData animationData) {
//        animationData.addAnimationController(new AnimationController(this, "controller", 10, this::predicate));
//    }
//
//    @Override
//    public AnimationFactory getFactory() {
//        return this.factory;
//    }
}
