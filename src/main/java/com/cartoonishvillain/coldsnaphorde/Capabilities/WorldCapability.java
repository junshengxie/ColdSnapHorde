package com.cartoonishvillain.coldsnaphorde.Capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class WorldCapability {
    @CapabilityInject(IWorldCapabilityManager.class)
    public static Capability<IWorldCapabilityManager> INSTANCE = null;

    public static void register(){
        CapabilityManager.INSTANCE.register(IWorldCapabilityManager.class);
    }
}
