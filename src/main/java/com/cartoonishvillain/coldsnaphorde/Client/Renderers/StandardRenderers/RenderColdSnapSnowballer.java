package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.BaseModels.ColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapSnowballer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderColdSnapSnowballer extends MobRenderer<ColdSnapSnowballer, ColdSnapSnowballerModel<ColdSnapSnowballer>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapsnowballer.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ecoldsnapsnowballer.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/pcoldsnapsnowballer.png");

    public RenderColdSnapSnowballer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ColdSnapSnowballerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapSnowballer entity) {
        if(entity.getHordeVariant() == 0)
            return TEXTURE;

        if(entity.getHordeVariant() == 3)
            return PTEXTURE;

        else return ETEXTURE;
    }

}
