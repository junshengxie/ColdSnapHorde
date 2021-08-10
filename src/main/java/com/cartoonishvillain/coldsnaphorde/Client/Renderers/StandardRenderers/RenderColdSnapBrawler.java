package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels.ColdSnapBrawlerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapBrawler;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapBrawler extends MobRenderer<ColdSnapBrawler, ColdSnapBrawlerModel<ColdSnapBrawler>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapbrawler.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ecoldsnapbrawler.png");


    public RenderColdSnapBrawler(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapBrawler entity) {
        if(entity.getHordeVariant() == 0)
        return TEXTURE;
        else return ETEXTURE;
    }
}
