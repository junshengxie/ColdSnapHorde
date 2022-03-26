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

public class FrostWallCharm extends Item implements ICurioItem {
    Tier tier;
    public FrostWallCharm(Properties p_41383_, Tier tier) {
        super(p_41383_);
        this.tier = tier;
    }

    public Tier getTier() {
        return tier;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
        switch (tier) {
            default -> {
                atts.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "knockback_res", 0.15, AttributeModifier.Operation.ADDITION));
            }
            case TWO -> {
                atts.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "knockback_res", 0.45, AttributeModifier.Operation.ADDITION));
            }
            case THREE -> {
                atts.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "knockback_res", 1, AttributeModifier.Operation.ADDITION));
            }
        }
        return atts;
    }


}