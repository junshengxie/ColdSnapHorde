package com.jedijoe.coldsnaphorde.Configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CConfiguration {

    public static final String CCATEGORY_MOBFACTOR = "Mob Properties";

    public static final String CCATEGORY_NUMBERS = "Spawn Rates";

    public ConfigHelper.ConfigValueListener<Integer> SPAWNTEMPS;
    public ConfigHelper.ConfigValueListener<Boolean> NETHERSNOW;
    public ConfigHelper.ConfigValueListener<Boolean> OCEANSNOW;
    public ConfigHelper.ConfigValueListener<Boolean> ENDSNOW;
    public ConfigHelper.ConfigValueListener<Integer> HEATPROT;
    public ConfigHelper.ConfigValueListener<Integer> SNOWTRAIL;

    public ConfigHelper.ConfigValueListener<Integer> STABBER;
    public ConfigHelper.ConfigValueListener<Integer> ESTABBER;
    public ConfigHelper.ConfigValueListener<Integer> NSTABBER;
    public ConfigHelper.ConfigValueListener<Integer> GUNNER;
    public ConfigHelper.ConfigValueListener<Integer> EGUNNER;
    public ConfigHelper.ConfigValueListener<Integer> NGUNNER;
    public ConfigHelper.ConfigValueListener<Integer> SNOWBALLER;
    public ConfigHelper.ConfigValueListener<Integer> ESNOWBALLER;
    public ConfigHelper.ConfigValueListener<Integer> NSNOWBALLER;
    public ConfigHelper.ConfigValueListener<Integer> GIFTER;
    public ConfigHelper.ConfigValueListener<Integer> EGIFTER;
    public ConfigHelper.ConfigValueListener<Integer> NGIFTER;
    public ConfigHelper.ConfigValueListener<Integer> ZAPPER;
    public ConfigHelper.ConfigValueListener<Integer> EZAPPER;
    public ConfigHelper.ConfigValueListener<Integer> NZAPPER;



    public CConfiguration(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify the rules for mobs to exist.").push(CCATEGORY_MOBFACTOR);
        this.SPAWNTEMPS = subscriber.subscribe(builder.comment("Changes temperature spawn requirements. 0: Cold, 1: Neutral, 2: Warm, 3: Hot.").defineInRange("spawnTempRange", 0, 0, 3));
        this.NETHERSNOW = subscriber.subscribe(builder.comment("Allows the cold snap horde to spawn in the nether.").define("snowmanInNether", false));
        this.OCEANSNOW = subscriber.subscribe(builder.comment("Allows the cold snap horde to spawn in the middle of the ocean.").define("snowmanInOcean", false));
        this.ENDSNOW = subscriber.subscribe(builder.comment("Allows the cold snap horde to spawn in the end").define("snowmanInEnd", false));
        this.HEATPROT = subscriber.subscribe(builder.comment("Defines how hot a cold snap snowman can get before it melts. 0: Cold, 1: Neutral, 2: Warm, 3: Hot (Recommend matching or being higher than spawnTempRange, or being 3 if snowmanInNether").defineInRange("snowSunScreen", 1, 0, 3));
        this.SNOWTRAIL = subscriber.subscribe(builder.comment("Defines how hot a cold snap snowman can be and still leave a snow trail. 0: Cold, 1: Neutral, 2: Warm, 3: Hot").defineInRange("snowTrailTemperature", 1, 0, 3));
        builder.pop();
        builder.comment("Modify spawn chances per dimension, per horde member. Higher values makes them more likely to spawn").push(CCATEGORY_NUMBERS);
        this.STABBER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Stabber in the Overworld").defineInRange("stabberOverworldWeight", 20, 0, 1000));
        this.ESTABBER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Stabber in the End").defineInRange("stabberEndWeight", 2, 0, 1000));
        this.NSTABBER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Stabber in the Nether").defineInRange("stabberNetherWeight", 10, 0, 1000));
        this.GUNNER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Gunner in the Overworld").defineInRange("gunnerOverworldWeight", 20, 0, 1000));
        this.EGUNNER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Gunner in the End").defineInRange("gunnerEndWeight", 2, 0, 1000));
        this.NGUNNER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Gunner in the Nether").defineInRange("gunnerNetherWeight", 10, 0, 1000));
        this.SNOWBALLER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Snowballer in the Overworld").defineInRange("snowballerOverworldWeight", 20, 0, 1000));
        this.ESNOWBALLER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Snowballer in the End").defineInRange("snowballerEndWeight", 2, 0, 1000));
        this.NSNOWBALLER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Snowballer in the Nether").defineInRange("snowballerNetherWeight", 10, 0, 1000));
        this.GIFTER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Gifter in the Overworld").defineInRange("gifterOverworldWeight", 10, 0, 1000));
        this.EGIFTER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Gifter in the End").defineInRange("gifterEndWeight", 1, 0, 1000));
        this.NGIFTER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Gifter in the Nether").defineInRange("gifterNetherWeight", 5, 0, 1000));
        this.ZAPPER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Zapper in the Overworld").defineInRange("zapperOverworldWeight", 6, 0, 1000));
        this.EZAPPER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Zapper in the End").defineInRange("zapperEndWeight", 1, 0, 1000));
        this.NZAPPER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Zapper in the Nether").defineInRange("zapperNetherWeight", 3, 0, 1000));
    }
}
