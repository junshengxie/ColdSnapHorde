package com.jedijoe.coldsnaphorde.Entities;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Register;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Spawns {
    @SubscribeEvent
    public static void SnowmanSpawner(BiomeLoadingEvent event){
        MobSpawnInfo.Spawners spawners = new MobSpawnInfo.Spawners(Register.COLDSNAPSTABBER.get(), 40,1,1);
        MobSpawnInfo.Spawners spawners1 = new MobSpawnInfo.Spawners(Register.COLDSNAPGUNNER.get(), 40,1,1);
        MobSpawnInfo.Spawners spawners2 = new MobSpawnInfo.Spawners(Register.COLDSNAPSNOWBALLER.get(), 40,1,1);


        if (event.getCategory() != Biome.Category.NETHER && event.getCategory() != Biome.Category.THEEND && event.getCategory() != Biome.Category.OCEAN){
        if(ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 0 && event.getClimate().temperature < 0.3f){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);}
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 1 && event.getClimate().temperature < 0.9f){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);}
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 2 && event.getClimate().temperature < 1.5f){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);}
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 3){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
        }
        }

        if(ColdSnapHorde.cconfig.OCEANSNOW.get() && event.getCategory() == Biome.Category.OCEAN){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
        }

        if(ColdSnapHorde.cconfig.NETHERSNOW.get() && event.getCategory() == Biome.Category.NETHER){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
        }

        if(ColdSnapHorde.cconfig.ENDSNOW.get() && event.getCategory() == Biome.Category.THEEND){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
        }
    }

    public static void PlacementManager(){
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPSTABBER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPSNOWBALLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPGUNNER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
    }
}
