package com.villain.coldsnaphorde;

import com.villain.cartoonishhorde.EntityHordeData;
import com.villain.coldsnaphorde.commands.GetHordeDefeatedLevel;
import com.villain.coldsnaphorde.commands.SetHordeDefeatedLevel;
import com.villain.coldsnaphorde.commands.StartHorde;
import com.villain.coldsnaphorde.commands.StopHorde;
import com.villain.coldsnaphorde.component.WorldCooldownComponent;
import com.villain.coldsnaphorde.config.ColdSnapConfig;
import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapGunner;
import com.villain.coldsnaphorde.events.HordeEventTier1;
import com.villain.coldsnaphorde.events.HordeEventTier2;
import com.villain.coldsnaphorde.events.HordeEventTier3;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.item.Item;


import java.util.ArrayList;
import java.util.UUID;

import static com.villain.coldsnaphorde.component.ComponentStarter.WORLDCOMPONENT;

public class FabricColdSnapHorde implements ModInitializer {

    public static EntityHordeData defaultHordeData;
    public static HordeEventTier1 hordeTier1;
    public static HordeEventTier2 hordeTier2;
    public static HordeEventTier3 hordeTier3;
    public static ColdSnapConfig config;
    public static HordeDataManager hordeDataManager = null;
    public static ArrayList<Item> TOPHATS = new ArrayList<>();
    
    @Override
    public void onInitialize() {
        CommonColdSnapHorde.init();
        Register.init();
        AutoConfig.register(ColdSnapConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ColdSnapConfig.class).getConfig();
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
            GetHordeDefeatedLevel.register(dispatcher);
            SetHordeDefeatedLevel.register(dispatcher);
            StartHorde.register(dispatcher);
            StopHorde.register(dispatcher);
        }));

        ServerLifecycleEvents.SERVER_STARTING.register(ServerStartListener.getInstance());

        ServerTickEvents.END_WORLD_TICK.register(WorldTickListener.getInstance());

        ServerPlayConnectionEvents.JOIN.register(JoinListener.getInstance());


        com.villain.FabricColdSnapHorde.entities.Spawns.addSpawns();
    }

    public static class ServerStartListener implements ServerLifecycleEvents.ServerStarting {
        private static final ServerStartListener INSTANCE = new ServerStartListener();

        public static ServerStartListener getInstance() {return INSTANCE;}

        @Override
        public void onServerStarting(MinecraftServer server) {
            defaultHordeData = new EntityHordeData(3, 0.5D, 1, Register.COLDSNAPGUNNER, ColdSnapGunner.class);

            for(ServerLevel serverWorld : server.getAllLevels()){
                WorldCooldownComponent h = WORLDCOMPONENT.get(serverWorld);
                if(h.getLevelBeaten() <= 0){h.setLevelBeaten(config.coldSnapSettings.GLOBALHORDECOOLDOWN * 20);}
            }

            hordeTier1 = new HordeEventTier1(server);
            hordeTier2 = new HordeEventTier2(server);
            hordeTier3 = new HordeEventTier3(server);

            hordeDataManager = HordeDataManager.getInstance();
        }
    }

    public static class JoinListener implements ServerPlayConnectionEvents.Join{
        private static final JoinListener INSTANCE = new JoinListener();
        @Override
        public void onPlayReady(ServerGamePacketListenerImpl handler, PacketSender sender, MinecraftServer server) {
            if(CommonColdSnapHorde.isInHolidayWindow){
                handler.player.sendMessage(new TranslatableComponent("info.coldsnaphorde.holiday").withStyle(ChatFormatting.AQUA), UUID.randomUUID());
            }
        }
        public static JoinListener getInstance() {return INSTANCE;}

    }

    public static class WorldTickListener implements ServerTickEvents.EndWorldTick{
        private static final WorldTickListener INSTANCE = new WorldTickListener();

        public static WorldTickListener getInstance() {return INSTANCE;}

        @Override
        public void onEndTick(ServerLevel world) {
            WorldCooldownComponent h = WORLDCOMPONENT.get(world);

            hordeDataManager.tickCooldown();
            hordeTier1.tick();
            hordeTier2.tick();
            hordeTier3.tick();
        }
    }
}
