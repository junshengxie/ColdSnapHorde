package com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenders;

import com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel.NetherColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel.ColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPSTABBER;
import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.NCOLDSNAPSTABBER;

public class RenderNetherColdSnapStabber extends MobRenderer<ColdSnapStabber, NetherColdSnapStabberModel<ColdSnapStabber>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ncoldsnapstabber.png");

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
