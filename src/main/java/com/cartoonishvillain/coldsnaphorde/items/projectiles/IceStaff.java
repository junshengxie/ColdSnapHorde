package com.cartoonishvillain.coldsnaphorde.items.projectiles;

import com.cartoonishvillain.coldsnaphorde.Register;
import com.cartoonishvillain.coldsnaphorde.entities.projectiles.IceProjectile;
import com.cartoonishvillain.coldsnaphorde.items.Tier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class IceStaff extends Item {
    Tier tier;

    public IceStaff(Properties p_41383_, Tier tier) {
        super(p_41383_);
        this.tier = tier;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && hand.equals(InteractionHand.MAIN_HAND)) {
            ItemStack itemStack = player.getItemInHand(hand);
            itemStack.hurtAndBreak(1, player, (p_32290_) -> p_32290_.broadcastBreakEvent(hand));
            player.playSound(SoundEvents.FIRECHARGE_USE, 1, 1);

            if(tier.equals(Tier.THREE)) {
                Tier sendTier;
                if(level.random.nextInt(5) == 1) {
                    sendTier = Tier.THREE;
                } else {
                    sendTier = Tier.TWO;
                }

                IceProjectile iceEntity = new IceProjectile(Register.ICEPROJECTILE.get(), level, player, sendTier);
                iceEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(iceEntity);
            } else {
                IceProjectile iceEntity = new IceProjectile(Register.ICEPROJECTILE.get(), level, player, Tier.ONE);
                iceEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(iceEntity);
            }

            player.getCooldowns().addCooldown(this, 50);
        }


        return super.use(level, player, hand);
    }
}
