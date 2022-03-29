package com.cartoonishvillain.coldsnaphorde.client;

import com.cartoonishvillain.coldsnaphorde.client.models.endmodel.EndColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.client.models.nethermodel.*;
import com.cartoonishvillain.coldsnaphorde.client.models.standardmodel.*;
import com.cartoonishvillain.coldsnaphorde.client.old_snow.old_model.*;
import com.cartoonishvillain.coldsnaphorde.client.old_snow.old_renders.*;
import com.cartoonishvillain.coldsnaphorde.client.renderers.endrenders.RenderEndColdSnapSnowballer;
import com.cartoonishvillain.coldsnaphorde.client.renderers.netherrenders.*;
import com.cartoonishvillain.coldsnaphorde.client.renderers.standardrenders.*;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import com.cartoonishvillain.coldsnaphorde.configs.ClientConfig;
import com.cartoonishvillain.coldsnaphorde.configs.ConfigHelper;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {

    public static ModelLayerLocation COLDSNAPSTABBER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:stabber"), "stabber");
    public static ModelLayerLocation COLDSNAPGUNNER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:gunner"), "gunner");
    public static ModelLayerLocation COLDSNAPSNOWBALLER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:snowballer"), "snowballer");
    public static ModelLayerLocation COLDSNAPGIFTER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:gifter"), "gifter");
    public static ModelLayerLocation COLDSNAPZAPPER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:zapper"), "zapper");
    public static ModelLayerLocation COLDSNAPBRAWLER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:brawler"), "brawler");

    public static ModelLayerLocation NCOLDSNAPSTABBER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:nstabber"), "nstabber");
    public static ModelLayerLocation NCOLDSNAPGUNNER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:ngunner"), "ngunner");
    public static ModelLayerLocation NCOLDSNAPBRAWLER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:nbrawler"), "nbrawler");
    public static ModelLayerLocation NCOLDSNAPSNOWBALLER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:nsnowballer"), "nsnowballer");
    public static ModelLayerLocation NCOLDSNAPGIFTER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:ngifter"), "ngifter");
    public static ModelLayerLocation NCOLDSNAPZAPPER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:nzapper"), "nzapper");

    public static ModelLayerLocation ECOLDSNAPSNOWBALLER = new ModelLayerLocation( new ResourceLocation("coldsnaphorde:esnowballer"), "esnowballer");

    public static ModelLayerLocation TOPHAT = new ModelLayerLocation( new ResourceLocation("minecraft:player"), "tophat");


    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(COLDSNAPSTABBER, ColdSnapStabberModel::createBodyLayer);
            event.registerLayerDefinition(COLDSNAPGUNNER, ColdSnapGunnerModel::createBodyLayer);
            event.registerLayerDefinition(COLDSNAPSNOWBALLER, ColdSnapSnowballerModel::createBodyLayer);
            event.registerLayerDefinition(COLDSNAPGIFTER, ColdSnapGifterModel::createBodyLayer);
            event.registerLayerDefinition(COLDSNAPZAPPER, ColdSnapZapperModel::createBodyLayer);
            event.registerLayerDefinition(COLDSNAPBRAWLER, ColdSnapBrawlerModel::createBodyLayer);
            event.registerLayerDefinition(ECOLDSNAPSNOWBALLER, EndColdSnapSnowballerModel::createBodyLayer);
            event.registerLayerDefinition(NCOLDSNAPSTABBER, NetherColdSnapStabberModel::createBodyLayer);
            event.registerLayerDefinition(NCOLDSNAPGUNNER, NetherColdSnapGunnerModel::createBodyLayer);
            event.registerLayerDefinition(NCOLDSNAPSNOWBALLER, NetherColdSnapSnowballerModel::createBodyLayer);
            event.registerLayerDefinition(NCOLDSNAPGIFTER, NetherColdSnapGifterModel::createBodyLayer);
            event.registerLayerDefinition(NCOLDSNAPZAPPER, NetherColdSnapZapperModel::createBodyLayer);
            event.registerLayerDefinition(NCOLDSNAPBRAWLER, NetherColdSnapBrawlerModel::createBodyLayer);
            event.registerLayerDefinition(OldColdSnapStabberModel.LAYER_LOCATION, OldColdSnapStabberModel::createBodyLayer);
            event.registerLayerDefinition(OldColdSnapGunnerModel.OLDCOLDSNAPLAYER, OldColdSnapGunnerModel::createBodyLayer);
            event.registerLayerDefinition(OldColdSnapSnowballerModel.LAYER_LOCATION, OldColdSnapSnowballerModel::createBodyLayer);
            event.registerLayerDefinition(OldColdSnapGifterModel.LAYER_LOCATION, OldColdSnapGifterModel::createBodyLayer);
            event.registerLayerDefinition(OldColdSnapZapperModel.LAYER_LOCATION, OldColdSnapZapperModel::createBodyLayer);
            event.registerLayerDefinition(OldColdSnapBrawler.OLDBRAWLERLAYER, OldColdSnapBrawler::createBodyLayer);
            event.registerLayerDefinition(TOPHAT, TopHatModel::createLayer);
    }


    public static void registerRenderers(){
        if (!ColdSnapHorde.clientConfig.OLD_SNOW.get()) {
            EntityRenderers.register(Register.COLDSNAPSTABBER.get(), RenderColdSnapStabber::new);
            EntityRenderers.register(Register.COLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
            EntityRenderers.register(Register.COLDSNAPSNOWBALLER.get(), RenderColdSnapSnowballer::new);
            EntityRenderers.register(Register.COLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
            EntityRenderers.register(Register.COLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
            EntityRenderers.register(Register.COLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);

            EntityRenderers.register(Register.NCOLDSNAPSTABBER.get(), RenderNetherColdSnapStabber::new);
            EntityRenderers.register(Register.NCOLDSNAPGUNNER.get(), RenderNetherColdSnapGunner::new);
            EntityRenderers.register(Register.NCOLDSNAPSNOWBALLER.get(), RenderNetherColdSnapSnowballer::new);
            EntityRenderers.register(Register.NCOLDSNAPGIFTER.get(), RenderNetherColdSnapGifter::new);
            EntityRenderers.register(Register.NCOLDSNAPZAPPER.get(), RenderNetherColdSnapZapper::new);
            EntityRenderers.register(Register.NCOLDSNAPBRAWLER.get(), RenderNetherColdSnapBrawler::new);

            EntityRenderers.register(Register.ECOLDSNAPSTABBER.get(), RenderColdSnapStabber::new);
            EntityRenderers.register(Register.ECOLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
            EntityRenderers.register(Register.ECOLDSNAPSNOWBALLER.get(), RenderEndColdSnapSnowballer::new);
            EntityRenderers.register(Register.ECOLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
            EntityRenderers.register(Register.ECOLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
            EntityRenderers.register(Register.ECOLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);

            EntityRenderers.register(Register.PCOLDSNAPSTABBER.get(), RenderColdSnapStabber::new);
            EntityRenderers.register(Register.PCOLDSNAPGUNNER.get(), RenderColdSnapGunner::new);
            EntityRenderers.register(Register.PCOLDSNAPSNOWBALLER.get(), RenderColdSnapSnowballer::new);
            EntityRenderers.register(Register.PCOLDSNAPGIFTER.get(), RenderColdSnapGifter::new);
            EntityRenderers.register(Register.PCOLDSNAPZAPPER.get(), RenderColdSnapZapper::new);
            EntityRenderers.register(Register.PCOLDSNAPBRAWLER.get(), RenderColdSnapBrawler::new);
        } else {
            EntityRenderers.register(Register.COLDSNAPSTABBER.get(), OldRenderColdSnapStabber::new);
            EntityRenderers.register(Register.COLDSNAPGUNNER.get(), OldRenderColdSnapGunner::new);
            EntityRenderers.register(Register.COLDSNAPSNOWBALLER.get(), OldRenderColdSnapSnowballer::new);
            EntityRenderers.register(Register.COLDSNAPGIFTER.get(), OldRenderColdSnapGifter::new);
            EntityRenderers.register(Register.COLDSNAPZAPPER.get(), OldRenderColdSnapZapper::new);
            EntityRenderers.register(Register.COLDSNAPBRAWLER.get(), OldRenderColdSnapBrawler::new);

            EntityRenderers.register(Register.NCOLDSNAPSTABBER.get(), OldRenderColdSnapStabber::new);
            EntityRenderers.register(Register.NCOLDSNAPGUNNER.get(), OldRenderColdSnapGunner::new);
            EntityRenderers.register(Register.NCOLDSNAPSNOWBALLER.get(), OldRenderColdSnapSnowballer::new);
            EntityRenderers.register(Register.NCOLDSNAPGIFTER.get(), OldRenderColdSnapGifter::new);
            EntityRenderers.register(Register.NCOLDSNAPZAPPER.get(), OldRenderColdSnapZapper::new);
            EntityRenderers.register(Register.NCOLDSNAPBRAWLER.get(), OldRenderColdSnapBrawler::new);

            EntityRenderers.register(Register.ECOLDSNAPSTABBER.get(), OldRenderColdSnapStabber::new);
            EntityRenderers.register(Register.ECOLDSNAPGUNNER.get(), OldRenderColdSnapGunner::new);
            EntityRenderers.register(Register.ECOLDSNAPSNOWBALLER.get(), OldRenderColdSnapSnowballer::new);
            EntityRenderers.register(Register.ECOLDSNAPGIFTER.get(), OldRenderColdSnapGifter::new);
            EntityRenderers.register(Register.ECOLDSNAPZAPPER.get(), OldRenderColdSnapZapper::new);
            EntityRenderers.register(Register.ECOLDSNAPBRAWLER.get(), OldRenderColdSnapBrawler::new);

            EntityRenderers.register(Register.PCOLDSNAPSTABBER.get(), OldRenderColdSnapStabber::new);
            EntityRenderers.register(Register.PCOLDSNAPGUNNER.get(), OldRenderColdSnapGunner::new);
            EntityRenderers.register(Register.PCOLDSNAPSNOWBALLER.get(), OldRenderColdSnapSnowballer::new);
            EntityRenderers.register(Register.PCOLDSNAPGIFTER.get(), OldRenderColdSnapGifter::new);
            EntityRenderers.register(Register.PCOLDSNAPZAPPER.get(), OldRenderColdSnapZapper::new);
            EntityRenderers.register(Register.PCOLDSNAPBRAWLER.get(), OldRenderColdSnapBrawler::new);
        }

        EntityRenderers.register(Register.COLDSNAPCOW.get(), RenderColdSnapCow::new);
        EntityRenderers.register(Register.GUNNERPROJECTILE.get(), ThrownItemRenderer::new);
        EntityRenderers.register(Register.LIGHTNINGSNOWBALLPROJECTILE.get(), ThrownItemRenderer::new);
        EntityRenderers.register(Register.ROCKSNOWBALLPROJECTILE.get(), ThrownItemRenderer::new);
        EntityRenderers.register(Register.SNOWIERSNOWBALLPROJECTILE.get(), ThrownItemRenderer::new);
        EntityRenderers.register(Register.THROWNCHORUSPROJECTILE.get(), ThrownItemRenderer::new);
        EntityRenderers.register(Register.HEALINGSNOWBALLPROJECTILE.get(), ThrownItemRenderer::new);
        EntityRenderers.register(Register.ICEPROJECTILE.get(), ThrownItemRenderer::new);
    }
    /*
For the functions: ConstructLayers and addLayertoPlayer, the following copyright notice applies.

Copyright (c) 2015, David Quintana <gigaherz@gmail.com>
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the author nor the
      names of the contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

     */
    @SubscribeEvent
    public static void ConstructLayers(EntityRenderersEvent.AddLayers event)
    {
        addLayerToPlayer(event, "default");
        addLayerToPlayer(event, "slim");
    }



    private static void addLayerToPlayer(EntityRenderersEvent.AddLayers event, String skinName)
    {
        EntityRenderer<? extends Player> render = event.getSkin(skinName);
        if (render instanceof LivingEntityRenderer livingRenderer)
        {
            livingRenderer.addLayer(new TopHatLayer(livingRenderer));
        }
    }


}
