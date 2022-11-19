package com.villain.coldsnaphorde.capabilities;

public interface IPlayerCapabilityManager {
    int getCooldownTicks();
    void setCooldownTicks(int ticks);
    void tickCooldown();
}
