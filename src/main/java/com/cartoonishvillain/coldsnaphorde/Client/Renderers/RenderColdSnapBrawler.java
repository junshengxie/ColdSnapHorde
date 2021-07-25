//package com.cartoonishvillain.coldsnaphorde.Client.Renderers;
//
//import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapBrawlerModel;
//import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
//import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapBrawler;
//import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.resources.ResourceLocation;
//
//public class RenderColdSnapBrawler extends MobRenderer<ColdSnapBrawler, ColdSnapBrawlerModel<ColdSnapBrawler>> {
//
//    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapbrawler.png");
//
//    public RenderColdSnapBrawler(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapBrawlerModel<>(), 0.5F);
//    }
//
//    @Override
//    public ResourceLocation getTextureLocation(ColdSnapBrawler entity) {
//        return TEXTURE;
//    }
//}
