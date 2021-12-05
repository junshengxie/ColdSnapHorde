package com.cartoonishvillain.coldsnaphorde.capabilities;

public interface IWorldCapabilityManager {
    int getCooldownTicks();
    void setCooldownTicks(int ticks);
    void addCooldownTicks(int ticks);
}
