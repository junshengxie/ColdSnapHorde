package com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel.NetherColdSnapStabberModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapStabber;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderNetherColdSnapStabber extends MobRenderer<ColdSnapStabber, NetherColdSnapStabberModel<ColdSnapStabber>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ncoldsnapstabber.png");

    public RenderNetherColdSnapStabber(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NetherColdSnapStabberModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapStabber entity) {
        return TEXTURE;
    }
}
