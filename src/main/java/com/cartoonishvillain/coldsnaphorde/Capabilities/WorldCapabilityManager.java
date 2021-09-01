package com.cartoonishvillain.coldsnaphorde.Capabilities;

import com.cartoonishvillain.coldsnaphorde.Events.ModBusEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WorldCapabilityManager implements IWorldCapabilityManager, ICapabilityProvider, INBTSerializable<CompoundTag> {
    protected int ticks = 0;
    public final LazyOptional<IWorldCapabilityManager> holder = LazyOptional.of(() -> this);
    @Override
    public int getCooldownTicks() {return ticks;}

    @Override
    public void setCooldownTicks(int ticks) {this.ticks = ticks;}

    @Override
    public void addCooldownTicks(int ticks) {this.ticks += ticks;}

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == ModBusEvents.WORLDCAPABILITYINSTANCE){ return ModBusEvents.WORLDCAPABILITYINSTANCE.orEmpty(cap, this.holder); }
        else return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("cooldown", ticks);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        ticks = nbt.getInt("cooldown");
    }
}
