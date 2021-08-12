package com.cartoonishvillain.coldsnaphorde.Client;

import com.cartoonishvillain.coldsnaphorde.Client.Renderers.EndRenderers.RenderEndColdSnapSnowballer;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenderers.*;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenderers.*;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.misc.TopHatRenderer;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.projectiles.GenericProjectileRenderFactory;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Items.Armor.TopHat;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        // do something that can only be done on the client
        RenderingRegistry.registerEntityRenderingHandler(Register.GUNNERPROJECTILE.get(), new GenericProjectileRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(Register.ROCKSNOWBALLPROJECTILE.get(), new GenericProjectileRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(Register.SNOWIERSNOWBALLPROJECTILE.get(), new GenericProjectileRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(Register.LIGHTNINGSNOWBALLPROJECTILE.get(), new GenericProjectileRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(Register.THROWNCHORUSPROJECTILE.get(), new GenericProjectileRenderFactory());
        GeoArmorRenderer.registerArmorRenderer(TopHat.class, new TopHatRenderer());

        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPSTABBER.get(), RenderColdSnapStabber::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPSNOWBALLER.get(), RenderColdSnapSnowballer::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);

        RenderingRegistry.registerEntityRenderingHandler(Register.ECOLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.ECOLDSNAPSTABBER.get(), RenderColdSnapStabber::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.ECOLDSNAPSNOWBALLER.get(), RenderEndColdSnapSnowballer::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.ECOLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.ECOLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.ECOLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);

        RenderingRegistry.registerEntityRenderingHandler(Register.NCOLDSNAPGUNNER.get(), RenderNetherColdSnapGunner::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.NCOLDSNAPSTABBER.get(), RenderNetherColdSnapStabber::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.NCOLDSNAPSNOWBALLER.get(), RenderNetherColdSnapSnowballer::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.NCOLDSNAPGIFTER.get(), RenderNetherColdSnapGifter::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.NCOLDSNAPZAPPER.get(), RenderNetherColdSnapZapper::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.NCOLDSNAPBRAWLER.get(), RenderNetherColdSnapBrawler::new);

        RenderingRegistry.registerEntityRenderingHandler(Register.PCOLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.PCOLDSNAPSTABBER.get(), RenderColdSnapStabber::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.PCOLDSNAPSNOWBALLER.get(), RenderColdSnapSnowballer::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.PCOLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.PCOLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
        RenderingRegistry.registerEntityRenderingHandler(Register.PCOLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);
    }
}
