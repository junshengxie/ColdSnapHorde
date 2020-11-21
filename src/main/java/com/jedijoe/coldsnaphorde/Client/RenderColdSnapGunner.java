package com.jedijoe.coldsnaphorde.Client;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Entities.ColdSnapGunner;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SnowManRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapGunner extends MobRenderer<ColdSnapGunner, ColdSnapGunnerModel<ColdSnapGunner>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapgunner.png");

    public RenderColdSnapGunner(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapGunnerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapGunner entity) {
        return TEXTURE;
    }
}
