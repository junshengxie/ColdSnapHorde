package com.cartoonishvillain.coldsnaphorde.Events;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapGunner;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapStabber;
import com.cartoonishvillain.coldsnaphorde.Entities.Spawns;
import com.cartoonishvillain.coldsnaphorde.Items.ColdSpawnEggItem;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {

    @SubscribeEvent
    public static void entityRegister(final RegistryEvent.Register<EntityType<?>> event){
        event.getRegistry().registerAll(
//                Register.COLDSNAPGUNNER.get(), Register.COLDSNAPSNOWBALLER.get(),
                        Register.COLDSNAPSTABBER.get()
//                        , Register.COLDSNAPZAPPER.get(),
//                        Register.COLDSNAPGIFTER.get(), Register.COLDSNAPBRAWLER.get()
                        );
        Spawns.PlacementManager();
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event){
        ColdSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void attributeAssigner(EntityAttributeCreationEvent event){
        event.put(Register.COLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().build());
        event.put(Register.COLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().build());

    }
}
