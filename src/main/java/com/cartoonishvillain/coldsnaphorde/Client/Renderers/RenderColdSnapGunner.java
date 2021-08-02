package com.cartoonishvillain.coldsnaphorde.Client.Renderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapGunnerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapGunner;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPGUNNER;
import static com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember.variant;

public class RenderColdSnapGunner extends MobRenderer<ColdSnapGunner, ColdSnapGunnerModel<ColdSnapGunner>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapgunner.png");
    protected static final ResourceLocation FTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/flamingcoldsnapgunner.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/endercoldsnapgunner.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/plaguecoldsnapgunner.png");

    public RenderColdSnapGunner(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapGunnerModel<>(p_174304_.bakeLayer(COLDSNAPGUNNER)), 0.5F);
    }

//    public RenderColdSnapGunner(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapGunnerModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGunner entity) {
        switch (entity.getEntityData().get(variant)){
            case 2 -> {return ETEXTURE;}
            case 1 -> {return FTEXTURE;}
            case 3 -> {return PTEXTURE;}
            default -> {return TEXTURE;}
        }
    }
}
