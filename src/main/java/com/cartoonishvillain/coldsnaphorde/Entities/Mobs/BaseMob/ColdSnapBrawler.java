package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob;

import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ColdSnapBrawler extends GenericHordeMember{
    public ColdSnapBrawler(EntityType<? extends MonsterEntity> type, World worldIn) { super(type, worldIn);}

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, 10, true, false, this::shouldAttack));
    }

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.42D)
                .add(Attributes.ATTACK_DAMAGE, 1D)
                .add(Attributes.ATTACK_KNOCKBACK, 3d);
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        switch(this.getHordeVariant()){
            case 0: break;
            case 1:
                int chance2 = this.random.nextInt(100);
                if (chance2 <= 75){
                    if (entityIn instanceof LivingEntity) ((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*5, 1));
                }
                break;
            case 2:
                int chance3 = random.nextInt(20);
                if(chance3 <= 2) ((LivingEntity) entityIn).randomTeleport(entityIn.getX() + random.nextInt(5+5)-5,entityIn.getY() + random.nextInt(5+5)-5,entityIn.getZ() + random.nextInt(5+5)-5, true);
                else if(chance3 <=4) this.randomTeleport(this.getX() + random.nextInt(5+5)-5,this.getY() + random.nextInt(5+5)-5,this.getZ() + random.nextInt(5+5)-5, true);
                break;
            case 3: Infection((LivingEntity) entityIn); break;
        }
        return super.doHurtTarget(entityIn);
    }

    public boolean shouldAttack(@Nullable LivingEntity entity){
        if (entity == null || entity.getItemBySlot(EquipmentSlotType.HEAD).getItem().equals(Register.TOPHAT.get().getItem())){
            return false;
        }else return true;
    }

}
