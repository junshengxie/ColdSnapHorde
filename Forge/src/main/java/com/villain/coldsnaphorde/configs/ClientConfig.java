package com.villain.coldsnaphorde.configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClientConfig {

    public static final String CCATEGORY_MOBFACTOR = "The Option";

    public ConfigHelper.ConfigValueListener<Boolean> OLD_SNOW;

    public ClientConfig(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify rendering of entities.").push(CCATEGORY_MOBFACTOR);
        this.OLD_SNOW = subscriber.subscribe(builder.comment("Nostalgia mode. If true, snowmen are replaced with their original counterparts where applicable.").define("old_snow", false));
        builder.pop();
    }
}
