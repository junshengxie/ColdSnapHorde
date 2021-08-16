package com.cartoonishvillain.coldsnaphorde.Client.Renderers.StandardRenders;

import com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel.ColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.Client.Models.StandardModel.ColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapSnowballer;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPSNOWBALLER;
import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPSTABBER;

public class RenderColdSnapSnowballer extends MobRenderer<ColdSnapSnowballer, ColdSnapSnowballerModel<ColdSnapSnowballer>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapsnowballer.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/pcoldsnapsnowballer.png");

    public RenderColdSnapSnowballer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapSnowballerModel<>(p_174304_.bakeLayer(COLDSNAPSNOWBALLER)), 0.5f);
    }

//    public RenderNetherColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapSnowballer entity) {
        if(entity.getHordeVariant() == 3) {return PTEXTURE;}
        else return TEXTURE;
    }
}
