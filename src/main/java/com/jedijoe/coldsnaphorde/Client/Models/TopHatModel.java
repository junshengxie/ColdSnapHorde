package com.jedijoe.coldsnaphorde.Client.Models;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Items.TopHat;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TopHatModel extends AnimatedGeoModel<TopHat> {
    @Override
    public ResourceLocation getModelLocation(TopHat topHat) {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, "geo/tophat.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TopHat topHat) {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, "textures/armor/tophat.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TopHat topHat) {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, "animations/model.animation.json");

    }
}
