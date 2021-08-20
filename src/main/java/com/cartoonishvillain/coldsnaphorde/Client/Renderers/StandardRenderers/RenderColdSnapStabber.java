package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels.ColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapStabber extends MobRenderer<ColdSnapStabber, ColdSnapStabberModel<ColdSnapStabber>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapstabber.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ecoldsnapstabber.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/pcoldsnapstabber.png");

    public RenderColdSnapStabber(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapStabberModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapStabber entity) {
        if(entity.getHordeVariant() == 0)
            return TEXTURE;

        if(entity.getHordeVariant() == 3)
            return PTEXTURE;

        else return ETEXTURE;
    }
}
