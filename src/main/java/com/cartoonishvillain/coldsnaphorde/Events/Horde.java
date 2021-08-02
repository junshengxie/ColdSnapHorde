package com.cartoonishvillain.coldsnaphorde.Events;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.*;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Horde {
    private Optional<BlockPos> hordeSpawn = Optional.empty();
    private ServerLevel world;
    private BlockPos center;
    public Horde(ServerLevel world, BlockPos center, ServerPlayer playerEntity) {
        //Stage 0, get nearby players and include them into event
        this.world = world;
        this.center = center;
        ArrayList<Entity> entities = (ArrayList<Entity>) world.getEntities(playerEntity, new AABB(playerEntity.getX() - 25, playerEntity.getY() - 25, playerEntity.getZ() - 25, playerEntity.getX() + 25, playerEntity.getY() + 25, playerEntity.getZ() + 25 ));
        ArrayList<Player> playerEntities = new ArrayList<>();
        playerEntities.add(playerEntity);
        for(Entity entity : entities){
            if(entity instanceof Player){
               playerEntities.add((Player) entity);
            }
        }
        //Stage 1, send message about incoming horde
        for(Player player : playerEntities){ player.displayClientMessage(new TextComponent(ChatFormatting.AQUA + "A cold snap horde approaches!"), true);}

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
        BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

        for(int a = 0; a < loopvar; ++a){
            float f = this.world.random.nextFloat() * ((float)Math.PI * 2F);
            double DISTANCE = -1;
            int j = Integer.MAX_VALUE, l = Integer.MAX_VALUE;
            while ((DISTANCE == -1 || !(DISTANCE > 450 && DISTANCE < 1250)) || !biomeCheck(world, new BlockPos(j, center.getY(), l))){ //check for appropriate distance from start and proper biome
            j = randFinder(this.center.getX(), f, i);
            l = randFinder(this.center.getZ(), f, i);
            DISTANCE = center.distSqr(new BlockPos(j, center.getY(), l));}

            int k = this.world.getHeight(Heightmap.Types.WORLD_SURFACE, j, l);
            blockPos.set(j, k, l);
            if(this.world.isAreaLoaded(blockPos, 20)) return blockPos;
        }
        return null;
    }

    private int randFinder(int centercoord, float f, int i){return centercoord + (this.world.random.nextInt(25+25) - 25);}

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
                coldSnapGunner.setPos(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapGunner.toggleHordeMember(center);
                world.addFreshEntity(coldSnapGunner);
                break;
            case 1:
                ColdSnapStabber coldSnapStabber = new ColdSnapStabber(Register.COLDSNAPSTABBER.get(), world);
                coldSnapStabber.setPos(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapStabber.toggleHordeMember(center);
                world.addFreshEntity(coldSnapStabber);
                break;
            case 2:
                ColdSnapSnowballer coldSnapSnowballer = new ColdSnapSnowballer(Register.COLDSNAPSNOWBALLER.get(), world);
                coldSnapSnowballer.setPos(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapSnowballer.toggleHordeMember(center);
                world.addFreshEntity(coldSnapSnowballer);
                break;
            case 3:
                ColdSnapZapper coldSnapZapper = new ColdSnapZapper(Register.COLDSNAPZAPPER.get(), world);
                coldSnapZapper.setPos(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapZapper.toggleHordeMember(center);
                world.addFreshEntity(coldSnapZapper);
                break;
            case 4:
                ColdSnapGifter coldSnapGifter = new ColdSnapGifter(Register.COLDSNAPGIFTER.get(), world);
                coldSnapGifter.setPos(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapGifter.toggleHordeMember(center);
                world.addFreshEntity(coldSnapGifter);
                break;
            case 5:
                ColdSnapBrawler coldSnapBrawler = new ColdSnapBrawler(Register.COLDSNAPBRAWLER.get(), world);
                coldSnapBrawler.setPos(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
                coldSnapBrawler.toggleHordeMember(center);
                world.addFreshEntity(coldSnapBrawler);
                break;
        }
    }

    private boolean biomeCheck(Level world, BlockPos pos){
        if(world.getBiome(pos).getRegistryName().toString().contains("swamp")){return true;}
        if(!world.dimension().toString().contains("over")){return true;}
        int protlvl = ColdSnapHorde.cconfig.HEATPROT.get();
        float temp = world.getBiome(pos).getBaseTemperature();
        int code = -1;
        if (temp < 0.3){code = 0;}
        else if(temp >= 0.3 && temp < 0.9){code = 1;}
        else if(temp >= 0.9 && temp < 1.5){code = 2;}
        else if(temp >= 1.5){code = 3;}

        return code <= protlvl;
    }
}
