package com.jedijoe.coldsnaphorde.Configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CConfiguration {

    public static final String CCATEGORY_MOBFACTOR = "Mob Properties";

    public ConfigHelper.ConfigValueListener<Integer> SPAWNTEMPS;
    public ConfigHelper.ConfigValueListener<Boolean> NETHERSNOW;
    public ConfigHelper.ConfigValueListener<Boolean> OCEANSNOW;
    public ConfigHelper.ConfigValueListener<Boolean> ENDSNOW;
    public ConfigHelper.ConfigValueListener<Integer> HEATPROT;
    public ConfigHelper.ConfigValueListener<Integer> SNOWTRAIL;

    public CConfiguration(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify the rules for mobs to exist.").push(CCATEGORY_MOBFACTOR);
        this.SPAWNTEMPS = subscriber.subscribe(builder.comment("Changes temperature spawn requirements. 0: Cold, 1: Neutral, 2: Warm, 3: Hot.").defineInRange("spawnTempRange", 0, 0, 3));
        this.NETHERSNOW = subscriber.subscribe(builder.comment("Allows the cold snap horde to spawn in the nether.").define("snowmanInNether", false));
        this.OCEANSNOW = subscriber.subscribe(builder.comment("Allows the cold snap horde to spawn in the middle of the ocean.").define("snowmanInOcean", false));
        this.ENDSNOW = subscriber.subscribe(builder.comment("Allows the cold snap horde to spawn in the end").define("snowmanInEnd", false));
        this.HEATPROT = subscriber.subscribe(builder.comment("Defines how hot a cold snap snowman can get before it melts. 0: Cold, 1: Neutral, 2: Warm, 3: Hot (Recommend matching or being higher than spawnTempRange, or being 3 if snowmanInNether").defineInRange("snowSunScreen", 1, 0, 3));
        this.SNOWTRAIL = subscriber.subscribe(builder.comment("Defines how hot a cold snap snowman can be and still leave a snow trail. 0: Cold, 1: Neutral, 2: Warm, 3: Hot").defineInRange("snowTrailTemperature", 1, 0, 3));
        builder.pop();
    }
}
