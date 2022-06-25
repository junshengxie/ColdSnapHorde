package com.villain.coldsnaphorde.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class ColdSnapConfig {

    public static String provider(String filename) {
        return "#Changes temperature spawn requirements for standard horde members. 0: Cold, 1: Neutral, 2: Warm, 3: Hot\n" +
                "SPAWNTEMPTS=0\n" +
                "#Defines how hot a standard snowmember can get before it melts. 0: Cold, 1: Neutral, 2: Warm, 3: Hot (Recommend matching or being higher than spawnTempRange\n" +
                "HEATPROT=1\n" +
                "#The hottest biome temperature a snow trail can spawn in, 0: Cold, 1: Neutral, 2: Warm, 3: Hot\n" +
                "SNOWTRAIL=1\n" +
                "#If true, cold snap horde mobs will be restricted to spawning only when unlocked by horde completion. If false, entities will spawn as if the world was through tier 3 already.\n" +
                "PROGRESSIVESPAWNS=true\n" +
                "#EXPERIMENTAL! MUST BE ALL CHARACTERS FROM [a-z0-9/._-] OR THE GAME WILL CRASH. List the biome names seperated by commas that you want to absolutely exclude the horde from. (eg: minecraft:desert,minecraft:jungle)\n" +
                "BiomeExclusion=notabiome\n" +
                "#Changes the spawn weight of the Stabber in the Overworld\n" +
                "STABBER=20\n" +
                "#Changes the spawn weight of the Gunner in the Overworld\n" +
                "GUNNER=20\n" +
                "#Changes the spawn weight of the Snowballer in the Overworld\n" +
                "SNOWBALLER=20\n" +
                "#Changes the spawn weight of the Gifter in the Overworld\n" +
                "GIFTER=10\n" +
                "#Changes the spawn weight of the Zapper in the Overworld\n" +
                "ZAPPER=6\n" +
                "#Changes the spawn weight of the Brawler in the Overworld\n" +
                "BRAWLER=8\n" +
                "#Changes the spawn weight of the Stabber other dimensions\n" +
                "DSTABBER=2\n" +
                "#Changes the spawn weight of the Gunner other dimensions\n" +
                "DGUNNER=2\n" +
                "#Changes the spawn weight of the Snowballer other dimensions\n" +
                "DSNOWBALLER=2\n" +
                "#Changes the spawn weight of the Gifter other dimensions\n" +
                "DGIFTER=1\n" +
                "#Changes the spawn weight of the Zapper other dimensions\n" +
                "DZAPPER=1\n" +
                "#Changes the spawn weight of the Brawler other dimensions\n" +
                "DBRAWLER=1\n" +
                "#Changes the spawn weight of the Frosty Cow\n" +
                "SNOWCOW=4\n" +
                "#Enables or disabled technical levels of thermometers. Gives minecraft temperature values instead of adapted ones.\n" +
                "TECHNICALTHERMOMETER=false\n" +
                "#The percent chance that the snowman zapper will stick a transponder on his target if one is available.\n" +
                "STICKTRANSPONDER=20\n" +
                "#Plague variants of the Cold Snap Horde can infect attack entities with Immortuos Calyx if it is installed alongside this mod.\n" +
                "PLAGUEIMMORTUOSCOMPAT=true\n" +
                "#Horde snowmen take double damage from fire.\n" +
                "HORDETAKESMOREFIRE=true\n" +
                "#How long in ticks (20 per second by default) it takes for a frosty cow to be ready to be \"milked\" for powdered snow again.\n" +
                "FROSTYHARVESTCOOLDOWN=1800\n" +
                "#How long in seconds players need to wait inbetween Snowglobe usage (Spawning a notable number of snowmen)\n" +
                "GLOBALHORDECOOLDOWN=60\n" +
                "#How many horde members will a tier 1 horde attempt to spawn at once. Once this limit is reached, the horde will not spawn more members until the amount of members alive or in range fall below this number\n" +
                "TIER1HORDESIZE=5\n" +
                "#Default amount of horde members needed to be killed in a tier 1 horde on easy difficulty before the horde deactivates with a player victory\n" +
                "TIER1ALIVEEASY=20\n" +
                "#Default amount of horde members needed to be killed in a tier 1 horde on normal difficulty before the horde deactivates with a player victory\n" +
                "TIER1ALIVENORMAL=30\n" +
                "#Default amount of horde members needed to be killed in a tier 1 horde on hard difficulty before the horde deactivates with a player victory\n" +
                "TIER1ALIVEHARD=40\n" +
                "#How many horde members will a tier 2 horde attempt to spawn at once. Once this limit is reached, the horde will not spawn more members until the amount of members alive or in range fall below this number\n" +
                "TIER2HORDESIZE=8\n" +
                "#Default amount of horde members needed to be killed in a tier 2 horde on easy difficulty before the horde deactivates with a player victory\n" +
                "TIER2ALIVEEASY=35\n" +
                "#Default amount of horde members needed to be killed in a tier 2 horde on normal difficulty before the horde deactivates with a player victory\n" +
                "TIER2ALIVENORMAL=50\n" +
                "#Default amount of horde members needed to be killed in a tier 2 horde on hard difficulty before the horde deactivates with a player victory\n" +
                "TIER2ALIVEHARD=65\n" +
                "#How many horde members will a tier 3 horde attempt to spawn at once. Once this limit is reached, the horde will not spawn more members until the amount of members alive or in range fall below this number\n" +
                "TIER3HORDESIZE=10\n" +
                "#Default amount of horde members needed to be killed in a tier 3 horde on easy difficulty before the horde deactivates with a player victory\n" +
                "TIER3ALIVEEASY=50\n" +
                "#Default amount of horde members needed to be killed in a tier 3 horde on normal difficulty before the horde deactivates with a player victory\n" +
                "TIER3ALIVENORMAL=65\n" +
                "#Default amount of horde members needed to be killed in a tier 3 horde on hard difficulty before the horde deactivates with a player victory\n" +
                "TIER3ALIVEHARD=80\n" +
                "#How often more expensive update ticks occur. This allows new in range players to get the bossbar, and updates the horde with the position of their main target. Higher reduces frequency of these more expensive ticks, but lowers horde responsiveness.\n" +
                "UPDATETICK=100\n" +
                "#Nostalgia mode. If true, snowmen are replaced with their original counterparts where applicable.\n" +
                "OLD_SNOW=false";
    }
}
