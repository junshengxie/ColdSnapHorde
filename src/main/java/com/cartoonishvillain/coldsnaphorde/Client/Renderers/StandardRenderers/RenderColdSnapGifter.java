package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels.ColdSnapGifterModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGifter;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapGifter extends MobRenderer<ColdSnapGifter, ColdSnapGifterModel<ColdSnapGifter>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapgifter.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ecoldsnapgifter.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/pcoldsnapgifter.png");

    public RenderColdSnapGifter(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapGifterModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGifter entity) {
        if(entity.getHordeVariant() == 0)
            return TEXTURE;

        if(entity.getHordeVariant() == 3)
            return PTEXTURE;
        else return ETEXTURE;
    }
}
