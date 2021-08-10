package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob;

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
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ColdSnapGifter extends GenericHordeMember {
    public ColdSnapGifter(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 10000*20, 5, false, false));
    }

    int timer = 50;
    boolean exploding = false;

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.75D, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, 10, true, false, this::shouldAttack));
    }


    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        switch(this.getHordeVariant()){
            case 0: break;
            case 1:
                int chance2 = this.rand.nextInt(100);
                if (chance2 <= 75){entityIn.setFire(3);}
                break;
            case 2:
                int chance3 = rand.nextInt(20);
                if(chance3 <= 2) ((LivingEntity) entityIn).attemptTeleport(entityIn.getPosX() + rand.nextInt(5+5)-5,entityIn.getPosY() + rand.nextInt(5+5)-5,entityIn.getPosZ() + rand.nextInt(5+5)-5, true);
                else if(chance3 <=4) this.attemptTeleport(this.getPosX() + rand.nextInt(5+5)-5,this.getPosY() + rand.nextInt(5+5)-5,this.getPosZ() + rand.nextInt(5+5)-5, true);
                break;
            case 3: Infection((LivingEntity) entityIn); break;
        }
        return super.attackEntityAsMob(entityIn);
    }

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 0D);
    }

    public boolean shouldAttack(@Nullable LivingEntity entity){
        if (entity == null || entity.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(Register.TOPHAT.get().getItem())){
            return false;
        }else return true;
    }

    public int getTimer() {return timer;}

    @Override
    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {}

    public void livingTick() {
        super.livingTick();
        LivingEntity livingEntity = this.getAttackTarget();
        if (livingEntity != null) {
            double distance = this.getDistanceSq(livingEntity);
            if (distance < 4.5D && !world.isRemote()) {
                if(!exploding){this.playSound(SoundEvents.ENTITY_TNT_PRIMED, 1F, 1F);}
                exploding = true;
                this.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 50, 10, false, false));
            }

            if (exploding && distance < 36D) {
                timer -= 1;
                if (!world.isRemote() && timer == 0) {
                    this.dead = true;
                    boolean snowy = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
                    GifterSurprise gifterSurprise = new GifterSurprise(this.world, this, this.getPosX(), this.getPosY(), this.getPosZ(), 5);
                    gifterSurprise.StageDetonation();
                    gifterSurprise.DetonateBlockDamage();
                    gifterSurprise.DetonateLivingHarm();
                    this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1f, 1.5f);
                    this.remove();
                }
            } else if (exploding && distance > 36D) {
                exploding = false;
                timer = 50;
            }
        }
    }
}
