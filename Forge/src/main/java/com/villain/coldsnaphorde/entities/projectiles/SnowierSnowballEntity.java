package com.villain.coldsnaphorde.entities.projectiles;

import com.villain.coldsnaphorde.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

public class SnowierSnowballEntity extends ThrowableItemProjectile {

    public SnowierSnowballEntity(EntityType<? extends ThrowableItemProjectile> type, Level worldIn, LivingEntity livingEntityIn) {
        super(type, livingEntityIn, worldIn);
    }

    public SnowierSnowballEntity(EntityType<SnowierSnowballEntity> type, Level worldIn) {
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
    protected void onHitEntity(EntityHitResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        if (!p_213868_1_.getEntity().level.isClientSide && p_213868_1_.getEntity() instanceof LivingEntity entity) {
            int i = entity instanceof Blaze ? 5 : 0;
            entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float) i);
            entity.setIsInPowderSnow(true);
            entity.setTicksFrozen(getTicksFrozen() + 40);
            int chance = random.nextInt(20);
            if (chance <= 2 && !this.level.isClientSide()) {
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 7 * 20, 0));
            }
        }
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        BlockState blockstate = Blocks.SNOW_BLOCK.defaultBlockState();
        Vec3i vec3i = new Vec3i((int) Math.round(result.getLocation().x), (int) Math.round(result.getLocation().y), (int) Math.round(result.getLocation().z));
        BlockPos blockpos = new BlockPos(vec3i);
        if (this.level.isEmptyBlock(blockpos) && this.level.getBiome(blockpos).value().getBaseTemperature() < 0.8F && blockstate.canSurvive(this.level, blockpos) && !level.isClientSide()) {
            this.level.setBlockAndUpdate(blockpos, blockstate);
        } else if(this.level.getBlockState(blockpos) == Blocks.LAVA.defaultBlockState() && !level.isClientSide()){
            this.level.setBlockAndUpdate(blockpos, Blocks.OBSIDIAN.defaultBlockState());
        }else if(this.level.getBlockState(blockpos) == Blocks.WATER.defaultBlockState() && !level.isClientSide()){
            this.level.setBlockAndUpdate(blockpos, Blocks.ICE.defaultBlockState());
        }
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void tick() {
        super.tick();
        BlockPos position = this.blockPosition();
        if(!level.isClientSide()){
            if(level.getBlockState(position) == Blocks.WATER.defaultBlockState()){
                level.setBlockAndUpdate(position, Blocks.ICE.defaultBlockState());
                this.remove(RemovalReason.DISCARDED);
            }else if(level.getBlockState(position) == Blocks.LAVA.defaultBlockState()){
                level.setBlockAndUpdate(position, Blocks.OBSIDIAN.defaultBlockState());
                this.remove(RemovalReason.DISCARDED);
            }

        }
    }
}
