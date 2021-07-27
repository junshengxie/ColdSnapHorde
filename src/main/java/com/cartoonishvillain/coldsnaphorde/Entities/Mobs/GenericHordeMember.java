package com.cartoonishvillain.coldsnaphorde.Entities.Mobs;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors.HordeMovementGoal;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class GenericHordeMember extends Monster {
    private BlockPos target = null;
    private Boolean HordeMember = false;

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
    public boolean canFreeze() {
        return false;
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

    protected GenericHordeMember(EntityType<? extends Monster> type, Level worldIn) {
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

    public BlockPos getLoc() {return target;}

    public boolean isHordeMember(){return HordeMember;}

    public void toggleHordeMember(BlockPos center) {this.target = center; HordeMember = true;}

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide()) {
            int i = Mth.floor(this.getX());
            int j = Mth.floor(this.getY());
            int k = Mth.floor(this.getZ());
            if (shouldOverHeat(this.level.getBiome(this.blockPosition()).getBaseTemperature(), ColdSnapHorde.cconfig.HEATPROT.get())) {
                this.hurt(DamageSource.ON_FIRE, 1.0F);
            }

            if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this)) {
                return;
            }

            BlockState blockstate = Blocks.SNOW.defaultBlockState();

            for(int l = 0; l < 4; ++l) {
                i = Mth.floor(this.getX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = Mth.floor(this.getY());
                k = Mth.floor(this.getZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockpos = new BlockPos(i, j, k);
                if (this.level.isEmptyBlock(blockpos) && !shouldOverHeat(this.level.getBiome(this.blockPosition()).getBaseTemperature(), ColdSnapHorde.cconfig.SNOWTRAIL.get()) && blockstate.canSurvive(this.level, blockpos)) {
                    this.level.setBlockAndUpdate(blockpos, blockstate);
                }
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
