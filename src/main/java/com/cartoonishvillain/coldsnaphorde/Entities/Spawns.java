package com.cartoonishvillain.coldsnaphorde.Entities;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Mob;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Animal;
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
        MobSpawnSettings.SpawnerData spawners1 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.GUNNER.get(),1,1);
        MobSpawnSettings.SpawnerData spawners2 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.SNOWBALLER.get(),1,1);
        MobSpawnSettings.SpawnerData spawners3 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.GIFTER.get(),1,1);
        MobSpawnSettings.SpawnerData spawners4 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.ZAPPER.get(),1,1);
        MobSpawnSettings.SpawnerData spawners5 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.BRAWLER.get(),1,1);
        MobSpawnSettings.SpawnerData spawners6 = new MobSpawnSettings.SpawnerData(Register.COLDSNAPCOW.get(), 8,4, 4);


        if (BiomeExclusion(finalBiomeExclusion, event.getName()) && !event.getName().toString().contains("swamp")){
        if(ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 0 && event.getClimate().temperature < 0.3f){
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
            event.getSpawns().addSpawn(MobCategory.CREATURE, spawners6);
        }
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 1 && event.getClimate().temperature < 0.9f){
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
            event.getSpawns().addSpawn(MobCategory.CREATURE, spawners6);
        }
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 2 && event.getClimate().temperature < 1.5f){
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
            event.getSpawns().addSpawn(MobCategory.CREATURE, spawners6);

        }
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 3){
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
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners1);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners2);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners3);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners4);
            event.getSpawns().addSpawn(MobCategory.MONSTER, spawners5);
        }
    }

    public static void PlacementManager(){
        SpawnPlacements.register(Register.COLDSNAPSTABBER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(Register.COLDSNAPSNOWBALLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(Register.COLDSNAPGUNNER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(Register.COLDSNAPGIFTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(Register.COLDSNAPZAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(Register.COLDSNAPBRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(Register.COLDSNAPCOW.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }

    public static Boolean BiomeExclusion(ResourceLocation[] BiomeExclusion, ResourceLocation name){
        for (ResourceLocation i : BiomeExclusion){
            if (i.toString().equals(name.toString())){return false;}
        }
        return true;
    }
}
