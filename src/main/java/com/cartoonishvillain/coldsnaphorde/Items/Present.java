package com.cartoonishvillain.coldsnaphorde.Items;

import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.item.Item.Properties;

public class Present extends Item {
    public Present(Properties properties) {super(properties);}

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!worldIn.isClientSide() && handIn == Hand.MAIN_HAND){
        playerIn.getCooldowns().addCooldown(this, 20);
        ArrayList<String> possibilities = new ArrayList<>();
        ArrayList<Float> weights = new ArrayList<>();
        possibilities.add("coal"); weights.add(25.5f);
        possibilities.add("snow"); weights.add(10f);
        possibilities.add("ice"); weights.add(15f);
        possibilities.add("packedice"); weights.add(10f);
        possibilities.add("blueice"); weights.add(5f);
        possibilities.add("doggo"); weights.add(5f);
        possibilities.add("cats"); weights.add(5f);
        possibilities.add("birb"); weights.add(5f);
        possibilities.add("friendsnowman"); weights.add(10f);
        possibilities.add("music"); weights.add(15f);
        possibilities.add("rollercoaster"); weights.add(10f);
        possibilities.add("horse"); weights.add(5f);
        possibilities.add("pig"); weights.add(5f);
        possibilities.add("candycane"); weights.add(10f);
        possibilities.add("icesword"); weights.add(5f);
        possibilities.add("transposerpiece"); weights.add(10f);
        possibilities.add("frostshard"); weights.add(15f);
        possibilities.add("transposer"); weights.add(5f);
        possibilities.add("frostcore"); weights.add(5f);

            playerIn.getMainHandItem().shrink(1);

        float Total = 0f;
        for(float totaling : weights) Total += totaling;
        float randomized = 0 + worldIn.random.nextFloat() * (Total-0);
        int select = 0;

        for(Float percentage : weights){
            randomized -= percentage;
            if(randomized <= 0) break;
            else select++;
        }

        if(select == possibilities.size()) select = select - 1;
        String selected = possibilities.get(select);
        RewardDispenser(worldIn, playerIn, selected);}

        return super.use(worldIn, playerIn, handIn);
    }

    private void ItemSpawner(BlockPos pos, World world, Item item, int low, int high){

        int bound = 0;
        if(low == high) {low = 0; bound = high;}
        else bound = world.random.nextInt(high - low);
        ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY(), pos.getZ()+0.5, new ItemStack(item, bound + low));
        world.addFreshEntity(itemEntity);
    }

    private void SpawnDispenser(World world, PlayerEntity playerEntity, Entity entity){
        if(entity instanceof WolfEntity){
            WolfEntity wolfEntity = (WolfEntity) entity;
            wolfEntity.tame(playerEntity);
            wolfEntity.setCollarColor(DyeColor.byId(world.random.nextInt(15)));
            wolfEntity.setPos(playerEntity.getX(), playerEntity.getY(), playerEntity.getZ());
            world.addFreshEntity(wolfEntity);
        }
        if(entity instanceof CatEntity){
            CatEntity catEntity = (CatEntity) entity;
            catEntity.tame(playerEntity);
            catEntity.setCatType(-1);
            catEntity.setCollarColor(DyeColor.byId(world.random.nextInt(15)));
            catEntity.setPos(playerEntity.getX(), playerEntity.getY(), playerEntity.getZ());
            world.addFreshEntity(catEntity);
        }
        if(entity instanceof ParrotEntity){
            ParrotEntity parrotEntity = (ParrotEntity) entity;
            parrotEntity.tame(playerEntity);
            parrotEntity.setVariant(world.random.nextInt(4));
            parrotEntity.setPos(playerEntity.getX(), playerEntity.getY(), playerEntity.getZ());
            world.addFreshEntity(parrotEntity);
        }
        if(entity instanceof HorseEntity){
            HorseEntity horseEntity = (HorseEntity) entity;
            horseEntity.tameWithName(playerEntity);
            horseEntity.setTamed(true);
            horseEntity.setPos(playerEntity.getX(), playerEntity.getY(), playerEntity.getZ());
            world.addFreshEntity(horseEntity);
        }
        if(entity instanceof PigEntity){
            PigEntity pigEntity = (PigEntity) entity;
            pigEntity.setPos(playerEntity.getX(), playerEntity.getY(), playerEntity.getZ());
            world.addFreshEntity(pigEntity);
        }
    }

    private void RewardDispenser(World world, PlayerEntity playerEntity, String selected) {
        switch (selected) {
            case "snow":
                ItemSpawner(playerEntity.blockPosition(), world, Items.SNOW_BLOCK, 12, 28);
                break;
            case "ice":
                ItemSpawner(playerEntity.blockPosition(), world, Items.ICE, 15, 18);
                break;
            case "packedice":
                ItemSpawner(playerEntity.blockPosition(), world, Items.PACKED_ICE, 9, 12);
                break;
            case "blueice":
                ItemSpawner(playerEntity.blockPosition(), world, Items.BLUE_ICE, 3, 6);
                break;
            case "doggo":
                WolfEntity wolfEntity = new WolfEntity(EntityType.WOLF, world);
                SpawnDispenser(world, playerEntity, wolfEntity);
                break;
            case "cats":
                CatEntity catEntity = new CatEntity(EntityType.CAT, world);
                SpawnDispenser(world, playerEntity, catEntity);
                break;
            case "birb":
                ParrotEntity parrotEntity = new ParrotEntity(EntityType.PARROT, world);
                SpawnDispenser(world, playerEntity, parrotEntity);
                break;
            case "friendsnowman":
                SnowGolemEntity snowGolemEntity = new SnowGolemEntity(EntityType.SNOW_GOLEM, world);
                SpawnDispenser(world, playerEntity, snowGolemEntity);
                break;
            case "music":
                ItemSpawner(playerEntity.blockPosition(), world, MusicDisc(), 1, 1);
                break;
            default:
                ItemSpawner(playerEntity.blockPosition(), world, Items.COAL, 6, 15);
                break;
            case "rollercoaster":
                ItemSpawner(playerEntity.blockPosition(), world, Items.MINECART, 1, 1);
                ItemSpawner(playerEntity.blockPosition(), world, Items.RAIL, 10, 24);
                ItemSpawner(playerEntity.blockPosition(), world, Items.POWERED_RAIL, 1, 4);
                ItemSpawner(playerEntity.blockPosition(), world, Items.DETECTOR_RAIL, 1, 4);
                break;
            case "horse":
                HorseEntity horseEntity = new HorseEntity(EntityType.HORSE, world);
                SpawnDispenser(world, playerEntity, horseEntity);
                ItemSpawner(playerEntity.blockPosition(), world, Items.SADDLE, 1, 1);
                break;
            case "pig":
                PigEntity pigEntity = new PigEntity(EntityType.PIG, world);
                SpawnDispenser(world, playerEntity, pigEntity);
                ItemSpawner(playerEntity.blockPosition(), world, Items.SADDLE, 1, 1);
                ItemSpawner(playerEntity.blockPosition(), world, Items.CARROT_ON_A_STICK, 1, 1);
                break;
            case "candycane":
                if(world.random.nextInt() % 2 == 0) ItemSpawner(playerEntity.blockPosition(), world, Register.REDCANDYCANEITEM.get(), 10, 20);
                else ItemSpawner(playerEntity.blockPosition(), world, Register.GREENCANDYCANEITEM.get(), 10, 20);
                break;
            case "icesword":
                ItemSpawner(playerEntity.blockPosition(), world, Register.ICESWORD.get(), 1, 1);
            case "frostcore":
                ItemSpawner(playerEntity.blockPosition(), world, Register.ICECORE.get(), 1, 1);
            case "transposer":
                ItemSpawner(playerEntity.blockPosition(), world, Register.LIGHTNINGTRANSPOSER.get(), 1, 1);
            case "transposerpiece":
                ItemSpawner(playerEntity.blockPosition(), world, Register.LIGHTNINGTRANSPOSERPIECE.get(), 1, 2);
            case "frostshard":
                ItemSpawner(playerEntity.blockPosition(), world, Register.ICESHARD.get(), 4, 10);

        }
        world.playSound(null, playerEntity.blockPosition(), SoundEvents.CHICKEN_EGG, SoundCategory.PLAYERS, 1f, 0.5f);
    }
    private Item MusicDisc(){
        ArrayList<Item> music = new ArrayList<Item>(Arrays.asList(Items.MUSIC_DISC_11, Items.MUSIC_DISC_13, Items.MUSIC_DISC_BLOCKS, Items.MUSIC_DISC_CAT, Items.MUSIC_DISC_CHIRP, Items.MUSIC_DISC_FAR, Items.MUSIC_DISC_MALL, Items.MUSIC_DISC_MELLOHI, Items.MUSIC_DISC_PIGSTEP, Items.MUSIC_DISC_STAL, Items.MUSIC_DISC_STRAD, Items.MUSIC_DISC_WAIT, Items.MUSIC_DISC_WARD));
        Random random = new Random();
        int select = random.nextInt(music.size());
        if(select == music.size()) select--;
        return music.get(select);
    }
}
