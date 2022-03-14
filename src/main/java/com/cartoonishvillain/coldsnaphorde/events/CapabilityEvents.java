package com.cartoonishvillain.coldsnaphorde.events;

import com.cartoonishvillain.coldsnaphorde.capabilities.IPlayerCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.capabilities.PlayerCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.capabilities.WorldCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityEvents {
    @SubscribeEvent
    public static void worldRegister(AttachCapabilitiesEvent<Level> event){
        WorldCapabilityManager provider = new WorldCapabilityManager();
        event.addCapability(new ResourceLocation(ColdSnapHorde.MOD_ID, "hordecooldown"), provider);
    }

    @SubscribeEvent
    public static void playerCooldownTick(TickEvent.PlayerTickEvent event){
        if(event.phase == TickEvent.Phase.END && !event.player.level.isClientSide){
            event.player.getCapability(ColdSnapHorde.PLAYERCAPABILITYINSTANCE).ifPresent(IPlayerCapabilityManager::tickCooldown);
        }
    }

    @SubscribeEvent
    public static void playerRegister(AttachCapabilitiesEvent<Entity> event){
        PlayerCapabilityManager provider = new PlayerCapabilityManager();
        event.addCapability(new ResourceLocation(ColdSnapHorde.MOD_ID, "plaguecooldown"), provider);
    }

    @SubscribeEvent
    public static void worldTick(TickEvent.WorldTickEvent event){
        if (event.side == LogicalSide.SERVER && event.phase == TickEvent.Phase.START){
            ColdSnapHorde.hordeDataManager.tickCooldown();
            ColdSnapHorde.Horde.tick();
        }
    }
}
