package com.jedijoe.coldsnaphorde.Entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class RockSnowballEntity extends SnowballEntity {

    public RockSnowballEntity(EntityType<? extends SnowballEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }
    public RockSnowballEntity(World worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }

    public RockSnowballEntity(World worldIn, double x, double y, double z) {super(worldIn, x, y, z); }

    @Override
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 1;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        BlockState blockstate = Blocks.SNOW_BLOCK.getDefaultState();
        int snowchance = rand.nextInt(20);
        BlockPos blockpos = new BlockPos(result.getHitVec());
        if (this.world.isAirBlock(blockpos) && this.world.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.isValidPosition(this.world, blockpos) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) && snowchance == 1) {
            this.world.setBlockState(blockpos, blockstate);
        }
    }
}
