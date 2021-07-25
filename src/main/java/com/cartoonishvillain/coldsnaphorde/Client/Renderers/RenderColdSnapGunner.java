//package com.cartoonishvillain.coldsnaphorde.Client.Renderers;
//
//import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapGunnerModel;
//import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
//import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapGunner;
//import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.resources.ResourceLocation;
//
//public class RenderColdSnapGunner extends MobRenderer<ColdSnapGunner, ColdSnapGunnerModel<ColdSnapGunner>> {
//
//    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapgunner.png");
//
//    public RenderColdSnapGunner(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapGunnerModel<>(), 0.5F);
//    }
//
//    @Override
//    public ResourceLocation getTextureLocation(ColdSnapGunner entity) {
//        return TEXTURE;
//    }
//}
