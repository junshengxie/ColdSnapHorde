package com.cartoonishvillain.coldsnaphorde;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.*;
import com.cartoonishvillain.coldsnaphorde.Entities.Projectiles.GunnerProjectileEntity;
import com.cartoonishvillain.coldsnaphorde.Entities.Projectiles.LightningSnowEntity;
import com.cartoonishvillain.coldsnaphorde.Entities.Projectiles.RockSnowballEntity;
import com.cartoonishvillain.coldsnaphorde.Entities.Projectiles.SnowierSnowballEntity;
import com.cartoonishvillain.coldsnaphorde.Items.ColdSpawnEggItem;
import com.cartoonishvillain.coldsnaphorde.Items.Present;
import com.cartoonishvillain.coldsnaphorde.Items.Projectiles.LightningSnowball;
import com.cartoonishvillain.coldsnaphorde.Items.Projectiles.RockySnowball;
import com.cartoonishvillain.coldsnaphorde.Items.Projectiles.SnowierSnowball;
import com.cartoonishvillain.coldsnaphorde.Items.Snowglobe;
import com.cartoonishvillain.coldsnaphorde.Items.ToolsOrOther.IceSword;
import com.cartoonishvillain.coldsnaphorde.Items.ToolsOrOther.Materials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Register {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ColdSnapHorde.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ColdSnapHorde.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ColdSnapHorde.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ColdSnapHorde.MOD_ID);


    public static void init(){
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUND_EVENT.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Item> ROCKYSNOWBALL = ITEMS.register("rockysnowball", RockySnowball::new);
    public static final RegistryObject<Item> SNOWIERSNOWBALL = ITEMS.register("freezeball", SnowierSnowball::new);
//    public static final RegistryObject<ArmorItem> TOPHAT = ITEMS.register("tophat", () -> new TopHat(ArmorMaterials.HAT, EquipmentSlotType.HEAD, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ICESHARD = ITEMS.register("iceshard", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ICECORE = ITEMS.register("icecore", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> LIGHTNINGTRANSPOSERPIECE = ITEMS.register("transposerpiece", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> LIGHTNINGTRANSPOSER = ITEMS.register("lightningtransposer", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> LIGHTNINGSNOWBALL = ITEMS.register("lightningsnowball", LightningSnowball::new);
    public static final RegistryObject<Item> THERMOMETER = ITEMS.register("thermometer", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> SNOWGLOBE = ITEMS.register("snowglobe", () -> new Snowglobe(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PRESENT = ITEMS.register("present", () -> new Present(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> GUNNERSPAWN = ITEMS.register("gunner_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPGUNNER, 14804727, 0, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> STABBERSPAWN = ITEMS.register("stabber_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPSTABBER, 14804727, 2359296, new Item.Properties().tab(ColdSnapHorde.TAB)));
//    public static final RegistryObject<Item> SNOWBALLERSPAWN = ITEMS.register("snowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPSNOWBALLER, 14804727, 2084, new Item.Properties().tab(ColdSnapHorde.TAB)));
//    public static final RegistryObject<Item> GIFTERSPAWN = ITEMS.register("gifter_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPGIFTER, 14804727, 9222, new Item.Properties().tab(ColdSnapHorde.TAB)));
//    public static final RegistryObject<Item> ZAPPERSPAWN = ITEMS.register("zapper_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPZAPPER, 14804727, 7697692, new Item.Properties().tab(ColdSnapHorde.TAB)));
//    public static final RegistryObject<Item> BRAWLERPAWN = ITEMS.register("brawler_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPBRAWLER, 14804727, 6229378, new Item.Properties().tab(ColdSnapHorde.TAB)));



//    public static final RegistryObject<EntityType<ColdSnapGifter>> COLDSNAPGIFTER = ENTITY_TYPES.register("coldsnapgifter", () -> EntityType.Builder.of(ColdSnapGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapgifter").toString()));
    public static final RegistryObject<EntityType<ColdSnapGunner>> COLDSNAPGUNNER = ENTITY_TYPES.register("coldsnapgunner", () -> EntityType.Builder.of(ColdSnapGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapgunner").toString()));
    public static final RegistryObject<EntityType<ColdSnapStabber>> COLDSNAPSTABBER = ENTITY_TYPES.register("coldsnapstabber", () -> EntityType.Builder.of(ColdSnapStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapstabber").toString()));
//    public static final RegistryObject<EntityType<ColdSnapSnowballer>> COLDSNAPSNOWBALLER = ENTITY_TYPES.register("coldsnapsnowballer", () -> EntityType.Builder.of(ColdSnapSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapsnowballer").toString()));
//    public static final RegistryObject<EntityType<ColdSnapZapper>> COLDSNAPZAPPER = ENTITY_TYPES.register("coldsnapzapper", () -> EntityType.Builder.of(ColdSnapZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapzapper").toString()));
//    public static final RegistryObject<EntityType<ColdSnapBrawler>> COLDSNAPBRAWLER = ENTITY_TYPES.register("coldsnapbrawler", () -> EntityType.Builder.of(ColdSnapBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<GunnerProjectileEntity>> GUNNERPROJECTILE = ENTITY_TYPES.register("gunnerprojectile", () -> EntityType.Builder.<GunnerProjectileEntity>of(GunnerProjectileEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "gunnerprojectile").toString()));
    public static final RegistryObject<EntityType<RockSnowballEntity>> ROCKSNOWBALLPROJECTILE = ENTITY_TYPES.register("rocksnowballprojectile", () -> EntityType.Builder.<RockSnowballEntity>of(RockSnowballEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "rocksnowballprojectile").toString()));
    public static final RegistryObject<EntityType<SnowierSnowballEntity>> SNOWIERSNOWBALLPROJECTILE = ENTITY_TYPES.register("snowiersnowballprojectile", () -> EntityType.Builder.<SnowierSnowballEntity>of(SnowierSnowballEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "snowiersnowballprojectile").toString()));
    public static final RegistryObject<EntityType<LightningSnowEntity>> LIGHTNINGSNOWBALLPROJECTILE = ENTITY_TYPES.register("lightningsnowprojectile", () -> EntityType.Builder.<LightningSnowEntity>of(LightningSnowEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "lightningsnowprojectile").toString()));

    public static final RegistryObject<SoundEvent> GIFTERATTACK = SOUND_EVENT.register("gifter_attack", () -> new SoundEvent(new ResourceLocation(ColdSnapHorde.MOD_ID, "gifter_attack")));

    public static final RegistryObject<Block> REDCANDYCANE = BLOCKS.register("redcandycane", () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO).strength(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> GREENCANDYCANE = BLOCKS.register("greencandycane", () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO).strength(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<BlockItem> REDCANDYCANEITEM = ITEMS.register("redcandycane", ()-> new BlockItem(REDCANDYCANE.get(), new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<BlockItem> GREENCANDYCANEITEM = ITEMS.register("greencandycane", ()-> new BlockItem(GREENCANDYCANE.get(), new Item.Properties().tab(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> ICESWORD = ITEMS.register("ice_sword", ()->new IceSword(Materials.ICE, 0, -2.4f, new Item.Properties().tab(ColdSnapHorde.TAB).rarity(Rarity.UNCOMMON)));

    public static Item gunner_egg;

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, name);
    }

}
