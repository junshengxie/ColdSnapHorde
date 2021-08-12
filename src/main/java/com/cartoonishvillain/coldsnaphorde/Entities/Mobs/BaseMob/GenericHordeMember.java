package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob;

import com.cartoonishvillain.ImmortuosCalyx.Infection.InfectionManagerCapability;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors.HordeMovementGoal;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.item.ItemEntity;
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
    public static final DataParameter<Integer> variant = EntityDataManager.createKey(GenericHordeMember.class, DataSerializers.VARINT);


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new HordeMovementGoal<>(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ColdSnapGifter.class, 6.0F, 1.0D, 1.2D, this::avoid));
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
        if(this.ticksExisted == 2){
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
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setHordeVariant(compound.getInt("variant"));
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("variant", this.getHordeVariant());
    }

    public void setHordeVariant(int hordeVariant) {this.dataManager.set(variant, hordeVariant);}

    public int getHordeVariant() {
        int variant = this.dataManager.get(GenericHordeMember.variant);
        return variant;
    }

    @Override
    public void onDeath(DamageSource cause) {
        int random = world.rand.nextInt(100);
        if(random > 80 && !world.isRemote() && isHordeMember()){
            ItemEntity itemEntity = new ItemEntity(world, this.getPosX(), this.getPosY(), this.getPosZ(), new ItemStack(Register.PRESENT.get(), 1));
            world.addEntity(itemEntity);
        }
        super.onDeath(cause);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {

        if(this.getDataManager().get(variant) == 2){
            int chance = rand.nextInt(10);
            if(chance <= 2) this.attemptTeleport(this.getPosX() + rand.nextInt(5+5)-5,this.getPosY() + rand.nextInt(5+5)-5,this.getPosZ() + rand.nextInt(5+5)-5, true);

        }
        return super.attackEntityFrom(source, amount);
    }

    protected GenericHordeMember(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
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

    public BlockPos getTarget() {return target;}

    public boolean isHordeMember(){return HordeMember;}

    public void toggleHordeMember(BlockPos center) {this.target = center; HordeMember = true;}

    @Override
    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote()) {
            int i = MathHelper.floor(this.getPosX());
            int j = MathHelper.floor(this.getPosY());
            int k = MathHelper.floor(this.getPosZ());
            if (shouldOverHeat(this.world.getBiome(this.getPosition()).getTemperature(), ColdSnapHorde.cconfig.HEATPROT.get())) {
                this.attackEntityFrom(DamageSource.ON_FIRE, 1.0F);
            }

            if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
                return;
            }

            BlockState blockstate = null;
            if (this.dataManager.get(variant) == 0 || this.dataManager.get(variant) == 3) {
                blockstate = Blocks.SNOW.getDefaultState();
            }
            if (this.dataManager.get(variant) == 1) {
                blockstate = Register.SLUSH.get().getDefaultState();
            }


            if (blockstate == Blocks.SNOW.getDefaultState()) {
                for (int l = 0; l < 4; ++l) {
                    i = MathHelper.floor(this.getPosX() + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
                    j = MathHelper.floor(this.getPosY());
                    k = MathHelper.floor(this.getPosZ() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
                    BlockPos blockpos = new BlockPos(i, j, k);
                    if (this.world.isAirBlock(blockpos) && !shouldOverHeat(this.world.getBiome(this.getPosition()).getTemperature(), ColdSnapHorde.cconfig.SNOWTRAIL.get()) && blockstate.isValidPosition(this.world, blockpos)) {
                        this.world.setBlockState(blockpos, blockstate);
                    }
                }
            } else if (blockstate == Register.SLUSH.get().getDefaultState()) {
                for (int l = 0; l < 4; ++l) {
                    i = MathHelper.floor(this.getPosX() + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
                    j = MathHelper.floor(this.getPosY());
                    k = MathHelper.floor(this.getPosZ() + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
                    BlockPos blockpos = new BlockPos(i, j, k);
                    if(this.world.isAirBlock(blockpos) && (blockstate.isValidPosition(this.world, blockpos)))this.world.setBlockState(blockpos, blockstate);
                }
            }}
            }


    @Override
    protected void registerData() {
        super.registerData();
        getDataManager().register(variant, -1);
    }

    @Override
    public boolean isImmuneToFire() {
        return (getHordeVariant() == 1);
    }

    @Override
    public boolean isWaterSensitive() {
        return (getHordeVariant() == 1 || getHordeVariant() == 2);
    }

    public boolean shouldOverHeat(float currentTemp, int protectionlevel){
        if(this.dataManager.get(variant) == 0) {
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
                if(entity.getRNG().nextInt(10) >= 4){
                    h.setInfectionProgressIfLower(1);
                }
            });
        }else{
            int chance = entity.getRNG().nextInt(10);
            switch (chance){
                default: break;
                case 3: {entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*20, 0)); break;}
                case 4: {entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*20, 0)); entity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20*20, 0)); break;}
                case 5: {entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*40, 0)); entity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20*40, 0)); break;}
                case 6: {entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*30, 0)); entity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20*30, 0)); entity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 20*10, 0)); break;}
                case 7: {entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*25, 1)); entity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20*25, 1)); entity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 20*20, 0)); break;}
                case 8: {entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*30, 1)); entity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20*30, 1)); entity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 20*20, 0)); entity.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 20*30, 0)); break;}
                case 9: {entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20*30, 1)); entity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20*30, 1)); entity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 20*20, 0)); entity.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 20*30, 1)); break;}
            }
        }
    }
}
