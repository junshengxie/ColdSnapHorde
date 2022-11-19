package com.villain.coldsnaphorde.client.renderers.netherrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.nethermodel.NetherColdSnapZapperModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapZapper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.ColdSnapClientInitializer.NCOLDSNAPZAPPER;

public class RenderNetherColdSnapZapper extends MobRenderer<ColdSnapZapper, NetherColdSnapZapperModel<ColdSnapZapper>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ncoldsnapzapper.png");


    public RenderNetherColdSnapZapper(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NetherColdSnapZapperModel<>(p_174304_.bakeLayer(NCOLDSNAPZAPPER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapZapper entity) {
        return TEXTURE;
    }
}
