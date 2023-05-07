package com.villain.coldsnaphorde;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.villain.cartoonishhorde.hordedata.EntityTypeHordeData;
import com.villain.cartoonishhorde.hordedata.EnumHordeData;
import com.villain.coldsnaphorde.capabilities.IPlayerCapabilityManager;
import com.villain.coldsnaphorde.capabilities.IWorldCapabilityManager;
import com.villain.coldsnaphorde.configs.CConfiguration;
import com.villain.coldsnaphorde.configs.ClientConfig;
import com.villain.coldsnaphorde.configs.ConfigHelper;
import com.villain.coldsnaphorde.configs.SConfiguration;
import com.villain.coldsnaphorde.entities.Spawns;
import com.villain.coldsnaphorde.entities.mobs.hordevariantmanager.StandardHorde;
import com.villain.coldsnaphorde.events.HordeEventTier1;
import com.villain.coldsnaphorde.events.HordeEventTier2;
import com.villain.coldsnaphorde.events.HordeEventTier3;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

@Mod(Constants.MOD_ID)
public class ForgeColdSnapHorde {

    public static Capability<IWorldCapabilityManager> WORLDCAPABILITYINSTANCE = null;
    public static Capability<IPlayerCapabilityManager> PLAYERCAPABILITYINSTANCE = null;
    public static ArrayList<ArmorItem> TOPHATS = new ArrayList<>();

    public static SConfiguration sconfig;
    public static CConfiguration cconfig;
    public static ClientConfig clientConfig;
    public static HordeEventTier1 hordeTier1;
    public static HordeEventTier2 hordeTier2;
    public static HordeEventTier3 hordeTier3;

    public static HordeDataManager hordeDataManager = null;

    static DeferredRegister<Codec<? extends BiomeModifier>> serializers = DeferredRegister
            .create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Constants.MOD_ID);

    public static RegistryObject<Codec<Spawns.SpawnModifiers>> SPAWNCODEC = serializers.register("spawnmodifiers", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    // declare fields
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(Spawns.SpawnModifiers::biomes),
                    MobSpawnSettings.SpawnerData.CODEC.fieldOf("spawn").forGetter(Spawns.SpawnModifiers::spawn)
                    // declare constructor
            ).apply(builder, Spawns.SpawnModifiers::new)));

    public ForgeColdSnapHorde() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        serializers.register(modEventBus);
        Register.init();
        FrostEffect.init();
        clientConfig = ConfigHelper.register(ModConfig.Type.CLIENT, ClientConfig::new);
        sconfig = ConfigHelper.register(ModConfig.Type.SERVER, SConfiguration::new);
        cconfig = ConfigHelper.register(ModConfig.Type.COMMON, CConfiguration::new);
        CommonColdSnapHorde.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        hordeTier1 = new HordeEventTier1(event.getServer());
        hordeTier1.setHordeData(
                new EntityTypeHordeData<>(3, 0.45d, 1, Register.COLDSNAPGUNNER.get(), StandardHorde.StandardGunner.class),
                new EntityTypeHordeData<>(3, 0.45d, 1, Register.COLDSNAPSTABBER.get(), StandardHorde.StandardStabber.class),
                new EntityTypeHordeData<>(3, 0.45d, 1, Register.COLDSNAPSNOWBALLER.get(), StandardHorde.StandardSnowballer.class)
        );
        hordeTier2 = new HordeEventTier2(event.getServer());
        hordeTier2.setHordeData(
                new EnumHordeData<>(3, 0.45d, 20, HordeEnum.COLDSNAPGUNNER),
                new EnumHordeData<>(3, 0.45d, 20, HordeEnum.COLDSNAPSTABBER),
                new EnumHordeData<>(3, 0.45d, 20, HordeEnum.COLDSNAPSNOWBALLER),
                new EnumHordeData<>(3, 0.45d, 7, HordeEnum.COLDSNAPGIFTER),
                new EnumHordeData<>(3, 0.45d, 7, HordeEnum.COLDSNAPZAPPER),
                new EnumHordeData<>(3, 0.45d, 7, HordeEnum.COLDSNAPBRAWLER)
        );

        hordeTier3 = new HordeEventTier3(event.getServer());
        hordeTier3.setHordeData(
                new EnumHordeData<>(3, 0.45d, 20, HordeEnum.COLDSNAPGUNNER),
                new EnumHordeData<>(3, 0.45d, 20, HordeEnum.COLDSNAPSTABBER),
                new EnumHordeData<>(3, 0.45d, 20, HordeEnum.COLDSNAPSNOWBALLER),
                new EnumHordeData<>(3, 0.45d, 10, HordeEnum.COLDSNAPGIFTER),
                new EnumHordeData<>(3, 0.45d, 10, HordeEnum.COLDSNAPZAPPER),
                new EnumHordeData<>(3, 0.45d, 10, HordeEnum.COLDSNAPBRAWLER)
        );

        hordeDataManager = HordeDataManager.getInstance();

        hordeDataManager.setupHighestLevelBeaten(event.getServer());
    }
}