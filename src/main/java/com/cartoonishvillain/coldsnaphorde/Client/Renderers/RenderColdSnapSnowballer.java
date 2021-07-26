package com.cartoonishvillain.coldsnaphorde.Client.Renderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapSnowballer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPSNOWBALLER;

public class RenderColdSnapSnowballer extends MobRenderer<ColdSnapSnowballer, ColdSnapSnowballerModel<ColdSnapSnowballer>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapsnowballer.png");

    public RenderColdSnapSnowballer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapSnowballerModel<>(p_174304_.bakeLayer(COLDSNAPSNOWBALLER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapSnowballer entity) {
        return TEXTURE;
    }
}
