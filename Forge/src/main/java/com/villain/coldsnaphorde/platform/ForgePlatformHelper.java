package com.villain.coldsnaphorde.platform;

import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import com.villain.coldsnaphorde.Register;
import com.villain.coldsnaphorde.platform.services.IPlatformHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {
    CreativeModeTab TAB = null;

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public boolean PLAGUEIMMORTUOSCOMPAT() {
        return ForgeColdSnapHorde.sconfig.PLAGUEIMMORTUOSCOMPAT.get();
    }
}
