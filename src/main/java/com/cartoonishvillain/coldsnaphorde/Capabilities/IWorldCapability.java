package com.cartoonishvillain.coldsnaphorde.Capabilities;

public interface IWorldCapability {
    int getCooldownTicks();
    void setCooldownTicks(int ticks);
    void addCooldownTicks(int ticks);
}
