package com.villain.coldsnaphorde.entities;

import com.villain.coldsnaphorde.ColdSnapBiomeTags;
import com.villain.coldsnaphorde.FabricColdSnapHorde;
import com.villain.coldsnaphorde.Register;
import com.villain.coldsnaphorde.Utils;
import com.villain.coldsnaphorde.config.ColdSnapConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Spawns {
    //TODO: Look into tags
    static ArrayList<ResourceLocation> finalBiomeExclusion;
    public static void addSpawns() {
        finalBiomeExclusion = exclusionFactor();

        standardSpawns(FabricColdSnapHorde.config.getOrDefault("SPAWNTEMPS", 0));
        swampSpawns();
        netherSpawns();
        endSpawns();
    }


    public static ArrayList<ResourceLocation> exclusionFactor() {
        final String BiomeList = FabricColdSnapHorde.config.getOrDefault("BiomeExclusion", "notabiome");
        String[] biomeExclusion = BiomeList.split(",");
        ArrayList<ResourceLocation> finalBiomeExclusion = new ArrayList<>();
        for (String i : biomeExclusion) {
            ResourceLocation newResource = new ResourceLocation(i);
            finalBiomeExclusion.add(newResource);
        }

        return finalBiomeExclusion;
    }

    public static void endSpawns() {
        Predicate<BiomeSelectionContext> spawnPredicate = endPredicate();
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.ECOLDSNAPGUNNER, FabricColdSnapHorde.config.getOrDefault("DGUNNER", 2), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.ECOLDSNAPSTABBER, FabricColdSnapHorde.config.getOrDefault("DSTABBER", 2), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.ECOLDSNAPSNOWBALLER, FabricColdSnapHorde.config.getOrDefault("DSNOWBALLER", 2), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.ECOLDSNAPZAPPER, FabricColdSnapHorde.config.getOrDefault("DZAPPER", 1), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.ECOLDSNAPGIFTER, FabricColdSnapHorde.config.getOrDefault("DGIFTER", 1), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.ECOLDSNAPBRAWLER, FabricColdSnapHorde.config.getOrDefault("DBRAWLER", 1), 1, 1);
        if (!FabricColdSnapHorde.config.getOrDefault("PROGRESSIVESPAWNS", true)) {
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.ECOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
        }
    }

    public static void netherSpawns() {
        Predicate<BiomeSelectionContext> spawnPredicate = netherPredicate();
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.NCOLDSNAPGUNNER, FabricColdSnapHorde.config.getOrDefault("DGUNNER", 2), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.NCOLDSNAPSTABBER, FabricColdSnapHorde.config.getOrDefault("DSTABBER", 2), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.NCOLDSNAPSNOWBALLER, FabricColdSnapHorde.config.getOrDefault("DSNOWBALLER", 2), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.NCOLDSNAPZAPPER, FabricColdSnapHorde.config.getOrDefault("DZAPPER", 1), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.NCOLDSNAPGIFTER, FabricColdSnapHorde.config.getOrDefault("DGIFTER", 1), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.NCOLDSNAPBRAWLER, FabricColdSnapHorde.config.getOrDefault("DBRAWLER", 1), 1, 1);
        if (!FabricColdSnapHorde.config.getOrDefault("PROGRESSIVESPAWNS", true)) {
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnRestrictionAccessor.callRegister(Register.NCOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
        }
    }

    public static void swampSpawns() {
        Predicate<BiomeSelectionContext> spawnPredicate = swampPredicate();
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.PCOLDSNAPGUNNER, FabricColdSnapHorde.config.getOrDefault("GUNNER", 20), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.PCOLDSNAPSTABBER, FabricColdSnapHorde.config.getOrDefault("STABBER", 20), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.PCOLDSNAPSNOWBALLER, FabricColdSnapHorde.config.getOrDefault("SNOWBALLER", 20), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.PCOLDSNAPZAPPER, FabricColdSnapHorde.config.getOrDefault("ZAPPER", 6), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.PCOLDSNAPGIFTER, FabricColdSnapHorde.config.getOrDefault("GIFTER", 10), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.PCOLDSNAPBRAWLER, FabricColdSnapHorde.config.getOrDefault("BRAWLER", 8), 1, 1);
        if (!FabricColdSnapHorde.config.getOrDefault("PROGRESSIVESPAWNS", true)) {
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnRestrictionAccessor.callRegister(Register.PCOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
        }
    }

    public static void standardSpawns(int spawnTemps) {
        Predicate<BiomeSelectionContext> spawnPredicate;
        switch (spawnTemps) {
            default -> spawnPredicate = coldBiome().and(overWorldNoSwampNoGoZones());
            case 1 -> spawnPredicate = moderateBiome().and(overWorldNoSwampNoGoZones());
            case 2 -> spawnPredicate = warmBiome().and(overWorldNoSwampNoGoZones());
            case 3 -> spawnPredicate = hotBiome().and(overWorldNoSwampNoGoZones());
        }
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.COLDSNAPGUNNER, FabricColdSnapHorde.config.getOrDefault("GUNNER", 20), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.COLDSNAPSTABBER, FabricColdSnapHorde.config.getOrDefault("STABBER", 20), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.COLDSNAPSNOWBALLER, FabricColdSnapHorde.config.getOrDefault("SNOWBALLER", 20), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.COLDSNAPZAPPER, FabricColdSnapHorde.config.getOrDefault("ZAPPER", 6), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.COLDSNAPGIFTER, FabricColdSnapHorde.config.getOrDefault("GIFTER", 10), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.MONSTER, Register.COLDSNAPBRAWLER, FabricColdSnapHorde.config.getOrDefault("BRAWLER", 8), 1, 1);
        BiomeModifications.addSpawn(spawnPredicate, MobCategory.CREATURE, Register.COLDSNAPCOW, FabricColdSnapHorde.config.getOrDefault("SNOWCOW", 4), 1, 1);
        if (!FabricColdSnapHorde.config.getOrDefault("PROGRESSIVESPAWNS", true)) {
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Utils::tier1);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnRestrictionAccessor.callRegister(Register.COLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
        }
        SpawnRestrictionAccessor.callRegister(Register.COLDSNAPCOW,SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }

    /*
        =-=PREDICATE SECTION=-=
     */

    /*
        Primary Predicates - Used as direct predicates
     */

    public static Predicate<BiomeSelectionContext> coldBiome() {
        return context -> context.getBiome().getBaseTemperature() < 0.3f;
    }

    public static Predicate<BiomeSelectionContext> moderateBiome() {
        return context -> context.getBiome().getBaseTemperature() < 0.9f;
    }

    public static Predicate<BiomeSelectionContext> warmBiome() {
        return context -> context.getBiome().getBaseTemperature() < 1.5f;
    }

    public static Predicate<BiomeSelectionContext> hotBiome() {
        return context -> true;
    }

    public static Predicate<BiomeSelectionContext> swampPredicate() {
        return BiomeSelectors.tag(ColdSnapBiomeTags.Swamps);
    }

    public static Predicate<BiomeSelectionContext> endPredicate() {
        return BiomeSelectors.tag(BiomeTags.IS_END);
    }

    public static Predicate<BiomeSelectionContext> netherPredicate() {
        return BiomeSelectors.tag(BiomeTags.IS_NETHER);
    }

    /*
        Secondary Predicates - Used as modifiers of primary predicates
     */

    public static Predicate<BiomeSelectionContext> overWorldNoSwampNoGoZones() {
        Predicate<BiomeSelectionContext> excluded = Predicate.not(exclusion());
        return BiomeSelectors.all().and(shroomExclusion()).and(netherExclusion()).and(endExclusion()).and(swampExclusion()).and(excluded);
    }

    /*
        Tertiary Predicates - Building block predicates.
     */

    public static Predicate<BiomeSelectionContext> exclusion() {
        return context -> finalBiomeExclusion.contains(context.getBiomeKey().location());
    }

    public static Predicate<BiomeSelectionContext> shroomExclusion() {
        return Predicate.not(BiomeSelectors.tag(ColdSnapBiomeTags.MushroomBiomes));
    }

    public static Predicate<BiomeSelectionContext> netherExclusion() {
        return Predicate.not(BiomeSelectors.tag(BiomeTags.IS_NETHER));
    }

    public static Predicate<BiomeSelectionContext> endExclusion() {
        return Predicate.not(BiomeSelectors.tag(BiomeTags.IS_END));
    }

    public static Predicate<BiomeSelectionContext> swampExclusion() {
        return Predicate.not(BiomeSelectors.tag(ColdSnapBiomeTags.Swamps));
    }
}
