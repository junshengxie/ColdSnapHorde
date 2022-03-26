package com.cartoonishvillain.coldsnaphorde;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

public class HordeDataManager {
    int highestLevelBeaten = 0;
    int cooldownTicks = 0;
    int currentHordeLevel = 0;

    private static HordeDataManager instance = null;

    public static HordeDataManager getInstance() {
        if (instance == null) instance = new HordeDataManager();
        return instance;
    }

    private HordeDataManager() {

    }

    public int getHighestLevelBeaten() {
        return highestLevelBeaten;
    }

    public void setupHighestLevelBeaten(MinecraftServer server) {
        for(ServerLevel serverWorld : server.getAllLevels()){
            if(serverWorld.dimension().location().getPath().contains("overworld")) {
                serverWorld.getCapability(ColdSnapHorde.WORLDCAPABILITYINSTANCE).ifPresent(h -> {
                    highestLevelBeaten = h.getLevelBeaten();
                });
            }
        }
    }

    public void updateHighestLevelBeaten(MinecraftServer server, int level) {
        for(ServerLevel serverWorld : server.getAllLevels()){
            if(serverWorld.dimension().location().getPath().contains("overworld")) {
                serverWorld.getCapability(ColdSnapHorde.WORLDCAPABILITYINSTANCE).ifPresent(h -> {
                    h.setLevelBeaten(level);
                });
            }
        }
    }

    public void setCooldownTicks(int ticks) {
        cooldownTicks = ticks;
    }

    public int getCooldownTicks() {
        return cooldownTicks;
    }

    public void tickCooldown() {
        if(cooldownTicks > 0) cooldownTicks--;
    }

    public void setCurrentHordeLevel(int level) {
        currentHordeLevel = level;
    }

    public int getCurrentHordeLevel() {
        return currentHordeLevel;
    }
}