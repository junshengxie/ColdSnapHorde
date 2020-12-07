package com.jedijoe.coldsnaphorde.Events;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Entities.Spawns;
import com.jedijoe.coldsnaphorde.Register;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {

    @SubscribeEvent
    public static void entityRegister(final RegistryEvent.Register<EntityType<?>> event){
        event.getRegistry().registerAll(Register.COLDSNAPGUNNER.get(), Register.COLDSNAPSNOWBALLER.get(), Register.COLDSNAPSTABBER.get());
        Spawns.PlacementManager();
    }
}
