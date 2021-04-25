package com.cartoonishvillain.coldsnaphorde.Client.Renderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapSnowballer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapSnowballer extends MobRenderer<ColdSnapSnowballer, ColdSnapSnowballerModel<ColdSnapSnowballer>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapsnowballer.png");

    public RenderColdSnapSnowballer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapSnowballerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapSnowballer entity) {
        return TEXTURE;
    }
}
