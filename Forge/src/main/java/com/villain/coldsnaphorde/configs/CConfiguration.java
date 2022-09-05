package com.villain.coldsnaphorde.configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CConfiguration {
    public static final String CCATEGORY_MOBFACTOR = "Mob Properties";
    public ConfigHelper.ConfigValueListener<Integer> SPAWNTEMPS;
    public ConfigHelper.ConfigValueListener<Integer> HEATPROT;
    public ConfigHelper.ConfigValueListener<Integer> SNOWTRAIL;
    public ConfigHelper.ConfigValueListener<Boolean> PROGRESSIVESPAWNS;



    public CConfiguration(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify the rules for mobs to exist.").push(CCATEGORY_MOBFACTOR);
        this.SPAWNTEMPS = subscriber.subscribe(builder.comment("Changes temperature spawn requirements. 0: Cold, 1: Neutral, 2: Warm, 3: Hot.").defineInRange("spawnTempRange", 0, 0, 3));
        this.HEATPROT = subscriber.subscribe(builder.comment("Defines how hot a cold snap snowman can get before it melts. 0: Cold, 1: Neutral, 2: Warm, 3: Hot (Recommend matching or being higher than spawnTempRange, or being 3 if snowmanInNether").defineInRange("snowSunScreen", 1, 0, 3));
        this.SNOWTRAIL = subscriber.subscribe(builder.comment("Defines how hot a cold snap snowman can be and still leave a snow trail. 0: Cold, 1: Neutral, 2: Warm, 3: Hot").defineInRange("snowTrailTemperature", 1, 0, 3));
        this.PROGRESSIVESPAWNS = subscriber.subscribe(builder.comment("If true, cold snap horde mobs will be restricted to spawning only when unlocked by horde completion. If false, entities will spawn as if the world was through tier 3 already.").define("progressiveSpawns", true));
        builder.pop();
    }
}
