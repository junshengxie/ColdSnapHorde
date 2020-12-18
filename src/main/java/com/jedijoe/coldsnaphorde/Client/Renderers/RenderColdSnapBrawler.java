package com.jedijoe.coldsnaphorde.Client.Renderers;

import com.jedijoe.coldsnaphorde.Client.Models.ColdSnapBrawlerModel;
import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Entities.Mobs.ColdSnapBrawler;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapBrawler extends MobRenderer<ColdSnapBrawler, ColdSnapBrawlerModel<ColdSnapBrawler>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapbrawler.png");

    public RenderColdSnapBrawler(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapBrawler entity) {
        return TEXTURE;
    }
}
