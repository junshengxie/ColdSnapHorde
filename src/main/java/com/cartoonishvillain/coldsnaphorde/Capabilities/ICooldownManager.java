package com.cartoonishvillain.coldsnaphorde.Capabilities;

public interface ICooldownManager {
    int getCooldownTicks();
    void setCooldownTicks(int ticks);
    void addCooldownTicks(int ticks);
}
