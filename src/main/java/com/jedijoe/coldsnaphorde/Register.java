package com.jedijoe.coldsnaphorde;

import com.jedijoe.coldsnaphorde.Entities.ColdSnapGunner;
import com.jedijoe.coldsnaphorde.Entities.ColdSnapSnowballer;
import com.jedijoe.coldsnaphorde.Entities.ColdSnapStabber;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.rmi.registry.Registry;

public class Register {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ColdSnapHorde.MOD_ID);

    public static void init(){
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<EntityType<ColdSnapGunner>> COLDSNAPGUNNER = ENTITY_TYPES.register("coldsnapgunner", () -> EntityType.Builder.create(ColdSnapGunner::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapgunner").toString()));
    public static final RegistryObject<EntityType<ColdSnapStabber>> COLDSNAPSTABBER = ENTITY_TYPES.register("coldsnapstabber", () -> EntityType.Builder.create(ColdSnapStabber::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapstabber").toString()));
    public static final RegistryObject<EntityType<ColdSnapSnowballer>> COLDSNAPSNOWBALLER = ENTITY_TYPES.register("coldsnapsnowballer", () -> EntityType.Builder.create(ColdSnapSnowballer::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapsnowballer").toString()));

}
