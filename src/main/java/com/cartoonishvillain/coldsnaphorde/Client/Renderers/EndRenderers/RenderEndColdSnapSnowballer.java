package com.cartoonishvillain.coldsnaphorde.Client.Renderers.EndRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.EndModel.EndColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapSnowballer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderEndColdSnapSnowballer extends MobRenderer<ColdSnapSnowballer, EndColdSnapSnowballerModel<ColdSnapSnowballer>> {

    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ecoldsnapsnowballer.png");

    public RenderEndColdSnapSnowballer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EndColdSnapSnowballerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapSnowballer entity) {
        return ETEXTURE;
    }

}
