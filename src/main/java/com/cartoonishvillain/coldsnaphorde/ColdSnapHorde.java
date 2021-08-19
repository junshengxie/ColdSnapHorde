package com.cartoonishvillain.coldsnaphorde;

import com.cartoonishvillain.coldsnaphorde.Capabilities.CooldownCapability;
import com.cartoonishvillain.coldsnaphorde.Configs.CConfiguration;
import com.cartoonishvillain.coldsnaphorde.Configs.ConfigHelper;
import com.cartoonishvillain.coldsnaphorde.Configs.SConfiguration;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
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
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(Register.COLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.COLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.COLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.COLDSNAPGIFTER.get(), ColdSnapSnowballer.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.COLDSNAPZAPPER.get(), ColdSnapZapper.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.COLDSNAPBRAWLER.get(), ColdSnapBrawler.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.PCOLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.PCOLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.PCOLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.PCOLDSNAPGIFTER.get(), ColdSnapSnowballer.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.PCOLDSNAPZAPPER.get(), ColdSnapZapper.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.PCOLDSNAPBRAWLER.get(), ColdSnapBrawler.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.NCOLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.NCOLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.NCOLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.NCOLDSNAPGIFTER.get(), ColdSnapSnowballer.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.NCOLDSNAPZAPPER.get(), ColdSnapZapper.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.NCOLDSNAPBRAWLER.get(), ColdSnapBrawler.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.ECOLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.ECOLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.ECOLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.ECOLDSNAPGIFTER.get(), ColdSnapSnowballer.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.ECOLDSNAPZAPPER.get(), ColdSnapZapper.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.ECOLDSNAPBRAWLER.get(), ColdSnapBrawler.customAttributes().create());
        });
        isCalyxLoaded = ModList.get().isLoaded("immortuoscalyx");

    }


    public static final ItemGroup TAB = new ItemGroup("ColdSnapHorde"){
        @Override
        public ItemStack createIcon() {return new ItemStack(Register.ROCKYSNOWBALL.get());}
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
