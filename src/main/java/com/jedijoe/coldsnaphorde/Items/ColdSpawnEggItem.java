package com.jedijoe.coldsnaphorde.Items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.spongepowered.asm.mixin.Final;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ColdSpawnEggItem extends SpawnEggItem {

    protected static final List<ColdSpawnEggItem> UNADDED = new ArrayList<ColdSpawnEggItem>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;

    public ColdSpawnEggItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColorIn, final int secondaryColorIn, final Item.Properties properties) {
        super(null, primaryColorIn, secondaryColorIn, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED.add(this);    }

    public ColdSpawnEggItem(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int PrimaryColor, final int SecondaryColor, final Item.Properties properties){
        super(null, PrimaryColor, SecondaryColor, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED.add(this);
    }

    public static void initSpawnEggs(){
        final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
        DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior(){
            @Override
            protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().get(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };

        for (final SpawnEggItem spawnEgg : UNADDED){
            EGGS.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerDispenseBehavior(spawnEgg, defaultDispenseItemBehavior);
        }
        EGGS.clear();
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT nbt) {
        return this.entityTypeSupplier.get();
    }
}
