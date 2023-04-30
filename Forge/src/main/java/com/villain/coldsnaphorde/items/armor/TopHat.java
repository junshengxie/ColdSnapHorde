package com.villain.coldsnaphorde.items.armor;

import com.villain.coldsnaphorde.platform.Services;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TopHat extends ArmorItem  {
    public TopHat(ArmorMaterials materialIn, ArmorItem.Type slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        p_41423_.add(Component.translatable("itemtooltip.tophat.1").withStyle(ChatFormatting.AQUA));
        p_41423_.add(Component.translatable("itemtooltip.tophat.2").withStyle(ChatFormatting.RED));
    }
}