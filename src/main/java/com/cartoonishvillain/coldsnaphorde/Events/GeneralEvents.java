package com.cartoonishvillain.coldsnaphorde.Events;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.ColdSnapGifter;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.cartoonishvillain.coldsnaphorde.Entities.Mobs.GenericHordeMember.variant;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GeneralEvents {
    @SubscribeEvent
    public static void CheckThermometer(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().getItem().equals(Register.THERMOMETER.get())){
            PlayerEntity player = event.getPlayer();
            float temp = player.world.getBiomeManager().getBiome(player.getPosition()).getTemperature(player.getPosition());
            String code = "MISSING";
            if (temp < 0.3){code = "Cold";}
            else if(temp >= 0.3 && temp < 0.9){code = "Neutral";}
            else if(temp >= 0.9 && temp < 1.5){code = "Warm";}
            else if(temp >= 1.5){code = "Hot";}
            if(ColdSnapHorde.sconfig.TECHNICALTHERMOMETER.get()){
                player.sendStatusMessage(new StringTextComponent("Temperature: " + Float.toString(temp) + " (" + code + ")"), true);
            }
            else{
                player.sendStatusMessage(new StringTextComponent("Temperature: " + code), true);
            }
        }
    }

    @SubscribeEvent
    public static void Transposer(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().getItem().equals(Register.LIGHTNINGTRANSPOSER.get()) && event.getPlayer().isCrouching() && !event.getPlayer().world.isRemote()){
            PlayerEntity player = event.getPlayer();
            ItemStack itemStack = event.getItemStack();
            itemStack.shrink(1);
            EntityType.LIGHTNING_BOLT.spawn((ServerWorld) player.getEntityWorld(), new ItemStack(Items.AIR), null, event.getPos(), SpawnReason.TRIGGERED, true, false);}
    }

    @SubscribeEvent
    public static void AttackSounds(LivingAttackEvent event){
        if (event.getSource().getTrueSource() instanceof LivingEntity){
            LivingEntity entity = (LivingEntity) event.getSource().getTrueSource();
            if(entity instanceof ColdSnapGifter){
                entity.playSound(Register.GIFTERATTACK.get(), 1F, 1F);
            }
        }
    }

    @SubscribeEvent
    public static void HordeHitByFire(LivingHurtEvent event){
        if(event.getEntityLiving() instanceof GenericHordeMember){
            if(event.getSource() == DamageSource.ON_FIRE || event.getSource() == DamageSource.IN_FIRE || event.getSource() == DamageSource.LAVA){
                if(ColdSnapHorde.sconfig.HORDETAKESMOREFIRE.get()){
                    event.setAmount(event.getAmount() * 2);
                }
            }
        }
    }


    @SubscribeEvent
    public static void HordeSpawn(EntityJoinWorldEvent event){
        if(event.getEntity() instanceof GenericHordeMember && !event.getWorld().isRemote()){
            if(event.getEntity().getDataManager().get(variant) == -1){
                ((GenericHordeMember) event.getEntity()).determineHordeVariant();}
        }
    }
}
