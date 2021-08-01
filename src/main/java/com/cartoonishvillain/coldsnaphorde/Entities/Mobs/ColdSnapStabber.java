package com.cartoonishvillain.coldsnaphorde.Entities.Mobs;

import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class ColdSnapStabber extends GenericHordeMember {
    private static final EntityDataAccessor<Float> ANITIMER = SynchedEntityData.defineId(ColdSnapStabber.class, EntityDataSerializers.FLOAT);
//    private AnimationFactory factory = new AnimationFactory(this);

    public ColdSnapStabber(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.5D));
        this.targetSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1D, false));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.5F));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Villager.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SnowGolem.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, IronGolem.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Blaze.class, 10, true, false, this::shouldAttack));

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(ANITIMER, 0f);
    }

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 2D);
    }


    public boolean shouldAttack(@Nullable LivingEntity entity){
        return entity != null && (!entity.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(Register.TOPHAT.get()) || this.isHordeMember());}

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if (entityIn instanceof LivingEntity && !this.level.isClientSide()) {
            switch(getHordeVariant()){
                case STANDARD -> {
                    int chance = random.nextInt(100);
                    if (chance <= 6){((LivingEntity) entityIn).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 10*20, 0));}

                    this.getEntityData().set(ANITIMER, 50f);
                }
                case FLAMING -> {
                    int chance = random.nextInt(100);
                    if (chance <= 75){entityIn.setSecondsOnFire(5);}

                    this.getEntityData().set(ANITIMER, 50f);
                }
                case ENDER -> {
                    int chance = random.nextInt(20);
                    if(chance <= 2) ((LivingEntity) entityIn).randomTeleport(entityIn.getX() + random.nextInt(5+5)-5,entityIn.getY() + random.nextInt(5+5)-5,entityIn.getZ() + random.nextInt(5+5)-5, true);
                    else if(chance <=4) this.randomTeleport(this.getX() + random.nextInt(5+5)-5,this.getY() + random.nextInt(5+5)-5,this.getZ() + random.nextInt(5+5)-5, true);
                }
            }

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
