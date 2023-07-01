package com.villain.coldsnaphorde.entities;

import com.villain.coldsnaphorde.ColdSnapBiomeTags;
import com.villain.coldsnaphorde.FabricColdSnapHorde;
import com.villain.coldsnaphorde.Register;
import com.villain.coldsnaphorde.Utils;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level().levelgen.Heightmap;

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
            SpawnPlacements.register(Register.ECOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.ECOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnPlacements.register(Register.ECOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.ECOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
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
            SpawnPlacements.register(Register.NCOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.NCOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnPlacements.register(Register.NCOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
            SpawnPlacements.register(Register.NCOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier3);
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
            SpawnPlacements.register(Register.PCOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.PCOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnPlacements.register(Register.PCOLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.PCOLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
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
            SpawnPlacements.register(Register.COLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(Register.COLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        } else {
            SpawnPlacements.register(Register.COLDSNAPSTABBER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
            SpawnPlacements.register(Register.COLDSNAPSNOWBALLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Utils::tier1);
            SpawnPlacements.register(Register.COLDSNAPGUNNER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier1);
            SpawnPlacements.register(Register.COLDSNAPGIFTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.COLDSNAPZAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
            SpawnPlacements.register(Register.COLDSNAPBRAWLER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utils::tier2);
        }
        SpawnPlacements.register(Register.COLDSNAPCOW,SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
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
