package com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel.NetherColdSnapGifterModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGifter;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderNetherColdSnapGifter extends MobRenderer<ColdSnapGifter, NetherColdSnapGifterModel<ColdSnapGifter>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ncoldsnapgifter.png");

    public RenderNetherColdSnapGifter(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NetherColdSnapGifterModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapGifter entity) {
        return TEXTURE;
    }
}
