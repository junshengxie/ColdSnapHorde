package com.villain.coldsnaphorde;

import com.cartoonishvillain.cartoonishhorde.EntityHordeData;
import com.villain.coldsnaphorde.capabilities.IPlayerCapabilityManager;
import com.villain.coldsnaphorde.capabilities.IWorldCapabilityManager;
import com.villain.coldsnaphorde.configs.CConfiguration;
import com.villain.coldsnaphorde.configs.ClientConfig;
import com.villain.coldsnaphorde.configs.ConfigHelper;
import com.villain.coldsnaphorde.configs.SConfiguration;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapGunner;
import com.villain.coldsnaphorde.events.HordeEventTier1;
import com.villain.coldsnaphorde.events.HordeEventTier2;
import com.villain.coldsnaphorde.events.HordeEventTier3;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@Mod(Constants.MOD_ID)
public class ForgeColdSnapHorde {

    public static Capability<IWorldCapabilityManager> WORLDCAPABILITYINSTANCE = null;
    public static Capability<IPlayerCapabilityManager> PLAYERCAPABILITYINSTANCE = null;
    public static ArrayList<Item> TOPHATS = new ArrayList<>();

    public static SConfiguration sconfig;
    public static CConfiguration cconfig;
    public static ClientConfig clientConfig;
    public static HordeEventTier1 hordeTier1;
    public static HordeEventTier2 hordeTier2;
    public static HordeEventTier3 hordeTier3;
    public static EntityHordeData defaultHordeData;
    public static HordeDataManager hordeDataManager = null;

    public ForgeColdSnapHorde() {
        CommonColdSnapHorde.init();
        Register.init();
        clientConfig = ConfigHelper.register(ModConfig.Type.CLIENT, ClientConfig::new);
        sconfig = ConfigHelper.register(ModConfig.Type.SERVER, SConfiguration::new);
        cconfig = ConfigHelper.register(ModConfig.Type.COMMON, CConfiguration::new);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        defaultHordeData = new EntityHordeData(3, 0.5D, 1, Register.COLDSNAPGUNNER.get(), ColdSnapGunner.class);
        hordeTier1 = new HordeEventTier1(event.getServer());
        hordeTier2 = new HordeEventTier2(event.getServer());
        hordeTier3 = new HordeEventTier3(event.getServer());

        hordeDataManager = HordeDataManager.getInstance();

        hordeDataManager.setupHighestLevelBeaten(event.getServer());
    }

}