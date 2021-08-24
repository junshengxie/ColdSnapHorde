package com.cartoonishvillain.coldsnaphorde.Capabilities;

public interface IWorldCapabilityManager {
    int getCooldownTicks();
    void setCooldownTicks(int ticks);
    void addCooldownTicks(int ticks);
}
