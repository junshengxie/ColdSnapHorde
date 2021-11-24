package com.cartoonishvillain.coldsnaphorde.Entities;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
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

        MobSpawnInfo.Spawners spawners = new MobSpawnInfo.Spawners(Register.COLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.STABBER.get(), 1, 1);
        MobSpawnInfo.Spawners spawners1 = new MobSpawnInfo.Spawners(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.GUNNER.get(), 1, 1);
        MobSpawnInfo.Spawners spawners2 = new MobSpawnInfo.Spawners(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.SNOWBALLER.get(), 1, 1);
        MobSpawnInfo.Spawners spawners3 = new MobSpawnInfo.Spawners(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.GIFTER.get(), 1, 1);
        MobSpawnInfo.Spawners spawners4 = new MobSpawnInfo.Spawners(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.ZAPPER.get(), 1, 1);
        MobSpawnInfo.Spawners spawners5 = new MobSpawnInfo.Spawners(Register.COLDSNAPBRAWLER.get(), ColdSnapHorde.cconfig.BRAWLER.get(), 1, 1);

        MobSpawnInfo.Spawners nspawners = new MobSpawnInfo.Spawners(Register.NCOLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.DSTABBER.get(), 1, 1);
        MobSpawnInfo.Spawners nspawners1 = new MobSpawnInfo.Spawners(Register.NCOLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.DGUNNER.get(), 1, 1);
        MobSpawnInfo.Spawners nspawners2 = new MobSpawnInfo.Spawners(Register.NCOLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.DSNOWBALLER.get(), 1, 1);
        MobSpawnInfo.Spawners nspawners3 = new MobSpawnInfo.Spawners(Register.NCOLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.DGIFTER.get(), 1, 1);
        MobSpawnInfo.Spawners nspawners4 = new MobSpawnInfo.Spawners(Register.NCOLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.DZAPPER.get(), 1, 1);
        MobSpawnInfo.Spawners nspawners5 = new MobSpawnInfo.Spawners(Register.NCOLDSNAPBRAWLER.get(), ColdSnapHorde.cconfig.DBRAWLER.get(), 1, 1);

        MobSpawnInfo.Spawners espawners = new MobSpawnInfo.Spawners(Register.ECOLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.DSTABBER.get(), 1, 1);
        MobSpawnInfo.Spawners espawners1 = new MobSpawnInfo.Spawners(Register.ECOLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.DGUNNER.get(), 1, 1);
        MobSpawnInfo.Spawners espawners2 = new MobSpawnInfo.Spawners(Register.ECOLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.DSNOWBALLER.get(), 1, 1);
        MobSpawnInfo.Spawners espawners3 = new MobSpawnInfo.Spawners(Register.ECOLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.DGIFTER.get(), 1, 1);
        MobSpawnInfo.Spawners espawners4 = new MobSpawnInfo.Spawners(Register.ECOLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.DZAPPER.get(), 1, 1);
        MobSpawnInfo.Spawners espawners5 = new MobSpawnInfo.Spawners(Register.ECOLDSNAPBRAWLER.get(), ColdSnapHorde.cconfig.DBRAWLER.get(), 1, 1);

        MobSpawnInfo.Spawners pspawners = new MobSpawnInfo.Spawners(Register.PCOLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.STABBER.get(), 1, 1);
        MobSpawnInfo.Spawners pspawners1 = new MobSpawnInfo.Spawners(Register.PCOLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.GUNNER.get(), 1, 1);
        MobSpawnInfo.Spawners pspawners2 = new MobSpawnInfo.Spawners(Register.PCOLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.SNOWBALLER.get(), 1, 1);
        MobSpawnInfo.Spawners pspawners3 = new MobSpawnInfo.Spawners(Register.PCOLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.GIFTER.get(), 1, 1);
        MobSpawnInfo.Spawners pspawners4 = new MobSpawnInfo.Spawners(Register.PCOLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.ZAPPER.get(), 1, 1);
        MobSpawnInfo.Spawners pspawners5 = new MobSpawnInfo.Spawners(Register.PCOLDSNAPBRAWLER.get(), ColdSnapHorde.cconfig.BRAWLER.get(), 1, 1);

        if (BiomeExclusion(finalBiomeExclusion, event.getName()) && !event.getName().toString().contains("swamp") && !(event.getCategory() == Biome.Category.NETHER || event.getCategory() == Biome.Category.THEEND || event.getCategory() == Biome.Category.MUSHROOM)){
            if(ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 0 && event.getClimate().temperature < 0.3f){
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners1);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners2);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners3);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners4);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners5);
            }
            else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 1 && event.getClimate().temperature < 0.9f){
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners1);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners2);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners3);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners4);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners5);
            }
            else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 2 && event.getClimate().temperature < 1.5f){
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners1);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners2);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners3);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners4);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners5);

            }
            else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 3){
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners1);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners2);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners3);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners4);
                event.getSpawns().addSpawn(EntityClassification.MONSTER, spawners5);
            }
        }
        else if(event.getName().toString().contains("swamp")){
            event.getSpawns().addSpawn(EntityClassification.MONSTER, pspawners);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, pspawners1);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, pspawners2);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, pspawners3);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, pspawners4);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, pspawners5);
        }
        else if(event.getCategory() == Biome.Category.NETHER && ColdSnapHorde.cconfig.DSPAWN.get()){
            event.getSpawns().addSpawn(EntityClassification.MONSTER, nspawners);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, nspawners1);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, nspawners2);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, nspawners3);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, nspawners4);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, nspawners5);
        }
        else if(event.getCategory() == Biome.Category.THEEND && ColdSnapHorde.cconfig.DSPAWN.get()){
            event.getSpawns().addSpawn(EntityClassification.MONSTER, espawners);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, espawners1);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, espawners2);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, espawners3);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, espawners4);
            event.getSpawns().addSpawn(EntityClassification.MONSTER, espawners5);
        }
    }

    public static void PlacementManager() {
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPSTABBER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPSNOWBALLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPGUNNER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPGIFTER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPZAPPER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPBRAWLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.NCOLDSNAPSTABBER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.NCOLDSNAPSNOWBALLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.NCOLDSNAPGUNNER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.NCOLDSNAPGIFTER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.NCOLDSNAPZAPPER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.NCOLDSNAPBRAWLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.ECOLDSNAPSTABBER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.ECOLDSNAPSNOWBALLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.ECOLDSNAPGUNNER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.ECOLDSNAPGIFTER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.ECOLDSNAPZAPPER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.ECOLDSNAPBRAWLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.PCOLDSNAPSTABBER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.PCOLDSNAPSNOWBALLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.PCOLDSNAPGUNNER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.PCOLDSNAPGIFTER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.PCOLDSNAPZAPPER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
        EntitySpawnPlacementRegistry.register(Register.PCOLDSNAPBRAWLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::checkMobSpawnRules);
    }


    public static Boolean BiomeExclusion(ResourceLocation[] BiomeExclusion, ResourceLocation name){
        for (ResourceLocation i : BiomeExclusion){
            if (i.toString().equals(name.toString())){return false;}
        }
        return true;
    }
}
