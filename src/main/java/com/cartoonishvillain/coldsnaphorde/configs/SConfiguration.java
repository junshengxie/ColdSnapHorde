package com.cartoonishvillain.coldsnaphorde.configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SConfiguration {
    public static final String SCATEGORY_TOOLS = "Tools";
    public static final String SCATEGORY_HORDE = "Horde Settings";

    public ConfigHelper.ConfigValueListener<Boolean> TECHNICALTHERMOMETER;
    public ConfigHelper.ConfigValueListener<Integer> STICKTRANSPONDER;
    public ConfigHelper.ConfigValueListener<Boolean> PLAGUEIMMORTUOSCOMPAT;
    public ConfigHelper.ConfigValueListener<Boolean> HORDETAKESMOREFIRE;

    public ConfigHelper.ConfigValueListener<Integer> GLOBALHORDECOOLDOWN;
    public ConfigHelper.ConfigValueListener<Integer> TIER1HORDESIZE;
    public ConfigHelper.ConfigValueListener<Integer> TIER1ALIVEEASY;
    public ConfigHelper.ConfigValueListener<Integer> TIER1ALIVENORMAL;
    public ConfigHelper.ConfigValueListener<Integer> TIER1ALIVEHARD;
    public ConfigHelper.ConfigValueListener<Integer> UPDATETICK;

    public ConfigHelper.ConfigValueListener<Integer> FROSTYHARVESTCOOLDOWN;


    public SConfiguration(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify how certain items and mobs work").push(SCATEGORY_TOOLS);
        this.TECHNICALTHERMOMETER = subscriber.subscribe(builder.comment("Enables or disabled technical levels of thermometers. Gives minecraft temperature values instead of adapted ones.").define("technicalThermometer", false));
        this.STICKTRANSPONDER = subscriber.subscribe(builder.comment("The percent chance that the snowman zapper will stick a transponder on his target if one is available.").defineInRange("transponderStick", 20, 0, 100));
        this.PLAGUEIMMORTUOSCOMPAT = subscriber.subscribe(builder.comment("Plague variants of the Cold Snap Horde can infect attack entities with Immortuos Calyx if it is installed alongside this mod.").define("plagueImmortuosCompat", true));
        this.HORDETAKESMOREFIRE = subscriber.subscribe(builder.comment("Horde snowmen take double damage from fire.").define("fireMeltsSnowBetter", true));
        this.FROSTYHARVESTCOOLDOWN = subscriber.subscribe(builder.comment("How long in ticks (20 per second by default) it takes for a frosty cow to be ready to be \"milked\" for powdered snow again.").define("frostyHarvestCooldown", 1800));
        builder.pop();
        builder.comment("Modify how hordes operate. Spawn rates, life counters, etc.").push(SCATEGORY_HORDE);
        this.GLOBALHORDECOOLDOWN = subscriber.subscribe(builder.comment("How long in seconds players need to wait inbetween Snowglobe usage (Spawning a notable number of snowmen)").defineInRange("globalHordeCooldown", 60, 1, 3600));
        this.TIER1HORDESIZE = subscriber.subscribe(builder.comment("How many horde members will a horde attempt to spawn at once. Once this limit is reached, the horde will not spawn more members until the amount of members alive or in range fall below this number").defineInRange("snowmanHordeSize", 5, 5, 50));
        this.TIER1ALIVEEASY = subscriber.subscribe(builder.comment("Default amount of horde members needed to be killed in a tier 1 horde on easy difficulty before the horde deactivates with a player victory").defineInRange("easyAliveCount", 20, 1, 20000));
        this.TIER1ALIVENORMAL = subscriber.subscribe(builder.comment("Default amount of horde members needed to be killed in a tier 1 horde on normal difficulty before the horde deactivates with a player victory").defineInRange("normalAliveCount", 30, 1, 20000));
        this.TIER1ALIVEHARD = subscriber.subscribe(builder.comment("Default amount of horde members needed to be killed in a tier 1 horde on hard difficulty before the horde deactivates with a player victory").defineInRange("hardAliveCount", 40, 1, 20000));
        this.UPDATETICK = subscriber.subscribe(builder.comment("How often more expensive update ticks occur. This allows new in range players to get the bossbar, and updates the horde with the position of their main target. Higher reduces frequency of these more expensive ticks, but lowers horde responsiveness.").defineInRange("hordeUpdateCooldown", 100, 20, 3600));
        builder.pop();
    }
}