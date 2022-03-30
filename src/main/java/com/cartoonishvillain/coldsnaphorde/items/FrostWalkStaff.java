package com.cartoonishvillain.coldsnaphorde.items;

import com.cartoonishvillain.coldsnaphorde.FrostEffect;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;

public class FrostWalkStaff extends TieredItem {
    Tier tier;

    public FrostWalkStaff(net.minecraft.world.item.Tier itemTier, Properties p_41383_, Tier tier) {
        super(itemTier, p_41383_);
        this.tier = tier;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && hand.equals(InteractionHand.MAIN_HAND)) {
            if (tier.equals(Tier.THREE)) {
                player.addEffect(new MobEffectInstance(FrostEffect.froststep, 15*20, 1));
            } else {
                player.addEffect(new MobEffectInstance(FrostEffect.froststep, 15*20, 0));
            }

            ItemStack itemStack = player.getItemInHand(hand);

            itemStack.hurtAndBreak(1, player, (p_32290_) -> p_32290_.broadcastBreakEvent(hand));
            player.playSound(SoundEvents.FIRECHARGE_USE, 1, 1);

            player.getCooldowns().addCooldown(this, 50);
        }
        return super.use(level, player, hand);
    }
}
