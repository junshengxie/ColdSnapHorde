package com.cartoonishvillain.coldsnaphorde.Items;

import com.cartoonishvillain.coldsnaphorde.Capabilities.CooldownCapability;
import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Events.Horde;
import com.sun.jna.platform.unix.X11;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import net.minecraft.item.Item.Properties;

public class Snowglobe extends Item {
    public Snowglobe(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(handIn == Hand.MAIN_HAND && !worldIn.isRemote() && playerIn != null) {
            if (worldIn.isAreaLoaded(playerIn.getPosition(), 20) && (biomeCheck(worldIn, playerIn.getPosition()) || worldIn.getBiome(playerIn.getPosition()).getRegistryName().toString().contains("swamp") || worldIn.getDimensionKey().toString().contains("end"))) {
                AtomicInteger atomicInteger = new AtomicInteger(0);
                worldIn.getCapability(CooldownCapability.INSTANCE).ifPresent(h->{
                    if(h.getCooldownTicks() > 0){
                        atomicInteger.set(h.getCooldownTicks());
                    }
                });

                if(!(atomicInteger.get() > 0)) {
                    Horde horde = new Horde((ServerWorld) worldIn, playerIn.getPosition(), (ServerPlayerEntity) playerIn);
                    worldIn.getCapability(CooldownCapability.INSTANCE).ifPresent(h->{h.setCooldownTicks(ColdSnapHorde.sconfig.GLOBALHORDECOOLDOWN.get() * 20);});
                    playerIn.getHeldItemMainhand().shrink(1);
                }else{
                    playerIn.sendStatusMessage(new StringTextComponent("Horde on cooldown! Returning in: " + TimeBuilder(atomicInteger.get())), false);
                }
            }else{
                playerIn.sendStatusMessage(new StringTextComponent("Temperature too hot for the horde to summon!"), false);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    private boolean biomeCheck(World world, BlockPos pos){
        int protlvl = ColdSnapHorde.cconfig.HEATPROT.get();
        float temp = world.getBiome(pos).getTemperature();
        int code = -1;
        if (temp < 0.3){code = 0;}
        else if(temp >= 0.3 && temp < 0.9){code = 1;}
        else if(temp >= 0.9 && temp < 1.5){code = 2;}
        else if(temp >= 1.5){code = 3;}

        return code <= protlvl;
    }

    private String TimeBuilder(int duration){
        String timer = "(";
        int timermath = duration/20;
        if (timermath >= 60){
            timer += Integer.toString(timermath/60);
            while(timermath >= 60){timermath -= 60;}
            timer += ":";
        }else{
            timer += "00:";
        }
        if (timermath > 9){
            timer += Integer.toString(timermath);
            timer += ")";
        } else{
            timer += "0";
            timer += Integer.toString(timermath);
            timer += ")";
        }
        return timer;
    }
}
