package com.villain.coldsnaphorde.component;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.resources.ResourceLocation;

public class ComponentStarter implements WorldComponentInitializer, EntityComponentInitializer {
    public static final ComponentKey<WorldCooldownComponent> WORLDCOMPONENT =
            ComponentRegistryV3.INSTANCE.getOrCreate(new ResourceLocation("coldsnaphorde:cooldown"), WorldCooldownComponent.class);

    public static final ComponentKey<PlayerCooldownComponent> PLAYERCOMPONENT =
            ComponentRegistryV3.INSTANCE.getOrCreate(new ResourceLocation("coldsnaphorde:playercooldown"), PlayerCooldownComponent.class);
    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(WORLDCOMPONENT, world -> new WorldCooldownComponent());
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(PLAYERCOMPONENT, PlayerCooldownComponent::new, RespawnCopyStrategy.LOSSLESS_ONLY);

    }
}
