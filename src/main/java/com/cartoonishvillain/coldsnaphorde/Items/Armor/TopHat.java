package com.cartoonishvillain.coldsnaphorde.Items.Armor;

import com.cartoonishvillain.coldsnaphorde.ColdSnapHorde;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;

import net.minecraft.item.Item.Properties;

public class TopHat extends ArmorItem {

    public TopHat(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder.tab(ColdSnapHorde.TAB));
    }

}
