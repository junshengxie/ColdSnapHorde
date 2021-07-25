package com.cartoonishvillain.coldsnaphorde.Entities;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Mob;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Spawns {
    @SubscribeEvent
    public static void SnowmanSpawner(BiomeLoadingEvent event){
        final String BiomeList = ColdSnapHorde.cconfig.BiomeExclusion.get();
        String[] biomeExclusion = BiomeList.split(",");
        int exclusionLength = biomeExclusion.length;
        ResourceLocation[] finalBiomeExclusion = new ResourceLocation[exclusionLength];
        int counter = 0;
        for(String i : biomeExclusion){
            ResourceLocation newResource = new ResourceLocation(i);
            finalBiomeExclusion[counter] = newResource;
            counter++;
        }

        MobSpawnSettings.SpawnerData spawners = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.STABBER.get(),1,1);
//        MobSpawnSettings.SpawnerData spawners1 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.GUNNER.get(),1,1);
//        MobSpawnSettings.SpawnerData spawners2 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.SNOWBALLER.get(),1,1);
//        MobSpawnSettings.SpawnerData spawners3 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.GIFTER.get(),1,1);
//        MobSpawnSettings.SpawnerData spawners4 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.ZAPPER.get(),1,1);
//        MobSpawnSettings.SpawnerData spawners5 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.BRAWLER.get(),1,1);


        if (event.getCategory() != Biome.BiomeCategory.NETHER && event.getCategory() != Biome.BiomeCategory.THEEND && event.getCategory() != Biome.BiomeCategory.OCEAN && BiomeExclusion(finalBiomeExclusion, event.getName())){
        if(ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 0 && event.getClimate().temperature < 0.3f){
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
        }
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 1 && event.getClimate().temperature < 0.9f){
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
        }
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 2 && event.getClimate().temperature < 1.5f){
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
        }
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 3){
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
        }
        }

        if(ColdSnapHorde.cconfig.OCEANSNOW.get() && event.getCategory() == Biome.BiomeCategory.OCEAN && BiomeExclusion(finalBiomeExclusion, event.getName())){
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
        }

        if(ColdSnapHorde.cconfig.NETHERSNOW.get() && event.getCategory() == Biome.BiomeCategory.NETHER && BiomeExclusion(finalBiomeExclusion, event.getName())){
            MobSpawnSettings.SpawnerData espawners = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.NSTABBER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners1 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.NGUNNER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners2 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.NSNOWBALLER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners3 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.NGIFTER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners4 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.NZAPPER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners5 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPBRAWLER.get(), ColdSnapHorde.cconfig.NBRAWLER.get(),1,1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners1);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners2);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners3);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners4);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners5);
        }

        if(ColdSnapHorde.cconfig.ENDSNOW.get() && event.getCategory() == Biome.BiomeCategory.THEEND && BiomeExclusion(finalBiomeExclusion, event.getName())){
            MobSpawnSettings.SpawnerData espawners = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.ESTABBER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners1 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.EGUNNER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners2 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.ESNOWBALLER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners3 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.EGIFTER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners4 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.EZAPPER.get(),1,1);
//            MobSpawnSettings.SpawnerData espawners5 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPBRAWLER.get(), ColdSnapHorde.cconfig.EBRAWLER.get(),1,1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners1);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners2);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners3);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners4);
//            event.getSpawns().addSpawn(MobCategory.MONSTER, espawners5);
        }
    }

    public static void PlacementManager(){
        SpawnPlacements.register(Register.COLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
//        SpawnPlacements.register(Register.COLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
//        SpawnPlacements.register(Register.COLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
//        SpawnPlacements.register(Register.COLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
//        SpawnPlacements.register(Register.COLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
//        SpawnPlacements.register(Register.COLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }

    public static Boolean BiomeExclusion(ResourceLocation[] BiomeExclusion, ResourceLocation name){
        for (ResourceLocation i : BiomeExclusion){
            if (i.toString().equals(name.toString())){return false;}
        }
        return true;
    }
}
