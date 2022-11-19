package com.villain.coldsnaphorde.platform;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.FabricColdSnapHorde;
import com.villain.coldsnaphorde.Register;
import com.villain.coldsnaphorde.entities.mobs.basemob.*;
import com.villain.coldsnaphorde.platform.services.IPlatformHelper;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FabricPlatformHelper implements IPlatformHelper {

    CreativeModeTab TAB = null;

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public boolean PLAGUEIMMORTUOSCOMPAT() {
        return FabricColdSnapHorde.config.coldSnapSettings.PLAGUEIMMORTUOSCOMPAT;
    }

    @Override
    public CreativeModeTab TAB() {
        if (TAB == null) {
            TAB = FabricItemGroupBuilder.build(new ResourceLocation(Constants.MOD_ID, "coldgroup"), () -> new ItemStack(Register.ROCKYSNOWBALL));
        }
        return TAB;
    }
}
