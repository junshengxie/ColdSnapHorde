package com.villain.coldsnaphorde.client.renderers.standardrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.standardmodel.ColdSnapGunnerModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapGunner;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.ColdSnapClientInitializer.COLDSNAPGUNNER;

public class RenderColdSnapGunner extends MobRenderer<ColdSnapGunner, ColdSnapGunnerModel<ColdSnapGunner>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/coldsnapgunner.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ecoldsnapgunner.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/pcoldsnapgunner.png");

    public RenderColdSnapGunner(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapGunnerModel<>(p_174304_.bakeLayer(COLDSNAPGUNNER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGunner entity) {
        if (entity.getHordeVariant() == 0)
            return TEXTURE;
        else if(entity.getHordeVariant() == 2) return ETEXTURE;
        else if(entity.getHordeVariant() == 3) {return PTEXTURE;}
        else return TEXTURE;
    }
}
