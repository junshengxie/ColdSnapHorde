package com.cartoonishvillain.coldsnaphorde.capabilities;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerCapabilityManager implements IPlayerCapabilityManager, ICapabilityProvider, INBTSerializable<CompoundTag> {
    protected int ticks = 0;
    public final LazyOptional<IPlayerCapabilityManager> holder = LazyOptional.of(() -> this);

    @Override
    public int getCooldownTicks() {
        return ticks;
    }

    @Override
    public void setCooldownTicks(int ticks) {
        this.ticks = ticks;
    }

    @Override
    public void tickCooldown() {
        if(!(ticks <= 0)) ticks--;
        if(ticks < 0) ticks = 0;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ColdSnapHorde.PLAYERCAPABILITYINSTANCE) {
            return ColdSnapHorde.PLAYERCAPABILITYINSTANCE.orEmpty(cap, this.holder);
        } else return LazyOptional.empty();
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