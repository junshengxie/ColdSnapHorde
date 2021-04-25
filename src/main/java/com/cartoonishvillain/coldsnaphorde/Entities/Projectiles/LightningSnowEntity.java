package com.cartoonishvillain.coldsnaphorde.Entities.Projectiles;

import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class LightningSnowEntity extends ProjectileItemEntity {

    public LightningSnowEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn, LivingEntity livingEntityIn) {
        super(type, livingEntityIn, worldIn);
    }

    public LightningSnowEntity(EntityType<LightningSnowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() { return new ItemStack(Register.LIGHTNINGSNOWBALL.get()); }

    @Override
    protected Item getDefaultItem() {
        {return Register.LIGHTNINGSNOWBALL.get();}
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if(!this.world.isRemote()){
        EntityType.LIGHTNING_BOLT.spawn((ServerWorld) this.getEntityWorld(), new ItemStack(Items.AIR), null, new BlockPos(result.getHitVec()), SpawnReason.TRIGGERED, true, false);}
        this.remove();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
