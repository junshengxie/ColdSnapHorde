package com.cartoonishvillain.coldsnaphorde;

import com.cartoonishvillain.coldsnaphorde.Capabilities.CooldownCapability;
import com.cartoonishvillain.coldsnaphorde.Configs.CConfiguration;
import com.cartoonishvillain.coldsnaphorde.Configs.ConfigHelper;
import com.cartoonishvillain.coldsnaphorde.Configs.SConfiguration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("coldsnaphorde")
public class ColdSnapHorde
{
    public static final String MOD_ID = "coldsnaphorde";
    private static final Logger LOGGER = LogManager.getLogger();
    public static SConfiguration sconfig;
    public static CConfiguration cconfig;
    public static boolean isCalyxLoaded;

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
        CooldownCapability.register();
        isCalyxLoaded = ModList.get().isLoaded("immortuoscalyx");
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
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
//
//    }

}
