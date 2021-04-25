package com.cartoonishvillain.coldsnaphorde.Items.Projectiles;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Projectiles.LightningSnowEntity;
import com.cartoonishvillain.coldsnaphorde.Register;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class LightningSnowball extends Item {
    public LightningSnowball() {
        super(new Properties().tab(ColdSnapHorde.TAB));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        worldIn.playSound((PlayerEntity)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isClientSide) {
            LightningSnowEntity snowballentity = new LightningSnowEntity(Register.LIGHTNINGSNOWBALLPROJECTILE.get(), worldIn, playerIn);
            snowballentity.setItem(itemstack);
            snowballentity.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 1.5F, 1.0F);
            worldIn.addFreshEntity(snowballentity);
        }

        playerIn.awardStat(Stats.ITEM_USED.get(this));
        if (!playerIn.abilities.instabuild) {
            itemstack.shrink(1);
        }

        return ActionResult.sidedSuccess(itemstack, worldIn.isClientSide());
    }
}

