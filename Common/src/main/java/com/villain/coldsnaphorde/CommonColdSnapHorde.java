package com.villain.coldsnaphorde;

import com.villain.coldsnaphorde.platform.Services;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import java.time.Instant;
import java.util.*;

public class CommonColdSnapHorde {

    // This method serves as an initialization hook for the mod. The vanilla
    // game has no mechanism to load tooltip listeners so this must be
    // invoked from a mod loader specific project like Forge or Fabric.


    public static boolean isCalyxLoaded;
    public static boolean isInHolidayWindow;
    public static HashMap<String, Float> tier1PresentPossibilities = new HashMap<>();
    public static HashMap<String, Float> tier2PresentPossibilities = new HashMap<>();
    public static HashMap<String, Float> tier3PresentPossibilities = new HashMap<>();
    public static void init() {
        isCalyxLoaded = Services.PLATFORM.isModLoaded("immortuoscalyx") && Services.PLATFORM.PLAGUEIMMORTUOSCOMPAT();
        holidayWindowCheck();

        tier1PresentPossibilities.put("coal", 15f);
        tier1PresentPossibilities.put("snow", 15f);
        tier1PresentPossibilities.put("ice", 20f);
        tier1PresentPossibilities.put("packedice", 15f);
        tier1PresentPossibilities.put("blueice", 5f);
        tier1PresentPossibilities.put("candycane", 20f);
        tier1PresentPossibilities.put("iceshard", 10f);

        tier2PresentPossibilities.put("coal", 30f);
        tier2PresentPossibilities.put("snow", 15f);
        tier2PresentPossibilities.put("ice", 20f);
        tier2PresentPossibilities.put("packedice", 15f);
        tier2PresentPossibilities.put("blueice", 10f);
        tier2PresentPossibilities.put("doggo", 10f);
        tier2PresentPossibilities.put("cats", 10f);
        tier2PresentPossibilities.put("birb", 10f);
        tier2PresentPossibilities.put("friendsnowman", 10f);
        tier2PresentPossibilities.put("music", 15f);
        tier2PresentPossibilities.put("rollercoaster", 10f);
        tier2PresentPossibilities.put("horse", 10f);
        tier2PresentPossibilities.put("pig", 10f);
        tier2PresentPossibilities.put("candycane", 20f);
        tier2PresentPossibilities.put("axolotl", 10f);
        tier2PresentPossibilities.put("screamgoat", 5f);
        tier2PresentPossibilities.put("panda", 5f);
        tier2PresentPossibilities.put("icesword", 10f);
        tier2PresentPossibilities.put("transposerpiece", 10f);
        tier2PresentPossibilities.put("iceshard", 15f);
        tier2PresentPossibilities.put("transposer", 5f);
        tier2PresentPossibilities.put("frostcore", 5f);

        tier3PresentPossibilities.put("blueice", 10f);
        tier3PresentPossibilities.put("doggo", 10f);
        tier3PresentPossibilities.put("cats", 10f);
        tier3PresentPossibilities.put("birb", 10f);
        tier3PresentPossibilities.put("friendsnowman", 10f);
        tier3PresentPossibilities.put("music", 15f);
        tier3PresentPossibilities.put("rollercoaster", 10f);
        tier3PresentPossibilities.put("horse", 10f);
        tier3PresentPossibilities.put("pig", 10f);
        tier3PresentPossibilities.put("candycane", 20f);
        tier3PresentPossibilities.put("axolotl", 10f);
        tier3PresentPossibilities.put("screamgoat", 5f);
        tier3PresentPossibilities.put("panda", 5f);
        tier3PresentPossibilities.put("icesword", 10f);
        tier3PresentPossibilities.put("transposerpiece", 10f);
        tier3PresentPossibilities.put("iceshard", 15f);
        tier3PresentPossibilities.put("transposer", 5f);
        tier3PresentPossibilities.put("frostcore", 10f);
    }

    public static void holidayWindowCheck(){
        Date date = Date.from(Instant.now());
        Date december = Date.from(Instant.now());
        december.setMonth(Calendar.DECEMBER);
        december.setDate(15);
        december.setHours(0);
        december.setMinutes(0);
        if(date.getMonth() == Calendar.JANUARY){
            december.setYear(december.getYear()-1);
        }
        Date January = Date.from(Instant.now());
        January.setMonth(Calendar.JANUARY);
        January.setDate(5);
        January.setHours(0);
        January.setMinutes(0);
        if(date.getMonth() != Calendar.JANUARY){
            January.setYear(January.getYear() + 1);
        }
        isInHolidayWindow = ((date.compareTo(december) >= 0) && (date.compareTo(January) <= 0));
    }

    public static void PlayerJoin(Player player) {
        if(isInHolidayWindow){
            player.sendMessage(new TranslatableComponent("info.coldsnaphorde.holiday").withStyle(ChatFormatting.AQUA), UUID.randomUUID());
        }
    }

    public static void giveAdvancement(ServerPlayer player, MinecraftServer server, ResourceLocation advancementResource){
        Advancement advancement = server.getAdvancements().getAdvancement(advancementResource);
        if(advancement != null) {
            AdvancementProgress advancementprogress = player.getAdvancements().getOrStartProgress(advancement);
            if (!advancementprogress.isDone()) {
                for(String s : advancementprogress.getRemainingCriteria()) {
                    player.getAdvancements().award(advancement, s);
                }
            }
        }
    }
}