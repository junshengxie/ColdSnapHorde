package com.villain.coldsnaphorde.entities;

import com.mojang.serialization.Codec;
import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Spawns {

    public record SpawnModifiers(HolderSet<Biome> biomes, MobSpawnSettings.SpawnerData spawn) implements BiomeModifier {
        @Override
        public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
            if (phase == Phase.ADD && this.biomes.contains(biome)) {
                builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, this.spawn);
                //Logging statement, in a vague attempt to see if anything shows up.
            }
        }

        @Override
        public Codec<? extends BiomeModifier> codec() {
            return ForgeColdSnapHorde.SPAWNCODEC.get();
        }
    }

    private static boolean returnFalse(EntityType<? extends Monster> monsterEntityType, ServerLevelAccessor serverLevelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource random) {
        return false;
    }
}
