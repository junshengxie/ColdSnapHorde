package com.villain.coldsnaphorde.platform.services;

import net.minecraft.world.item.CreativeModeTab;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

    boolean PLAGUEIMMORTUOSCOMPAT();

    CreativeModeTab TAB();

}

//    int SPAWNTEMPS();
//    int HEATPROT();
//    int SNOWTRAIL();
//    int PROGRESSIVESPAWNS();
//    String BiomeExclusion();
//    int STABBER();
//    int GUNNER();
//    int SNOWBALLER();
//    int GIFTER();
//    int ZAPPER();
//    int BRAWLER();
//    int DSTABBER();
//    int DGUNNER();
//    int DSNOWBALLER();
//    int DGIFTER();
//    int DZAPPER();
//    int DBRAWLER();
//    int SNOWCOW();
//
//    boolean TECHNICALTHERMOMETER();
//    int STICKTRANSPONDER();

//    boolean HORDETAKESMOREFIRE();
//    int FROSTYHARVESTCOOLDOWN();
//    int GLOBALHORDECOOLDOWN();
//    int TIER1HORDESIZE();
//    int TIER1ALIVEEASY();
//    int TIER1ALIVENORMAL();
//    int TIER1ALIVEHARD();
//    int TIER2HORDESIZE();
//    int TIER2ALIVEEASY();
//    int TIER2ALIVENORMAL();
//    int TIER2ALIVEHARD();
//    int TIER3HORDESIZE();
//    int TIER3ALIVEEASY();
//    int TIER3ALIVENORMAL();
//    int TIER3ALIVEHARD();
//    int UPDATETICK();
//
//    boolean OLD_SNOW();
//
//    EntityType<ColdSnapGunner> COLDSNAPGUNNER();
//    EntityType<ColdSnapGunner> NCOLDSNAPGUNNER();
//    EntityType<ColdSnapGunner> ECOLDSNAPGUNNER();
//    EntityType<ColdSnapGunner> PCOLDSNAPGUNNER();
//
//    EntityType<ColdSnapStabber> COLDSNAPSTABBER();
//    EntityType<ColdSnapStabber> NCOLDSNAPSTABBER();
//    EntityType<ColdSnapStabber> ECOLDSNAPSTABBER();
//    EntityType<ColdSnapStabber> PCOLDSNAPSTABBER();
//
//    EntityType<ColdSnapSnowballer> COLDSNAPSNOWBALLER();
//    EntityType<ColdSnapSnowballer> NCOLDSNAPSNOWBALLER();
//    EntityType<ColdSnapSnowballer> ECOLDSNAPSNOWBALLER();
//    EntityType<ColdSnapSnowballer> PCOLDSNAPSNOWBALLER();
//
//    EntityType<ColdSnapGifter> COLDSNAPGIFTER();
//    EntityType<ColdSnapGifter> NCOLDSNAPGIFTER();
//    EntityType<ColdSnapGifter> ECOLDSNAPGIFTER();
//    EntityType<ColdSnapGifter> PCOLDSNAPGIFTER();
//
//    EntityType<ColdSnapZapper> COLDSNAPZAPPER();
//    EntityType<ColdSnapZapper> NCOLDSNAPZAPPER();
//    EntityType<ColdSnapZapper> ECOLDSNAPZAPPER();
//    EntityType<ColdSnapZapper> PCOLDSNAPZAPPER();
//
//    EntityType<ColdSnapBrawler> COLDSNAPBRAWLER();
//    EntityType<ColdSnapBrawler> NCOLDSNAPBRAWLER();
//    EntityType<ColdSnapBrawler> ECOLDSNAPBRAWLER();
//    EntityType<ColdSnapBrawler> PCOLDSNAPBRAWLER();
//
//    EntityType<GunnerProjectileEntity> GUNNERPROJECTILE();
//    EntityType<RockSnowballEntity> ROCKSNOWBALLPROJECTILE();
//    EntityType<ThrownChorusEntity> THROWNCHORUSPROJECTILE();
//    EntityType<SnowierSnowballEntity> SNOWIERSNOWBALLPROJECTILE();
//    EntityType<LightningSnowEntity> LIGHTNINGSNOWBALLPROJECTILE();
//    EntityType<HealingSnowballEntity> HEALINGSNOWBALLPROJECTILE();
//    EntityType<IceProjectile> ICEPROJECTILE();
//
//    SoundEvent GIFTERATTACK();
//
//}
