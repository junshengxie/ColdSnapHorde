package com.jedijoe.coldsnaphorde.Configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SConfiguration {
    public static final String SCATEGORY_TOOLS = "Tools";

    public static final String SCATEGORY_MOBFACTOR = "Mod Properties";

    public ConfigHelper.ConfigValueListener<Boolean> TECHNICALTHERMOMETER;


    public SConfiguration(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify how certain items work").push(SCATEGORY_TOOLS);
        this.TECHNICALTHERMOMETER = subscriber.subscribe(builder.comment("Enables or disabled technical levels of thermometers. Gives minecraft temperature values instead of adapted ones.").define("technicalThermometer", false));
        builder.pop();
    }
}
