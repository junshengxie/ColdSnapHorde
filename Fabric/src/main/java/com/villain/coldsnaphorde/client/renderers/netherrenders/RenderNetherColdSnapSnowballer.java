package com.villain.coldsnaphorde.client.renderers.netherrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.nethermodel.NetherColdSnapSnowballerModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapSnowballer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.ColdSnapClientInitializer.NCOLDSNAPSNOWBALLER;

public class RenderNetherColdSnapSnowballer extends MobRenderer<ColdSnapSnowballer, NetherColdSnapSnowballerModel<ColdSnapSnowballer>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ncoldsnapsnowballer.png");

    public RenderNetherColdSnapSnowballer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NetherColdSnapSnowballerModel<>(p_174304_.bakeLayer(NCOLDSNAPSNOWBALLER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapSnowballer entity) {
        return TEXTURE;
    }
}
