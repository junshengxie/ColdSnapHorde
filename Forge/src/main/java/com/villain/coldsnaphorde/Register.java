package com.villain.coldsnaphorde;

import com.villain.coldsnaphorde.entities.mobs.basemob.ColdSnapCow;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.EndHorde;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.NetherHorde;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.PlagueHorde;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.StandardHorde;
import com.villain.coldsnaphorde.entities.projectiles.*;
import com.villain.coldsnaphorde.items.Tier;
import com.villain.coldsnaphorde.items.*;
import com.villain.coldsnaphorde.items.armor.ArmorMaterials;
import com.villain.coldsnaphorde.items.armor.TopHat;
import com.villain.coldsnaphorde.items.projectiles.*;
import com.villain.coldsnaphorde.items.toolsorother.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Register {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Constants.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static void init(){
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUND_EVENT.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TAB.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Item> ROCKYSNOWBALL = ITEMS.register("rockysnowball", RockySnowball::new);
    public static final RegistryObject<Item> SNOWIERSNOWBALL = ITEMS.register("freezeball", SnowierSnowball::new);

    public static final RegistryObject<ArmorItem> TOPHAT = ITEMS.register("tophat", () -> new TopHat(ArmorMaterials.HAT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> REDTOPHAT = ITEMS.register("redtophat", () -> new TopHat(ArmorMaterials.HAT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> BLUETOPHAT = ITEMS.register("bluetophat", () -> new TopHat(ArmorMaterials.HAT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> GREENTOPHAT = ITEMS.register("greentophat", () -> new TopHat(ArmorMaterials.HAT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> PURPLETOPHAT = ITEMS.register("purpletophat", () -> new TopHat(ArmorMaterials.HAT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> THERMOMETER = ITEMS.register("thermometer", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ICESHARD = ITEMS.register("iceshard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SNOWWALLCHARM = ITEMS.register("snow_wall_charm", () -> new FrostWallCharm(new Item.Properties().stacksTo(1), Tier.ONE));
    public static final RegistryObject<Item> SNOWGLOBE = ITEMS.register("snowglobe", () -> new Snowglobe(new Item.Properties(), Tier.ONE));
    public static final RegistryObject<Item> SMALLPRESENT = ITEMS.register("small_present", () -> new Present(new Item.Properties(), Tier.ONE));
    public static final RegistryObject<Item> LESSERHEALINGBALL = ITEMS.register("lesser_healing_ball", () -> new HealingSnowball(Tier.ONE));
    public static final RegistryObject<Item> ICICLE = ITEMS.register("icicle", () -> new Icicle(Materials.ICICLE, 2, -3.2f, new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> FROSTESSENCE = ITEMS.register("frostessence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FROSTCORE = ITEMS.register("frostcore", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLACIERWALLCHARM = ITEMS.register("glacier_wall_charm", () -> new FrostWallCharm(new Item.Properties().stacksTo(1), Tier.TWO));
    public static final RegistryObject<Item> FROSTCHARM = ITEMS.register("frost_charm", () -> new FrostCharm(new Item.Properties().stacksTo(1), Tier.TWO));
    public static final RegistryObject<Item> HEALINGBALL = ITEMS.register("healing_ball", () -> new HealingSnowball(Tier.TWO));
    public static final RegistryObject<Item> PRESENT = ITEMS.register("present", () -> new Present(new Item.Properties(), Tier.TWO));
    public static final RegistryObject<Item> ICESWORD = ITEMS.register("ice_sword", () -> new IceSword(Materials.ICE, 0, -2.4f, new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
    public static final RegistryObject<Item> FROSTEDSNOWGLOBE = ITEMS.register("frosted_snowglobe", () -> new Snowglobe(new Item.Properties(), Tier.TWO));
    public static final RegistryObject<Item> ICESTAFF = ITEMS.register("ice_staff", () -> new IceStaff(Materials.FROSTESSENCE, new Item.Properties().defaultDurability(256), Tier.TWO));
    public static final RegistryObject<Item> WANDOFTHEFROSTWALKER = ITEMS.register("wand_of_ice_walker", () -> new FrostWalkStaff(Materials.FROSTESSENCE, new Item.Properties().defaultDurability(256), Tier.TWO));


    public static final RegistryObject<Item> ICEESSENCE = ITEMS.register("iceessence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ICECORE = ITEMS.register("icecore", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REINFOCEDGLACIERCHARM = ITEMS.register("reinforced_glacier_wall_charm", () -> new FrostWallCharm(new Item.Properties().stacksTo(1), Tier.THREE));
    public static final RegistryObject<Item> ARCTICCHARM = ITEMS.register("arctic_wind_charm", () -> new FrostCharm(new Item.Properties().stacksTo(1), Tier.THREE));
    public static final RegistryObject<Item> GREATERHEALINGBALL = ITEMS.register("greater_healing_ball", () -> new HealingSnowball(Tier.THREE));
    public static final RegistryObject<Item> LARGEPRESENT = ITEMS.register("large_present", () -> new Present(new Item.Properties(), Tier.THREE));
    public static final RegistryObject<Item> GLACIERSTAFF = ITEMS.register("glacier_staff", () -> new IceStaff(Materials.ICEESSENCE, new Item.Properties().defaultDurability(256), Tier.THREE));
    public static final RegistryObject<Item> STAFFOFICEFROSTWALKER = ITEMS.register("staff_of_frost_walker", () -> new FrostWalkStaff(Materials.ICEESSENCE, new Item.Properties().defaultDurability(768), Tier.THREE));
    public static final RegistryObject<Item> FROZENSNOWGLOBE = ITEMS.register("frozen_snowglobe", () -> new Snowglobe(new Item.Properties(), Tier.THREE));

    public static final RegistryObject<Item> NOVEMBERSNOWDISC = ITEMS.register("november_snow", () -> new RecordItem(6, Register.NOVEMBERSNOW, new Item.Properties().stacksTo(1), 6980));
    public static final RegistryObject<Item> ARCTICBEATDISC = ITEMS.register("arctic_beat", () -> new RecordItem(7, Register.ARCTICBEAT, new Item.Properties().stacksTo(1), 3840));

    public static final RegistryObject<Item> LIGHTNINGTRANSPOSERPIECE = ITEMS.register("transposerpiece", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHTNINGTRANSPOSER = ITEMS.register("lightningtransposer", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIGHTNINGSNOWBALL = ITEMS.register("lightningsnowball", LightningSnowball::new);

    public static final RegistryObject<Item> GUNNERSPAWN = ITEMS.register("gunner_spawn_egg", () -> new ForgeSpawnEggItem(Register.COLDSNAPGUNNER, 14804727, 0, new Item.Properties()));
    public static final RegistryObject<Item> STABBERSPAWN = ITEMS.register("stabber_spawn_egg", () -> new ForgeSpawnEggItem(Register.COLDSNAPSTABBER, 14804727, 8585216, new Item.Properties()));
    public static final RegistryObject<Item> SNOWBALLERSPAWN = ITEMS.register("snowballer_spawn_egg", () -> new ForgeSpawnEggItem(Register.COLDSNAPSNOWBALLER, 14804727, 25753, new Item.Properties()));
    public static final RegistryObject<Item> GIFTERSPAWN = ITEMS.register("gifter_spawn_egg", () -> new ForgeSpawnEggItem(Register.COLDSNAPGIFTER, 14804727, 26671, new Item.Properties()));
    public static final RegistryObject<Item> ZAPPERSPAWN = ITEMS.register("zapper_spawn_egg", () -> new ForgeSpawnEggItem(Register.COLDSNAPZAPPER, 14804727, 9802549, new Item.Properties()));
    public static final RegistryObject<Item> BRAWLERPAWN = ITEMS.register("brawler_spawn_egg", () -> new ForgeSpawnEggItem(Register.COLDSNAPBRAWLER, 14804727, 6229378, new Item.Properties()));

    public static final RegistryObject<Item> NGUNNERSPAWN = ITEMS.register("ngunner_spawn_egg", () -> new ForgeSpawnEggItem(Register.NCOLDSNAPGUNNER, 4926000, 0, new Item.Properties()));
    public static final RegistryObject<Item> NSTABBERSPAWN = ITEMS.register("nstabber_spawn_egg", () -> new ForgeSpawnEggItem(Register.NCOLDSNAPSTABBER, 4926000, 8585216, new Item.Properties()));
    public static final RegistryObject<Item> NSNOWBALLERSPAWN = ITEMS.register("nsnowballer_spawn_egg", () -> new ForgeSpawnEggItem(Register.NCOLDSNAPSNOWBALLER, 4926000, 25753, new Item.Properties()));
    public static final RegistryObject<Item> NGIFTERSPAWN = ITEMS.register("ngifter_spawn_egg", () -> new ForgeSpawnEggItem(Register.NCOLDSNAPGIFTER, 4926000, 26671, new Item.Properties()));
    public static final RegistryObject<Item> NZAPPERSPAWN = ITEMS.register("nzapper_spawn_egg", () -> new ForgeSpawnEggItem(Register.NCOLDSNAPZAPPER, 4926000, 9802549, new Item.Properties()));
    public static final RegistryObject<Item> NBRAWLERPAWN = ITEMS.register("nbrawler_spawn_egg", () -> new ForgeSpawnEggItem(Register.NCOLDSNAPBRAWLER, 4926000, 6229378, new Item.Properties()));

    public static final RegistryObject<Item> EGUNNERSPAWN = ITEMS.register("egunner_spawn_egg", () -> new ForgeSpawnEggItem(Register.ECOLDSNAPGUNNER, 15332272, 0, new Item.Properties()));
    public static final RegistryObject<Item> ESTABBERSPAWN = ITEMS.register("estabber_spawn_egg", () -> new ForgeSpawnEggItem(Register.ECOLDSNAPSTABBER, 15332272, 8585216, new Item.Properties()));
    public static final RegistryObject<Item> ESNOWBALLERSPAWN = ITEMS.register("esnowballer_spawn_egg", () -> new ForgeSpawnEggItem(Register.ECOLDSNAPSNOWBALLER, 15332272, 25753, new Item.Properties()));
    public static final RegistryObject<Item> EGIFTERSPAWN = ITEMS.register("egifter_spawn_egg", () -> new ForgeSpawnEggItem(Register.ECOLDSNAPGIFTER, 15332272, 26671, new Item.Properties()));
    public static final RegistryObject<Item> EZAPPERSPAWN = ITEMS.register("ezapper_spawn_egg", () -> new ForgeSpawnEggItem(Register.ECOLDSNAPZAPPER, 15332272, 9802549, new Item.Properties()));
    public static final RegistryObject<Item> EBRAWLERPAWN = ITEMS.register("ebrawler_spawn_egg", () -> new ForgeSpawnEggItem(Register.ECOLDSNAPBRAWLER, 15332272, 6229378, new Item.Properties()));

    public static final RegistryObject<Item> PGUNNERSPAWN = ITEMS.register("pgunner_spawn_egg", () -> new ForgeSpawnEggItem(Register.PCOLDSNAPGUNNER, 7444, 0, new Item.Properties()));
    public static final RegistryObject<Item> PSTABBERSPAWN = ITEMS.register("pstabber_spawn_egg", () -> new ForgeSpawnEggItem(Register.PCOLDSNAPSTABBER, 7444, 8585216, new Item.Properties()));
    public static final RegistryObject<Item> PSNOWBALLERSPAWN = ITEMS.register("psnowballer_spawn_egg", () -> new ForgeSpawnEggItem(Register.PCOLDSNAPSNOWBALLER, 7444, 25753, new Item.Properties()));
    public static final RegistryObject<Item> PGIFTERSPAWN = ITEMS.register("pgifter_spawn_egg", () -> new ForgeSpawnEggItem(Register.PCOLDSNAPGIFTER, 7444, 26671, new Item.Properties()));
    public static final RegistryObject<Item> PZAPPERSPAWN = ITEMS.register("pzapper_spawn_egg", () -> new ForgeSpawnEggItem(Register.PCOLDSNAPZAPPER, 7444, 9802549, new Item.Properties()));
    public static final RegistryObject<Item> PBRAWLERPAWN = ITEMS.register("pbrawler_spawn_egg", () -> new ForgeSpawnEggItem(Register.PCOLDSNAPBRAWLER, 7444, 6229378, new Item.Properties()));
    public static final RegistryObject<Item> COWSPAWN = ITEMS.register("frostcow_spawn_egg", () -> new ForgeSpawnEggItem(Register.COLDSNAPCOW, 14804727, 1840384, new Item.Properties()));

    public static final RegistryObject<EntityType<ColdSnapCow>> COLDSNAPCOW = ENTITY_TYPES.register("frostycow", () -> EntityType.Builder.of(ColdSnapCow::new, MobCategory.CREATURE).sized(0.9F, 1.4F).build(new ResourceLocation(Constants.MOD_ID, "frostycow").toString()));

    public static final RegistryObject<EntityType<StandardHorde.StandardGifter>> COLDSNAPGIFTER = ENTITY_TYPES.register("coldsnapgifter", () -> EntityType.Builder.of(StandardHorde.StandardGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "coldsnapgifter").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardGunner>> COLDSNAPGUNNER = ENTITY_TYPES.register("coldsnapgunner", () -> EntityType.Builder.of(StandardHorde.StandardGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "coldsnapgunner").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardStabber>> COLDSNAPSTABBER = ENTITY_TYPES.register("coldsnapstabber", () -> EntityType.Builder.of(StandardHorde.StandardStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "coldsnapstabber").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardSnowballer>> COLDSNAPSNOWBALLER = ENTITY_TYPES.register("coldsnapsnowballer", () -> EntityType.Builder.of(StandardHorde.StandardSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "coldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardZapper>> COLDSNAPZAPPER = ENTITY_TYPES.register("coldsnapzapper", () -> EntityType.Builder.of(StandardHorde.StandardZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "coldsnapzapper").toString()));
    public static final RegistryObject<EntityType<StandardHorde.StandardBrawler>> COLDSNAPBRAWLER = ENTITY_TYPES.register("coldsnapbrawler", () -> EntityType.Builder.of(StandardHorde.StandardBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "coldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<NetherHorde.NetherGifter>> NCOLDSNAPGIFTER = ENTITY_TYPES.register("ncoldsnapgifter", () -> EntityType.Builder.of(NetherHorde.NetherGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ncoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherGunner>> NCOLDSNAPGUNNER = ENTITY_TYPES.register("ncoldsnapgunner", () -> EntityType.Builder.of(NetherHorde.NetherGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ncoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherStabber>> NCOLDSNAPSTABBER = ENTITY_TYPES.register("ncoldsnapstabber", () -> EntityType.Builder.of(NetherHorde.NetherStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ncoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherSnowballer>> NCOLDSNAPSNOWBALLER = ENTITY_TYPES.register("ncoldsnapsnowballer", () -> EntityType.Builder.of(NetherHorde.NetherSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ncoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherZapper>> NCOLDSNAPZAPPER = ENTITY_TYPES.register("ncoldsnapzapper", () -> EntityType.Builder.of(NetherHorde.NetherZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ncoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<NetherHorde.NetherBrawler>> NCOLDSNAPBRAWLER = ENTITY_TYPES.register("ncoldsnapbrawler", () -> EntityType.Builder.of(NetherHorde.NetherBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ncoldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<EndHorde.EndGifter>> ECOLDSNAPGIFTER = ENTITY_TYPES.register("ecoldsnapgifter", () -> EntityType.Builder.of(EndHorde.EndGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ecoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndGunner>> ECOLDSNAPGUNNER = ENTITY_TYPES.register("ecoldsnapgunner", () -> EntityType.Builder.of(EndHorde.EndGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ecoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndStabber>> ECOLDSNAPSTABBER = ENTITY_TYPES.register("ecoldsnapstabber", () -> EntityType.Builder.of(EndHorde.EndStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ecoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndSnowballer>> ECOLDSNAPSNOWBALLER = ENTITY_TYPES.register("ecoldsnapsnowballer", () -> EntityType.Builder.of(EndHorde.EndSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ecoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndZapper>> ECOLDSNAPZAPPER = ENTITY_TYPES.register("ecoldsnapzapper", () -> EntityType.Builder.of(EndHorde.EndZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ecoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<EndHorde.EndBrawler>> ECOLDSNAPBRAWLER = ENTITY_TYPES.register("ecoldsnapbrawler", () -> EntityType.Builder.of(EndHorde.EndBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "ecoldsnapbrawler").toString()));

    public static final RegistryObject<EntityType<PlagueHorde.PlagueGifter>> PCOLDSNAPGIFTER = ENTITY_TYPES.register("pcoldsnapgifter", () -> EntityType.Builder.of(PlagueHorde.PlagueGifter::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "pcoldsnapgifter").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueGunner>> PCOLDSNAPGUNNER = ENTITY_TYPES.register("pcoldsnapgunner", () -> EntityType.Builder.of(PlagueHorde.PlagueGunner::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "pcoldsnapgunner").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueStabber>> PCOLDSNAPSTABBER = ENTITY_TYPES.register("pcoldsnapstabber", () -> EntityType.Builder.of(PlagueHorde.PlagueStabber::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "pcoldsnapstabber").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueSnowballer>> PCOLDSNAPSNOWBALLER = ENTITY_TYPES.register("pcoldsnapsnowballer", () -> EntityType.Builder.of(PlagueHorde.PlagueSnowballer::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "pcoldsnapsnowballer").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueZapper>> PCOLDSNAPZAPPER = ENTITY_TYPES.register("pcoldsnapzapper", () -> EntityType.Builder.of(PlagueHorde.PlagueZapper::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "pcoldsnapzapper").toString()));
    public static final RegistryObject<EntityType<PlagueHorde.PlagueBrawler>> PCOLDSNAPBRAWLER = ENTITY_TYPES.register("pcoldsnapbrawler", () -> EntityType.Builder.of(PlagueHorde.PlagueBrawler::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Constants.MOD_ID, "pcoldsnapbrawler").toString()));


    public static final RegistryObject<EntityType<GunnerProjectileEntity>> GUNNERPROJECTILE = ENTITY_TYPES.register("gunnerprojectile", () -> EntityType.Builder.<GunnerProjectileEntity>of(GunnerProjectileEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Constants.MOD_ID, "gunnerprojectile").toString()));
    public static final RegistryObject<EntityType<RockSnowballEntity>> ROCKSNOWBALLPROJECTILE = ENTITY_TYPES.register("rocksnowballprojectile", () -> EntityType.Builder.<RockSnowballEntity>of(RockSnowballEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Constants.MOD_ID, "rocksnowballprojectile").toString()));
    public static final RegistryObject<EntityType<ThrownChorusEntity>> THROWNCHORUSPROJECTILE = ENTITY_TYPES.register("thrownchorusprojectile", () -> EntityType.Builder.<ThrownChorusEntity>of(ThrownChorusEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Constants.MOD_ID, "thrownchorusprojectile").toString()));
    public static final RegistryObject<EntityType<SnowierSnowballEntity>> SNOWIERSNOWBALLPROJECTILE = ENTITY_TYPES.register("snowiersnowballprojectile", () -> EntityType.Builder.<SnowierSnowballEntity>of(SnowierSnowballEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Constants.MOD_ID, "snowiersnowballprojectile").toString()));
    public static final RegistryObject<EntityType<LightningSnowEntity>> LIGHTNINGSNOWBALLPROJECTILE = ENTITY_TYPES.register("lightningsnowprojectile", () -> EntityType.Builder.<LightningSnowEntity>of(LightningSnowEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Constants.MOD_ID, "lightningsnowprojectile").toString()));
    public static final RegistryObject<EntityType<HealingSnowballEntity>> HEALINGSNOWBALLPROJECTILE = ENTITY_TYPES.register("healingsnowprojectile", () -> EntityType.Builder.<HealingSnowballEntity>of(HealingSnowballEntity::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Constants.MOD_ID, "healingsnowprojectile").toString()));
    public static final RegistryObject<EntityType<IceProjectile>> ICEPROJECTILE = ENTITY_TYPES.register("iceprojectile", () -> EntityType.Builder.<IceProjectile>of(IceProjectile::new, MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Constants.MOD_ID, "iceprojectile").toString()));

    public static final RegistryObject<SoundEvent> GIFTERATTACK = SOUND_EVENT.register("gifter_attack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Constants.MOD_ID, "gifter_attack")));
    public static final RegistryObject<SoundEvent> NOVEMBERSNOW = SOUND_EVENT.register("novemember_snow", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Constants.MOD_ID, "november_snow")));
    public static final RegistryObject<SoundEvent> ARCTICBEAT = SOUND_EVENT.register("arctic_beat", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Constants.MOD_ID, "arctic_beat")));

    public static final RegistryObject<Block> REDCANDYCANE = BLOCKS.register("redcandycane", () -> new Block(BlockBehaviour.Properties.of().pushReaction(PushReaction.NORMAL).mapColor(MapColor.STONE).strength(1).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> GREENCANDYCANE = BLOCKS.register("greencandycane", () -> new Block(BlockBehaviour.Properties.of().pushReaction(PushReaction.NORMAL).mapColor(MapColor.STONE).strength(1).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> SLUSH = BLOCKS.register("slush", () -> new SlushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0).sound(SoundType.SNOW)));

    public static final RegistryObject<BlockItem> REDCANDYCANEITEM = ITEMS.register("redcandycane", ()-> new LoredBlockItem(REDCANDYCANE.get(), new Item.Properties(), Component.translatable("itemtooltip.candycane.1").withStyle(ChatFormatting.AQUA), Component.translatable("itemtooltip.candycane.2").withStyle(ChatFormatting.AQUA)));
    public static final RegistryObject<BlockItem> GREENCANDYCANEITEM = ITEMS.register("greencandycane", ()-> new LoredBlockItem(GREENCANDYCANE.get(), new Item.Properties(), Component.translatable("itemtooltip.candycane.1").withStyle(ChatFormatting.AQUA), Component.translatable("itemtooltip.candycane.2").withStyle(ChatFormatting.AQUA)));
    public static final RegistryObject<BlockItem> SLUSHITEM = ITEMS.register("slush", ()-> new BlockItem(SLUSH.get(), new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> COLDSNAPHORDETAB = TAB.register("coldsnaphordetab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> SNOWGLOBE.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.ColdSnapHorde"))
            .displayItems((parameters, output) -> {
                output.accept(Register.TOPHAT.get());
                output.accept(Register.REDTOPHAT.get());
                output.accept(Register.BLUETOPHAT.get());
                output.accept(Register.GREENTOPHAT.get());
                output.accept(Register.PURPLETOPHAT.get());
                output.accept(Register.THERMOMETER.get());
                output.accept(Register.ROCKYSNOWBALL.get());
                output.accept(Register.SNOWIERSNOWBALL.get());
                output.accept(Register.LESSERHEALINGBALL.get());
                output.accept(Register.HEALINGBALL.get());
                output.accept(Register.GREATERHEALINGBALL.get());
                output.accept(Register.LIGHTNINGSNOWBALL.get());
                output.accept(Register.LIGHTNINGTRANSPOSER.get());
                output.accept(Register.SNOWGLOBE.get());
                output.accept(Register.FROSTEDSNOWGLOBE.get());
                output.accept(Register.FROZENSNOWGLOBE.get());
                output.accept(Register.SMALLPRESENT.get());
                output.accept(Register.PRESENT.get());
                output.accept(Register.LARGEPRESENT.get());
                output.accept(Register.ICICLE.get());
                output.accept(Register.ICESWORD.get());
                output.accept(Register.SNOWWALLCHARM.get());
                output.accept(Register.GLACIERWALLCHARM.get());
                output.accept(Register.REINFOCEDGLACIERCHARM.get());
                output.accept(Register.FROSTCHARM.get());
                output.accept(Register.ARCTICCHARM.get());
                output.accept(Register.ICESTAFF.get());
                output.accept(Register.GLACIERSTAFF.get());
                output.accept(Register.WANDOFTHEFROSTWALKER.get());
                output.accept(Register.STAFFOFICEFROSTWALKER.get());
                output.accept(Register.NOVEMBERSNOWDISC.get());
                output.accept(Register.ARCTICBEATDISC.get());
                output.accept(Register.ICESHARD.get());
                output.accept(Register.FROSTESSENCE.get());
                output.accept(Register.FROSTCORE.get());
                output.accept(Register.ICEESSENCE.get());
                output.accept(Register.ICECORE.get());
                output.accept(Register.COWSPAWN.get());
                output.accept(Register.GUNNERSPAWN.get());
                output.accept(Register.STABBERSPAWN.get());
                output.accept(Register.SNOWBALLERSPAWN.get());
                output.accept(Register.GIFTERSPAWN.get());
                output.accept(Register.ZAPPERSPAWN.get());
                output.accept(Register.BRAWLERPAWN.get());
                output.accept(Register.PGUNNERSPAWN.get());
                output.accept(Register.PSTABBERSPAWN.get());
                output.accept(Register.PSNOWBALLERSPAWN.get());
                output.accept(Register.PGIFTERSPAWN.get());
                output.accept(Register.PZAPPERSPAWN.get());
                output.accept(Register.PBRAWLERPAWN.get());
                output.accept(Register.NGUNNERSPAWN.get());
                output.accept(Register.NSTABBERSPAWN.get());
                output.accept(Register.NSNOWBALLERSPAWN.get());
                output.accept(Register.NGIFTERSPAWN.get());
                output.accept(Register.NZAPPERSPAWN.get());
                output.accept(Register.NBRAWLERPAWN.get());
                output.accept(Register.EGUNNERSPAWN.get());
                output.accept(Register.ESTABBERSPAWN.get());
                output.accept(Register.ESNOWBALLERSPAWN.get());
                output.accept(Register.EGIFTERSPAWN.get());
                output.accept(Register.EZAPPERSPAWN.get());
                output.accept(Register.EBRAWLERPAWN.get());
            }).build());

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(Constants.MOD_ID, name);
    }

}
