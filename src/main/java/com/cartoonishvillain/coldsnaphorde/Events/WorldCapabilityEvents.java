package com.cartoonishvillain.coldsnaphorde.Events;

import com.cartoonishvillain.coldsnaphorde.Capabilities.WorldCapability;
import com.cartoonishvillain.coldsnaphorde.Capabilities.WorldCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldCapabilityEvents {
    @SubscribeEvent
    public static void worldRegister(AttachCapabilitiesEvent<Level> event){
        WorldCapabilityManager provider = new WorldCapabilityManager();
        event.addCapability(new ResourceLocation(ColdSnapHorde.MOD_ID, "hordecooldown"), provider);
    }

    @SubscribeEvent
    public static void worldTick(TickEvent.WorldTickEvent event){
        if (event.side == LogicalSide.SERVER && event.phase == TickEvent.Phase.START){
            event.world.getCapability(WorldCapability.INSTANCE).ifPresent(h->{
                if(h.getCooldownTicks() > 0){
                    h.addCooldownTicks(-1);
                }

                if(h.getCooldownTicks() < 0){
                    h.setCooldownTicks(0);
                }
            });
        }
    }
}
