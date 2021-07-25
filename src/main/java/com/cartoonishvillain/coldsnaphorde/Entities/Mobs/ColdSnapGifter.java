package com.cartoonishvillain.coldsnaphorde.Entities.Mobs;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors.GifterSurprise;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.*;
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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ColdSnapGifter extends GenericHordeMember {
    public ColdSnapGifter(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.addEffect(new EffectInstance(Effects.WEAKNESS, 10000*20, 5, false, false));
    }

    int timer = 50;
    boolean exploding = false;

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.targetSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.75D, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, 10, true, false, this::shouldAttack));
    }

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.4D)
                .add(Attributes.ATTACK_DAMAGE, 0D);
    }

    public boolean shouldAttack(@Nullable LivingEntity entity){
//        if (entity == null || entity.getItemBySlot(EquipmentSlotType.HEAD).getItem().equals(Register.TOPHAT.get().getItem())){
//            return false;
//        }else
            return true;
    }

    public int getTimer() {return timer;}

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {}

    public void aiStep() {
        super.aiStep();
        LivingEntity livingEntity = this.getTarget();
        if (livingEntity != null) {
            double distance = this.distanceToSqr(livingEntity);
            if (distance < 4.5D && !level.isClientSide()) {
                if(!exploding){this.playSound(SoundEvents.TNT_PRIMED, 1F, 1F);}
                exploding = true;
                this.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 50, 10, false, false));
            }

            if (exploding && distance < 36D) {
                timer -= 1;
                if (!level.isClientSide() && timer == 0) {
                    this.dead = true;
                    boolean snowy = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this);
                    GifterSurprise gifterSurprise = new GifterSurprise(this.level, this, DamageSource.explosion(this), null, this.getX(), this.getY(), this.getZ(), 5, true, Explosion.Mode.NONE);
                    gifterSurprise.explode();
                    gifterSurprise.finalizeExplosion(true);
                    this.playSound(SoundEvents.GENERIC_EXPLODE, 1f, 1.5f);
                    this.remove();
                }
            } else if (exploding && distance > 36D) {
                exploding = false;
                timer = 50;
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
