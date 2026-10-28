package io.redspace.ironsspellbooks;

import com.mojang.logging.LogUtils;
import io.redspace.ironsspellbooks.api.config.SpellConfigManager;
import io.redspace.ironsspellbooks.api.magic.MagicHelper;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.config.ClientConfigs;
import io.redspace.ironsspellbooks.config.ServerConfigs;
import io.redspace.ironsspellbooks.network.*;
import io.redspace.ironsspellbooks.network.casting.*;
import io.redspace.ironsspellbooks.network.debug.PlayPlayerAnimationPacket;
import io.redspace.ironsspellbooks.network.gui.SelectSpellPacket;
import io.redspace.ironsspellbooks.network.particles.*;
import io.redspace.ironsspellbooks.network.spells.GuidingBoltManagerStartTrackingPacket;
import io.redspace.ironsspellbooks.network.spells.GuidingBoltManagerStopTrackingPacket;
import io.redspace.ironsspellbooks.network.spells.LearnSpellPacket;
import io.redspace.ironsspellbooks.registries.*;
import io.redspace.ironsspellbooks.setup.ModSetup;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.BuiltInPackSource;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.event.lifecycle.InterModProcessEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
public class IronsSpellbooks implements ModInitializer {
    // Directly reference a slf4j logger
    public static final String MOD_ID = "irons_spellbooks";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static MagicManager MAGIC_MANAGER;

    public static MinecraftServer MCS;
    public static ServerLevel OVERWORLD;

    @Override
    public void onInitialize() {


        // Registering packets and their handlers
        registerPackets();


        // TODO: update registries

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(event -> {
            event.accept(ItemRegistry.MITHRIL_ORE_BLOCK_ITEM);
            event.accept(ItemRegistry.MITHRIL_ORE_DEEPSLATE_BLOCK_ITEM);
        });
    }

    private <T extends CustomPacketPayload> void registerServerBoundPacket(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf,T> codec, ServerPlayNetworking.PlayPayloadHandler<T> handler) {
        PayloadTypeRegistry.playC2S().register(type, codec);
        ServerPlayNetworking.registerGlobalReceiver(type, handler);
    }

    private <T extends CustomPacketPayload> void registerClientBoundPacket(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf,T> codec, ClientPlayNetworking.PlayPayloadHandler<T> handler) {
        PayloadTypeRegistry.playS2C().register(type, codec);
        ClientPlayNetworking.registerGlobalReceiver(type, handler);
    }

