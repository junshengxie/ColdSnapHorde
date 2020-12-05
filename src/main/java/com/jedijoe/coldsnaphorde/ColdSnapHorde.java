package com.jedijoe.coldsnaphorde;

import com.jedijoe.coldsnaphorde.Client.Renderers.*;
import com.jedijoe.coldsnaphorde.Entities.ColdSnapGunner;
import com.jedijoe.coldsnaphorde.Entities.ColdSnapSnowballer;
import com.jedijoe.coldsnaphorde.Entities.ColdSnapStabber;
import com.jedijoe.coldsnaphorde.Items.TopHat;
import net.minecraft.client.particle.BreakingParticle;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("coldsnaphorde")
public class ColdSnapHorde
{
    public static final String MOD_ID = "coldsnaphorde";
    private static final Logger LOGGER = LogManager.getLogger();

    public ColdSnapHorde() {
        // Register the setup method for modloading
        GeckoLib.initialize();
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
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(Register.COLDSNAPGUNNER.get(), ColdSnapGunner.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.COLDSNAPSTABBER.get(), ColdSnapStabber.customAttributes().create());
            GlobalEntityTypeAttributes.put(Register.COLDSNAPSNOWBALLER.get(), ColdSnapSnowballer.customAttributes().create());
        });

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
