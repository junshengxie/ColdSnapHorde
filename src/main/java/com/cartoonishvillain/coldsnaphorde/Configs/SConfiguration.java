package com.cartoonishvillain.coldsnaphorde.Configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SConfiguration {
    public static final String SCATEGORY_TOOLS = "Tools";

    public static final String SCATEGORY_MOBFACTOR = "Mob Properties";

    public ConfigHelper.ConfigValueListener<Boolean> TECHNICALTHERMOMETER;
    public ConfigHelper.ConfigValueListener<Integer> STICKTRANSPONDER;
    public ConfigHelper.ConfigValueListener<Integer> GLOBALHORDECOOLDOWN;
    public ConfigHelper.ConfigValueListener<Integer> HORDESIZE;
    public ConfigHelper.ConfigValueListener<Boolean> HORDETAKESMOREFIRE;
    public ConfigHelper.ConfigValueListener<Boolean> PLAGUEIMMORTUOSCOMPAT;
    public ConfigHelper.ConfigValueListener<Integer> FROSTYHARVESTCOOLDOWN;


    public SConfiguration(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber){
        builder.comment("Modify how certain items and mobs work").push(SCATEGORY_TOOLS);
        this.TECHNICALTHERMOMETER = subscriber.subscribe(builder.comment("Enables or disabled technical levels of thermometers. Gives minecraft temperature values instead of adapted ones.").define("technicalThermometer", false));
        this.STICKTRANSPONDER = subscriber.subscribe(builder.comment("The percent chance that the snowman zapper will stick a transponder on his target if one is available.").defineInRange("transponderStick", 20, 0, 100));
        this.GLOBALHORDECOOLDOWN = subscriber.subscribe(builder.comment("How long in seconds players need to wait inbetween Snowglobe usage (Spawning a notable number of snowmen)").defineInRange("globalHordeCooldown", 60, 1, 3600));
        this.HORDESIZE = subscriber.subscribe(builder.comment("How large snowmen hordes are when manually summoned.").defineInRange("snowmanHordeSize", 10, 5, 50));
        this.HORDETAKESMOREFIRE = subscriber.subscribe(builder.comment("Horde snowmen take double damage from fire.").define("fireMeltsSnowBetter", true));
        this.PLAGUEIMMORTUOSCOMPAT = subscriber.subscribe(builder.comment("Plague variants of the Cold Snap Horde can infect attack entities with Immortuos Calyx if it is installed alongside this mod.").define("plagueImmortuosCompat", true));
        this.FROSTYHARVESTCOOLDOWN = subscriber.subscribe(builder.comment("How long in ticks (20 per second by default) it takes for a frosty cow to be ready to be \"milked\" for powdered snow again.").define("frostyHarvestCooldown", 1800));
        builder.pop();
    }
}
