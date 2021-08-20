package com.cartoonishvillain.coldsnaphorde.Client;

import com.cartoonishvillain.coldsnaphorde.Client.Models.TopHatLayer;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.EndRenderers.RenderEndColdSnapSnowballer;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenderers.*;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenderers.*;
import com.cartoonishvillain.coldsnaphorde.Client.Renderers.projectiles.GenericProjectileRenderFactory;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

import java.util.Map;

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

        /*
For the functions: AddTopHatLayer, and addLayerToPlayerSkin, the following copyright notice applies.
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



    public static void AddTopHatLayer(){
        Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap();
        addLayerToPlayerSkin(skinMap, "default");
        addLayerToPlayerSkin(skinMap, "slim");
    }

    private static void addLayerToPlayerSkin(Map<String, PlayerRenderer> skinMap, String skinName)
    {
        PlayerRenderer render = skinMap.get(skinName);
        render.addLayer(new TopHatLayer<>(render));
    }
}
