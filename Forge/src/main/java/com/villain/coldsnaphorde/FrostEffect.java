package com.villain.coldsnaphorde;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.ForgeRegistries;

public class FrostEffect {
    public static MobEffect froststep;

    public static void init(){
        froststep = new ModdedPotionEffects(MobEffectCategory.BENEFICIAL, 4587519, new ResourceLocation(Constants.MOD_ID, "frost_step_effect"));
    }

    /*
        While code reusage is minimal would like to shout out the immersive engineering team and BluSunrize for having such a neat license to help me get through this bit in particular
     */
    public static class ModdedPotionEffects extends MobEffect {

        protected ModdedPotionEffects(MobEffectCategory p_19451_, int p_19452_, ResourceLocation location) {
            super(p_19451_, p_19452_);
            ForgeRegistries.MOB_EFFECTS.register(this.setRegistryName(location));
        }
    }
}
