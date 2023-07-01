package com.villain.coldsnaphorde.events;


import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import com.villain.coldsnaphorde.capabilities.IPlayerCapabilityManager;
import com.villain.coldsnaphorde.capabilities.PlayerCapabilityManager;
import com.villain.coldsnaphorde.capabilities.WorldCapabilityManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityEvents {
    @SubscribeEvent
    public static void worldRegister(AttachCapabilitiesEvent<Level> event){
        WorldCapabilityManager provider = new WorldCapabilityManager();
        event.addCapability(new ResourceLocation(Constants.MOD_ID, "hordecooldown"), provider);
    }

    @SubscribeEvent
    public static void playerCooldownTick(TickEvent.PlayerTickEvent event){
        if(event.phase == TickEvent.Phase.END && !event.player.level().isClientSide){
            event.player.getCapability(ForgeColdSnapHorde.PLAYERCAPABILITYINSTANCE).ifPresent(IPlayerCapabilityManager::tickCooldown);
        }
    }

    @SubscribeEvent
    public static void playerRegister(AttachCapabilitiesEvent<Entity> event){
        PlayerCapabilityManager provider = new PlayerCapabilityManager();
        event.addCapability(new ResourceLocation(Constants.MOD_ID, "plaguecooldown"), provider);
    }

    @SubscribeEvent
    public static void worldTick(TickEvent.ServerTickEvent event){
        if (event.phase == TickEvent.Phase.END) {
            ForgeColdSnapHorde.hordeDataManager.tickCooldown();
            ForgeColdSnapHorde.hordeTier1.tick();
            ForgeColdSnapHorde.hordeTier2.tick();
            ForgeColdSnapHorde.hordeTier3.tick();
        }
    }
}
