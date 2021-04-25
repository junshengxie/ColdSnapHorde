package com.cartoonishvillain.coldsnaphorde.Entities.Mobs;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors.GifterSurprise;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors.HordeMovementGoal;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class GenericHordeMember extends MonsterEntity {
    private BlockPos target = null;
    private Boolean HordeMember = false;

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

    public void toggleHordeMember(BlockPos center) {this.target = center; HordeMember = true;}

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

            BlockState blockstate = Blocks.SNOW.defaultBlockState();

            for(int l = 0; l < 4; ++l) {
                i = MathHelper.floor(this.getX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = MathHelper.floor(this.getY());
                k = MathHelper.floor(this.getZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
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
