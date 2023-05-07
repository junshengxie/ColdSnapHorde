package com.villain.coldsnaphorde.entities.mobs.basemob;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import static com.villain.coldsnaphorde.ForgeColdSnapHorde.TOPHATS;

public class ColdSnapBrawler extends GenericHordeMember {
    public ColdSnapBrawler(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    private static final EntityDataAccessor<Float> ANITIMER = SynchedEntityData.defineId(ColdSnapBrawler.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> ARMTOGGLE = SynchedEntityData.defineId(ColdSnapBrawler.class, EntityDataSerializers.BOOLEAN);


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.9D, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Villager.class, 10, true, false, this::shouldAttack));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, IronGolem.class, 10, true, false, this::shouldAttack));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(ANITIMER, 10f);
        getEntityData().define(ARMTOGGLE, false);
    }

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.45D)
                .add(Attributes.ATTACK_DAMAGE, 1D)
                .add(Attributes.ATTACK_KNOCKBACK, 3d);
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        switch (this.getHordeVariant()) {
            case 0 -> {

            }
            case 1 -> {
                int chance2 = random.nextInt(100);
                if (chance2 <= 10) {
                    ((LivingEntity) entityIn).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 5, 1));
                }

            }
            case 2 -> {
                int chance2 = random.nextInt(20);
                if (chance2 <= 1)
                    ((LivingEntity) entityIn).randomTeleport(entityIn.getX() + random.nextInt(5 + 5) - 5, entityIn.getY() + random.nextInt(5 + 5) - 5, entityIn.getZ() + random.nextInt(5 + 5) - 5, true);
                else if (chance2 <= 3)
                    this.randomTeleport(this.getX() + random.nextInt(5 + 5) - 5, this.getY() + random.nextInt(5 + 5) - 5, this.getZ() + random.nextInt(5 + 5) - 5, true);
            }
            case 3 -> {
                Infection((LivingEntity) entityIn);
            }
        }

        if(getANITIMER() >= 10) {
            this.getEntityData().set(ARMTOGGLE, this.random.nextBoolean());
            this.getEntityData().set(ANITIMER, 0f);
        }
        return super.doHurtTarget(entityIn);
    }

    public Float getANITIMER() {
        return getEntityData().get(ANITIMER);
    }

    public Boolean getARMTOGGLE() {
        return getEntityData().get(ARMTOGGLE);
    }

    public boolean shouldAttack(@Nullable LivingEntity entity) {
        return entity != null && (!TOPHATS.contains(entity.getItemBySlot(EquipmentSlot.HEAD).getItem()) || getHordeMember());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide()) {
            float timer = getEntityData().get(ANITIMER);
            if (timer < 11) this.getEntityData().set(ANITIMER, timer += 1f);
        }
    }
}
