package com.villain.coldsnaphorde.entities;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import com.villain.coldsnaphorde.Register;
import com.villain.coldsnaphorde.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Spawns {
    @SubscribeEvent
    public static void SnowmanSpawner(BiomeLoadingEvent event){
        final String BiomeList = ForgeColdSnapHorde.cconfig.BiomeExclusion.get();
        String[] biomeExclusion = BiomeList.split(",");
        int exclusionLength = biomeExclusion.length;
        ResourceLocation[] finalBiomeExclusion = new ResourceLocation[exclusionLength];
        int counter = 0;
        for(String i : biomeExclusion){
            ResourceLocation newResource = new ResourceLocation(i);
            finalBiomeExclusion[counter] = newResource;
            counter++;
        }
        MobSpawnSettings.SpawnerData spawners = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSTABBER.get(), ForgeColdSnapHorde.cconfig.STABBER.get(), 1, 1);
        MobSpawnSettings.SpawnerData spawners1 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGUNNER.get(), ForgeColdSnapHorde.cconfig.GUNNER.get(), 1, 1);
        MobSpawnSettings.SpawnerData spawners2 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSNOWBALLER.get(), ForgeColdSnapHorde.cconfig.SNOWBALLER.get(), 1, 1);
        MobSpawnSettings.SpawnerData spawners3 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGIFTER.get(), ForgeColdSnapHorde.cconfig.GIFTER.get(), 1, 1);
        MobSpawnSettings.SpawnerData spawners4 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPZAPPER.get(), ForgeColdSnapHorde.cconfig.ZAPPER.get(), 1, 1);
        MobSpawnSettings.SpawnerData spawners5 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPBRAWLER.get(), ForgeColdSnapHorde.cconfig.BRAWLER.get(), 1, 1);
        MobSpawnSettings.SpawnerData spawners6 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPCOW.get(), ForgeColdSnapHorde.cconfig.SNOWCOW.get(),2, 4);


        MobSpawnSettings.SpawnerData nspawners = new MobSpawnSettings.SpawnerData(Register.NCOLDSNAPSTABBER.get(), ForgeColdSnapHorde.cconfig.DSTABBER.get(), 1, 1);
        MobSpawnSettings.SpawnerData nspawners1 = new MobSpawnSettings.SpawnerData(Register.NCOLDSNAPGUNNER.get(), ForgeColdSnapHorde.cconfig.DGUNNER.get(), 1, 1);
        MobSpawnSettings.SpawnerData nspawners2 = new MobSpawnSettings.SpawnerData(Register.NCOLDSNAPSNOWBALLER.get(), ForgeColdSnapHorde.cconfig.DSNOWBALLER.get(), 1, 1);
        MobSpawnSettings.SpawnerData nspawners3 = new MobSpawnSettings.SpawnerData(Register.NCOLDSNAPGIFTER.get(), ForgeColdSnapHorde.cconfig.DGIFTER.get(), 1, 1);
        MobSpawnSettings.SpawnerData nspawners4 = new MobSpawnSettings.SpawnerData(Register.NCOLDSNAPZAPPER.get(), ForgeColdSnapHorde.cconfig.DZAPPER.get(), 1, 1);
        MobSpawnSettings.SpawnerData nspawners5 = new MobSpawnSettings.SpawnerData(Register.NCOLDSNAPBRAWLER.get(), ForgeColdSnapHorde.cconfig.DBRAWLER.get(), 1, 1);

        MobSpawnSettings.SpawnerData espawners = new MobSpawnSettings.SpawnerData(Register.ECOLDSNAPSTABBER.get(), ForgeColdSnapHorde.cconfig.DSTABBER.get(), 1, 1);
        MobSpawnSettings.SpawnerData espawners1 = new MobSpawnSettings.SpawnerData(Register.ECOLDSNAPGUNNER.get(), ForgeColdSnapHorde.cconfig.DGUNNER.get(), 1, 1);
        MobSpawnSettings.SpawnerData espawners2 = new MobSpawnSettings.SpawnerData(Register.ECOLDSNAPSNOWBALLER.get(), ForgeColdSnapHorde.cconfig.DSNOWBALLER.get(), 1, 1);
        MobSpawnSettings.SpawnerData espawners3 = new MobSpawnSettings.SpawnerData(Register.ECOLDSNAPGIFTER.get(), ForgeColdSnapHorde.cconfig.DGIFTER.get(), 1, 1);
        MobSpawnSettings.SpawnerData espawners4 = new MobSpawnSettings.SpawnerData(Register.ECOLDSNAPZAPPER.get(), ForgeColdSnapHorde.cconfig.DZAPPER.get(), 1, 1);
        MobSpawnSettings.SpawnerData espawners5 = new MobSpawnSettings.SpawnerData(Register.ECOLDSNAPBRAWLER.get(), ForgeColdSnapHorde.cconfig.DBRAWLER.get(), 1, 1);

        MobSpawnSettings.SpawnerData pspawners = new MobSpawnSettings.SpawnerData(Register.PCOLDSNAPSTABBER.get(), ForgeColdSnapHorde.cconfig.STABBER.get(), 1, 1);
        MobSpawnSettings.SpawnerData pspawners1 = new MobSpawnSettings.SpawnerData(Register.PCOLDSNAPGUNNER.get(), ForgeColdSnapHorde.cconfig.GUNNER.get(), 1, 1);
        MobSpawnSettings.SpawnerData pspawners2 = new MobSpawnSettings.SpawnerData(Register.PCOLDSNAPSNOWBALLER.get(), ForgeColdSnapHorde.cconfig.SNOWBALLER.get(), 1, 1);
        MobSpawnSettings.SpawnerData pspawners3 = new MobSpawnSettings.SpawnerData(Register.PCOLDSNAPGIFTER.get(), ForgeColdSnapHorde.cconfig.GIFTER.get(), 1, 1);
        MobSpawnSettings.SpawnerData pspawners4 = new MobSpawnSettings.SpawnerData(Register.PCOLDSNAPZAPPER.get(), ForgeColdSnapHorde.cconfig.ZAPPER.get(), 1, 1);
        MobSpawnSettings.SpawnerData pspawners5 = new MobSpawnSettings.SpawnerData(Register.PCOLDSNAPBRAWLER.get(), ForgeColdSnapHorde.cconfig.BRAWLER.get(), 1, 1);

        if (BiomeExclusion(finalBiomeExclusion, event.getName()) && !event.getName().toString().contains("swamp") && !(event.getCategory() == Biome.BiomeCategory.NETHER || event.getCategory() == Biome.BiomeCategory.THEEND || event.getCategory() == Biome.BiomeCategory.MUSHROOM)){
            if(ForgeColdSnapHorde.cconfig.SPAWNTEMPS.get() == 0 && event.getClimate().temperature < 0.3f){
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
                event.getSpawns().addSpawn(MobCategory.CREATURE, spawners6);
            }
            else if (ForgeColdSnapHorde.cconfig.SPAWNTEMPS.get() == 1 && event.getClimate().temperature < 0.9f){
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
                event.getSpawns().addSpawn(MobCategory.CREATURE, spawners6);
            }
            else if (ForgeColdSnapHorde.cconfig.SPAWNTEMPS.get() == 2 && event.getClimate().temperature < 1.5f){
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
                event.getSpawns().addSpawn(MobCategory.CREATURE, spawners6);

            }
            else if (ForgeColdSnapHorde.cconfig.SPAWNTEMPS.get() == 3){
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
                event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
                event.getSpawns().addSpawn(MobCategory.CREATURE, spawners6);
            }
        }
        else if(event.getName().toString().contains("swamp")){
            event.getSpawns().addSpawn(MobCategory.MONSTER, pspawners);
            event.getSpawns().addSpawn(MobCategory.MONSTER, pspawners1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, pspawners2);
            event.getSpawns().addSpawn(MobCategory.MONSTER, pspawners3);
            event.getSpawns().addSpawn(MobCategory.MONSTER, pspawners4);
            event.getSpawns().addSpawn(MobCategory.MONSTER, pspawners5);
        }
        else if(event.getCategory() == Biome.BiomeCategory.NETHER && ForgeColdSnapHorde.cconfig.DSPAWN.get()){
            event.getSpawns().addSpawn(MobCategory.MONSTER, nspawners);
            event.getSpawns().addSpawn(MobCategory.MONSTER, nspawners1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, nspawners2);
            event.getSpawns().addSpawn(MobCategory.MONSTER, nspawners3);
            event.getSpawns().addSpawn(MobCategory.MONSTER, nspawners4);
            event.getSpawns().addSpawn(MobCategory.MONSTER, nspawners5);
        }
        else if(event.getCategory() == Biome.BiomeCategory.THEEND && ForgeColdSnapHorde.cconfig.DSPAWN.get()){
            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners);
            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners2);
            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners3);
            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners4);
            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners5);
        }

    }



    public static void PlacementManager(){
        if (!ForgeColdSnapHorde.cconfig.PROGRESSIVESPAWNS.get()) {
            SpawnPlacements.register(Register.COLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnPlacements.register(Register.COLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
            SpawnPlacements.register(Register.COLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
            SpawnPlacements.register(Register.COLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
            SpawnPlacements.register(Register.COLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.COLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.COLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.NCOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.PCOLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.   MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
        }


        SpawnPlacements.register(Register.COLDSNAPCOW.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }

    public static boolean doMobSpawn(EntityType<? extends Monster> p_33018_, ServerLevelAccessor p_33019_, MobSpawnType p_33020_, BlockPos p_33021_, Random p_33022_, int level) {
        if (ForgeColdSnapHorde.hordeDataManager.getHighestLevelBeaten() >= level) {
            return Monster.checkMonsterSpawnRules(p_33018_, p_33019_, p_33020_, p_33021_, p_33022_);
        }
        return Spawns.returnFalse(p_33018_, p_33019_, p_33020_, p_33021_, p_33022_);
    }

    private static boolean returnFalse(EntityType<? extends Monster> monsterEntityType, ServerLevelAccessor serverLevelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, Random random) {
        return false;
    }

    public static Boolean BiomeExclusion(ResourceLocation[] BiomeExclusion, ResourceLocation name){
        for (ResourceLocation i : BiomeExclusion){
            if (i.toString().equals(name.toString())){return false;}
        }
        return true;
    }
}
