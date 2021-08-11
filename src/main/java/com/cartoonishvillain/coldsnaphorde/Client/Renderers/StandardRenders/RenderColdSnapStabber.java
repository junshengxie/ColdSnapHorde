package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenders;

import com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel.ColdSnapGunnerModel;
import com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel.ColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGunner;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPGUNNER;
import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPSTABBER;

public class RenderColdSnapStabber extends MobRenderer<ColdSnapStabber, ColdSnapStabberModel<ColdSnapStabber>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapstabber.png");

    public RenderColdSnapStabber(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapStabberModel<>(p_174304_.bakeLayer(COLDSNAPSTABBER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapStabber entity) {
        return TEXTURE;
    }
}
