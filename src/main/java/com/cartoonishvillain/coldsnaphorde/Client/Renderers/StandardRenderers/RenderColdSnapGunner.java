package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels.ColdSnapGunnerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGunner;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapGunner extends MobRenderer<ColdSnapGunner, ColdSnapGunnerModel<ColdSnapGunner>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapgunner.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ecoldsnapgunner.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/pcoldsnapgunner.png");

    public RenderColdSnapGunner(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapGunnerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGunner entity) {
        if(entity.getHordeVariant() == 0)
            return TEXTURE;

        if(entity.getHordeVariant() == 3)
            return PTEXTURE;

        else return ETEXTURE;
    }
}
