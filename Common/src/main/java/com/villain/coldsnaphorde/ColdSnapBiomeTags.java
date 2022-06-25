package com.villain.coldsnaphorde;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ColdSnapBiomeTags {
    public static final TagKey<Biome> MushroomBiomes = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Constants.MOD_ID, "land_spawnable"));
    public static final TagKey<Biome> Swamps = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Constants.MOD_ID, "swamp"));

}
