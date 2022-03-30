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

    public static ArrayList<String> tier1PresentPossibilities = new ArrayList<>();
    public static ArrayList<Float> tier1PresentWeights = new ArrayList<>();
    public static ArrayList<String> tier2PresentPossibilities = new ArrayList<>();
    public static ArrayList<Float> tier2PresentWeights = new ArrayList<>();
    public static ArrayList<String> tier3PresentPossibilities = new ArrayList<>();
    public static ArrayList<Float> tier3PresentWeights = new ArrayList<>();

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
    
    tier1PresentPossibilities.add("coal"); tier1PresentWeights.add(15f);
    tier1PresentPossibilities.add("snow"); tier1PresentWeights.add(15f);
    tier1PresentPossibilities.add("ice"); tier1PresentWeights.add(20f);
    tier1PresentPossibilities.add("packedice"); tier1PresentWeights.add(15f);
    tier1PresentPossibilities.add("blueice"); tier1PresentWeights.add(5f);
    tier1PresentPossibilities.add("candycane"); tier1PresentWeights.add(20f);
    tier1PresentPossibilities.add("iceshard"); tier1PresentWeights.add(10f);

    tier2PresentPossibilities.add("coal"); tier2PresentWeights.add(30f);
    tier2PresentPossibilities.add("snow"); tier2PresentWeights.add(15f);
    tier2PresentPossibilities.add("ice"); tier2PresentWeights.add(20f);
    tier2PresentPossibilities.add("packedice"); tier2PresentWeights.add(15f);
    tier2PresentPossibilities.add("blueice"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("doggo"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("cats"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("birb"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("friendsnowman"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("music"); tier2PresentWeights.add(15f);
    tier2PresentPossibilities.add("rollercoaster"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("horse"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("pig"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("candycane"); tier2PresentWeights.add(20f);
    tier2PresentPossibilities.add("axolotl"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("screamgoat"); tier2PresentWeights.add(5f);
    tier2PresentPossibilities.add("panda"); tier2PresentWeights.add(5f);
    tier2PresentPossibilities.add("icesword"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("transposerpiece"); tier2PresentWeights.add(10f);
    tier2PresentPossibilities.add("iceshard"); tier2PresentWeights.add(15f);
    tier2PresentPossibilities.add("transposer"); tier2PresentWeights.add(5f);
    tier2PresentPossibilities.add("frostcore"); tier2PresentWeights.add(5f);

    tier3PresentPossibilities.add("blueice"); tier3PresentWeights.add(20f);
    tier3PresentPossibilities.add("doggo"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("cats"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("birb"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("friendsnowman"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("music"); tier3PresentWeights.add(15f);
    tier3PresentPossibilities.add("rollercoaster"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("horse"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("pig"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("candycane"); tier3PresentWeights.add(20f);
    tier3PresentPossibilities.add("axolotl"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("screamgoat"); tier3PresentWeights.add(5f);
    tier3PresentPossibilities.add("panda"); tier3PresentWeights.add(5f);
    tier3PresentPossibilities.add("icesword"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("transposerpiece"); tier3PresentWeights.add(10f);
    tier3PresentPossibilities.add("iceshard"); tier3PresentWeights.add(15f);
    tier3PresentPossibilities.add("transposer"); tier3PresentWeights.add(5f);
    tier3PresentPossibilities.add("frostcore"); tier3PresentWeights.add(10f); //TODO: add ice core loot item, make it weight 1
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
