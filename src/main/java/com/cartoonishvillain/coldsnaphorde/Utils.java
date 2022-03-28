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

    public static boolean heatCheck(Level serverLevel, BlockPos pos) {
        if(isEnd(serverLevel) || isNether(serverLevel) || isSwamp(serverLevel.getBiome(pos).value())) return true;
        int protlvl = ColdSnapHorde.cconfig.HEATPROT.get();
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
        return !isEnd(serverLevel) && !isNether(serverLevel) && !isSwamp(serverLevel.getBiome(pos).value()) && heatCheck(serverLevel, pos);
    }

    public static boolean tier2Valid(Level serverLevel, BlockPos pos) {
        return !isEnd(serverLevel) && !isNether(serverLevel) && heatCheck(serverLevel, pos);
    }
}
