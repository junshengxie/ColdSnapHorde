package com.cartoonishvillain.coldsnaphorde.Client.Renderers.NetherRenderers;

import com.cartoonishvillain.coldsnaphorde.Client.Models.NetherModel.NetherColdSnapZapperModel;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.ColdSnapZapper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderNetherColdSnapZapper extends MobRenderer<ColdSnapZapper, NetherColdSnapZapperModel<ColdSnapZapper>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/ncoldsnapzapper.png");

    public RenderNetherColdSnapZapper(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NetherColdSnapZapperModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(ColdSnapZapper entity) {
        return TEXTURE;
    }
}
