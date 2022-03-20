package com.cartoonishvillain.coldsnaphorde;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

public class Utils {
    public static boolean isEnd(Level serverLevel) {
        return serverLevel.dimension().toString().contains("end");
    }

    public static boolean isNether(Level serverLevel) {
        return serverLevel.dimension().toString().contains("nether");
    }

    public static boolean isSwamp(Biome biome) {
        String BiomeName = biome.getRegistryName().toString();
        return BiomeName.contains("swamp");
    }

    public static boolean tier1Valid(Level serverLevel, BlockPos pos) {
        return !isEnd(serverLevel) && !isNether(serverLevel) && !isSwamp(serverLevel.getBiome(pos).value());
    }
}
