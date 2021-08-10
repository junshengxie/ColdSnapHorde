package com.cartoonishvillain.coldsnaphorde.Events;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.*;
import com.cartoonishvillain.coldsnaphorde.Register;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.GiantEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.raid.RaidManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.EntityViewRenderEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Horde {
    private Optional<BlockPos> hordeSpawn = Optional.empty();
    private ServerWorld world;
    private BlockPos center;
    public Horde(ServerWorld world, BlockPos center, ServerPlayerEntity playerEntity) {
        //Stage 0, get nearby players and include them into event
        this.world = world;
        this.center = center;
        ArrayList<Entity> entities = (ArrayList<Entity>) world.getEntitiesWithinAABBExcludingEntity(playerEntity, new AxisAlignedBB(playerEntity.getPosX() - 25, playerEntity.getPosY() - 25, playerEntity.getPosZ() - 25, playerEntity.getPosX() + 25, playerEntity.getPosY() + 25, playerEntity.getPosZ() + 25 ));
        ArrayList<PlayerEntity> playerEntities = new ArrayList<>();
        playerEntities.add(playerEntity);
        for(Entity entity : entities){
            if(entity instanceof PlayerEntity){
               playerEntities.add((PlayerEntity) entity);
            }
        }
        //Stage 1, send message about incoming horde
        for(PlayerEntity player : playerEntities){ player.sendStatusMessage(new StringTextComponent(TextFormatting.AQUA + "A cold snap horde approaches!"), true);}

        //Stage 2, spawn a horde of enemies, send them towards the block center.
        for(int entityCount = 0; entityCount < ColdSnapHorde.sconfig.HORDESIZE.get(); entityCount++){
            this.hordeSpawn = this.getValidSpawn(2);
            if(!hordeSpawn.equals(Optional.empty()) && hordeSpawn.isPresent()){
                spawnSnowman(hordeSpawn.get());
            }
        }
    }

    private Optional<BlockPos> getValidSpawn(int var1){
        for(int i = 0; i < 3; ++i){
            BlockPos blockPos = this.findRandomSpawnPos(var1, 1);
            if(blockPos != null) return Optional.of(blockPos);
        }
        return Optional.empty();
    }

    @Nullable
    private BlockPos findRandomSpawnPos(int logicvar, int loopvar){
        int i = logicvar == 0 ? 2 : 2 - logicvar;
        BlockPos.Mutable blockPos = new BlockPos.Mutable();

        for(int a = 0; a < loopvar; ++a){
            float f = this.world.rand.nextFloat() * ((float)Math.PI * 2F);
            double DISTANCE = -1;
            int j = Integer.MAX_VALUE, l = Integer.MAX_VALUE;
            while ((DISTANCE == -1 || !(DISTANCE > 450 && DISTANCE < 1250)) || !biomeCheck(world, new BlockPos(j, center.getY(), l))){ //check for appropriate distance from start and proper biome
            j = randFinder(this.center.getX(), f, i);
            l = randFinder(this.center.getZ(), f, i);
            DISTANCE = center.distanceSq(new BlockPos(j, center.getY(), l));}

            int k = this.world.getHeight(Heightmap.Type.WORLD_SURFACE, j, l);
            blockPos.setPos(j, k, l);
            if(this.world.isAreaLoaded(blockPos, 20)) return blockPos;
        }
        return null;
    }

    private int randFinder(int centercoord, float f, int i){return centercoord + (this.world.rand.nextInt(25+25) - 25);}

    private void spawnSnowman(BlockPos pos){
        ArrayList<Integer> SpawnWeights = new ArrayList<>();
        SpawnWeights.add(ColdSnapHorde.cconfig.GUNNER.get());
        SpawnWeights.add(ColdSnapHorde.cconfig.STABBER.get());
        SpawnWeights.add(ColdSnapHorde.cconfig.SNOWBALLER.get());
        SpawnWeights.add(ColdSnapHorde.cconfig.ZAPPER.get());
        SpawnWeights.add(ColdSnapHorde.cconfig.GIFTER.get());
        SpawnWeights.add(ColdSnapHorde.cconfig.BRAWLER.get());
        int combined = 0; for(Integer weight : SpawnWeights) combined += weight;
        Random random = new Random();
        int rng = random.nextInt(combined);
        int selected = -1;
        int counter = 0;
        for(Integer weights : SpawnWeights){
            if ((rng - weights) <= 0){
                selected = counter;
                break;
            }else counter++; rng -= weights;
        }

        switch (selected){
            case 0:
                ColdSnapGunner coldSnapGunner = new ColdSnapGunner(Register.COLDSNAPGUNNER.get(), world);
                coldSnapGunner.setPosition(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapGunner.toggleHordeMember(center);
                world.addEntity(coldSnapGunner);
                break;
            case 1:
                ColdSnapStabber coldSnapStabber = new ColdSnapStabber(Register.COLDSNAPSTABBER.get(), world);
                coldSnapStabber.setPosition(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapStabber.toggleHordeMember(center);
                world.addEntity(coldSnapStabber);
                break;
            case 2:
                ColdSnapSnowballer coldSnapSnowballer = new ColdSnapSnowballer(Register.COLDSNAPSNOWBALLER.get(), world);
                coldSnapSnowballer.setPosition(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapSnowballer.toggleHordeMember(center);
                world.addEntity(coldSnapSnowballer);
                break;
            case 3:
                ColdSnapZapper coldSnapZapper = new ColdSnapZapper(Register.COLDSNAPZAPPER.get(), world);
                coldSnapZapper.setPosition(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapZapper.toggleHordeMember(center);
                world.addEntity(coldSnapZapper);
                break;
            case 4:
                ColdSnapGifter coldSnapGifter = new ColdSnapGifter(Register.COLDSNAPGIFTER.get(), world);
                coldSnapGifter.setPosition(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapGifter.toggleHordeMember(center);
                world.addEntity(coldSnapGifter);
                break;
            case 5:
                ColdSnapBrawler coldSnapBrawler = new ColdSnapBrawler(Register.COLDSNAPBRAWLER.get(), world);
                coldSnapBrawler.setPosition(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapBrawler.toggleHordeMember(center);
                world.addEntity(coldSnapBrawler);
                break;
        }
    }

    private boolean biomeCheck(World world, BlockPos pos){
        if(world.getBiome(pos).getRegistryName().toString().contains("swamp")){return true;}
        if(!world.getDimensionKey().toString().contains("over")){return true;}
        int protlvl = ColdSnapHorde.cconfig.HEATPROT.get();
        float temp = world.getBiome(pos).getTemperature();
        int code = -1;
        if (temp < 0.3){code = 0;}
        else if(temp >= 0.3 && temp < 0.9){code = 1;}
        else if(temp >= 0.9 && temp < 1.5){code = 2;}
        else if(temp >= 1.5){code = 3;}

        return code <= protlvl;
    }
}