    public void registerPackets() {
        //GENERAL
        registerClientBoundPacket(AddMotionToPlayerPacket.TYPE, AddMotionToPlayerPacket.STREAM_CODEC, AddMotionToPlayerPacket::handle);
        registerClientBoundPacket(EntityEventPacket.TYPE, EntityEventPacket.STREAM_CODEC, EntityEventPacket::handle);
        registerClientBoundPacket(EquipmentChangedPacket.TYPE, EquipmentChangedPacket.STREAM_CODEC, EquipmentChangedPacket::handle);
        registerClientBoundPacket(OpenEldritchScreenPacket.TYPE, OpenEldritchScreenPacket.STREAM_CODEC, OpenEldritchScreenPacket::handle);
        registerClientBoundPacket(SyncAnimationPacket.TYPE, SyncAnimationPacket.STREAM_CODEC, SyncAnimationPacket::handle);
        registerClientBoundPacket(SyncCameraShakePacket.TYPE, SyncCameraShakePacket.STREAM_CODEC, SyncCameraShakePacket::handle);
        registerClientBoundPacket(SyncAllCameraShakesPacket.TYPE, SyncAllCameraShakesPacket.STREAM_CODEC, SyncAllCameraShakesPacket::handle);
        registerClientBoundPacket(SyncManaPacket.TYPE, SyncManaPacket.STREAM_CODEC, SyncManaPacket::handle);
        registerClientBoundPacket(PlayPlayerAnimationPacket.TYPE, PlayPlayerAnimationPacket.STREAM_CODEC, PlayPlayerAnimationPacket::handle);

        registerServerBoundPacket(ScrollForgeSelectSpellPacket.TYPE, ScrollForgeSelectSpellPacket.STREAM_CODEC, ScrollForgeSelectSpellPacket::handle);
        registerClientBoundPacket(SyncJsonConfigPacket.TYPE, SyncJsonConfigPacket.STREAM_CODEC, SyncJsonConfigPacket::handle);

        //PARTICLES
        registerClientBoundPacket(AbsorptionParticlesPacket.TYPE, AbsorptionParticlesPacket.STREAM_CODEC, AbsorptionParticlesPacket::handle);
        registerClientBoundPacket(BloodSiphonParticlesPacket.TYPE, BloodSiphonParticlesPacket.STREAM_CODEC, BloodSiphonParticlesPacket::handle);
        registerClientBoundPacket(FieryExplosionParticlesPacket.TYPE, FieryExplosionParticlesPacket.STREAM_CODEC, FieryExplosionParticlesPacket::handle);
        registerClientBoundPacket(FortifyAreaParticlesPacket.TYPE, FortifyAreaParticlesPacket.STREAM_CODEC, FortifyAreaParticlesPacket::handle);
        registerClientBoundPacket(FrostStepParticlesPacket.TYPE, FrostStepParticlesPacket.STREAM_CODEC, FrostStepParticlesPacket::handle);
        registerClientBoundPacket(HealParticlesPacket.TYPE, HealParticlesPacket.STREAM_CODEC, HealParticlesPacket::handle);
        registerClientBoundPacket(OakskinParticlesPacket.TYPE, OakskinParticlesPacket.STREAM_CODEC, OakskinParticlesPacket::handle);
        registerClientBoundPacket(RegenCloudParticlesPacket.TYPE, RegenCloudParticlesPacket.STREAM_CODEC, RegenCloudParticlesPacket::handle);
        registerClientBoundPacket(ShockwaveParticlesPacket.TYPE, ShockwaveParticlesPacket.STREAM_CODEC, ShockwaveParticlesPacket::handle);
        registerClientBoundPacket(TeleportParticlesPacket.TYPE, TeleportParticlesPacket.STREAM_CODEC, TeleportParticlesPacket::handle);
        registerClientBoundPacket(FlamethrowerParticlesPacket.TYPE, FlamethrowerParticlesPacket.STREAM_CODEC, FlamethrowerParticlesPacket::handle);

        //CASTING
        registerServerBoundPacket(ServerBoundCancelCastPacket.TYPE, ServerBoundCancelCastPacket.STREAM_CODEC, ServerBoundCancelCastPacket::handle);
        registerClientBoundPacket(CastErrorPacket.TYPE, CastErrorPacket.STREAM_CODEC, CastErrorPacket::handle);
        registerClientBoundPacket(OnCastFinishedPacket.TYPE, OnCastFinishedPacket.STREAM_CODEC, OnCastFinishedPacket::handle);
        registerClientBoundPacket(OnCastStartedPacket.TYPE, OnCastStartedPacket.STREAM_CODEC, OnCastStartedPacket::handle);
        registerClientBoundPacket(OnClientCastPacket.TYPE, OnClientCastPacket.STREAM_CODEC, OnClientCastPacket::handle);
        registerClientBoundPacket(RemoveRecastPacket.TYPE, RemoveRecastPacket.STREAM_CODEC, RemoveRecastPacket::handle);
        registerClientBoundPacket(SyncCooldownPacket.TYPE, SyncCooldownPacket.STREAM_CODEC, SyncCooldownPacket::handle);
        registerClientBoundPacket(SyncCooldownsPacket.TYPE, SyncCooldownsPacket.STREAM_CODEC, SyncCooldownsPacket::handle);
        registerClientBoundPacket(SyncEntityDataPacket.TYPE, SyncEntityDataPacket.STREAM_CODEC, SyncEntityDataPacket::handle);
        registerClientBoundPacket(SyncCastingMobAimingDataPacket.TYPE, SyncCastingMobAimingDataPacket.STREAM_CODEC, SyncCastingMobAimingDataPacket::handle);
        registerClientBoundPacket(SyncPlayerDataPacket.TYPE, SyncPlayerDataPacket.STREAM_CODEC, SyncPlayerDataPacket::handle);
        registerClientBoundPacket(SyncRecastPacket.TYPE, SyncRecastPacket.STREAM_CODEC, SyncRecastPacket::handle);
        registerClientBoundPacket(SyncRecastsPacket.TYPE, SyncRecastsPacket.STREAM_CODEC, SyncRecastsPacket::handle);
        registerClientBoundPacket(SyncTargetingDataPacket.TYPE, SyncTargetingDataPacket.STREAM_CODEC, SyncTargetingDataPacket::handle);
        registerClientBoundPacket(UpdateCastingStatePacket.TYPE, UpdateCastingStatePacket.STREAM_CODEC, UpdateCastingStatePacket::handle);

        registerServerBoundPacket(CastPacket.TYPE, CastPacket.STREAM_CODEC, CastPacket::handle);
        registerServerBoundPacket(QuickCastPacket.TYPE, QuickCastPacket.STREAM_CODEC, QuickCastPacket::handle);

        //SPELLS
        registerClientBoundPacket(GuidingBoltManagerStartTrackingPacket.TYPE, GuidingBoltManagerStartTrackingPacket.STREAM_CODEC, GuidingBoltManagerStartTrackingPacket::handle);
        registerClientBoundPacket(GuidingBoltManagerStopTrackingPacket.TYPE, GuidingBoltManagerStopTrackingPacket.STREAM_CODEC, GuidingBoltManagerStopTrackingPacket::handle);

        registerServerBoundPacket(LearnSpellPacket.TYPE, LearnSpellPacket.STREAM_CODEC, LearnSpellPacket::handle);

        //GUI
        registerServerBoundPacket(SelectSpellPacket.TYPE, SelectSpellPacket.STREAM_CODEC, SelectSpellPacket::handle);
    }

