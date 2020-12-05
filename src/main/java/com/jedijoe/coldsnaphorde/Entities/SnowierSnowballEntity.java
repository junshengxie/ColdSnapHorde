package com.jedijoe.coldsnaphorde.Entities;

import com.jedijoe.coldsnaphorde.Register;
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
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = entity instanceof BlazeEntity ? 5 : 0;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
        int chance = rand.nextInt(20);
        if (chance <= 2 && entity instanceof LivingEntity && !this.world.isRemote()){((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 7*20, 0));}
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        BlockState blockstate = Blocks.SNOW_BLOCK.getDefaultState();
        BlockPos blockpos = new BlockPos(result.getHitVec());
        if (this.world.isAirBlock(blockpos) && this.world.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.isValidPosition(this.world, blockpos) && !world.isRemote()) {
            this.world.setBlockState(blockpos, blockstate);
        } else if(this.world.getBlockState(blockpos) == Blocks.LAVA.getDefaultState() && !world.isRemote()){
            this.world.setBlockState(blockpos, Blocks.OBSIDIAN.getDefaultState());
        }else if(this.world.getBlockState(blockpos) == Blocks.WATER.getDefaultState() && !world.isRemote()){
            this.world.setBlockState(blockpos, Blocks.ICE.getDefaultState());
        }
        this.remove();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        super.tick();
        BlockPos position = this.getPosition();
        if(!world.isRemote()){
            if(world.getBlockState(position) == Blocks.WATER.getDefaultState()){
                world.setBlockState(position, Blocks.ICE.getDefaultState());
                this.remove();
            }else if(world.getBlockState(position) == Blocks.LAVA.getDefaultState()){
                world.setBlockState(position, Blocks.OBSIDIAN.getDefaultState());
                this.remove();
            }

        }
    }
}
