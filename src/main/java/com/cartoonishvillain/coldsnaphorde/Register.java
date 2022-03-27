package com.cartoonishvillain.coldsnaphorde;

import com.cartoonishvillain.coldsnaphorde.entities.mobs.basemob.ColdSnapCow;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.hordevariantmanager.EndHorde;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.hordevariantmanager.NetherHorde;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.hordevariantmanager.PlagueHorde;
import com.cartoonishvillain.coldsnaphorde.entities.mobs.hordevariantmanager.StandardHorde;
import com.cartoonishvillain.coldsnaphorde.entities.projectiles.*;
import com.cartoonishvillain.coldsnaphorde.items.*;
import com.cartoonishvillain.coldsnaphorde.items.Tier;
import com.cartoonishvillain.coldsnaphorde.items.armor.ArmorMaterials;
import com.cartoonishvillain.coldsnaphorde.items.armor.TopHat;
import com.cartoonishvillain.coldsnaphorde.items.projectiles.LightningSnowball;
import com.cartoonishvillain.coldsnaphorde.items.projectiles.RockySnowball;
import com.cartoonishvillain.coldsnaphorde.items.projectiles.SnowierSnowball;
import com.cartoonishvillain.coldsnaphorde.items.toolsorother.IceSword;
import com.cartoonishvillain.coldsnaphorde.items.toolsorother.Materials;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    public static final RegistryObject<ArmorItem> TOPHAT = ITEMS.register("tophat", () -> new TopHat(ArmorMaterials.HAT, EquipmentSlot.HEAD, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<ArmorItem> REDTOPHAT = ITEMS.register("redtophat", () -> new TopHat(ArmorMaterials.HAT, EquipmentSlot.HEAD, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<ArmorItem> BLUETOPHAT = ITEMS.register("bluetophat", () -> new TopHat(ArmorMaterials.HAT, EquipmentSlot.HEAD, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<ArmorItem> GREENTOPHAT = ITEMS.register("greentophat", () -> new TopHat(ArmorMaterials.HAT, EquipmentSlot.HEAD, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<ArmorItem> PURPLETOPHAT = ITEMS.register("purpletophat", () -> new TopHat(ArmorMaterials.HAT, EquipmentSlot.HEAD, new Item.Properties().tab(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> THERMOMETER = ITEMS.register("thermometer", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ICESHARD = ITEMS.register("iceshard", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> SNOWWALLCHARM = ITEMS.register("snow_wall_charm", () -> new FrostWallCharm(new Item.Properties().tab(ColdSnapHorde.TAB).stacksTo(1), Tier.ONE));
    public static final RegistryObject<Item> SNOWGLOBE = ITEMS.register("snowglobe", () -> new Snowglobe(new Item.Properties().tab(ColdSnapHorde.TAB), Tier.ONE));
    public static final RegistryObject<Item> SMALLPRESENT = ITEMS.register("small_present", () -> new Present(new Item.Properties().tab(ColdSnapHorde.TAB), Tier.ONE));

    public static final RegistryObject<Item> GLACIERWALLCHARM = ITEMS.register("glacier_wall_charm", () -> new FrostWallCharm(new Item.Properties().tab(ColdSnapHorde.TAB).stacksTo(1), Tier.TWO));
    public static final RegistryObject<Item> FROSTCHARM = ITEMS.register("frost_charm", () -> new FrostCharm(new Item.Properties().tab(ColdSnapHorde.TAB).stacksTo(1), Tier.TWO));
    public static final RegistryObject<Item> FROSTCORE = ITEMS.register("frostcore", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> REINFOCEDGLACIERCHARM = ITEMS.register("reinforced_glacier_wall_charm", () -> new FrostWallCharm(new Item.Properties().tab(ColdSnapHorde.TAB).stacksTo(1), Tier.THREE));
    public static final RegistryObject<Item> ARCTICCHARM = ITEMS.register("arctic_wind_charm", () -> new FrostCharm(new Item.Properties().tab(ColdSnapHorde.TAB).stacksTo(1), Tier.THREE));

    public static final RegistryObject<Item> NOVEMBERSNOWDISC = ITEMS.register("november_snow", () -> new RecordItem(6, Register.NOVEMBERSNOW, new Item.Properties().tab(ColdSnapHorde.TAB).stacksTo(1)));
    public static final RegistryObject<Item> ARCTICBEATDISC = ITEMS.register("arctic_beat", () -> new RecordItem(7, Register.ARCTICBEAT, new Item.Properties().tab(ColdSnapHorde.TAB).stacksTo(1)));

    public static final RegistryObject<Item> LIGHTNINGTRANSPOSERPIECE = ITEMS.register("transposerpiece", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> LIGHTNINGTRANSPOSER = ITEMS.register("lightningtransposer", () -> new Item(new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> LIGHTNINGSNOWBALL = ITEMS.register("lightningsnowball", LightningSnowball::new);
    public static final RegistryObject<Item> PRESENT = ITEMS.register("present", () -> new Present(new Item.Properties().tab(ColdSnapHorde.TAB), Tier.TWO));

    public static final RegistryObject<Item> GUNNERSPAWN = ITEMS.register("gunner_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPGUNNER, 14804727, 0, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> STABBERSPAWN = ITEMS.register("stabber_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPSTABBER, 14804727, 8585216, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> SNOWBALLERSPAWN = ITEMS.register("snowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPSNOWBALLER, 14804727, 25753, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> GIFTERSPAWN = ITEMS.register("gifter_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPGIFTER, 14804727, 26671, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ZAPPERSPAWN = ITEMS.register("zapper_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPZAPPER, 14804727, 9802549, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> BRAWLERPAWN = ITEMS.register("brawler_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPBRAWLER, 14804727, 6229378, new Item.Properties().tab(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> NGUNNERSPAWN = ITEMS.register("ngunner_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPGUNNER, 4926000, 0, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NSTABBERSPAWN = ITEMS.register("nstabber_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPSTABBER, 4926000, 8585216, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NSNOWBALLERSPAWN = ITEMS.register("nsnowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPSNOWBALLER, 4926000, 25753, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NGIFTERSPAWN = ITEMS.register("ngifter_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPGIFTER, 4926000, 26671, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NZAPPERSPAWN = ITEMS.register("nzapper_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPZAPPER, 4926000, 9802549, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> NBRAWLERPAWN = ITEMS.register("nbrawler_spawn_egg", () -> new ColdSpawnEggItem(Register.NCOLDSNAPBRAWLER, 4926000, 6229378, new Item.Properties().tab(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> EGUNNERSPAWN = ITEMS.register("egunner_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPGUNNER, 15332272, 0, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ESTABBERSPAWN = ITEMS.register("estabber_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPSTABBER, 15332272, 8585216, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> ESNOWBALLERSPAWN = ITEMS.register("esnowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPSNOWBALLER, 15332272, 25753, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> EGIFTERSPAWN = ITEMS.register("egifter_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPGIFTER, 15332272, 26671, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> EZAPPERSPAWN = ITEMS.register("ezapper_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPZAPPER, 15332272, 9802549, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> EBRAWLERPAWN = ITEMS.register("ebrawler_spawn_egg", () -> new ColdSpawnEggItem(Register.ECOLDSNAPBRAWLER, 15332272, 6229378, new Item.Properties().tab(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> PGUNNERSPAWN = ITEMS.register("pgunner_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPGUNNER, 7444, 0, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PSTABBERSPAWN = ITEMS.register("pstabber_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPSTABBER, 7444, 8585216, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PSNOWBALLERSPAWN = ITEMS.register("psnowballer_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPSNOWBALLER, 7444, 25753, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PGIFTERSPAWN = ITEMS.register("pgifter_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPGIFTER, 7444, 26671, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PZAPPERSPAWN = ITEMS.register("pzapper_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPZAPPER, 7444, 9802549, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> PBRAWLERPAWN = ITEMS.register("pbrawler_spawn_egg", () -> new ColdSpawnEggItem(Register.PCOLDSNAPBRAWLER, 7444, 6229378, new Item.Properties().tab(ColdSnapHorde.TAB)));
    public static final RegistryObject<Item> COWSPAWN = ITEMS.register("frostcow_spawn_egg", () -> new ColdSpawnEggItem(Register.COLDSNAPCOW, 14804727, 1840384, new Item.Properties().tab(ColdSnapHorde.TAB)));

    public static final RegistryObject<EntityType<ColdSnapCow>> COLDSNAPCOW = ENTITY_TYPES.register("frostycow", () -> EntityType.Builder.of(ColdSnapCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "frostycow").toString()));

    public static final RegistryObject<EntityType<StandardHorde.StandardGifter>> COLDSNAPGIFTER = ENTITY_TYPES.register("coldsnapgifter", () -> EntityType.Builder.of(StandardHorde.StandardGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapgifter").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardGunner>> COLDSNAPGUNNER = ENTITY_TYPES.register("coldsnapgunner", () -> EntityType.Builder.of(StandardHorde.StandardGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapgunner").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardStabber>> COLDSNAPSTABBER = ENTITY_TYPES.register("coldsnapstabber", () -> EntityType.Builder.of(StandardHorde.StandardStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapstabber").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardSnowballer>> COLDSNAPSNOWBALLER = ENTITY_TYPES.register("coldsnapsnowballer", () -> EntityType.Builder.of(StandardHorde.StandardSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardZapper>> COLDSNAPZAPPER = ENTITY_TYPES.register("coldsnapzapper", () -> EntityType.Builder.of(StandardHorde.StandardZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapzapper").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardBrawler>> COLDSNAPBRAWLER = ENTITY_TYPES.register("coldsnapbrawler", () -> EntityType.Builder.of(StandardHorde.StandardBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "coldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<NetherHorde.NetherGifter>> NCOLDSNAPGIFTER = ENTITY_TYPES.register("ncoldsnapgifter", () -> EntityType.Builder.of(NetherHorde.NetherGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherGunner>> NCOLDSNAPGUNNER = ENTITY_TYPES.register("ncoldsnapgunner", () -> EntityType.Builder.of(NetherHorde.NetherGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherStabber>> NCOLDSNAPSTABBER = ENTITY_TYPES.register("ncoldsnapstabber", () -> EntityType.Builder.of(NetherHorde.NetherStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherSnowballer>> NCOLDSNAPSNOWBALLER = ENTITY_TYPES.register("ncoldsnapsnowballer", () -> EntityType.Builder.of(NetherHorde.NetherSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherZapper>> NCOLDSNAPZAPPER = ENTITY_TYPES.register("ncoldsnapzapper", () -> EntityType.Builder.of(NetherHorde.NetherZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherBrawler>> NCOLDSNAPBRAWLER = ENTITY_TYPES.register("ncoldsnapbrawler", () -> EntityType.Builder.of(NetherHorde.NetherBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ncoldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<EndHorde.EndGifter>> ECOLDSNAPGIFTER = ENTITY_TYPES.register("ecoldsnapgifter", () -> EntityType.Builder.of(EndHorde.EndGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndGunner>> ECOLDSNAPGUNNER = ENTITY_TYPES.register("ecoldsnapgunner", () -> EntityType.Builder.of(EndHorde.EndGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndStabber>> ECOLDSNAPSTABBER = ENTITY_TYPES.register("ecoldsnapstabber", () -> EntityType.Builder.of(EndHorde.EndStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndSnowballer>> ECOLDSNAPSNOWBALLER = ENTITY_TYPES.register("ecoldsnapsnowballer", () -> EntityType.Builder.of(EndHorde.EndSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndZapper>> ECOLDSNAPZAPPER = ENTITY_TYPES.register("ecoldsnapzapper", () -> EntityType.Builder.of(EndHorde.EndZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndBrawler>> ECOLDSNAPBRAWLER = ENTITY_TYPES.register("ecoldsnapbrawler", () -> EntityType.Builder.of(EndHorde.EndBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "ecoldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<PlagueHorde.PlagueGifter>> PCOLDSNAPGIFTER = ENTITY_TYPES.register("pcoldsnapgifter", () -> EntityType.Builder.of(PlagueHorde.PlagueGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueGunner>> PCOLDSNAPGUNNER = ENTITY_TYPES.register("pcoldsnapgunner", () -> EntityType.Builder.of(PlagueHorde.PlagueGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueStabber>> PCOLDSNAPSTABBER = ENTITY_TYPES.register("pcoldsnapstabber", () -> EntityType.Builder.of(PlagueHorde.PlagueStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueSnowballer>> PCOLDSNAPSNOWBALLER = ENTITY_TYPES.register("pcoldsnapsnowballer", () -> EntityType.Builder.of(PlagueHorde.PlagueSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueZapper>> PCOLDSNAPZAPPER = ENTITY_TYPES.register("pcoldsnapzapper", () -> EntityType.Builder.of(PlagueHorde.PlagueZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueBrawler>> PCOLDSNAPBRAWLER = ENTITY_TYPES.register("pcoldsnapbrawler", () -> EntityType.Builder.of(PlagueHorde.PlagueBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "pcoldsnapbrawler").toString()));


    public static final RegistryObject<EntityType<GunnerProjectileEntity>> GUNNERPROJECTILE = ENTITY_TYPES.register("gunnerprojectile", () -> EntityType.Builder.<GunnerProjectileEntity>of(GunnerProjectileEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "gunnerprojectile").toString()));
    public static final RegistryObject<EntityType<RockSnowballEntity>> ROCKSNOWBALLPROJECTILE = ENTITY_TYPES.register("rocksnowballprojectile", () -> EntityType.Builder.<RockSnowballEntity>of(RockSnowballEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "rocksnowballprojectile").toString()));
    public static final RegistryObject<EntityType<ThrownChorusEntity>> THROWNCHORUSPROJECTILE = ENTITY_TYPES.register("thrownchorusprojectile", () -> EntityType.Builder.<ThrownChorusEntity>of(ThrownChorusEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "thrownchorusprojectile").toString()));
    public static final RegistryObject<EntityType<SnowierSnowballEntity>> SNOWIERSNOWBALLPROJECTILE = ENTITY_TYPES.register("snowiersnowballprojectile", () -> EntityType.Builder.<SnowierSnowballEntity>of(SnowierSnowballEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "snowiersnowballprojectile").toString()));
    public static final RegistryObject<EntityType<LightningSnowEntity>> LIGHTNINGSNOWBALLPROJECTILE = ENTITY_TYPES.register("lightningsnowprojectile", () -> EntityType.Builder.<LightningSnowEntity>of(LightningSnowEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(ColdSnapHorde.MOD_ID, "lightningsnowprojectile").toString()));


    public static final RegistryObject<SoundEvent> GIFTERATTACK = SOUND_EVENT.register("gifter_attack", () -> new SoundEvent(new ResourceLocation(ColdSnapHorde.MOD_ID, "gifter_attack")));
    public static final RegistryObject<SoundEvent> NOVEMBERSNOW = SOUND_EVENT.register("novemember_snow", () -> new SoundEvent(new ResourceLocation(ColdSnapHorde.MOD_ID, "november_snow")));
    public static final RegistryObject<SoundEvent> ARCTICBEAT = SOUND_EVENT.register("arctic_beat", () -> new SoundEvent(new ResourceLocation(ColdSnapHorde.MOD_ID, "arctic_beat")));

    public static final RegistryObject<Block> REDCANDYCANE = BLOCKS.register("redcandycane", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> GREENCANDYCANE = BLOCKS.register("greencandycane", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> SLUSH = BLOCKS.register("slush", () -> new SlushBlock(BlockBehaviour.Properties.of(Material.SNOW).strength(0).sound(SoundType.SNOW)));

    public static final RegistryObject<BlockItem> REDCANDYCANEITEM = ITEMS.register("redcandycane", ()-> new LoredBlockItem(REDCANDYCANE.get(), new Item.Properties().tab(ColdSnapHorde.TAB), new TranslatableComponent("itemtooltip.candycane.1").withStyle(ChatFormatting.AQUA), new TranslatableComponent("itemtooltip.candycane.2").withStyle(ChatFormatting.AQUA)));
    public static final RegistryObject<BlockItem> GREENCANDYCANEITEM = ITEMS.register("greencandycane", ()-> new LoredBlockItem(GREENCANDYCANE.get(), new Item.Properties().tab(ColdSnapHorde.TAB), new TranslatableComponent("itemtooltip.candycane.1").withStyle(ChatFormatting.AQUA), new TranslatableComponent("itemtooltip.candycane.2").withStyle(ChatFormatting.AQUA)));
    public static final RegistryObject<BlockItem> SLUSHITEM = ITEMS.register("slush", ()-> new BlockItem(SLUSH.get(), new Item.Properties().tab(ColdSnapHorde.TAB)));

    public static final RegistryObject<Item> ICESWORD = ITEMS.register("ice_sword", ()->new IceSword(Materials.ICE, 0, -2.4f, new Item.Properties().tab(ColdSnapHorde.TAB).rarity(Rarity.UNCOMMON)));

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(ColdSnapHorde.MOD_ID, name);
    }

}
