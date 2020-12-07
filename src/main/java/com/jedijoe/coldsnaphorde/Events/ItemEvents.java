package com.jedijoe.coldsnaphorde.Events;

import com.jedijoe.coldsnaphorde.ColdSnapHorde;
import com.jedijoe.coldsnaphorde.Register;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemEvents {
    @SubscribeEvent
    public static void CheckThermometer(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().getItem().equals(Register.THERMOMETER.get())){
            PlayerEntity player = event.getPlayer();
            if(ColdSnapHorde.sconfig.TECHNICALTHERMOMETER.get()){
                player.sendStatusMessage(new StringTextComponent("Temperature: " + Float.toString(player.world.getBiomeManager().getBiome(player.getPosition()).getTemperature(player.getPosition()))), true);
            }
            else{
                float temp = player.world.getBiomeManager().getBiome(player.getPosition()).getTemperature(player.getPosition());
                String code = "MISSING";
                if (temp < 0.3){code = "Cold";}
                else if(temp >= 0.3 && temp < 0.9){code = "Neutral";}
                else if(temp >= 0.9 && temp < 1.5){code = "Warm";}
                else if(temp >= 1.5){code = "Hot";}
                player.sendStatusMessage(new StringTextComponent("Temperature: " + code), true);

            }

        }
    }
}
