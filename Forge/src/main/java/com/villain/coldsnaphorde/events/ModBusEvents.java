package com.villain.coldsnaphorde.events;

import com.villain.coldsnaphorde.*;
import com.villain.coldsnaphorde.capabilities.IWorldCapabilityManager;
import com.villain.coldsnaphorde.capabilities.PlayerCapabilityManager;
import com.villain.coldsnaphorde.entities.mobs.basemob.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.event.CreativeModeTabEvent;
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
    public static void registerTab(CreativeModeTabEvent.Register event) {
        HORDETAB = event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "coldsnaphordetab"), builder -> builder
                .icon(() -> new ItemStack(Register.SNOWGLOBE.get()))
                .title(Component.translatable("itemGroup.ColdSnapHorde"))
                .displayItems((featureFlags, output) -> {
                    output.accept(Register.TOPHAT.get());
                    output.accept(Register.REDTOPHAT.get());
                    output.accept(Register.BLUETOPHAT.get());
                    output.accept(Register.GREENTOPHAT.get());
                    output.accept(Register.PURPLETOPHAT.get());
                    output.accept(Register.THERMOMETER.get());
                    output.accept(Register.ROCKYSNOWBALL.get());
                    output.accept(Register.SNOWIERSNOWBALL.get());
                    output.accept(Register.LESSERHEALINGBALL.get());
                    output.accept(Register.HEALINGBALL.get());
                    output.accept(Register.GREATERHEALINGBALL.get());
                    output.accept(Register.LIGHTNINGSNOWBALL.get());
                    output.accept(Register.LIGHTNINGTRANSPOSER.get());
                    output.accept(Register.SNOWGLOBE.get());
                    output.accept(Register.FROSTEDSNOWGLOBE.get());
                    output.accept(Register.FROZENSNOWGLOBE.get());
                    output.accept(Register.SMALLPRESENT.get());
                    output.accept(Register.PRESENT.get());
                    output.accept(Register.LARGEPRESENT.get());
                    output.accept(Register.ICICLE.get());
                    output.accept(Register.ICESWORD.get());
                    output.accept(Register.SNOWWALLCHARM.get());
                    output.accept(Register.GLACIERWALLCHARM.get());
                    output.accept(Register.REINFOCEDGLACIERCHARM.get());
                    output.accept(Register.FROSTCHARM.get());
                    output.accept(Register.ARCTICCHARM.get());
                    output.accept(Register.ICESTAFF.get());
                    output.accept(Register.GLACIERSTAFF.get());
                    output.accept(Register.WANDOFTHEFROSTWALKER.get());
                    output.accept(Register.STAFFOFICEFROSTWALKER.get());
                    output.accept(Register.NOVEMBERSNOWDISC.get());
                    output.accept(Register.ARCTICBEATDISC.get());
                    output.accept(Register.ICESHARD.get());
                    output.accept(Register.FROSTESSENCE.get());
                    output.accept(Register.FROSTCORE.get());
                    output.accept(Register.ICEESSENCE.get());
                    output.accept(Register.ICECORE.get());
                    output.accept(Register.COWSPAWN.get());
                    output.accept(Register.GUNNERSPAWN.get());
                    output.accept(Register.STABBERSPAWN.get());
                    output.accept(Register.SNOWBALLERSPAWN.get());
                    output.accept(Register.GIFTERSPAWN.get());
                    output.accept(Register.ZAPPERSPAWN.get());
                    output.accept(Register.BRAWLERPAWN.get());
                    output.accept(Register.PGUNNERSPAWN.get());
                    output.accept(Register.PSTABBERSPAWN.get());
                    output.accept(Register.PSNOWBALLERSPAWN.get());
                    output.accept(Register.PGIFTERSPAWN.get());
                    output.accept(Register.PZAPPERSPAWN.get());
                    output.accept(Register.PBRAWLERPAWN.get());
                    output.accept(Register.NGUNNERSPAWN.get());
                    output.accept(Register.NSTABBERSPAWN.get());
                    output.accept(Register.NSNOWBALLERSPAWN.get());
                    output.accept(Register.NGIFTERSPAWN.get());
                    output.accept(Register.NZAPPERSPAWN.get());
                    output.accept(Register.NBRAWLERPAWN.get());
                    output.accept(Register.EGUNNERSPAWN.get());
                    output.accept(Register.ESTABBERSPAWN.get());
                    output.accept(Register.ESNOWBALLERSPAWN.get());
                    output.accept(Register.EGIFTERSPAWN.get());
                    output.accept(Register.EZAPPERSPAWN.get());
                    output.accept(Register.EBRAWLERPAWN.get());
                }));
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
