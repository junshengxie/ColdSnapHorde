package com.cartoonishvillain.coldsnaphorde.Events;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapGifter;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GeneralEvents {
    @SubscribeEvent
    public static void CheckThermometer(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().getItem().equals(Register.THERMOMETER.get())){
            PlayerEntity player = event.getPlayer();
            float temp = player.level.getBiomeManager().getBiome(player.blockPosition()).getTemperature(player.blockPosition());
            String code = "MISSING";
            if (temp < 0.3){code = "Cold";}
            else if(temp >= 0.3 && temp < 0.9){code = "Neutral";}
            else if(temp >= 0.9 && temp < 1.5){code = "Warm";}
            else if(temp >= 1.5){code = "Hot";}
            if(ColdSnapHorde.sconfig.TECHNICALTHERMOMETER.get()){
                player.displayClientMessage(new StringTextComponent("Temperature: " + Float.toString(temp) + " (" + code + ")"), true);
            }
            else{
                player.displayClientMessage(new StringTextComponent("Temperature: " + code), true);
            }
        }
    }

    @SubscribeEvent
    public static void Transposer(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().getItem().equals(Register.LIGHTNINGTRANSPOSER.get()) && event.getPlayer().isCrouching() && !event.getPlayer().level.isClientSide()){
            PlayerEntity player = event.getPlayer();
            ItemStack itemStack = event.getItemStack();
            itemStack.shrink(1);
            EntityType.LIGHTNING_BOLT.spawn((ServerWorld) player.getCommandSenderWorld(), new ItemStack(Items.AIR), null, event.getPos(), SpawnReason.TRIGGERED, true, false);}
    }

    @SubscribeEvent
    public static void AttackSounds(LivingAttackEvent event){
        if (event.getSource().getEntity() instanceof LivingEntity){
            LivingEntity entity = (LivingEntity) event.getSource().getEntity();
            if(entity instanceof ColdSnapGifter){
                entity.playSound(Register.GIFTERATTACK.get(), 1F, 1F);
            }
        }
    }
}
