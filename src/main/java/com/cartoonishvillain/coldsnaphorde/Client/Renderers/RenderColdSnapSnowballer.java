package com.cartoonishvillain.coldsnaphorde.Client.Renderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapSnowballerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapSnowballer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPSNOWBALLER;

public class RenderColdSnapSnowballer extends MobRenderer<ColdSnapSnowballer, ColdSnapSnowballerModel<ColdSnapSnowballer>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapsnowballer.png");
    protected static final ResourceLocation FTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/flamingcoldsnapsnowballer.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/endercoldsnapsnowballer.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/plaguecoldsnapsnowballer.png");

    public RenderColdSnapSnowballer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapSnowballerModel<>(p_174304_.bakeLayer(COLDSNAPSNOWBALLER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapSnowballer entity) {
        switch (entity.getHordeVariant()){
            case ENDER -> {return ETEXTURE;}
            case FLAMING -> {return FTEXTURE;}
            case PLAGUE -> {return PTEXTURE;}
            default -> {return TEXTURE;}
        }
    }
}
