package com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel.NetherColdSnapBrawlerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapBrawler;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderNetherColdSnapBrawler extends MobRenderer<ColdSnapBrawler, NetherColdSnapBrawlerModel<ColdSnapBrawler>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ncoldsnapbrawler.png");

    public RenderNetherColdSnapBrawler(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NetherColdSnapBrawlerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapBrawler entity) {
        return TEXTURE;
    }
}
