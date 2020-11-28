package com.jedijoe.coldsnaphorde.Entities;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Register;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Spawns {
    @SubscribeEvent
    public static void SnowmanSpawner(BiomeLoadingEvent event){
        if(event.getClimate().temperature < 0.3f){
            MobSpawnInfo.Spawners spawners = new MobSpawnInfo.Spawners(Register.COLDSNAPSTABBER.get(), 50,1,1);
            MobSpawnInfo.Spawners spawners1 = new MobSpawnInfo.Spawners(Register.COLDSNAPGUNNER.get(), 50,1,1);
            MobSpawnInfo.Spawners spawners2 = new MobSpawnInfo.Spawners(Register.COLDSNAPSNOWBALLER.get(), 50,1,1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners1);
            event.getSpawns().withSpawner(EntityClassification.MONSTER, spawners2);}
    }
}
