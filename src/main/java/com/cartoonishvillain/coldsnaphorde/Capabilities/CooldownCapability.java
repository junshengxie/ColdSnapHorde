package com.cartoonishvillain.coldsnaphorde.Capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;

public class CooldownCapability {
    @CapabilityInject(ICooldownManager.class)
    public static Capability<ICooldownManager> INSTANCE = null;

    public static void register(){
        CapabilityManager.INSTANCE.register(ICooldownManager.class);
    }
}
