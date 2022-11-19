package com.villain.coldsnaphorde.client.renderers.netherrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.nethermodel.NetherColdSnapGunnerModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapGunner;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.ColdSnapClientInitializer.NCOLDSNAPGUNNER;

public class RenderNetherColdSnapGunner extends MobRenderer<ColdSnapGunner, NetherColdSnapGunnerModel<ColdSnapGunner>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ncoldsnapgunner.png");

    public RenderNetherColdSnapGunner(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NetherColdSnapGunnerModel<>(p_174304_.bakeLayer(NCOLDSNAPGUNNER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGunner entity) {
        return TEXTURE;
    }
}
