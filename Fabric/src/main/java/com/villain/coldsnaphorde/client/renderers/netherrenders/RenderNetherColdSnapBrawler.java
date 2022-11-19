package com.villain.coldsnaphorde.client.renderers.netherrenders;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.client.models.nethermodel.NetherColdSnapBrawlerModel;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapBrawler;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.villain.coldsnaphorde.client.ColdSnapClientInitializer.NCOLDSNAPBRAWLER;

public class RenderNetherColdSnapBrawler extends MobRenderer<ColdSnapBrawler, NetherColdSnapBrawlerModel<ColdSnapBrawler>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entity/ncoldsnapbrawler.png");

    public RenderNetherColdSnapBrawler(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new NetherColdSnapBrawlerModel<>(p_174304_.bakeLayer(NCOLDSNAPBRAWLER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapBrawler entity) {
        return TEXTURE;
    }
    }
