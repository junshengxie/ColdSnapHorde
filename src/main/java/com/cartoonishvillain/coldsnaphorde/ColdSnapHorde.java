package com.cartoonishvillain.coldsnaphorde;

import com.cartoonishvillain.coldsnaphorde.Capabilities.WorldCapability;
import com.cartoonishvillain.coldsnaphorde.Configs.CConfiguration;
import com.cartoonishvillain.coldsnaphorde.Configs.ConfigHelper;
import com.cartoonishvillain.coldsnaphorde.Configs.SConfiguration;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.*;
import com.cartoonishvillain.coldsnaphorde.Events.NewHorde;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.AddTopHatLayer;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("coldsnaphorde")
public class ColdSnapHorde
{
    public static final String MOD_ID = "coldsnaphorde";
    private static final Logger LOGGER = LogManager.getLogger();
    public static SConfiguration sconfig;
    public static CConfiguration cconfig;
    public static boolean isCalyxLoaded;
    public static NewHorde Horde;


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

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::StartTopHatLayer);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        WorldCapability.register();
        isCalyxLoaded = ModList.get().isLoaded("immortuoscalyx");

    }


    public static final ItemGroup TAB = new ItemGroup("ColdSnapHorde"){
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
    public void onServerStarting(FMLServerStartingEvent event) {
        Horde = new NewHorde(event.getServer());

        for(ServerWorld serverWorld : event.getServer().getAllLevels()){
            serverWorld.getCapability(WorldCapability.INSTANCE).ifPresent(h->{
                if(h.getCooldownTicks() <= 0){h.setCooldownTicks(sconfig.GLOBALHORDECOOLDOWN.get() * 20);}
            });
        }

    }


    public void StartTopHatLayer(FMLLoadCompleteEvent event){
        event.enqueueWork(() -> {
            if (FMLEnvironment.dist == Dist.CLIENT) AddTopHatLayer();
        });
    }


}
