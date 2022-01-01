package com.cartoonishvillain.coldsnaphorde.events;

import com.cartoonishvillain.coldsnaphorde.capabilities.IPlayerCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.capabilities.IWorldCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.capabilities.PlayerCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.basemob.*;
import com.cartoonishvillain.coldsnaphorde.entities.Spawns;
import com.cartoonishvillain.coldsnaphorde.items.ColdSpawnEggItem;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {

    @SubscribeEvent
    public static void capabilityRegister(final RegisterCapabilitiesEvent event){
        event.register(IWorldCapabilityManager.class);
        event.register(PlayerCapabilityManager.class);
        ColdSnapHorde.PLAYERCAPABILITYINSTANCE = CapabilityManager.get(new CapabilityToken<IPlayerCapabilityManager>() {});
        ColdSnapHorde.WORLDCAPABILITYINSTANCE = CapabilityManager.get(new CapabilityToken<IWorldCapabilityManager>() {});
    }

    @SubscribeEvent
    public static void entityRegister(final RegistryEvent.Register<EntityType<?>> event){
        Spawns.PlacementManager();
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event){
        ColdSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void itemRegister(final RegistryEvent.Register<Item> event){
        ColdSnapHorde.TOPHATS = new ArrayList<>(List.of(Register.TOPHAT.get(), Register.REDTOPHAT.get(), Register.BLUETOPHAT.get(), Register.GREENTOPHAT.get(), Register.PURPLETOPHAT.get()));
    }

    @SubscribeEvent
    public static void attributeAssigner(EntityAttributeCreationEvent event){
        event.put(Register.COLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().build());
        event.put(Register.COLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().build());
        event.put(Register.COLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().build());
        event.put(Register.COLDSNAPGIFTER.get(), ColdSnapGifter.customAttributes().build());
        event.put(Register.COLDSNAPZAPPER.get(), ColdSnapZapper.customAttributes().build());
        event.put(Register.COLDSNAPBRAWLER.get(), ColdSnapBrawler.customAttributes().build());
        event.put(Register.COLDSNAPCOW.get(), ColdSnapCow.customAttributes().build());

        event.put(Register.PCOLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().build());
        event.put(Register.PCOLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().build());
        event.put(Register.PCOLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().build());
        event.put(Register.PCOLDSNAPGIFTER.get(), ColdSnapGifter.customAttributes().build());
        event.put(Register.PCOLDSNAPZAPPER.get(), ColdSnapZapper.customAttributes().build());
        event.put(Register.PCOLDSNAPBRAWLER.get(), ColdSnapBrawler.customAttributes().build());

        event.put(Register.NCOLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().build());
        event.put(Register.NCOLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().build());
        event.put(Register.NCOLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().build());
        event.put(Register.NCOLDSNAPGIFTER.get(), ColdSnapGifter.customAttributes().build());
        event.put(Register.NCOLDSNAPZAPPER.get(), ColdSnapZapper.customAttributes().build());
        event.put(Register.NCOLDSNAPBRAWLER.get(), ColdSnapBrawler.customAttributes().build());

        event.put(Register.ECOLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().build());
        event.put(Register.ECOLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().build());
        event.put(Register.ECOLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().build());
        event.put(Register.ECOLDSNAPGIFTER.get(), ColdSnapGifter.customAttributes().build());
        event.put(Register.ECOLDSNAPZAPPER.get(), ColdSnapZapper.customAttributes().build());
        event.put(Register.ECOLDSNAPBRAWLER.get(), ColdSnapBrawler.customAttributes().build());

    }

}
