package com.jedijoe.coldsnaphorde.Client;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Entities.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapStabber extends MobRenderer<ColdSnapStabber, ColdSnapStabberModel<ColdSnapStabber>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapstabber.png");

    public RenderColdSnapStabber(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapStabberModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapStabber entity) {
        return TEXTURE;
    }
}
