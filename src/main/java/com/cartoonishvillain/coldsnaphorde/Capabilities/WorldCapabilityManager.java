package com.cartoonishvillain.coldsnaphorde.Capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WorldCapabilityManager implements IWorldCapability, ICapabilityProvider, INBTSerializable<CompoundNBT> {
    protected int ticks = 0;
    public final LazyOptional<IWorldCapability> holder = LazyOptional.of(() -> this);
    @Override
    public int getCooldownTicks() {return ticks;}

    @Override
    public void setCooldownTicks(int ticks) {this.ticks = ticks;}

    @Override
    public void addCooldownTicks(int ticks) {this.ticks += ticks;}

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == WorldCapability.INSTANCE){ return WorldCapability.INSTANCE.orEmpty(cap, this.holder); }
        else return LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("cooldown", ticks);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        ticks = nbt.getInt("cooldown");
    }
}
