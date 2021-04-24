package com.cartoonishvillain.coldsnaphorde.Capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;

public class CooldownCapability {
    @CapabilityInject(ICooldownManager.class)
    public static Capability<ICooldownManager> INSTANCE = null;

    public static void register(){
        CapabilityManager.INSTANCE.register(ICooldownManager.class, new Capability.IStorage<ICooldownManager>() {
            @Nullable
            @Override
            public INBT writeNBT(Capability<ICooldownManager> capability, ICooldownManager instance, Direction side) {
                CompoundNBT tag = new CompoundNBT();
                tag.putInt("cooldown", instance.getCooldownTicks());
                return tag;
            }

            @Override
            public void readNBT(Capability<ICooldownManager> capability, ICooldownManager instance, Direction side, INBT nbt) {
                CompoundNBT tag = (CompoundNBT) nbt;
                instance.setCooldownTicks(((CompoundNBT) nbt).getInt("cooldown"));
            }
        }, new Callable<CooldownManager>(){
            @Override
            public CooldownManager call() throws Exception {
                return new CooldownManager();
            }

        });
    }
}
