package com.villain.coldsnaphorde.client.renderers.netherrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.nethermodel.NetherColdSnapGifterModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapGifter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.ColdSnapClientInitializer.NCOLDSNAPGIFTER;

public class RenderNetherColdSnapGifter extends MobRenderer<ColdSnapGifter, NetherColdSnapGifterModel<ColdSnapGifter>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ncoldsnapgifter.png");

    public RenderNetherColdSnapGifter(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NetherColdSnapGifterModel<>(p_174304_.bakeLayer(NCOLDSNAPGIFTER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGifter entity) {
        return TEXTURE;
    }
}
