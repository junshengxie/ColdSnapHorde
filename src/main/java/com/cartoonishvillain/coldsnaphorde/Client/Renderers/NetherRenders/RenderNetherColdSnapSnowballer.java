package com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenders;

import com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel.NetherColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel.ColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapSnowballer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPSNOWBALLER;
import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.NCOLDSNAPSNOWBALLER;

public class RenderNetherColdSnapSnowballer extends MobRenderer<ColdSnapSnowballer, NetherColdSnapSnowballerModel<ColdSnapSnowballer>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ncoldsnapsnowballer.png");

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
