package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenders;

import com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel.ColdSnapGunnerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapBrawler;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGunner;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPGUNNER;
import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.NCOLDSNAPBRAWLER;

public class RenderColdSnapGunner extends MobRenderer<ColdSnapGunner, ColdSnapGunnerModel<ColdSnapGunner>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapgunner.png");

    public RenderColdSnapGunner(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapGunnerModel<>(p_174304_.bakeLayer(COLDSNAPGUNNER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGunner entity) {
        return TEXTURE;
    }
}
