package com.cartoonishvillain.coldsnaphorde.Client.Renderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapGifterModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapGifter;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapGifter extends MobRenderer<ColdSnapGifter, ColdSnapGifterModel<ColdSnapGifter>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapgifter.png");

    public RenderColdSnapGifter(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapGifterModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapGifter entity) {
        return TEXTURE;
    }
}
