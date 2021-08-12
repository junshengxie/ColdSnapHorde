package com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenders;

import com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel.NetherColdSnapZapperModel;
import com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel.ColdSnapZapperModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapZapper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPZAPPER;
import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.NCOLDSNAPZAPPER;

public class RenderNetherColdSnapZapper extends MobRenderer<ColdSnapZapper, NetherColdSnapZapperModel<ColdSnapZapper>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ncoldsnapzapper.png");


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
