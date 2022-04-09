package com.cartoonishvillain.coldsnaphorde.events;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.FrostEffect;
import com.cartoonishvillain.coldsnaphorde.Register;
import com.cartoonishvillain.coldsnaphorde.commands.GetHordeDefeatedLevel;
import com.cartoonishvillain.coldsnaphorde.commands.SetHordeDefeatedLevel;
import com.cartoonishvillain.coldsnaphorde.commands.StartHorde;
import com.cartoonishvillain.coldsnaphorde.commands.StopHorde;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.basemob.ColdSnapGifter;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.basemob.SnowCreature;
import com.cartoonishvillain.coldsnaphorde.items.toolsorother.FrostCharm;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.FrostWalkerEnchantment;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandlerModifiable;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = ColdSnapHorde.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GeneralEvents {

    @SubscribeEvent
    public static void commands(RegisterCommandsEvent event){
        GetHordeDefeatedLevel.register(event.getDispatcher());
        SetHordeDefeatedLevel.register(event.getDispatcher());
        StartHorde.register(event.getDispatcher());
        StopHorde.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void CheckThermometer(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().getItem().equals(Register.THERMOMETER.get())){
            Player player = event.getPlayer();
            float temp = player.level.getBiomeManager().getBiome(player.blockPosition()).value().getBaseTemperature();
            String code = "MISSING";
            if (temp < 0.3){code = "Cold";}
            else if(temp >= 0.3 && temp < 0.9){code = "Neutral";}
            else if(temp >= 0.9 && temp < 1.5){code = "Warm";}
            else if(temp >= 1.5){code = "Hot";}
            if(ColdSnapHorde.sconfig.TECHNICALTHERMOMETER.get()){
                player.displayClientMessage(new TextComponent("Temperature: " + Float.toString(temp) + " (" + code + ")"), true);
            }
            else{
                player.displayClientMessage(new TextComponent("Temperature: " + code), true);
            }
        }
    }

    @SubscribeEvent
    public static void Transposer(PlayerInteractEvent.RightClickItem event){
        if(event.getItemStack().getItem().equals(Register.LIGHTNINGTRANSPOSER.get()) && event.getPlayer().isCrouching() && !event.getPlayer().level.isClientSide()){
            Player player = event.getPlayer();
            ItemStack itemStack = event.getItemStack();
            itemStack.shrink(1);
            EntityType.LIGHTNING_BOLT.spawn((ServerLevel) player.getCommandSenderWorld(), new ItemStack(Items.AIR), null, event.getPos(), MobSpawnType.TRIGGERED, true, false);}
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

    @SubscribeEvent
    public static void HordeHitByFire(LivingHurtEvent event){
        if(event.getEntityLiving() instanceof SnowCreature){
            if(event.getSource() == DamageSource.ON_FIRE || event.getSource() == DamageSource.IN_FIRE || event.getSource() == DamageSource.LAVA){
                if(ColdSnapHorde.sconfig.HORDETAKESMOREFIRE.get()){
                    event.setAmount(event.getAmount() * 2);
                }
            }
        }
    }

    @SubscribeEvent
    public static void playerHurtEvent(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof Player && !event.getEntityLiving().level.isClientSide && event.getSource().getEntity() instanceof LivingEntity attacker) {
            LazyOptional<IItemHandlerModifiable> optional = CuriosApi.getCuriosHelper().getEquippedCurios(event.getEntityLiving());
            if(!optional.isPresent()) return;

            optional.ifPresent(entry -> {
                int level = 0;
                for (int i = 0; i < entry.getSlots(); i++) {
                    if(entry.getStackInSlot(i).getItem() instanceof FrostCharm) {
                        if(((FrostCharm) entry.getStackInSlot(i).getItem()).getTier().ordinal() > level) {
                            level = ((FrostCharm) entry.getStackInSlot(i).getItem()).getTier().ordinal();
                        }
                    }
                }

                //Handled this way to calculate the highest level... For when another mod adds another charm slot, and the user decides to add both a frost and arctic wind charm, the arctic wind charm will overrule.
                switch (level) {
                    default -> {
                    }

                    case 1 -> {
                        int chance = event.getEntityLiving().level.random.nextInt(5);
                        if (chance == 1) {
                            attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0));
                        }
                    }
                    case 2 -> {
                        int chance = event.getEntityLiving().level.random.nextInt(3);
                        if (chance == 1) {
                            attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 1));
                        }
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public static void playerAttackEvent(AttackEntityEvent event) {
        if (!event.getEntityLiving().level.isClientSide && event.getTarget() instanceof LivingEntity target) {
            float value = event.getPlayer().getAttackStrengthScale(1);
            if(event.getPlayer().getRandom().nextBoolean() && value == 1) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 0));
            }
        }
    }

    @SubscribeEvent
    public static void Login(final PlayerEvent.PlayerLoggedInEvent event){
        if(ColdSnapHorde.isInHolidayWindow){
            event.getPlayer().sendMessage(new TranslatableComponent("info.coldsnaphorde.holiday").withStyle(ChatFormatting.AQUA), UUID.randomUUID());
        }
    }

    @SubscribeEvent
    public static void Death(LivingDeathEvent event){
        if(event.getEntityLiving().getType() != EntityType.PLAYER && !event.getEntityLiving().level.isClientSide() && ColdSnapHorde.isInHolidayWindow){
            int random = event.getEntityLiving().level.random.nextInt(15);
            if(random == 1) {
                switch (ColdSnapHorde.hordeDataManager.getHighestLevelBeaten()) {
                    default -> {
                        ItemEntity itemEntity = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), new ItemStack(Register.SMALLPRESENT.get(), 1));
                        event.getEntityLiving().level.addFreshEntity(itemEntity);
                    }
                    case 2 -> {
                        ItemEntity itemEntity = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), new ItemStack(Register.PRESENT.get(), 1));
                        event.getEntityLiving().level.addFreshEntity(itemEntity);
                    }
                    case 3 -> {
                        ItemEntity itemEntity = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), new ItemStack(Register.LARGEPRESENT.get(), 1));
                        event.getEntityLiving().level.addFreshEntity(itemEntity);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void frostEffect (TickEvent.PlayerTickEvent event) {
        if (event.phase.equals(TickEvent.Phase.END) && event.player.tickCount % 2 == 0 && !event.player.level.isClientSide && event.player.hasEffect(FrostEffect.froststep)) {
            FrostWalkerEnchantment.onEntityMoved(event.player, event.player.getLevel(), event.player.blockPosition(), event.player.getEffect(FrostEffect.froststep).getAmplifier()+1);
        }
    }
}
