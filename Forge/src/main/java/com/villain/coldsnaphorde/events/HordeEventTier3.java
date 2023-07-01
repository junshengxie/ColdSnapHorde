package com.villain.coldsnaphorde.events;

import com.villain.coldsnaphorde.*;
import com.villain.coldsnaphorde.entities.mobs.basemob.*;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.EndHorde;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.NetherHorde;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.PlagueHorde;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.StandardHorde;
import com.villain.villainoushordemanager.RuleEnumInterface;
import com.villain.villainoushordemanager.hordedata.EnumHordeData;
import com.villain.villainoushordemanager.hordes.EntityEnumHorde;
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
import java.util.Random;

import static com.villain.coldsnaphorde.CommonColdSnapHorde.giveAdvancement;
import static com.villain.coldsnaphorde.ForgeColdSnapHorde.hordeDataManager;

public class HordeEventTier3 extends EntityEnumHorde {
    public HordeEventTier3(MinecraftServer server) {
        super(server);
    }

    boolean isSwamp;
    boolean isEnd;
    boolean isNether;

    @Override
    public void Stop(HordeStopReasons stopReason) {
        switch (stopReason) {
            case VICTORY -> {
                broadcast(server, Component.translatable("message.coldsnaphorde.hordevictory").withStyle(ChatFormatting.AQUA));
                ResourceLocation extraAchievement = null;
                if (isSwamp) {
                    extraAchievement = new ResourceLocation(Constants.MOD_ID, "pestilence");
                } else if (isEnd) {
                    extraAchievement = new ResourceLocation(Constants.MOD_ID, "horde_end");
                } else if (isNether) {
                    extraAchievement = new ResourceLocation(Constants.MOD_ID, "meltdown");
                }

                for (ServerPlayer player : players) {
                    giveAdvancement(player, server, new ResourceLocation(Constants.MOD_ID, "horde_breaker"));
                    if (extraAchievement != null) {
                        giveAdvancement(player, server, extraAchievement);
                    }
                }

                giveAdvancement(hordeAnchorPlayer, server, new ResourceLocation(Constants.MOD_ID, "horde_breaker"));
                giveAdvancement(hordeAnchorPlayer, server, extraAchievement);
                hordeDataManager.updateHighestLevelBeaten(server, 3);
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
        allowedActive = ForgeColdSnapHorde.sconfig.TIER3HORDESIZE.get();
    }

    @Override
    public void SetUpHorde(ServerPlayer serverPlayer) {
        super.SetUpHorde(serverPlayer);
        hordeDataManager.setCooldownTicks(-1);

        isSwamp = false;
        isEnd = false;
        isNether = false;

        bossInfo.setCreateWorldFog(true);
        if (hordeAnchorPlayer.level().dimension().toString().contains("end")) {
            bossInfo.setColor(BossEvent.BossBarColor.PURPLE);
            bossInfo.setName(Component.literal("Cold Snap Horde (Tier 3)").withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD));
            isEnd = true;
        } else if (hordeAnchorPlayer.level().dimension().toString().contains("nether")) {
            bossInfo.setColor(BossEvent.BossBarColor.RED);
            bossInfo.setName(Component.literal("Cold Snap Horde (Tier 3)").withStyle(ChatFormatting.RED, ChatFormatting.BOLD));
            isNether = true;
        } else {
            if (world.getBiome(center).is(ColdSnapBiomeTags.Swamps)) {
                bossInfo.setColor(BossEvent.BossBarColor.GREEN);
                bossInfo.setName(Component.literal("Cold Snap Horde (Tier 3)").withStyle(ChatFormatting.GREEN, ChatFormatting.BOLD));
                isSwamp = true;
            } else {
                bossInfo.setColor(BossEvent.BossBarColor.BLUE);
                bossInfo.setName(Component.literal("Cold Snap Horde (Tier 3)").withStyle(ChatFormatting.AQUA, ChatFormatting.BOLD));
            }
        }
        giveAdvancement(serverPlayer, server, new ResourceLocation(Constants.MOD_ID, "hail_storm"));
        broadcast(server, Component.translatable("message.coldsnaphorde.hordestart", serverPlayer.getDisplayName()).withStyle(ChatFormatting.AQUA));
        hordeDataManager.setCurrentHordeLevel(3);
    }

    @Override
    public void setEasyDifficultyStats() {
        Alive = ForgeColdSnapHorde.sconfig.TIER3ALIVEEASY.get();
        initAlive = ForgeColdSnapHorde.sconfig.TIER3ALIVEEASY.get();
    }

    @Override
    public void setNormalDifficultyStats() {
        Alive = ForgeColdSnapHorde.sconfig.TIER3ALIVENORMAL.get();
        initAlive = ForgeColdSnapHorde.sconfig.TIER3ALIVENORMAL.get();
    }

    @Override
    public void setHardDifficultyStats() {
        Alive = ForgeColdSnapHorde.sconfig.TIER3ALIVEHARD.get();
        initAlive = ForgeColdSnapHorde.sconfig.TIER3ALIVEHARD.get();
    }

    @Override
    protected void updateCenter() {
        if (updateCenter == 0 && hordeAnchorPlayer != null) {
            center = hordeAnchorPlayer.blockPosition();
            updateCenter = ForgeColdSnapHorde.sconfig.UPDATETICK.get();
            if (!world.dimension().toString().contains("nether") && !world.dimension().toString().contains("end")) {
                if (world.getBiome(center).is(ColdSnapBiomeTags.Swamps)) {
                    bossInfo.setColor(BossEvent.BossBarColor.GREEN);
                    bossInfo.setName(Component.literal("Cold Snap Horde (Tier 3)").withStyle(ChatFormatting.GREEN, ChatFormatting.BOLD));
                } else {
                    bossInfo.setColor(BossEvent.BossBarColor.BLUE);
                    bossInfo.setName(Component.literal("Cold Snap Horde (Tier 3)").withStyle(ChatFormatting.AQUA, ChatFormatting.BOLD));
                    isSwamp = false;
                }
            }
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
            attempts++;
            if (hordeSpawn.isEmpty() && attempts >= 5) {
                this.Stop(HordeStopReasons.SPAWN_ERROR);
                return null;
            }
        }
        return hordeSpawn.get();
    }

    @Override
    protected void spawnBasedOnEnum(RuleEnumInterface ruleEnumInterface, EnumHordeData enumHordeData) {
        if (ruleEnumInterface instanceof HordeEnum)
            if (ruleEnumInterface.equals(HordeEnum.COLDSNAPGUNNER)) {
                ColdSnapGunner coldSnapGunner = new StandardHorde.StandardGunner(Register.COLDSNAPGUNNER.get(), world);
                BlockPos pos = hordeSpawnAttempter(coldSnapGunner.getType());
                if (pos == null) return;
                coldSnapGunner = gunnerSpawnRules(world, pos);
                coldSnapGunner.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                injectGoal(coldSnapGunner, enumHordeData, enumHordeData.getGoalMovementSpeed());
                world.addFreshEntity(coldSnapGunner);
                activeHordeMembers.add(coldSnapGunner);
            } else if (ruleEnumInterface.equals(HordeEnum.COLDSNAPSTABBER)) {
                ColdSnapStabber coldSnapStabber = new StandardHorde.StandardStabber(Register.COLDSNAPSTABBER.get(), world);
                BlockPos pos = hordeSpawnAttempter(coldSnapStabber.getType());
                if (pos == null) return;
                coldSnapStabber = stabberSpawnRules(world, pos);
                coldSnapStabber.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                injectGoal(coldSnapStabber, enumHordeData, enumHordeData.getGoalMovementSpeed());
                world.addFreshEntity(coldSnapStabber);
                activeHordeMembers.add(coldSnapStabber);
            } else if (ruleEnumInterface.equals(HordeEnum.COLDSNAPSNOWBALLER)) {
                ColdSnapSnowballer coldSnapSnowballer = new StandardHorde.StandardSnowballer(Register.COLDSNAPSNOWBALLER.get(), world);
                BlockPos pos = hordeSpawnAttempter(coldSnapSnowballer.getType());
                if (pos == null) return;
                coldSnapSnowballer = snowballerSpawnRules(world, pos);
                coldSnapSnowballer.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                injectGoal(coldSnapSnowballer, enumHordeData, enumHordeData.getGoalMovementSpeed());
                world.addFreshEntity(coldSnapSnowballer);
                activeHordeMembers.add(coldSnapSnowballer);
            } else if (ruleEnumInterface.equals(HordeEnum.COLDSNAPGIFTER)) {
                ColdSnapGifter coldSnapGifter = new StandardHorde.StandardGifter(Register.COLDSNAPGIFTER.get(), world);
                BlockPos pos = hordeSpawnAttempter(coldSnapGifter.getType());
                if (pos == null) return;
                coldSnapGifter = gifterSpawnRules(world, pos);
                coldSnapGifter.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                injectGoal(coldSnapGifter, enumHordeData, enumHordeData.getGoalMovementSpeed());
                world.addFreshEntity(coldSnapGifter);
                activeHordeMembers.add(coldSnapGifter);
            } else if (ruleEnumInterface.equals(HordeEnum.COLDSNAPZAPPER)) {
                ColdSnapZapper coldSnapZapper = new StandardHorde.StandardZapper(Register.COLDSNAPSNOWBALLER.get(), world);
                BlockPos pos = hordeSpawnAttempter(coldSnapZapper.getType());
                if (pos == null) return;
                coldSnapZapper = zapperSpawnRules(world, pos);
                coldSnapZapper.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                injectGoal(coldSnapZapper, enumHordeData, enumHordeData.getGoalMovementSpeed());
                world.addFreshEntity(coldSnapZapper);
                activeHordeMembers.add(coldSnapZapper);
            } else if (ruleEnumInterface.equals(HordeEnum.COLDSNAPBRAWLER)) {
                ColdSnapBrawler coldSnapBrawler = new StandardHorde.StandardBrawler(Register.COLDSNAPSNOWBALLER.get(), world);
                BlockPos pos = hordeSpawnAttempter(coldSnapBrawler.getType());
                if (pos == null) return;
                coldSnapBrawler = brawlerSpawnRules(world, pos);
                coldSnapBrawler.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                injectGoal(coldSnapBrawler, enumHordeData, enumHordeData.getGoalMovementSpeed());
                world.addFreshEntity(coldSnapBrawler);
                activeHordeMembers.add(coldSnapBrawler);
            }
    }

    @Override
    public void injectGoal(PathfinderMob entity, EnumHordeData entityHordeData, double movementSpeedModifier) {
        super.injectGoal(entity, entityHordeData, movementSpeedModifier);
        if(entity instanceof GenericHordeMember) {((GenericHordeMember) entity).setHordeStatus(true);}
    }


    private ColdSnapGunner gunnerSpawnRules(ServerLevel world, BlockPos pos) {
        ColdSnapGunner coldSnapGunner = null;
        if (world.getBiome(center).is(ColdSnapBiomeTags.Swamps)) {
            coldSnapGunner = new PlagueHorde.PlagueGunner(Register.PCOLDSNAPGUNNER.get(), world);
        } else if (world.dimension().toString().contains("end")) {
            coldSnapGunner = new EndHorde.EndGunner(Register.ECOLDSNAPGUNNER.get(), world);
        } else if (world.dimension().toString().contains("nether")) {
            coldSnapGunner = new EndHorde.EndGunner(Register.NCOLDSNAPGUNNER.get(), world);
        } else if (trueBiomeCheck(world, pos)) {
            if (!world.isRainingAt(pos)) {
                Random random = new Random();
                int chance = random.nextInt(100);
                if (chance <= 5) {
                    coldSnapGunner = new NetherHorde.NetherGunner(Register.NCOLDSNAPGUNNER.get(), world);
                }
                chance = random.nextInt(100);
                if (chance <= 5 && coldSnapGunner == null)
                    coldSnapGunner = new EndHorde.EndGunner(Register.ECOLDSNAPGUNNER.get(), world);
                chance = random.nextInt(100);
                if (chance <= 5 && coldSnapGunner == null)
                    coldSnapGunner = new PlagueHorde.PlagueGunner(Register.PCOLDSNAPGUNNER.get(), world);
                if (coldSnapGunner == null)
                    coldSnapGunner = new StandardHorde.StandardGunner(Register.COLDSNAPGUNNER.get(), world);
            } else {
                Random random = new Random();
                int chance = random.nextInt(150);
                if (chance <= 10 && coldSnapGunner == null)
                    coldSnapGunner = new PlagueHorde.PlagueGunner(Register.PCOLDSNAPGUNNER.get(), world);
                if (coldSnapGunner == null)
                    coldSnapGunner = new StandardHorde.StandardGunner(Register.COLDSNAPGUNNER.get(), world);
            }

        } else coldSnapGunner = new NetherHorde.NetherGunner(Register.NCOLDSNAPGUNNER.get(), world);
        return coldSnapGunner;
    }

    private ColdSnapStabber stabberSpawnRules(ServerLevel world, BlockPos pos) {
        ColdSnapStabber coldSnapStabber = null;
        if (world.getBiome(center).is(ColdSnapBiomeTags.Swamps)) {
            coldSnapStabber = new PlagueHorde.PlagueStabber(Register.PCOLDSNAPSTABBER.get(), world);
        } else if (world.dimension().toString().contains("end")) {
            coldSnapStabber = new EndHorde.EndStabber(Register.ECOLDSNAPSTABBER.get(), world);
        } else if (world.dimension().toString().contains("nether")) {
            coldSnapStabber = new NetherHorde.NetherStabber(Register.NCOLDSNAPSTABBER.get(), world);
        } else if (trueBiomeCheck(world, pos)) {
            if (!world.isRainingAt(pos)) {
                Random random = new Random();
                int chance = random.nextInt(100);
                if (chance <= 5) {
                    coldSnapStabber = new NetherHorde.NetherStabber(Register.NCOLDSNAPSTABBER.get(), world);
                }
                chance = random.nextInt(100);
                if (chance <= 5 && coldSnapStabber == null)
                    coldSnapStabber = new EndHorde.EndStabber(Register.ECOLDSNAPSTABBER.get(), world);
                chance = random.nextInt(100);
                if (chance <= 5 && coldSnapStabber == null)
                    coldSnapStabber = new PlagueHorde.PlagueStabber(Register.PCOLDSNAPSTABBER.get(), world);
                if (coldSnapStabber == null)
                    coldSnapStabber = new StandardHorde.StandardStabber(Register.COLDSNAPSTABBER.get(), world);
            } else {
                Random random = new Random();
                int chance = random.nextInt(150);
                if (chance <= 10 && coldSnapStabber == null)
                    coldSnapStabber = new PlagueHorde.PlagueStabber(Register.PCOLDSNAPSTABBER.get(), world);
                if (coldSnapStabber == null)
                    coldSnapStabber = new StandardHorde.StandardStabber(Register.COLDSNAPSTABBER.get(), world);
            }

        } else coldSnapStabber = new NetherHorde.NetherStabber(Register.NCOLDSNAPSTABBER.get(), world);
        return coldSnapStabber;
    }


    private ColdSnapSnowballer snowballerSpawnRules(ServerLevel world, BlockPos pos) {
        ColdSnapSnowballer coldSnapSnowballer = null;
        if (world.getBiome(center).is(ColdSnapBiomeTags.Swamps)) {
            coldSnapSnowballer = new PlagueHorde.PlagueSnowballer(Register.PCOLDSNAPSNOWBALLER.get(), world);
        } else if (world.dimension().toString().contains("end")) {
            coldSnapSnowballer = new EndHorde.EndSnowballer(Register.ECOLDSNAPSNOWBALLER.get(), world);
        } else if (world.dimension().toString().contains("nether")) {
            coldSnapSnowballer = new NetherHorde.NetherSnowballer(Register.NCOLDSNAPSNOWBALLER.get(), world);
        }
        else if (trueBiomeCheck(world, pos)) {
            if (!world.isRainingAt(pos)) {
                Random random = new Random();
                int chance = random.nextInt(100);
                if (chance <= 5) {
                    coldSnapSnowballer = new NetherHorde.NetherSnowballer(Register.NCOLDSNAPSNOWBALLER.get(), world);}
                chance = random.nextInt(100);
                if (chance <= 5 && coldSnapSnowballer == null)
                    coldSnapSnowballer = new EndHorde.EndSnowballer(Register.ECOLDSNAPSNOWBALLER.get(), world);
                chance = random.nextInt(100);
                if (chance <= 5 && coldSnapSnowballer == null)
                    coldSnapSnowballer = new PlagueHorde.PlagueSnowballer(Register.PCOLDSNAPSNOWBALLER.get(), world);
                if (coldSnapSnowballer == null)
                    coldSnapSnowballer = new StandardHorde.StandardSnowballer(Register.COLDSNAPSNOWBALLER.get(), world);
            } else {
                Random random = new Random();
                int chance = random.nextInt(150);
                if (chance <= 10 && coldSnapSnowballer == null)
                    coldSnapSnowballer = new PlagueHorde.PlagueSnowballer(Register.PCOLDSNAPSNOWBALLER.get(), world);
                if (coldSnapSnowballer == null)
                    coldSnapSnowballer = new StandardHorde.StandardSnowballer(Register.COLDSNAPSNOWBALLER.get(), world);
            }

        } else coldSnapSnowballer = new NetherHorde.NetherSnowballer(Register.NCOLDSNAPSNOWBALLER.get(), world);
        return coldSnapSnowballer;
    }

    private ColdSnapGifter gifterSpawnRules(ServerLevel world, BlockPos pos){
        ColdSnapGifter coldSnapGifter = null;
        if (world.getBiome(center).is(ColdSnapBiomeTags.Swamps)){
            coldSnapGifter = new PlagueHorde.PlagueGifter(Register.PCOLDSNAPGIFTER.get(), world);
        }else if(world.dimension().toString().contains("end")){
            coldSnapGifter = new EndHorde.EndGifter(Register.ECOLDSNAPGIFTER.get(), world);
        }else if(world.dimension().toString().contains("nether")){
            coldSnapGifter = new NetherHorde.NetherGifter(Register.NCOLDSNAPGIFTER.get(), world);
        } else if(trueBiomeCheck(world, pos)){
            if(!world.isRainingAt(pos)){
                Random random = new Random();
                int chance = random.nextInt(100);
                if(chance <= 5){coldSnapGifter = new NetherHorde.NetherGifter(Register.NCOLDSNAPGIFTER.get(), world);}
                chance = random.nextInt(100);
                if(chance <= 5 && coldSnapGifter == null) coldSnapGifter = new EndHorde.EndGifter(Register.ECOLDSNAPGIFTER.get(), world);
                chance = random.nextInt(100);
                if(chance <= 5 && coldSnapGifter == null) coldSnapGifter = new PlagueHorde.PlagueGifter(Register.PCOLDSNAPGIFTER.get(), world);
                if(coldSnapGifter == null) coldSnapGifter = new StandardHorde.StandardGifter(Register.COLDSNAPGIFTER.get(), world);
            }else {
                Random random = new Random();
                int chance = random.nextInt(150);
                if(chance <= 10 && coldSnapGifter == null) coldSnapGifter = new PlagueHorde.PlagueGifter(Register.PCOLDSNAPGIFTER.get(), world);
                if(coldSnapGifter == null) coldSnapGifter = new StandardHorde.StandardGifter(Register.COLDSNAPGIFTER.get(), world);
            }

        }
        else coldSnapGifter = new NetherHorde.NetherGifter(Register.NCOLDSNAPGIFTER.get(), world);
        return coldSnapGifter;
    }

    private ColdSnapZapper zapperSpawnRules(ServerLevel world, BlockPos pos){
        ColdSnapZapper coldSnapZapper = null;
        if (world.getBiome(center).is(ColdSnapBiomeTags.Swamps)){coldSnapZapper = new PlagueHorde.PlagueZapper(Register.PCOLDSNAPZAPPER.get(), world);
        }else if(world.dimension().toString().contains("end")){
            coldSnapZapper = new EndHorde.EndZapper(Register.ECOLDSNAPZAPPER.get(), world);
        }else if(world.dimension().toString().contains("nether")){
            coldSnapZapper = new NetherHorde.NetherZapper(Register.NCOLDSNAPZAPPER.get(), world);
        }else if(trueBiomeCheck(world, pos)){
            if(!world.isRainingAt(pos)){
                Random random = new Random();
                int chance = random.nextInt(100);
                if(chance <= 5){coldSnapZapper = new NetherHorde.NetherZapper(Register.NCOLDSNAPZAPPER.get(), world);}
                chance = random.nextInt(100);
                if(chance <= 5 && coldSnapZapper == null) coldSnapZapper = new EndHorde.EndZapper(Register.ECOLDSNAPZAPPER.get(), world);
                chance = random.nextInt(100);
                if(chance <= 5 && coldSnapZapper == null) coldSnapZapper = new PlagueHorde.PlagueZapper(Register.PCOLDSNAPZAPPER.get(), world);
                if(coldSnapZapper == null) coldSnapZapper = new StandardHorde.StandardZapper(Register.COLDSNAPZAPPER.get(), world);
            }else {
                Random random = new Random();
                int chance = random.nextInt(150);
                if(chance <= 10 && coldSnapZapper == null) coldSnapZapper = new PlagueHorde.PlagueZapper(Register.PCOLDSNAPZAPPER.get(), world);
                if(coldSnapZapper == null) coldSnapZapper = new StandardHorde.StandardZapper(Register.COLDSNAPZAPPER.get(), world);
            }

        }
        else coldSnapZapper = new NetherHorde.NetherZapper(Register.NCOLDSNAPZAPPER.get(), world);
        return coldSnapZapper;
    }

    private ColdSnapBrawler brawlerSpawnRules(ServerLevel world, BlockPos pos){
        ColdSnapBrawler coldSnapBrawler = null;
        if (world.getBiome(center).is(ColdSnapBiomeTags.Swamps)){
            coldSnapBrawler = new PlagueHorde.PlagueBrawler(Register.PCOLDSNAPBRAWLER.get(), world);
        }else if(world.dimension().toString().contains("end")){
            coldSnapBrawler = new EndHorde.EndBrawler(Register.ECOLDSNAPBRAWLER.get(), world);
        }else if(world.dimension().toString().contains("nether")){
            coldSnapBrawler = new NetherHorde.NetherBrawler(Register.NCOLDSNAPBRAWLER.get(), world);
        } else if(trueBiomeCheck(world, pos)){
            if(!world.isRainingAt(pos)){
                Random random = new Random();
                int chance = random.nextInt(100);
                if(chance <= 5){coldSnapBrawler = new NetherHorde.NetherBrawler(Register.NCOLDSNAPBRAWLER.get(), world);}
                chance = random.nextInt(100);
                if(chance <= 5 && coldSnapBrawler == null) coldSnapBrawler = new EndHorde.EndBrawler(Register.ECOLDSNAPBRAWLER.get(), world);
                chance = random.nextInt(100);
                if(chance <= 5 && coldSnapBrawler == null) coldSnapBrawler = new PlagueHorde.PlagueBrawler(Register.PCOLDSNAPBRAWLER.get(), world);
                if(coldSnapBrawler == null) coldSnapBrawler = new StandardHorde.StandardBrawler(Register.COLDSNAPBRAWLER.get(), world);
            }else {
                Random random = new Random();
                int chance = random.nextInt(150);
                if(chance <= 10 && coldSnapBrawler == null) coldSnapBrawler = new PlagueHorde.PlagueBrawler(Register.PCOLDSNAPBRAWLER.get(), world);
                if(coldSnapBrawler == null) coldSnapBrawler = new StandardHorde.StandardBrawler(Register.COLDSNAPBRAWLER.get(), world);
            }

        }
        else coldSnapBrawler = new NetherHorde.NetherBrawler(Register.NCOLDSNAPBRAWLER.get(), world);
        return coldSnapBrawler;
    }
}
