package com.jedijoe.coldsnaphorde.Entities;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Register;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
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

        MobSpawnInfo.Spawners spawners = new MobSpawnInfo.Spawners(Register.COLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.STABBER.get(),1,1);
        MobSpawnInfo.Spawners spawners1 = new MobSpawnInfo.Spawners(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.GUNNER.get(),1,1);
        MobSpawnInfo.Spawners spawners2 = new MobSpawnInfo.Spawners(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.SNOWBALLER.get(),1,1);
        MobSpawnInfo.Spawners spawners3 = new MobSpawnInfo.Spawners(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.GIFTER.get(),1,1);
        MobSpawnInfo.Spawners spawners4 = new MobSpawnInfo.Spawners(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.ZAPPER.get(),1,1);


        if (event.getCategory() != Biome.Category.NETHER && event.getCategory() != Biome.Category.THEEND && event.getCategory() != Biome.Category.OCEAN && BiomeExclusion(finalBiomeExclusion, event.getName())){
        if(ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 0 && event.getClimate().temperature < 0.3f){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);}
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 1 && event.getClimate().temperature < 0.9f){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);}
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 2 && event.getClimate().temperature < 1.5f){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);}
        else if (ColdSnapHorde.cconfig.SPAWNTEMPS.get() == 3){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);}
        }

        if(ColdSnapHorde.cconfig.OCEANSNOW.get() && event.getCategory() == Biome.Category.OCEAN){
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners4);
        }

        if(ColdSnapHorde.cconfig.NETHERSNOW.get() && event.getCategory() == Biome.Category.NETHER){
            MobSpawnInfo.Spawners espawners = new MobSpawnInfo.Spawners(Register.COLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.NSTABBER.get(),1,1);
            MobSpawnInfo.Spawners espawners1 = new MobSpawnInfo.Spawners(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.NGUNNER.get(),1,1);
            MobSpawnInfo.Spawners espawners2 = new MobSpawnInfo.Spawners(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.NSNOWBALLER.get(),1,1);
            MobSpawnInfo.Spawners espawners3 = new MobSpawnInfo.Spawners(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.NGIFTER.get(),1,1);
            MobSpawnInfo.Spawners espawners4 = new MobSpawnInfo.Spawners(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.NZAPPER.get(),1,1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners4);
        }

        if(ColdSnapHorde.cconfig.ENDSNOW.get() && event.getCategory() == Biome.Category.THEEND){
            MobSpawnInfo.Spawners espawners = new MobSpawnInfo.Spawners(Register.COLDSNAPSTABBER.get(), ColdSnapHorde.cconfig.ESTABBER.get(),1,1);
            MobSpawnInfo.Spawners espawners1 = new MobSpawnInfo.Spawners(Register.COLDSNAPGUNNER.get(), ColdSnapHorde.cconfig.EGUNNER.get(),1,1);
            MobSpawnInfo.Spawners espawners2 = new MobSpawnInfo.Spawners(Register.COLDSNAPSNOWBALLER.get(), ColdSnapHorde.cconfig.ESNOWBALLER.get(),1,1);
            MobSpawnInfo.Spawners espawners3 = new MobSpawnInfo.Spawners(Register.COLDSNAPGIFTER.get(), ColdSnapHorde.cconfig.EGIFTER.get(),1,1);
            MobSpawnInfo.Spawners espawners4 = new MobSpawnInfo.Spawners(Register.COLDSNAPZAPPER.get(), ColdSnapHorde.cconfig.EZAPPER.get(),1,1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners2);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners3);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, espawners4);
        }
    }

    public static void PlacementManager(){
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPSTABBER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPSNOWBALLER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPGUNNER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPGIFTER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(Register.COLDSNAPZAPPER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
    }

    public static Boolean BiomeExclusion(ResourceLocation[] BiomeExclusion, ResourceLocation name){
        for (ResourceLocation i : BiomeExclusion){
            if (i.toString().equals(name.toString())){return false;}
        }
        return true;
    }
}
