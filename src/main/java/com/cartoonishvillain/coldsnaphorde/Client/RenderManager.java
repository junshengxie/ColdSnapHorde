package com.cartoonishvillain.coldsnaphorde.Client;

import com.cartoonishvillain.coldsnaphorde.Client.Models.*;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.*;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {

    public static ModelLayerLocation COLDSNAPSTABBER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:stabber"), "stabber");
    public static ModelLayerLocation COLDSNAPGUNNER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:gunner"), "gunner");
    public static ModelLayerLocation COLDSNAPSNOWBALLER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:snowballer"), "snowballer");
    public static ModelLayerLocation COLDSNAPGIFTER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:gifter"), "gifter");
    public static ModelLayerLocation COLDSNAPZAPPER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:zapper"), "zapper");
    public static ModelLayerLocation COLDSNAPBRAWLER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:brawler"), "brawler");



    @SubscribeEvent
    public static void registerlayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(COLDSNAPSTABBER, ColdSnapStabberModel::createLayer);
        event.registerLayerDefinition(COLDSNAPGUNNER, ColdSnapGunnerModel::createLayer);
        event.registerLayerDefinition(COLDSNAPSNOWBALLER, ColdSnapSnowballerModel::createLayer);
        event.registerLayerDefinition(COLDSNAPGIFTER, ColdSnapGifterModel::createLayer);
        event.registerLayerDefinition(COLDSNAPZAPPER, ColdSnapZapperModel::createLayer);
        event.registerLayerDefinition(COLDSNAPBRAWLER, ColdSnapBrawlerModel::createLayer);

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(Register.COLDSNAPSTABBER.get(), RenderColdSnapStabber::new);
        event.registerEntityRenderer(Register.COLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
        event.registerEntityRenderer(Register.COLDSNAPSNOWBALLER.get(), RenderColdSnapSnowballer::new);
        event.registerEntityRenderer(Register.COLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
        event.registerEntityRenderer(Register.COLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
        event.registerEntityRenderer(Register.COLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);
        event.registerEntityRenderer(Register.GUNNERPROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Register.LIGHTNINGSNOWBALLPROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Register.ROCKSNOWBALLPROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Register.SNOWIERSNOWBALLPROJECTILE.get(), ThrownItemRenderer::new);

    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        // do something that can only be done on the client
//        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
//        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPSNOWBALLER.get(), RenderColdSnapSnowballer::new);
//        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
//        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
//        RenderingRegistry.registerEntityRenderingHandler(Register.COLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);
//        RenderingRegistry.registerEntityRenderingHandler(Register.GUNNERPROJECTILE.get(), new GunnerProjectileRenderFactory());
//        RenderingRegistry.registerEntityRenderingHandler(Register.ROCKSNOWBALLPROJECTILE.get(), new RockySnowballRenderFactory());
//        RenderingRegistry.registerEntityRenderingHandler(Register.SNOWIERSNOWBALLPROJECTILE.get(), new SnowierSnowballRenderFactory());
//        RenderingRegistry.registerEntityRenderingHandler(Register.LIGHTNINGSNOWBALLPROJECTILE.get(), new LightningSnowballRenderFactory());
    }
}
