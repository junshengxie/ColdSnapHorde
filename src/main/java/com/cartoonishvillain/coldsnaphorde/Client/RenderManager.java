package com.cartoonishvillain.coldsnaphorde.Client;

import com.cartoonishvillain.coldsnaphorde.Client.Renderers.*;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        // do something that can only be done on the client
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPSNOWBALLER.get(), RenderColdSnapSnowballer::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.GUNNERPROJECTILE.get(), new GunnerProjectileRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(Register.ROCKSNOWBALLPROJECTILE.get(), new RockySnowballRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(Register.SNOWIERSNOWBALLPROJECTILE.get(), new SnowierSnowballRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(Register.LIGHTNINGSNOWBALLPROJECTILE.get(), new LightningSnowballRenderFactory());
    }
}
