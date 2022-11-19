package com.villain.coldsnaphorde.client.renderers.netherrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.nethermodel.NetherColdSnapStabberModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.RenderManager.NCOLDSNAPSTABBER;

public class RenderNetherColdSnapStabber extends MobRenderer<ColdSnapStabber, NetherColdSnapStabberModel<ColdSnapStabber>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ncoldsnapstabber.png");

    public RenderNetherColdSnapStabber(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NetherColdSnapStabberModel<>(p_174304_.bakeLayer(NCOLDSNAPSTABBER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapStabber entity) {
        return TEXTURE;
    }
}
