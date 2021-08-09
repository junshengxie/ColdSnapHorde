package com.cartoonishvillain.coldsnaphorde.Entities.Mobs;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class ColdSnapZapper extends GenericHordeMember {
    public ColdSnapZapper(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    LivingEntity ZapTarget;
    int timer = 60;
    float transponderprogress = 1;

    public LivingEntity getZapTarget() {
        return ZapTarget;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, CreatureEntity.class, 6.0F, 0.75D, 0.75D, this::avoid));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 6.0F, 1.0D, 1.2D, this::avoid));
        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 0.75D, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, 10, true, false, this::shouldAttack));

    }

    private boolean avoid(@Nullable LivingEntity entity){
        if (entity == null || entity != ZapTarget) {
            return false;
        } else return true;

    }

    public static AttributeModifierMap.MutableAttribute customAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1D);
    }

    public boolean shouldAttack(@Nullable LivingEntity entity){
        if (entity == null || entity.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(Register.TOPHAT.get().getItem()) || entity == ZapTarget){
            return false;
        }else return true;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        int chance = rand.nextInt(100);
        if(chance >= ColdSnapHorde.sconfig.STICKTRANSPONDER.get() && entityIn instanceof LivingEntity && transponderprogress == 1){
            ZapTarget = (LivingEntity) entityIn;
            transponderprogress = 0;
        }
        return super.attackEntityAsMob(entityIn);
    }

    public void livingTick() {
        super.livingTick();

        if(ZapTarget != null && !this.world.isRemote()){
            timer -= 1;
            if (timer == 0){
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) ZapTarget.getEntityWorld(), new ItemStack(Items.AIR), null, ZapTarget.getPosition(), SpawnReason.TRIGGERED, true, false);
                ZapTarget = null;
                timer = 60;
            }
        }
        if(transponderprogress < 1){
            transponderprogress += 0.0025;
            if (transponderprogress > 1) transponderprogress = 1;
        }
    }


}

class CustomMeleeAttackGoal extends MeleeAttackGoal {
    public CustomMeleeAttackGoal(CreatureEntity creature, double speedIn, boolean useLongMemory) {
        super(creature, speedIn, useLongMemory);
    }

    @Override
    public boolean shouldContinueExecuting() {
        if(this.attacker instanceof ColdSnapZapper && this.attacker.getAttackTarget() == ((ColdSnapZapper) this.attacker).getZapTarget()){return false;}
        return super.shouldContinueExecuting();
    }
}

