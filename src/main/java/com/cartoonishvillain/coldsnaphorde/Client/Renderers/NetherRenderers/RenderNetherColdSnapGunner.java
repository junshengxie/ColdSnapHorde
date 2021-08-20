package com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel.NetherColdSnapGunnerModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapGunner;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderNetherColdSnapGunner extends MobRenderer<ColdSnapGunner, NetherColdSnapGunnerModel<ColdSnapGunner>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ncoldsnapgunner.png");

    public RenderNetherColdSnapGunner(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NetherColdSnapGunnerModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapGunner entity) {
        return TEXTURE;
    }
}
