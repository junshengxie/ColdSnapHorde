package com.villain.coldsnaphorde.client.renderers.standardrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.standardmodel.ColdSnapBrawlerModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapBrawler;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.RenderManager.COLDSNAPBRAWLER;

public class RenderColdSnapBrawler extends MobRenderer<ColdSnapBrawler, ColdSnapBrawlerModel<ColdSnapBrawler>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/coldsnapbrawler.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ecoldsnapbrawler.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/pcoldsnapbrawler.png");

    public RenderColdSnapBrawler(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapBrawlerModel<>(p_174304_.bakeLayer(COLDSNAPBRAWLER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapBrawler entity) {
        if (entity.getHordeVariant() == 0)
        {return TEXTURE;}
        else if(entity.getHordeVariant() == 2) {return ETEXTURE;}
        else if(entity.getHordeVariant() == 3) {return PTEXTURE;}
        else return TEXTURE;
    }
    }
