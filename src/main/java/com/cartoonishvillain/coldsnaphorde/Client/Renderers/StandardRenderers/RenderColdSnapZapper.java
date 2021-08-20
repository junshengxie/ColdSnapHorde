package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels.ColdSnapZapperModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapZapper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapZapper extends MobRenderer<ColdSnapZapper, ColdSnapZapperModel<ColdSnapZapper>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapzapper.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ecoldsnapzapper.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/pcoldsnapzapper.png");

    public RenderColdSnapZapper(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapZapperModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapZapper entity) {
        if(entity.getHordeVariant() == 0)
            return TEXTURE;

        if(entity.getHordeVariant() == 3)
            return PTEXTURE;

        else return ETEXTURE;
    }
}
