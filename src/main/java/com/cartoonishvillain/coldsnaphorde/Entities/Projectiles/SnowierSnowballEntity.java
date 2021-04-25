package com.cartoonishvillain.coldsnaphorde.Entities.Projectiles;

import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class SnowierSnowballEntity extends ProjectileItemEntity {

    public SnowierSnowballEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn, LivingEntity livingEntityIn) {
        super(type, livingEntityIn, worldIn);
    }

    public SnowierSnowballEntity(EntityType<SnowierSnowballEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() { return new ItemStack(Register.SNOWIERSNOWBALL.get()); }

    @Override
    protected Item getDefaultItem() {
        {return Register.SNOWIERSNOWBALL.get();}
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = entity instanceof BlazeEntity ? 5 : 0;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
        int chance = random.nextInt(20);
        if (chance <= 2 && entity instanceof LivingEntity && !this.level.isClientSide()){((LivingEntity) entity).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 7*20, 0));}
    }

    @Override
    protected void onHit(RayTraceResult result) {
        super.onHit(result);
        BlockState blockstate = Blocks.SNOW_BLOCK.defaultBlockState();
        BlockPos blockpos = new BlockPos(result.getLocation());
        if (this.level.isEmptyBlock(blockpos) && this.level.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.canSurvive(this.level, blockpos) && !level.isClientSide()) {
            this.level.setBlockAndUpdate(blockpos, blockstate);
        } else if(this.level.getBlockState(blockpos) == Blocks.LAVA.defaultBlockState() && !level.isClientSide()){
            this.level.setBlockAndUpdate(blockpos, Blocks.OBSIDIAN.defaultBlockState());
        }else if(this.level.getBlockState(blockpos) == Blocks.WATER.defaultBlockState() && !level.isClientSide()){
            this.level.setBlockAndUpdate(blockpos, Blocks.ICE.defaultBlockState());
        }
        this.remove();
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        super.tick();
        BlockPos position = this.blockPosition();
        if(!level.isClientSide()){
            if(level.getBlockState(position) == Blocks.WATER.defaultBlockState()){
                level.setBlockAndUpdate(position, Blocks.ICE.defaultBlockState());
                this.remove();
            }else if(level.getBlockState(position) == Blocks.LAVA.defaultBlockState()){
                level.setBlockAndUpdate(position, Blocks.OBSIDIAN.defaultBlockState());
                this.remove();
            }

        }
    }
}
