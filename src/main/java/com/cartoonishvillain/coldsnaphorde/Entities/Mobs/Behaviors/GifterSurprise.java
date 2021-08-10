package com.cartoonishvillain.coldsnaphorde.Entities.Mobs.Behaviors;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import java.util.*;

import static com.cartoonishvillain.coldsnaphorde.Entities.Mobs.BaseMob.GenericHordeMember.Infection;

public class GifterSurprise {

    World world;
    Entity exploder;
    double Entx;
    double Enty;
    double Entz;
    float radius;
    Vector3d position;
    DamageSource damageSource;
    ArrayList<BlockPos> blockPosArrayList = new ArrayList<>();
    int hordeVariant;
    ArrayList<Entity> effectedEntities = new ArrayList<>();



    public GifterSurprise(World world, @Nullable Entity exploder, double x, double y, double z, float radius) {
        this.world = world;
        this.Entx = x;
        this.Enty = y;
        this.Entz = z;
        this.exploder = exploder;
        this.radius = radius;
        this.damageSource = DamageSource.causeExplosionDamage((LivingEntity) exploder);
        this.position = new Vector3d(x, y, z);
        if(exploder instanceof GenericHordeMember){
            GenericHordeMember genericHordeMember = (GenericHordeMember) exploder;
            this.hordeVariant = genericHordeMember.getHordeVariant();
        }
    }


// The for loop equation for this class belongs under the following license
//    The MIT License (MIT)
//
//Copyright (c) 2021 b
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//THE SOFTWARE.
// Due to them not having a very helpful name to find their work, the github repo is here: https://github.com/Luligabi1/ElementalCreepersRefabricated

    public void StageDetonation(){
        for (int x = (int) -radius - 1; x <= radius; x++) {
            for (int y = (int) -radius - 1; y <= radius; y++) {
                for (int z = (int) -radius - 1; z <= radius; z++) {
                    BlockPos blockPos = new BlockPos(Entx + x,Enty + y,Entz + z);
                    blockPosArrayList.add(blockPos);
                    ArrayList<Entity> entities = (ArrayList<Entity>) world.getEntitiesInAABBexcluding(exploder, new AxisAlignedBB(Entx+x+2, Enty+y+2, Entz+z+2, Entx+x-2, Enty+y-2, Entz+z-2), null);
                    for(Entity entity : entities){
                        if(!effectedEntities.contains(entity)) effectedEntities.add(entity);
                    }
                }
            }
        }
    }

    public void DetonateTest(){
        for(BlockPos blockPos : blockPosArrayList){
            world.setBlockState(blockPos, Blocks.WATER.getDefaultState());
        }
    }

    public void DetonateBlockDamage(){
        if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(exploder.world, exploder) && hordeVariant != 2){
            if(hordeVariant != 1){
                for (BlockPos blockPos : blockPosArrayList){
                    if((world.getBlockState(blockPos).equals(Blocks.AIR.getDefaultState()) || world.getBlockState(blockPos).equals(Blocks.GRASS.getDefaultState())) && !(world.getBlockState(blockPos.down()).equals(Blocks.AIR.getDefaultState()) || world.getBlockState(blockPos.down()).equals(Blocks.GRASS.getDefaultState()))){
                        world.setBlockState(blockPos, Blocks.SNOW.getDefaultState());
                    }else if(world.getBlockState(blockPos).equals(Blocks.WATER.getDefaultState())) world.setBlockState(blockPos, Blocks.ICE.getDefaultState());
                    else if(world.getBlockState(blockPos).equals(Blocks.LAVA.getDefaultState())) world.setBlockState(blockPos, Blocks.OBSIDIAN.getDefaultState());
                    else if(world.getBlockState(blockPos).getBlock().equals(Blocks.FARMLAND)) world.setBlockState(blockPos, Blocks.DIRT.getDefaultState());
                    else if(world.getBlockState(blockPos).equals(Blocks.ICE.getDefaultState())) world.setBlockState(blockPos, Blocks.PACKED_ICE.getDefaultState());
                    else if(world.getBlockState(blockPos).getBlock().equals(Blocks.FIRE)) world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                }
            } else{
                for (BlockPos blockPos : blockPosArrayList){
                    if((world.getBlockState(blockPos).equals(Blocks.AIR.getDefaultState()) || world.getBlockState(blockPos).equals(Blocks.GRASS.getDefaultState())) && !(world.getBlockState(blockPos.down()).equals(Blocks.AIR.getDefaultState()) || world.getBlockState(blockPos.down()).equals(Blocks.GRASS.getDefaultState()))){
                        if(world.getBlockState(blockPos.down()).equals(Blocks.SOUL_SAND.getDefaultState()) || world.getBlockState(blockPos.down()).equals(Blocks.SOUL_SOIL.getDefaultState())){
                            world.setBlockState(blockPos, Blocks.SOUL_FIRE.getDefaultState());
                        }else {world.setBlockState(blockPos, Blocks.FIRE.getDefaultState());}

                    } else if(world.getBlockState(blockPos).equals(Blocks.ICE.getDefaultState())) world.setBlockState(blockPos, Blocks.PACKED_ICE.getDefaultState());
                }
            }
        }
    }

    public void DetonateLivingHarm(){
        Vector3d vec3 = new Vector3d(this.Entx, this.Enty, this.Entz);
        for(Entity entity : effectedEntities){
            if (entity instanceof LivingEntity){
                float DamageRadius = radius * 1.5f;
                if(!entity.isImmuneToExplosions()){
                    double distanceFactor = Math.sqrt(entity.getDistanceSq(vec3)) / DamageRadius;
                    if(distanceFactor <= 1){
                        double directionalx = entity.getPosX() - this.Entx;
                        double directionaly = entity.getPosY() - this.Enty;
                        double directionalz = entity.getPosZ() - this.Entz;
                        double percentSeen =  Explosion.getBlockDensity(vec3, entity);
                        double damage = (1.0D - distanceFactor) * percentSeen;
                        if(hordeVariant != 2) {
                            double knockback = damage;
                            if (entity instanceof LivingEntity) {
                                knockback = ProtectionEnchantment.getBlastDamageReduction((LivingEntity) entity, damage);
                            }
                            entity.setMotion(entity.getMotion().add(directionalx * knockback, directionaly * knockback, directionalz * knockback));
                            if(hordeVariant == 3){Infection((LivingEntity) entity);}
                        }else{
                            ((LivingEntity) entity).attemptTeleport(entity.getPosX() + entity.world.rand.nextInt(10+10)-10,entity.getPosY() + entity.world.rand.nextInt(10+10)-10,entity.getPosZ() + entity.world.rand.nextInt(10+10)-10, true);
                        }
                        entity.attackEntityFrom(this.damageSource, (float)((int)((damage * damage + damage) / 2.0D * 3.0D * (double)DamageRadius + 1.0D)));
                    }
                }
            }
        }
    }


}