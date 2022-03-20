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
import com.cartoonishvillain.coldsnaphorde.events.HordeEventTier3;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
    public static HordeEventTier1 Horde;
    public static EntityHordeData defaultHordeData;

    public static ArrayList<String> presentPossibilities = new ArrayList<>();
    public static ArrayList<Float> presentWeights = new ArrayList<>();

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
    Horde = new HordeEventTier1(event.getServer());

    hordeDataManager = HordeDataManager.getInstance();

    hordeDataManager.setupHighestLevelBeaten(event.getServer());

    presentPossibilities.add("coal"); presentWeights.add(30f);
    presentPossibilities.add("snow"); presentWeights.add(15f);
    presentPossibilities.add("ice"); presentWeights.add(20f);
    presentPossibilities.add("packedice"); presentWeights.add(15f);
    presentPossibilities.add("blueice"); presentWeights.add(10f);
    presentPossibilities.add("doggo"); presentWeights.add(10f);
    presentPossibilities.add("cats"); presentWeights.add(10f);
    presentPossibilities.add("birb"); presentWeights.add(10f);
    presentPossibilities.add("friendsnowman"); presentWeights.add(10f);
    presentPossibilities.add("music"); presentWeights.add(15f);
    presentPossibilities.add("rollercoaster"); presentWeights.add(10f);
    presentPossibilities.add("horse"); presentWeights.add(10f);
    presentPossibilities.add("pig"); presentWeights.add(10f);
    presentPossibilities.add("candycane"); presentWeights.add(20f);
    presentPossibilities.add("axolotl"); presentWeights.add(10f);
    presentPossibilities.add("screamgoat"); presentWeights.add(5f);
    presentPossibilities.add("panda"); presentWeights.add(5f);
    presentPossibilities.add("icesword"); presentWeights.add(10f);
    presentPossibilities.add("transposerpiece"); presentWeights.add(10f);
    presentPossibilities.add("frostshard"); presentWeights.add(15f);
    presentPossibilities.add("transposer"); presentWeights.add(5f);
    presentPossibilities.add("frostcore"); presentWeights.add(5f);
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
