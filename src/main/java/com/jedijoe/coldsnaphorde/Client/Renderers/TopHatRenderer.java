package com.jedijoe.coldsnaphorde.Client.Renderers;

import com.jedijoe.coldsnaphorde.Client.Models.TopHatModel;
import com.jedijoe.coldsnaphorde.Items.TopHat;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class TopHatRenderer extends GeoArmorRenderer<TopHat> {
    public TopHatRenderer() {
        super(new TopHatModel());
    }

}
