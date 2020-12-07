package com.jedijoe.coldsnaphorde.Client.Models;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Entities.Mobs.ColdSnapStabber;
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
