package com.cartoonishvillain.coldsnaphorde.Events;

import com.cartoonishvillain.coldsnaphorde.Capabilities.CooldownCapability;
import com.cartoonishvillain.coldsnaphorde.Capabilities.CooldownManager;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldCapabilityEvents {
    @SubscribeEvent
    public static void worldRegister(AttachCapabilitiesEvent<World> event){
        CooldownManager provider = new CooldownManager();
        event.addCapability(new ResourceLocation(ColdSnapHorde.MOD_ID, "hordecooldown"), provider);
    }

    @SubscribeEvent
    public static void worldTick(TickEvent.WorldTickEvent event){
        if (event.side == LogicalSide.SERVER && event.phase == TickEvent.Phase.START){
            event.world.getCapability(CooldownCapability.INSTANCE).ifPresent(h->{
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
