package com.villain.coldsnaphorde.events;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import com.villain.coldsnaphorde.Register;
import com.villain.coldsnaphorde.Utils;
import com.villain.coldsnaphorde.capabilities.IWorldCapabilityManager;
import com.villain.coldsnaphorde.capabilities.PlayerCapabilityManager;
import com.villain.coldsnaphorde.entities.mobs.basemob.*;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {

    public static CreativeModeTab HORDETAB;


    @SubscribeEvent
    public static void interModComms(InterModEnqueueEvent e){
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.CHARM.getMessageBuilder().build());
    }

    @SubscribeEvent
    public static void capabilityRegister(final RegisterCapabilitiesEvent event){
        event.register(IWorldCapabilityManager.class);
        event.register(PlayerCapabilityManager.class);
        ForgeColdSnapHorde.PLAYERCAPABILITYINSTANCE = CapabilityManager.get(new CapabilityToken<>() {});
        ForgeColdSnapHorde.WORLDCAPABILITYINSTANCE = CapabilityManager.get(new CapabilityToken<>() {});
    }

    @SubscribeEvent
    public static void effect(RegisterEvent event){
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
                SpawnPlacements.register(Register.COLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
                SpawnPlacements.register(Register.COLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
                SpawnPlacements.register(Register.COLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
                SpawnPlacements.register(Register.COLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
                SpawnPlacements.register(Register.COLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
                SpawnPlacements.register(Register.COLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
                SpawnPlacements.register(Register.NCOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.NCOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.NCOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.NCOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.NCOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.NCOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.ECOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.ECOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.ECOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.ECOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.ECOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.ECOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
                SpawnPlacements.register(Register.PCOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2Swamp);
                SpawnPlacements.register(Register.PCOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2Swamp);
                SpawnPlacements.register(Register.PCOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2Swamp);
                SpawnPlacements.register(Register.PCOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2Swamp);
                SpawnPlacements.register(Register.PCOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.   MOTION_BLOCKING_NO_LEAVES, Utils::tier2Swamp);
                SpawnPlacements.register(Register.PCOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2Swamp);
                SpawnPlacements.register(Register.COLDSNAPCOW.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::checkFrostyCow);
        });
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
