package com.villain.coldsnaphorde.capabilities;

import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WorldCapabilityManager implements IWorldCapabilityManager, ICapabilityProvider, INBTSerializable<CompoundTag> {
    int levelBeaten = 0;
    public final LazyOptional<IWorldCapabilityManager> holder = LazyOptional.of(() -> this);

    @Override
    public void setLevelBeaten(int level) {
        levelBeaten = level;
    }

    @Override
    public int getLevelBeaten() {
        return levelBeaten;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeColdSnapHorde.WORLDCAPABILITYINSTANCE){ return ForgeColdSnapHorde.WORLDCAPABILITYINSTANCE.orEmpty(cap, this.holder); }
        else return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("levelbeaten", levelBeaten);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        levelBeaten = nbt.getInt("levelbeaten");
    }
}
