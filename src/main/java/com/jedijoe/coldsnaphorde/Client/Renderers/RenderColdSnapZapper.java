package com.jedijoe.coldsnaphorde.Client.Renderers;

import com.jedijoe.coldsnaphorde.Client.Models.ColdSnapSnowballerModel;
import com.jedijoe.coldsnaphorde.Client.Models.ColdSnapZapperModel;
import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Entities.Mobs.ColdSnapSnowballer;
import com.jedijoe.coldsnaphorde.Entities.Mobs.ColdSnapZapper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapZapper extends MobRenderer<ColdSnapZapper, ColdSnapZapperModel<ColdSnapZapper>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapzapper.png");

    public RenderColdSnapZapper(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapZapperModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapZapper entity) {
        return TEXTURE;
    }
}
