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
        MobSpawnInfo.Spawners spawners5 = new MobSpawnInfo.Spawners(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.BRAWLER.get(), 1, 1);

        MobSpawnInfo.Spawners dspawners = new MobSpawnInfo.Spawners(Register.COLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.DSTABBER.get(), 1, 1);
        MobSpawnInfo.Spawners dspawners1 = new MobSpawnInfo.Spawners(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.DGUNNER.get(), 1, 1);
        MobSpawnInfo.Spawners dspawners2 = new MobSpawnInfo.Spawners(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.DSNOWBALLER.get(), 1, 1);
        MobSpawnInfo.Spawners dspawners3 = new MobSpawnInfo.Spawners(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.DGIFTER.get(), 1, 1);
        MobSpawnInfo.Spawners dspawners4 = new MobSpawnInfo.Spawners(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.DZAPPER.get(), 1, 1);
        MobSpawnInfo.Spawners dspawners5 = new MobSpawnInfo.Spawners(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.DBRAWLER.get(), 1, 1);

        if (BiomeExclusion(finalBiomeExclusion, event.getName()) && !event.getName().toString().contains("swamp") && !(event.getCategory() == Biome.Category.NETHER || event.getCategory() == Biome.Category.THEEND)){
            if(ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 0 && event.getClimate().temperature < 0.3f){
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners5);
            }
            else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 1 && event.getClimate().temperature < 0.9f){
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners5);
            }
            else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 2 && event.getClimate().temperature < 1.5f){
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners5);

            }
            else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 3){
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);
                event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners5);
            }
        }
        else if(event.getName().toString().contains("swamp")){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners5);
        }
        else if(event.getCategory() == Biome.Category.NETHER || event.getCategory() == Biome.Category.THEEND){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, dspawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, dspawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, dspawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, dspawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, dspawners4);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, dspawners5);
        }
    }

    public static void PlacementManager() {
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPSTABBER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPSNOWBALLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPGUNNER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPGIFTER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPZAPPER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPBRAWLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
    }


    public static Boolean BiomeExclusion(ResourceLocation[] BiomeExclusion, ResourceLocation name){
        for (ResourceLocation i : BiomeExclusion){
            if (i.toString().equals(name.toString())){return false;}
        }
        return true;
    }
}