    public IronsSpellbooks(IEventBus modEventBus, ModContainer modContainer) {

        ModSetup.setup();

        MAGIC_MANAGER = new MagicManager();
        MagicHelper.MAGIC_MANAGER = MAGIC_MANAGER;

        modEventBus.addListener(ModSetup::init);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(SchoolRegistry::registerRegistry);
        modEventBus.addListener(SpellRegistry::registerRegistry);
        modEventBus.addListener(UpgradeOrbTypeRegistry::registerDatapackRegistries);
        //NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addPackFinders);
        NeoForge.EVENT_BUS.addListener(this::addServerDataListeners);

        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC,"irons_spellbooks-client.toml");
        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, String.format("%s-client.toml", IronsSpellbooks.MOD_ID));
        modContainer.registerConfig(ModConfig.Type.SERVER, ServerConfigs.SPEC, String.format("%s-server.toml", IronsSpellbooks.MOD_ID));

    }

    public void addServerDataListeners(AddReloadListenerEvent event) {
        SpellConfigManager.INSTANCE = new SpellConfigManager();
        event.addListener(SpellConfigManager.INSTANCE);
    }

    public void addPackFinders(AddPackFindersEvent event) {
        IronsSpellbooks.LOGGER.debug("addPackFinders");
        try {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                addBuiltinPack(event, "legacy_dead_king_resource_pack", Component.literal("Legacy Dead King"));
            }
        } catch (IOException ex) {
            IronsSpellbooks.LOGGER.error("Failed to load a builtin resource pack! If you are seeing this message, please report an issue to https://github.com/iron431/Irons-Spells-n-Spellbooks/issues");
            // throw new RuntimeException(ex);
        }
    }

    private static void addBuiltinPack(AddPackFindersEvent event, String filename, Component displayName) throws IOException {
        filename = "builtin_resource_packs/" + filename;
        String id = "builtin/" + filename;
        var resourcePath = ModList.get().getModFileById(MOD_ID).getFile().findResource(filename);
        var pack = Pack.readMetaAndCreate(
                new PackLocationInfo(id, displayName, PackSource.BUILT_IN, Optional.empty()),
                BuiltInPackSource.fromName((path) -> new PathPackResources(path, resourcePath)),
                PackType.CLIENT_RESOURCES,
                new PackSelectionConfig(false, Pack.Position.TOP, false)
        );
        event.addRepositorySource((packConsumer) -> packConsumer.accept(pack));
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    public static ResourceLocation id(@NotNull String path) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, path);
    }
}
