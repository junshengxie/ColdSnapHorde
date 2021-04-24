package com.cartoonishvillain.coldsnaphorde.Items;

import com.cartoonishvillain.coldsnaphorde.Events.Horde;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class hordedebugstick extends Item {
    public hordedebugstick(Properties properties) {
        super(properties);
    }

    @Override
    public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        super.onUse(worldIn, livingEntityIn, stack, count);
        if(!worldIn.isRemote()){
            //spawn horde
     }
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        if(context.getHand() == Hand.MAIN_HAND && !context.getWorld().isRemote() && context.getPlayer() != null){
            Random random = new Random();
            Horde horde = new Horde((ServerWorld) context.getWorld(), context.getPlayer().getPosition(), (ServerPlayerEntity) context.getPlayer());
        }
        return super.onItemUse(context);
    }
}
