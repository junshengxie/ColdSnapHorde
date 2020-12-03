package com.jedijoe.coldsnaphorde.Client.Models;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Entities.ColdSnapStabber;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ColdSnapStabberModel extends AnimatedGeoModel<ColdSnapStabber> {

    @Override
    public ResourceLocation getModelLocation(ColdSnapStabber coldSnapStabber) {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, "geo/coldsnapstabbermodel.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ColdSnapStabber coldSnapStabber) {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/entity/coldsnapstabber.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ColdSnapStabber coldSnapStabber) {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, "animations/model.animation.json");
    }
}
