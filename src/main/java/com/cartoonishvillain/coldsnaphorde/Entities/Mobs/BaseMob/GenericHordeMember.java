package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob;

import com.cartoonishvillain.ImmortuosCalyx.ImmortuosCalyx;
import com.cartoonishvillain.ImmortuosCalyx.Infection.InfectionManagerCapability;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors.HordeMovementGoal;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;

public class GenericHordeMember extends MonsterEntity {
    private BlockPos target = null;
    private Boolean HordeMember = false;
    public static final DataParameter<Integer> variant = EntityDataManager.defineId(GenericHordeMember.class, DataSerializers.INT);


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new HordeMovementGoal<>(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ColdSnapGifter.class, 6.0F, 1.0D, 1.2D, this::avoid));
        if(getHordeVariant() == 1 || getHordeVariant() == 2){
        this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this, 1));}
    }

    private boolean avoid(@Nullable LivingEntity entity) {
        if (entity instanceof ColdSnapGifter) {
            int timer = ((ColdSnapGifter) entity).getTimer();
            return timer < 50;
        }
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.tickCount == 2){
            String check = this.getType().toString();
            int variantcheck = this.getHordeVariant();
            if(check.contains("ncoldsnap") && variantcheck != 1)
            {setHordeVariant(1);}
            else if(check.contains("ecoldsnap") && variantcheck != 2)
            {setHordeVariant(2);}
            else if(check.contains("pcoldsnap") && variantcheck != 3)
            {setHordeVariant(3);}
        }
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.setHordeVariant(compound.getInt("variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("variant", this.getHordeVariant());
    }

    public void setHordeVariant(int hordeVariant) {this.entityData.set(variant, hordeVariant);}

    public int getHordeVariant() {
        int variant = this.entityData.get(GenericHordeMember.variant);
        return variant;
    }

    @Override
    public void die(DamageSource cause) {
        int random = level.random.nextInt(100);
        if(random > 80 && !level.isClientSide() && isHordeMember()){
            ItemEntity itemEntity = new ItemEntity(level, this.getX(), this.getY(), this.getZ(), new ItemStack(Register.PRESENT.get(), 1));
            level.addFreshEntity(itemEntity);
        }
        super.die(cause);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {

        if(this.getEntityData().get(variant) == 2){
            int chance = random.nextInt(10);
            if(chance <= 2) this.randomTeleport(this.getX() + random.nextInt(5+5)-5,this.getY() + random.nextInt(5+5)-5,this.getZ() + random.nextInt(5+5)-5, true);

        }
        return super.hurt(source, amount);
    }

    protected GenericHordeMember(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SNOW_GOLEM_AMBIENT;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SNOW_GOLEM_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.SNOW_GOLEM_DEATH;
    }

    public BlockPos getLocTarget() {return target;}

    public boolean isHordeMember(){return HordeMember;}

    public void toggleHordeMember(BlockPos center) {
        this.target = center; HordeMember = true;
        ColdSnapHorde.Horde.SpawnUnit();
    }

    public void updateHordeMember(BlockPos center) {this.target = center;}

    public void cancelHordeMembership(){
        this.target = null; this.HordeMember = false;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide()) {
            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY());
            int k = MathHelper.floor(this.getZ());
            if (shouldOverHeat(this.level.getBiome(this.blockPosition()).getBaseTemperature(), ColdSnapHorde.cconfig.HEATPROT.get())) {
                this.hurt(DamageSource.ON_FIRE, 1.0F);
            }

            if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this)) {
                return;
            }

            BlockState blockstate = null;
            if (this.entityData.get(variant) == 0 || this.entityData.get(variant) == 3) {
                blockstate = Blocks.SNOW.defaultBlockState();
            }
            if (this.entityData.get(variant) == 1) {
                blockstate = Register.SLUSH.get().defaultBlockState();
            }


            if (blockstate == Blocks.SNOW.defaultBlockState()) {
                for (int l = 0; l < 4; ++l) {
                    i = MathHelper.floor(this.getX() + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
                    j = MathHelper.floor(this.getY());
                    k = MathHelper.floor(this.getZ() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
                    BlockPos blockpos = new BlockPos(i, j, k);
                    if (this.level.isEmptyBlock(blockpos) && !shouldOverHeat(this.level.getBiome(this.blockPosition()).getBaseTemperature(), ColdSnapHorde.cconfig.SNOWTRAIL.get()) && blockstate.canSurvive(this.level, blockpos)) {
                        this.level.setBlockAndUpdate(blockpos, blockstate);
                    }
                }
            } else if (blockstate == Register.SLUSH.get().defaultBlockState()) {
                for (int l = 0; l < 4; ++l) {
                    i = MathHelper.floor(this.getX() + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
                    j = MathHelper.floor(this.getY());
                    k = MathHelper.floor(this.getZ() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
                    BlockPos blockpos = new BlockPos(i, j, k);
                    if(this.level.isEmptyBlock(blockpos) && (blockstate.canSurvive(this.level, blockpos)))this.level.setBlockAndUpdate(blockpos, blockstate);
                }
            }}
            }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        getEntityData().define(variant, -1);
    }

    @Override
    public boolean fireImmune() {
        return (getHordeVariant() == 1);
    }

    @Override
    public boolean isSensitiveToWater() {
        return (getHordeVariant() == 1 || getHordeVariant() == 2);
    }

    public boolean shouldOverHeat(float currentTemp, int protectionlevel){
        if(this.entityData.get(variant) == 0) {
            switch (protectionlevel) {
                case 0: return currentTemp > 0.3f;
                case 1: return currentTemp > 0.9f;
                case 2: return currentTemp > 1.5f;
                case 3: return false;
                default: return true;
            }
        }else return false;
    }

    public static void Infection(LivingEntity entity){
        if(ColdSnapHorde.isCalyxLoaded && ColdSnapHorde.sconfig.PLAGUEIMMORTUOSCOMPAT.get()){
            entity.getCapability(InfectionManagerCapability.INSTANCE).ifPresent(h->{
                if(entity.getRandom().nextInt(10) >= 4){
                    if(h.getInfectionProgress() <= 0) h.setInfectionProgress(1);
                }
            });
        }else{
            int chance = entity.getRandom().nextInt(10);
            switch (chance){
                default: break;
                case 3: {entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*20, 0)); break;}
                case 4: {entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*20, 0)); entity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 20*20, 0)); break;}
                case 5: {entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*40, 0)); entity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 20*40, 0)); break;}
                case 6: {entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*30, 0)); entity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 20*30, 0)); entity.addEffect(new EffectInstance(Effects.CONFUSION, 20*10, 0)); break;}
                case 7: {entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*25, 1)); entity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 20*25, 1)); entity.addEffect(new EffectInstance(Effects.CONFUSION, 20*20, 0)); break;}
                case 8: {entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*30, 1)); entity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 20*30, 1)); entity.addEffect(new EffectInstance(Effects.CONFUSION, 20*20, 0)); entity.addEffect(new EffectInstance(Effects.WEAKNESS, 20*30, 0)); break;}
                case 9: {entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*30, 1)); entity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 20*30, 1)); entity.addEffect(new EffectInstance(Effects.CONFUSION, 20*20, 0)); entity.addEffect(new EffectInstance(Effects.WEAKNESS, 20*30, 1)); break;}
            }
        }
    }
}
