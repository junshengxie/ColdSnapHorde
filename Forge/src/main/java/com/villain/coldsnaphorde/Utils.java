package com.villain.coldsnaphorde;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;

import net.minecraft.util.RandomSource;

import static net.minecraft.world.entity.animal.Animal.checkAnimalSpawnRules;

public class Utils {
    public static boolean isEnd(Level serverLevel) {
        return serverLevel.dimension().toString().contains("end");
    }

    public static boolean isNether(Level serverLevel) {
        return serverLevel.dimension().toString().contains("nether");
    }

    public static boolean isSwamp(Holder<Biome> biome) {
        return biome.is(ColdSnapBiomeTags.Swamps);
    }

    public static boolean heatCheck(Level serverLevel, BlockPos pos) {
        if(isEnd(serverLevel) || isNether(serverLevel) || isSwamp(serverLevel.getBiome(pos))) return true;
        int protlvl = ForgeColdSnapHorde.cconfig.HEATPROT.get();
        float temp = serverLevel.getBiome(pos).value().getBaseTemperature();
        int code = -1;
        if (temp < 0.3) {
            code = 0;
        } else if (temp >= 0.3 && temp < 0.9) {
            code = 1;
        } else if (temp >= 0.9 && temp < 1.5) {
            code = 2;
        } else if (temp >= 1.5) {
            code = 3;
        }

        return code <= protlvl;
    }

    public static boolean heatSpawnCheck(Level serverLevel, BlockPos pos) {
        if(isEnd(serverLevel) || isNether(serverLevel) || isSwamp(serverLevel.getBiome(pos))) return true;
        int protlvl = ForgeColdSnapHorde.cconfig.SPAWNTEMPS.get();
        float temp = serverLevel.getBiome(pos).value().getBaseTemperature();
        int code = -1;
        if (temp < 0.3) {
            code = 0;
        } else if (temp >= 0.3 && temp < 0.9) {
            code = 1;
        } else if (temp >= 0.9 && temp < 1.5) {
            code = 2;
        } else if (temp >= 1.5) {
            code = 3;
        }

        return code <= protlvl;
    }

    public static boolean tier1Valid(Level serverLevel, BlockPos pos) {
        return !isEnd(serverLevel) && !isNether(serverLevel) && !isSwamp(serverLevel.getBiome(pos)) && heatCheck(serverLevel, pos);
    }

    public static boolean tier1SpawnValid(Level serverLevel, BlockPos pos) {
        return !isEnd(serverLevel) && !isNether(serverLevel) && !isSwamp(serverLevel.getBiome(pos)) && heatSpawnCheck(serverLevel, pos);
    }

    public static boolean tier2Valid(Level serverLevel, BlockPos pos) {
        return !isEnd(serverLevel) && !isNether(serverLevel) && heatCheck(serverLevel, pos);
    }

    public static boolean tier2SpawnValid(Level serverLevel, BlockPos pos) {
        return !isEnd(serverLevel) && !isNether(serverLevel) && heatCheck(serverLevel, pos) && heatSpawnCheck(serverLevel, pos);
    }

    public static boolean tier3Valid(Level serverLevel, BlockPos pos) {
        return heatCheck(serverLevel, pos);
    }

    public static boolean tier3SpawnValid(Level serverLevel, BlockPos pos) {
        return heatCheck(serverLevel, pos) && heatSpawnCheck(serverLevel, pos);
    }

    public static boolean tier1(EntityType<? extends Monster> p_33018_, LevelAccessor p_33019_, MobSpawnType p_33020_, BlockPos p_33021_, RandomSource p_33022_) {
        if(ForgeColdSnapHorde.cconfig.PROGRESSIVESPAWNS.get()) {
            return Monster.checkMonsterSpawnRules(p_33018_, (ServerLevelAccessor) p_33019_, p_33020_, p_33021_, p_33022_) && ForgeColdSnapHorde.hordeDataManager.getHighestLevelBeaten() >= 1 && tier1SpawnValid((ServerLevel) p_33019_, p_33021_);
        }
        else return Monster.checkMonsterSpawnRules(p_33018_, (ServerLevelAccessor) p_33019_, p_33020_, p_33021_, p_33022_) && tier1SpawnValid((ServerLevel) p_33019_, p_33021_);
    }

    public static boolean tier2(EntityType<? extends Monster> p_33018_, LevelAccessor p_33019_, MobSpawnType p_33020_, BlockPos p_33021_, RandomSource p_33022_) {
        if(ForgeColdSnapHorde.cconfig.PROGRESSIVESPAWNS.get()) {
            return Monster.checkMonsterSpawnRules(p_33018_, (ServerLevelAccessor) p_33019_, p_33020_, p_33021_, p_33022_) && ForgeColdSnapHorde.hordeDataManager.getHighestLevelBeaten() >= 2 && tier1SpawnValid((ServerLevel) p_33019_, p_33021_);
        }
        else return Monster.checkMonsterSpawnRules(p_33018_, (ServerLevelAccessor) p_33019_, p_33020_, p_33021_, p_33022_) && tier1SpawnValid((ServerLevel) p_33019_, p_33021_);
    }

    public static boolean tier2Swamp(EntityType<? extends Monster> p_33018_, LevelAccessor p_33019_, MobSpawnType p_33020_, BlockPos p_33021_, RandomSource p_33022_) {
        if(ForgeColdSnapHorde.cconfig.PROGRESSIVESPAWNS.get()) {
            return Monster.checkMonsterSpawnRules(p_33018_, (ServerLevelAccessor) p_33019_, p_33020_, p_33021_, p_33022_) && ForgeColdSnapHorde.hordeDataManager.getHighestLevelBeaten() >= 2;
        }
        else return Monster.checkMonsterSpawnRules(p_33018_, (ServerLevelAccessor) p_33019_, p_33020_, p_33021_, p_33022_);
    }

    public static boolean tier3(EntityType<? extends Monster> p_33018_, LevelAccessor p_33019_, MobSpawnType p_33020_, BlockPos p_33021_, RandomSource p_33022_) {
        if(ForgeColdSnapHorde.cconfig.PROGRESSIVESPAWNS.get()) {
            return Monster.checkMonsterSpawnRules(p_33018_, (ServerLevelAccessor) p_33019_, p_33020_, p_33021_, p_33022_) && ForgeColdSnapHorde.hordeDataManager.getHighestLevelBeaten() >= 3;
        }
        else return Monster.checkMonsterSpawnRules(p_33018_, (ServerLevelAccessor) p_33019_, p_33020_, p_33021_, p_33022_);
    }

    public static boolean checkFrostyCow(EntityType<? extends Animal> p_218105_, LevelAccessor p_218106_, MobSpawnType p_218107_, BlockPos p_218108_, RandomSource p_218109_) {
        return checkAnimalSpawnRules(p_218105_, p_218106_, p_218107_, p_218108_, p_218109_) && tier1SpawnValid((ServerLevel) p_218106_, p_218108_);
    }

}
