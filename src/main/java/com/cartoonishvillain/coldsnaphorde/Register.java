package com.cartoonishvillain.coldsnaphorde;

import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.HordeVariantManager.EndHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.HordeVariantManager.NetherHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.HordeVariantManager.PlagueHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Mobs.HordeVariantManager.StandardHorde;
import com.cartoonishvillain.coldsnaphorde.Entities.Projectiles.*;
import com.cartoonishvillain.coldsnaphorde.Items.*;
import com.cartoonishvillain.coldsnaphorde.Items.Armor.ArmorMaterials;
import com.cartoonishvillain.coldsnaphorde.Items.Armor.TopHat;
import com.cartoonishvillain.coldsnaphorde.Items.Projectiles.LightningSnowball;
import com.cartoonishvillain.coldsnaphorde.Items.Projectiles.RockySnowball;
import com.cartoonishvillain.coldsnaphorde.Items.Projectiles.SnowierSnowball;
import com.cartoonishvillain.coldsnaphorde.Items.ToolsOrOther.IceSword;
import com.cartoonishvillain.coldsnaphorde.Items.ToolsOrOther.Materials;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.item.Item;

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
    public static final RegistryObject<ArmorItem> TOPHAT = ITEMS.register("tophat", () -> new TopHat(ArmorMaterials.HAT, EquipmentSlotType.HEAD, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ICESHARD = ITEMS.register("iceshard", () -> new Item(new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ICECORE = ITEMS.register("icecore", () -> new Item(new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> LIGHTNINGTRANSPOSERPIECE = ITEMS.register("transposerpiece", () -> new Item(new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> LIGHTNINGTRANSPOSER = ITEMS.register("lightningtransposer", () -> new Item(new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> LIGHTNINGSNOWBALL = ITEMS.register("lightningsnowball", LightningSnowball::new);
    public static final RegistryObject<Item> THERMOMETER = ITEMS.register("thermometer", () -> new Item(new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> SNOWGLOBE = ITEMS.register("snowglobe", () -> new Snowglobe(new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PRESENT = ITEMS.register("present", () -> new Present(new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> GUNNERSPAWN = ITEMS.register("gunner_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPGUNNER, 14804727, 0, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> STABBERSPAWN = ITEMS.register("stabber_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPSTABBER, 14804727, 8585216, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> SNOWBALLERSPAWN = ITEMS.register("snowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPSNOWBALLER, 14804727, 25753, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> GIFTERSPAWN = ITEMS.register("gifter_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPGIFTER, 14804727, 26671, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ZAPPERSPAWN = ITEMS.register("zapper_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPZAPPER, 14804727, 9802549, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> BRAWLERPAWN = ITEMS.register("brawler_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPBRAWLER, 14804727, 6229378, new Item.Properties().group(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> NGUNNERSPAWN = ITEMS.register("ngunner_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPGUNNER, 4926000, 0, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NSTABBERSPAWN = ITEMS.register("nstabber_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPSTABBER, 4926000, 8585216, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NSNOWBALLERSPAWN = ITEMS.register("nsnowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPSNOWBALLER, 4926000, 25753, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NGIFTERSPAWN = ITEMS.register("ngifter_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPGIFTER, 4926000, 26671, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NZAPPERSPAWN = ITEMS.register("nzapper_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPZAPPER, 4926000, 9802549, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NBRAWLERPAWN = ITEMS.register("nbrawler_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPBRAWLER, 4926000, 6229378, new Item.Properties().group(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> EGUNNERSPAWN = ITEMS.register("egunner_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPGUNNER, 15332272, 0, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ESTABBERSPAWN = ITEMS.register("estabber_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPSTABBER, 15332272, 8585216, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ESNOWBALLERSPAWN = ITEMS.register("esnowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPSNOWBALLER, 15332272, 25753, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> EGIFTERSPAWN = ITEMS.register("egifter_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPGIFTER, 15332272, 26671, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> EZAPPERSPAWN = ITEMS.register("ezapper_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPZAPPER, 15332272, 9802549, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> EBRAWLERPAWN = ITEMS.register("ebrawler_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPBRAWLER, 15332272, 6229378, new Item.Properties().group(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> PGUNNERSPAWN = ITEMS.register("pgunner_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPGUNNER, 7444, 0, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PSTABBERSPAWN = ITEMS.register("pstabber_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPSTABBER, 7444, 8585216, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PSNOWBALLERSPAWN = ITEMS.register("psnowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPSNOWBALLER, 7444, 25753, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PGIFTERSPAWN = ITEMS.register("pgifter_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPGIFTER, 7444, 26671, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PZAPPERSPAWN = ITEMS.register("pzapper_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPZAPPER, 7444, 9802549, new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PBRAWLERPAWN = ITEMS.register("pbrawler_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPBRAWLER, 7444, 6229378, new Item.Properties().group(ColdSnapHorde.TAB)));


    public static final RegistryObject<EntityType<StandardHorde.StandardGifter>> COLDSNAPGIFTER = ENTITY_TYPES.register("coldsnapgifter", () -> EntityType.Builder.create(StandardHorde.StandardGifter::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapgifter").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardGunner>> COLDSNAPGUNNER = ENTITY_TYPES.register("coldsnapgunner", () -> EntityType.Builder.create(StandardHorde.StandardGunner::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapgunner").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardStabber>> COLDSNAPSTABBER = ENTITY_TYPES.register("coldsnapstabber", () -> EntityType.Builder.create(StandardHorde.StandardStabber::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapstabber").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardSnowballer>> COLDSNAPSNOWBALLER = ENTITY_TYPES.register("coldsnapsnowballer", () -> EntityType.Builder.create(StandardHorde.StandardSnowballer::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardZapper>> COLDSNAPZAPPER = ENTITY_TYPES.register("coldsnapzapper", () -> EntityType.Builder.create(StandardHorde.StandardZapper::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapzapper").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardBrawler>> COLDSNAPBRAWLER = ENTITY_TYPES.register("coldsnapbrawler", () -> EntityType.Builder.create(StandardHorde.StandardBrawler::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<NetherHorde.NetherGifter>> NCOLDSNAPGIFTER = ENTITY_TYPES.register("ncoldsnapgifter", () -> EntityType.Builder.create(NetherHorde.NetherGifter::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherGunner>> NCOLDSNAPGUNNER = ENTITY_TYPES.register("ncoldsnapgunner", () -> EntityType.Builder.create(NetherHorde.NetherGunner::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherStabber>> NCOLDSNAPSTABBER = ENTITY_TYPES.register("ncoldsnapstabber", () -> EntityType.Builder.create(NetherHorde.NetherStabber::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherSnowballer>> NCOLDSNAPSNOWBALLER = ENTITY_TYPES.register("ncoldsnapsnowballer", () -> EntityType.Builder.create(NetherHorde.NetherSnowballer::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherZapper>> NCOLDSNAPZAPPER = ENTITY_TYPES.register("ncoldsnapzapper", () -> EntityType.Builder.create(NetherHorde.NetherZapper::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherBrawler>> NCOLDSNAPBRAWLER = ENTITY_TYPES.register("ncoldsnapbrawler", () -> EntityType.Builder.create(NetherHorde.NetherBrawler::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<EndHorde.EndGifter>> ECOLDSNAPGIFTER = ENTITY_TYPES.register("ecoldsnapgifter", () -> EntityType.Builder.create(EndHorde.EndGifter::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndGunner>> ECOLDSNAPGUNNER = ENTITY_TYPES.register("ecoldsnapgunner", () -> EntityType.Builder.create(EndHorde.EndGunner::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndStabber>> ECOLDSNAPSTABBER = ENTITY_TYPES.register("ecoldsnapstabber", () -> EntityType.Builder.create(EndHorde.EndStabber::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndSnowballer>> ECOLDSNAPSNOWBALLER = ENTITY_TYPES.register("ecoldsnapsnowballer", () -> EntityType.Builder.create(EndHorde.EndSnowballer::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndZapper>> ECOLDSNAPZAPPER = ENTITY_TYPES.register("ecoldsnapzapper", () -> EntityType.Builder.create(EndHorde.EndZapper::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndBrawler>> ECOLDSNAPBRAWLER = ENTITY_TYPES.register("ecoldsnapbrawler", () -> EntityType.Builder.create(EndHorde.EndBrawler::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<PlagueHorde.PlagueGifter>> PCOLDSNAPGIFTER = ENTITY_TYPES.register("pcoldsnapgifter", () -> EntityType.Builder.create(PlagueHorde.PlagueGifter::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueGunner>> PCOLDSNAPGUNNER = ENTITY_TYPES.register("pcoldsnapgunner", () -> EntityType.Builder.create(PlagueHorde.PlagueGunner::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueStabber>> PCOLDSNAPSTABBER = ENTITY_TYPES.register("pcoldsnapstabber", () -> EntityType.Builder.create(PlagueHorde.PlagueStabber::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueSnowballer>> PCOLDSNAPSNOWBALLER = ENTITY_TYPES.register("pcoldsnapsnowballer", () -> EntityType.Builder.create(PlagueHorde.PlagueSnowballer::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueZapper>> PCOLDSNAPZAPPER = ENTITY_TYPES.register("pcoldsnapzapper", () -> EntityType.Builder.create(PlagueHorde.PlagueZapper::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueBrawler>> PCOLDSNAPBRAWLER = ENTITY_TYPES.register("pcoldsnapbrawler", () -> EntityType.Builder.create(PlagueHorde.PlagueBrawler::new, EntityClassification.MONSTER).size(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<GunnerProjectileEntity>> GUNNERPROJECTILE = ENTITY_TYPES.register("gunnerprojectile", () -> EntityType.Builder.<GunnerProjectileEntity>create(GunnerProjectileEntity::new, EntityClassification.MISC).size(0.25f, 0.25f).trackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "gunnerprojectile").toString()));
    public static final RegistryObject<EntityType<RockSnowballEntity>> ROCKSNOWBALLPROJECTILE = ENTITY_TYPES.register("rocksnowballprojectile", () -> EntityType.Builder.<RockSnowballEntity>create(RockSnowballEntity::new, EntityClassification.MISC).size(0.25f, 0.25f).trackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "rocksnowballprojectile").toString()));
    public static final RegistryObject<EntityType<ThrownChorusEntity>> THROWNCHORUSPROJECTILE = ENTITY_TYPES.register("thrownchorusprojectile", () -> EntityType.Builder.<ThrownChorusEntity>create(ThrownChorusEntity::new, EntityClassification.MISC).size(0.25f, 0.25f).trackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "thrownchorusprojectile").toString()));
    public static final RegistryObject<EntityType<SnowierSnowballEntity>> SNOWIERSNOWBALLPROJECTILE = ENTITY_TYPES.register("snowiersnowballprojectile", () -> EntityType.Builder.<SnowierSnowballEntity>create(SnowierSnowballEntity::new, EntityClassification.MISC).size(0.25f, 0.25f).trackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "snowiersnowballprojectile").toString()));
    public static final RegistryObject<EntityType<LightningSnowEntity>> LIGHTNINGSNOWBALLPROJECTILE = ENTITY_TYPES.register("lightningsnowprojectile", () -> EntityType.Builder.<LightningSnowEntity>create(LightningSnowEntity::new, EntityClassification.MISC).size(0.25f, 0.25f).trackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "lightningsnowprojectile").toString()));

    public static final RegistryObject<SoundEvent> GIFTERATTACK = SOUND_EVENT.register("gifter_attack", () -> new SoundEvent(new ResourceLocation(ColdSnapHorde.MOD_ID, "gifter_attack")));

    public static final RegistryObject<Block> REDCANDYCANE = BLOCKS.register("redcandycane", () -> new Block(AbstractBlock.Properties.create(Material.BAMBOO).hardnessAndResistance(2).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.BONE)));
    public static final RegistryObject<Block> GREENCANDYCANE = BLOCKS.register("greencandycane", () -> new Block(AbstractBlock.Properties.create(Material.BAMBOO).hardnessAndResistance(2).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.BONE)));
    public static final RegistryObject<Block> SLUSH = BLOCKS.register("slush", () -> new SlushBlock(AbstractBlock.Properties.create(Material.SNOW).hardnessAndResistance(0).sound(SoundType.SNOW)));

    public static final RegistryObject<BlockItem> REDCANDYCANEITEM = ITEMS.register("redcandycane", ()-> new BlockItem(REDCANDYCANE.get(), new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<BlockItem> GREENCANDYCANEITEM = ITEMS.register("greencandycane", ()-> new BlockItem(GREENCANDYCANE.get(), new Item.Properties().group(ColdSnapHorde.TAB)));
    public static final RegistryObject<BlockItem> SLUSHITEM = ITEMS.register("slush", ()-> new BlockItem(SLUSH.get(), new Item.Properties().group(ColdSnapHorde.TAB)));


    public static final RegistryObject<Item> ICESWORD = ITEMS.register("ice_sword", ()->new IceSword(Materials.ICE, 0, -2.4f, new Item.Properties().group(ColdSnapHorde.TAB).rarity(Rarity.UNCOMMON)));

    public static Item gunner_egg;

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, name);
    }

}
