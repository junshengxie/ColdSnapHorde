package com.villain.coldsnaphorde.events;

import com.villain.coldsnaphorde.Constants;
import com.villain.coldsnaphorde.ForgeColdSnapHorde;
import com.villain.coldsnaphorde.HordeDataManager;
import com.villain.coldsnaphorde.Utils;
import com.villain.coldsnaphorde.entities.mobs.basemob.GenericHordeMember;
import com.villain.villainoushordemanager.hordedata.EntityTypeHordeData;
import com.villain.villainoushordemanager.hordes.EntityTypeHorde;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;

import java.util.Optional;

import static com.villain.coldsnaphorde.CommonColdSnapHorde.giveAdvancement;
import static com.villain.coldsnaphorde.ForgeColdSnapHorde.hordeDataManager;

public class HordeEventTier1 extends EntityTypeHorde {
    public HordeEventTier1(MinecraftServer server) {
        super(server);
    }

    @Override
    public void Stop(HordeStopReasons stopReason) {
        switch (stopReason) {
            case VICTORY -> {
                broadcast(server, Component.translatable("message.coldsnaphorde.hordevictory").withStyle(ChatFormatting.AQUA));
                for (ServerPlayer player : players) {
                    giveAdvancement(player, server, new ResourceLocation(Constants.MOD_ID, "sliced_snowmen"));
                }
                giveAdvancement(hordeAnchorPlayer, server, new ResourceLocation(Constants.MOD_ID, "sliced_snowmen"));
                HordeDataManager.getInstance().updateHighestLevelBeaten(server, 1);
            }
            case DEFEAT -> broadcast(server, Component.translatable("message.coldsnaphorde.hordedefeat").withStyle(ChatFormatting.RED));
            case PEACEFUL -> broadcast(server, Component.translatable("message.coldsnaphorde.peaceful").withStyle(ChatFormatting.YELLOW));
            case SPAWN_ERROR -> broadcast(server, Component.translatable("message.coldsnaphorde.confused").withStyle(ChatFormatting.RED));
        }
        hordeDataManager.setCooldownTicks(ForgeColdSnapHorde.sconfig.GLOBALHORDECOOLDOWN.get() * 20);
        hordeDataManager.setCurrentHordeLevel(0);
        super.Stop(stopReason);
    }

    @Override
    public void setActiveMemberCount() {
        allowedActive = ForgeColdSnapHorde.sconfig.TIER1HORDESIZE.get();
    }

    @Override
    public void SetUpHorde(ServerPlayer serverPlayer) {
        super.SetUpHorde(serverPlayer);
        if(!trueBiomeCheck(world,  center) || !Utils.tier1Valid(world, center)) return;
        hordeDataManager.setCooldownTicks(-1);

        bossInfo.setCreateWorldFog(true);
        bossInfo.setColor(BossEvent.BossBarColor.BLUE);
        bossInfo.setName(Component.literal("Cold Snap Horde (Tier 1)").withStyle(ChatFormatting.AQUA, ChatFormatting.BOLD));
        giveAdvancement(serverPlayer, server, new ResourceLocation(Constants.MOD_ID, "snow_day"));
        broadcast(server, Component.translatable("message.coldsnaphorde.hordestart", serverPlayer.getDisplayName()).withStyle(ChatFormatting.AQUA));
        hordeDataManager.setCurrentHordeLevel(1);
    }

    @Override
    public void setEasyDifficultyStats() {
        Alive = ForgeColdSnapHorde.sconfig.TIER1ALIVEEASY.get();
        initAlive = ForgeColdSnapHorde.sconfig.TIER1ALIVEEASY.get();
    }

    @Override
    public void setNormalDifficultyStats() {
        Alive = ForgeColdSnapHorde.sconfig.TIER1ALIVENORMAL.get();
        initAlive = ForgeColdSnapHorde.sconfig.TIER1ALIVENORMAL.get();
    }

    @Override
    public void setHardDifficultyStats() {
        Alive = ForgeColdSnapHorde.sconfig.TIER1ALIVEHARD.get();
        initAlive = ForgeColdSnapHorde.sconfig.TIER1ALIVEHARD.get();
    }

    @Override
    protected void updateCenter() {
        if (updateCenter <= 0 && hordeAnchorPlayer != null) {
            center = hordeAnchorPlayer.blockPosition();
            updateCenter = ForgeColdSnapHorde.sconfig.UPDATETICK.get();
            updatePlayers();
            updateHorde();
        } else {
            updateCenter--;
        }
    }

    private void broadcast(MinecraftServer server, Component translationTextComponent) {
        server.getPlayerList().broadcastSystemMessage(translationTextComponent, false);
    }

    private boolean trueBiomeCheck(ServerLevel world, BlockPos pos) {
        int protlvl = ForgeColdSnapHorde.cconfig.HEATPROT.get();
        float temp = world.getBiome(pos).value().getBaseTemperature();
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

    protected BlockPos hordeSpawnAttempter(EntityType type) {
        Optional<BlockPos> hordeSpawn = Optional.empty();
        int attempts = 0;
        while (hordeSpawn.isEmpty()) {
            hordeSpawn = this.getValidSpawn(2, type);
            //If the spawn is not within additional Horde parameters, clear it out. We will accept extra attempts for this.
            if (hordeSpawn.isPresent() && !additionalHordeCheck(hordeSpawn.get(), world))
                hordeSpawn = Optional.empty();
            attempts++;
            if (hordeSpawn.isEmpty() && attempts >= 10) {
                this.Stop(HordeStopReasons.SPAWN_ERROR);
                return null;
            }
        }
        return hordeSpawn.get();
    }

    protected boolean additionalHordeCheck(BlockPos pos, ServerLevel world) {
        return trueBiomeCheck(world, pos) && Utils.tier1Valid(world, pos);
    }

    @Override
    public void injectGoal(PathfinderMob entity, EntityTypeHordeData entityHordeData, double movementSpeedModifier) {
        super.injectGoal(entity, entityHordeData, movementSpeedModifier);
        if(entity instanceof GenericHordeMember) {((GenericHordeMember) entity).setHordeStatus(true);}
    }
}
