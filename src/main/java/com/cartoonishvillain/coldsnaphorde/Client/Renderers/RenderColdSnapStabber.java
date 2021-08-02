package com.cartoonishvillain.coldsnaphorde.Client.Renderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.ColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.cartoonishvillain.coldsnaphorde.Client.RenderManager.COLDSNAPSTABBER;
import static com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember.variant;

public class RenderColdSnapStabber extends MobRenderer<ColdSnapStabber, ColdSnapStabberModel<ColdSnapStabber>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapstabber.png");
    protected static final ResourceLocation FTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/flamingcoldsnapstabber.png");
    protected static final ResourceLocation ETEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/endercoldsnapstabber.png");
    protected static final ResourceLocation PTEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/plaguecoldsnapstabber.png");

    public RenderColdSnapStabber(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new ColdSnapStabberModel<>(p_174304_.bakeLayer(COLDSNAPSTABBER)), 0.65f);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapStabber entity) {
        switch (entity.getEntityData().get(variant)){
            case 2 -> {return ETEXTURE;}
            case 1 -> {return FTEXTURE;}
            case 3 -> {return PTEXTURE;}
            default -> {return TEXTURE;}
        }
    }
}
