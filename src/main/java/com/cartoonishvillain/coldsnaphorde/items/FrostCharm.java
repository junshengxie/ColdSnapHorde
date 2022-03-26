package com.cartoonishvillain.coldsnaphorde.items;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class FrostCharm extends Item implements ICurioItem {
    Tier tier;
    public FrostCharm(Properties p_41383_, Tier tier) {
        super(p_41383_);
        this.tier = tier;
    }

    public Tier getTier() {
        return tier;
    }


}
