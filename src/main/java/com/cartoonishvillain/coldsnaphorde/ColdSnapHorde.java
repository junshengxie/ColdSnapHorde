package com.cartoonishvillain.coldsnaphorde;

import com.cartoonishvillain.cartoonishhorde.EntityHordeData;
import com.cartoonishvillain.coldsnaphorde.capabilities.IPlayerCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.capabilities.IWorldCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.configs.CConfiguration;
import com.cartoonishvillain.coldsnaphorde.configs.ClientConfig;
import com.cartoonishvillain.coldsnaphorde.configs.ConfigHelper;
import com.cartoonishvillain.coldsnaphorde.configs.SConfiguration;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.basemob.ColdSnapGunner;
import com.cartoonishvillain.coldsnaphorde.events.HordeEventTier1;
import com.cartoonishvillain.coldsnaphorde.events.HordeEventTier2;
import com.cartoonishvillain.coldsnaphorde.events.HordeEventTier3;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("coldsnaphorde")
public class ColdSnapHorde
{
    public static Capability<IWorldCapabilityManager> WORLDCAPABILITYINSTANCE = null;
    public static Capability<IPlayerCapabilityManager> PLAYERCAPABILITYINSTANCE = null;
    public static ArrayList<Item> TOPHATS = new ArrayList<>();

    public static final String MOD_ID = "coldsnaphorde";
    private static final Logger LOGGER = LogManager.getLogger();
    public static SConfiguration sconfig;
    public static CConfiguration cconfig;
    public static ClientConfig clientConfig;
    public static boolean isCalyxLoaded;
    public static boolean isInHolidayWindow;
    public static HordeEventTier1 hordeTier1;
    public static HordeEventTier2 hordeTier2;
    public static HordeEventTier3 hordeTier3;
    public static EntityHordeData defaultHordeData;

    public static HashMap<String, Float> tier1PresentPossibilities = new HashMap<>();
    public static HashMap<String, Float> tier2PresentPossibilities = new HashMap<>();
    public static HashMap<String, Float> tier3PresentPossibilities = new HashMap<>();

    public static HordeDataManager hordeDataManager = null;

    public ColdSnapHorde() {
        // Register the setup method for modloading
        clientConfig = ConfigHelper.register(ModConfig.Type.CLIENT, ClientConfig::new);
        sconfig = ConfigHelper.register(ModConfig.Type.SERVER, SConfiguration::new);
        cconfig = ConfigHelper.register(ModConfig.Type.COMMON, CConfiguration::new);
        Register.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        isCalyxLoaded = ModList.get().isLoaded("immortuoscalyx");
        Date date = Date.from(Instant.now());
        Date december = Date.from(Instant.now());
        december.setMonth(Calendar.DECEMBER);
        december.setDate(15);
        december.setHours(0);
        december.setMinutes(0);
        if(date.getMonth() == Calendar.JANUARY){
            december.setYear(december.getYear()-1);
        }
        Date January = Date.from(Instant.now());
        January.setMonth(Calendar.JANUARY);
        January.setDate(5);
        January.setHours(0);
        January.setMinutes(0);
        if(date.getMonth() != Calendar.JANUARY){
            January.setYear(January.getYear() + 1);
        }
        isInHolidayWindow = ((date.compareTo(december) >= 0) && (date.compareTo(January) <= 0));
        LOGGER.debug(isInHolidayWindow);
    }


    public static final CreativeModeTab TAB = new CreativeModeTab("ColdSnapHorde"){
        @Override
        public ItemStack makeIcon() {return new ItemStack(Register.SNOWGLOBE.get());}
    };

@SubscribeEvent
public void onServerStarting(ServerStartingEvent event) {
    defaultHordeData = new EntityHordeData(3, 0.5D, 1, Register.COLDSNAPGUNNER.get(), ColdSnapGunner.class);
    hordeTier1 = new HordeEventTier1(event.getServer());
    hordeTier2 = new HordeEventTier2(event.getServer());
    hordeTier3 = new HordeEventTier3(event.getServer());

    hordeDataManager = HordeDataManager.getInstance();

    hordeDataManager.setupHighestLevelBeaten(event.getServer());

    tier1PresentPossibilities.put("coal", 15f);
    tier1PresentPossibilities.put("snow", 15f);
    tier1PresentPossibilities.put("ice", 20f);
    tier1PresentPossibilities.put("packedice", 15f);
    tier1PresentPossibilities.put("blueice", 5f);
    tier1PresentPossibilities.put("candycane", 20f);
    tier1PresentPossibilities.put("iceshard", 10f);

    tier2PresentPossibilities.put("coal", 30f);
    tier2PresentPossibilities.put("snow", 15f);
    tier2PresentPossibilities.put("ice", 20f);
    tier2PresentPossibilities.put("packedice", 15f);
    tier2PresentPossibilities.put("blueice", 10f);
    tier2PresentPossibilities.put("doggo", 10f);
    tier2PresentPossibilities.put("cats", 10f);
    tier2PresentPossibilities.put("birb", 10f);
    tier2PresentPossibilities.put("friendsnowman", 10f);
    tier2PresentPossibilities.put("music", 15f);
    tier2PresentPossibilities.put("rollercoaster", 10f);
    tier2PresentPossibilities.put("horse", 10f);
    tier2PresentPossibilities.put("pig", 10f);
    tier2PresentPossibilities.put("candycane", 20f);
    tier2PresentPossibilities.put("axolotl", 10f);
    tier2PresentPossibilities.put("screamgoat", 5f);
    tier2PresentPossibilities.put("panda", 5f);
    tier2PresentPossibilities.put("icesword", 10f);
    tier2PresentPossibilities.put("transposerpiece", 10f);
    tier2PresentPossibilities.put("iceshard", 15f);
    tier2PresentPossibilities.put("transposer", 5f);
    tier2PresentPossibilities.put("frostcore", 5f);

    tier3PresentPossibilities.put("blueice", 10f);
    tier3PresentPossibilities.put("doggo", 10f);
    tier3PresentPossibilities.put("cats", 10f);
    tier3PresentPossibilities.put("birb", 10f);
    tier3PresentPossibilities.put("friendsnowman", 10f);
    tier3PresentPossibilities.put("music", 15f);
    tier3PresentPossibilities.put("rollercoaster", 10f);
    tier3PresentPossibilities.put("horse", 10f);
    tier3PresentPossibilities.put("pig", 10f);
    tier3PresentPossibilities.put("candycane", 20f);
    tier3PresentPossibilities.put("axolotl", 10f);
    tier3PresentPossibilities.put("screamgoat", 5f);
    tier3PresentPossibilities.put("panda", 5f);
    tier3PresentPossibilities.put("icesword", 10f);
    tier3PresentPossibilities.put("transposerpiece", 10f);
    tier3PresentPossibilities.put("iceshard", 15f);
    tier3PresentPossibilities.put("transposer", 5f);
    tier3PresentPossibilities.put("frostcore", 10f);
}

    public static void giveAdvancement(ServerPlayer player, MinecraftServer server, ResourceLocation advancementResource) {
        if (player != null) {
            Advancement advancement = server.getAdvancements().getAdvancement(advancementResource);
            if (advancement != null) {
                AdvancementProgress advancementprogress = player.getAdvancements().getOrStartProgress(advancement);
                if (!advancementprogress.isDone()) {
                    for (String s : advancementprogress.getRemainingCriteria()) {
                        player.getAdvancements().award(advancement, s);
                    }
                }
            }
        }
    }
}
