package com.cartoonishvillain.coldsnaphorde;

import com.cartoonishvillain.coldsnaphorde.capabilities.IPlayerCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.capabilities.IWorldCapabilityManager;
import com.cartoonishvillain.coldsnaphorde.configs.CConfiguration;
import com.cartoonishvillain.coldsnaphorde.configs.ConfigHelper;
import com.cartoonishvillain.coldsnaphorde.configs.SConfiguration;
import com.cartoonishvillain.coldsnaphorde.events.Horde;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
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
import java.util.Calendar;
import java.util.Date;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("coldsnaphorde")
public class ColdSnapHorde
{
    public static Capability<IWorldCapabilityManager> WORLDCAPABILITYINSTANCE = null;
    public static Capability<IPlayerCapabilityManager> PLAYERCAPABILITYINSTANCE = null;

    public static final String MOD_ID = "coldsnaphorde";
    private static final Logger LOGGER = LogManager.getLogger();
    public static SConfiguration sconfig;
    public static CConfiguration cconfig;
    public static boolean isCalyxLoaded;
    public static boolean isInHolidayWindow;
    public static Horde Horde;

    public ColdSnapHorde() {
        // Register the setup method for modloading
        sconfig = ConfigHelper.register(ModConfig.Type.SERVER, SConfiguration::new);
        cconfig = ConfigHelper.register(ModConfig.Type.COMMON, CConfiguration::new);
        Register.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

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
        public ItemStack makeIcon() {return new ItemStack(Register.ROCKYSNOWBALL.get());}
    };

//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//        // some example code to dispatch IMC to another mod
//    }

//    private void processIMC(final InterModProcessEvent event)
//    {
//
//    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
@SubscribeEvent
public void onServerStarting(ServerStartingEvent event) {
    Horde = new Horde(event.getServer());

    for(ServerLevel serverWorld : event.getServer().getAllLevels()){
        serverWorld.getCapability(ColdSnapHorde.WORLDCAPABILITYINSTANCE).ifPresent(h->{
            if(h.getCooldownTicks() <= 0){h.setCooldownTicks(sconfig.GLOBALHORDECOOLDOWN.get() * 20);}
        });
    }

}

}
