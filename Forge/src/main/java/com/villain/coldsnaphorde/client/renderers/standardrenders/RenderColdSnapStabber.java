package com.villain.coldsnaphorde.client.renderers.standardrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.standardmodel.ColdSnapStabberModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.RenderManager.COLDSNAPSTABBER;

public class RenderColdSnapStabber extends MobRenderer<ColdSnapStabber, ColdSnapStabberModel<ColdSnapStabber>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/coldsnapstabber.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ecoldsnapstabber.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/pcoldsnapstabber.png");

    public RenderColdSnapStabber(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapStabberModel<>(p_174304_.bakeLayer(COLDSNAPSTABBER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapStabber entity) {
        if (entity.getHordeVariant() == 0) {return TEXTURE;}
        else if(entity.getHordeVariant() == 2) {return ETEXTURE;}
        else if(entity.getHordeVariant() == 3) {return PTEXTURE;}
        else return TEXTURE;
    }
}
