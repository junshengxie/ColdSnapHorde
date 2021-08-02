package com.cartoonishvillain.coldsnaphorde.Configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CConfiguration {

    public static final String CCATEGORY_MOBFACTOR = "Mob Properties";

    public static final String CCATEGORY_NUMBERS = "Spawn Rates";

    public ConfigHelper.ConfigValueListener<Integer> SPAWNTEMPS;
    public ConfigHelper.ConfigValueListener<Integer> HEATPROT;
    public ConfigHelper.ConfigValueListener<Integer> SNOWTRAIL;

    public ConfigHelper.ConfigValueListener<Integer> STABBER;
    public ConfigHelper.ConfigValueListener<Integer> GUNNER;
    public ConfigHelper.ConfigValueListener<Integer> SNOWBALLER;
    public ConfigHelper.ConfigValueListener<Integer> GIFTER;
    public ConfigHelper.ConfigValueListener<Integer> ZAPPER;
    public ConfigHelper.ConfigValueListener<Integer> BRAWLER;

    public ConfigHelper.ConfigValueListener<Double> FLAMINGSPAWNINSTANDARD;
    public ConfigHelper.ConfigValueListener<Double> ENDERSPAWNINSTANDARD;
    public ConfigHelper.ConfigValueListener<Double> PLAGUESPAWNINSTANDARD;
    public ConfigHelper.ConfigValueListener<Double> PLAGUESPAWNINSWAMP;


    public ConfigHelper.ConfigValueListener<String> BiomeExclusion;



    public CConfiguration(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify the rules for mobs to exist.").push(CCATEGORY_MOBFACTOR);
        this.SPAWNTEMPS = subscriber.subscribe(builder.comment("Changes temperature spawn requirements. 0: Cold, 1: Neutral, 2: Warm, 3: Hot.").defineInRange("spawnTempRange", 0, 0, 3));
        this.HEATPROT = subscriber.subscribe(builder.comment("Defines how hot a cold snap snowman can get before it melts. 0: Cold, 1: Neutral, 2: Warm, 3: Hot (Recommend matching or being higher than spawnTempRange, or being 3 if snowmanInNether").defineInRange("snowSunScreen", 1, 0, 3));
        this.SNOWTRAIL = subscriber.subscribe(builder.comment("Defines how hot a cold snap snowman can be and still leave a snow trail. 0: Cold, 1: Neutral, 2: Warm, 3: Hot").defineInRange("snowTrailTemperature", 1, 0, 3));
        this.BiomeExclusion = subscriber.subscribe(builder.comment("EXPERIMENTAL! MUST BE ALL CHARACTERS FROM [a-z0-9/._-] OR THE GAME WILL CRASH. List the biome names seperated by commas that you want to absolutely exclude the horde from. (eg: minecraft:desert,minecraft:jungle)").define("hordeBiomeExclusion", "notabiome"));
        builder.pop();
        builder.comment("Modify spawn chances per horde member. Higher values makes them more likely to spawn").push(CCATEGORY_NUMBERS);
        this.STABBER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Stabber in the Overworld").defineInRange("stabberOverworldWeight", 20, 0, 1000));
        this.GUNNER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Gunner in the Overworld").defineInRange("gunnerOverworldWeight", 20, 0, 1000));
        this.SNOWBALLER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Snowballer in the Overworld").defineInRange("snowballerOverworldWeight", 20, 0, 1000));
        this.GIFTER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Gifter in the Overworld").defineInRange("gifterOverworldWeight", 10, 0, 1000));
        this.ZAPPER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Zapper in the Overworld").defineInRange("zapperOverworldWeight", 6, 0, 1000));
        this.BRAWLER = subscriber.subscribe(builder.comment("Changes the spawn weight of the Brawler in the Overworld").defineInRange("brawlerOverworldWeight", 8, 0, 1000));
        this.FLAMINGSPAWNINSTANDARD = subscriber.subscribe(builder.comment("Changes the roll requirements for a flaming category horde member to spawn in place of a standard one (one effected by the SpawnTemps). Lower is rarer, 0 is impossible").defineInRange("flamingSpawnRequirement", 3.0, 0.0, 100.0));
        this.ENDERSPAWNINSTANDARD = subscriber.subscribe(builder.comment("Changes the roll requirements for an ender category horde member to spawn in place of a standard one (one effected by the SpawnTemps), Lower is rarer, 0 is impossible").defineInRange("enderSpawnRequirement", 3.0, 0.0, 100.0));
        this.PLAGUESPAWNINSTANDARD = subscriber.subscribe(builder.comment("Changes the roll requirements for a plague category horde member to spawn in place of a standard one (one effected by the SpawnTemps), Lower is rarer, 0 is impossible").defineInRange("plagueSpawnRequirement", 2.0, 0.0, 100.0));
        this.PLAGUESPAWNINSWAMP = subscriber.subscribe(builder.comment("Changes the roll requirements for a plague category horde member to spawn in a swamp, their natural habitat. If the roll is failed, a standard will try to take it's place. If it can't, the spawn will fail.").defineInRange("plagueSwampSpawn", 100.0, 0.0, 100.0));

    }
}
