package com.cartoonishvillain.coldsnaphorde.Client.Renderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapGifterModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGifter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPGIFTER;
import static com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember.variant;

public class RenderColdSnapGifter extends MobRenderer<ColdSnapGifter, ColdSnapGifterModel<ColdSnapGifter>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapgifter.png");
    protected static final ResourceLocation FTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/flamingcoldsnapgifter.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/endercoldsnapgifter.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/plaguecoldsnapgifter.png");

    public RenderColdSnapGifter(EntityRendererProvider.Context p_174304) {
        super(p_174304, new ColdSnapGifterModel<>(p_174304.bakeLayer(COLDSNAPGIFTER)), 0.5f);
    }

//    public RenderColdSnapGifter(EntityRenderDispatcher renderManagerIn) {
//        super(renderManagerIn, new ColdSnapGifterModel<>(), 0.5F);
//    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGifter entity) {
        switch (entity.getEntityData().get(variant)){
            case 2 -> {return ETEXTURE;}
            case 1 -> {return FTEXTURE;}
            case 3 -> {return PTEXTURE;}
            default -> {return TEXTURE;}
        }
    }
}
