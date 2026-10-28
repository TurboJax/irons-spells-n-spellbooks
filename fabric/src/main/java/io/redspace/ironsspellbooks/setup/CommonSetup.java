package io.redspace.ironsspellbooks.setup;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.config.ClientConfigs;
import io.redspace.ironsspellbooks.config.ServerConfigs;
import io.redspace.ironsspellbooks.entity.mobs.SummonedHorse;
import io.redspace.ironsspellbooks.entity.mobs.SummonedSkeleton;
import io.redspace.ironsspellbooks.entity.mobs.SummonedVex;
import io.redspace.ironsspellbooks.entity.mobs.SummonedZombie;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.DeadKingBoss;
import io.redspace.ironsspellbooks.entity.mobs.debug_wizard.DebugWizard;
import io.redspace.ironsspellbooks.entity.mobs.frozen_humanoid.FrozenHumanoid;
import io.redspace.ironsspellbooks.entity.mobs.ice_spider.IceSpiderEntity;
import io.redspace.ironsspellbooks.entity.mobs.keeper.KeeperEntity;
import io.redspace.ironsspellbooks.entity.mobs.necromancer.NecromancerEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.alchemist.ApothecaristEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.archevoker.ArchevokerEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.cryomancer.CryomancerEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.cultist.CultistEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.cursed_armor_stand.CursedArmorStandEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.fire_boss.FireBossEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.priest.PriestEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.pyromancer.PyromancerEntity;
import io.redspace.ironsspellbooks.entity.spells.root.RootEntity;
import io.redspace.ironsspellbooks.entity.spells.scapegoat.ScapegoatEntity;
import io.redspace.ironsspellbooks.entity.spells.spectral_hammer.SpectralHammer;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedClaymoreEntity;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedRapierEntity;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedSwordEntity;
import io.redspace.ironsspellbooks.entity.spells.void_tentacle.VoidTentacle;
import io.redspace.ironsspellbooks.entity.spells.wisp.WispEntity;
import io.redspace.ironsspellbooks.registries.BlockRegistry;
import io.redspace.ironsspellbooks.registries.EntityRegistry;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = IronsSpellbooks.MOD_ID)
public class CommonSetup {
    @SubscribeEvent
    public static void onModConfigLoadingEvent(ModConfigEvent.Loading event) {
        //IronsSpellbooks.LOGGER.debug("onModConfigLoadingEvent");
        if (event.getConfig().getType() == ModConfig.Type.SERVER) {
            SpellRegistry.onConfigReload();
            ServerConfigs.onConfigReload();
        } else if (event.getConfig().getType() == ModConfig.Type.CLIENT) {
            ClientConfigs.onConfigReload();
        }
    }

    @SubscribeEvent
    public static void onModConfigReloadingEvent(ModConfigEvent.Reloading event) {
        //IronsSpellbooks.LOGGER.debug("onModConfigReloadingEvent");
        if (event.getConfig().getType() == ModConfig.Type.SERVER) {
            SpellRegistry.onConfigReload();
            ServerConfigs.onConfigReload();
        } else if (event.getConfig().getType() == ModConfig.Type.CLIENT) {
            ClientConfigs.onConfigReload();
        }
    }

    @SubscribeEvent
    public static void registerCapabilitiesEvent(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, BlockRegistry.ALCHEMIST_CAULDRON_TILE.get(),
                (be, context) -> {
                    if (be.fluidCapability == null) {
                        be.refreshCapabilities();
                    }

                    return be.fluidCapability;
                });
    }

    @SubscribeEvent
    public static void addVaultCompatibleBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.VAULT, BlockRegistry.BONE_VAULT_BLOCK.get(), BlockRegistry.CINDEROUS_VAULT_BLOCK.get());
    }

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.DEBUG_WIZARD, DebugWizard.prepareAttributes().build());
        event.put(EntityRegistry.PYROMANCER, PyromancerEntity.prepareAttributes().build());
        event.put(EntityRegistry.NECROMANCER, NecromancerEntity.prepareAttributes().build());
        event.put(EntityRegistry.SPECTRAL_STEED, SummonedHorse.prepareAttributes().build());
        event.put(EntityRegistry.WISP, WispEntity.prepareAttributes().build());
        event.put(EntityRegistry.SPECTRAL_HAMMER, SpectralHammer.prepareAttributes().build());
        event.put(EntityRegistry.SUMMONED_VEX, SummonedVex.createAttributes().build());
        event.put(EntityRegistry.SUMMONED_ZOMBIE, SummonedZombie.createAttributes().build());
        event.put(EntityRegistry.SUMMONED_SKELETON, SummonedSkeleton.createAttributes().build());
        event.put(EntityRegistry.FROZEN_HUMANOID, FrozenHumanoid.prepareAttributes().build());
        event.put(EntityRegistry.SUMMONED_POLAR_BEAR, PolarBear.createAttributes().build());
        event.put(EntityRegistry.DEAD_KING, DeadKingBoss.prepareAttributes().build());
        event.put(EntityRegistry.DEAD_KING_CORPSE, DeadKingBoss.prepareAttributes().build());
        event.put(EntityRegistry.CATACOMBS_ZOMBIE, Zombie.createAttributes().build());
        event.put(EntityRegistry.MAGEHUNTER_VINDICATOR, Vindicator.createAttributes().build());
        event.put(EntityRegistry.ARCHEVOKER, ArchevokerEntity.prepareAttributes().build());
        event.put(EntityRegistry.PRIEST, PriestEntity.prepareAttributes().build());
        event.put(EntityRegistry.KEEPER, KeeperEntity.prepareAttributes().build());
        event.put(EntityRegistry.SCULK_TENTACLE, VoidTentacle.createLivingAttributes().build());
        event.put(EntityRegistry.CRYOMANCER, CryomancerEntity.prepareAttributes().build());
        event.put(EntityRegistry.ROOT, RootEntity.createLivingAttributes().build());
        event.put(EntityRegistry.FIREFLY_SWARM, WispEntity.prepareAttributes().build());
        event.put(EntityRegistry.APOTHECARIST, ApothecaristEntity.prepareAttributes().build());
        event.put(EntityRegistry.CULTIST, CultistEntity.prepareAttributes().build());
        event.put(EntityRegistry.FIRE_BOSS, FireBossEntity.prepareAttributes().build());
        event.put(EntityRegistry.CURSED_ARMOR_STAND, CursedArmorStandEntity.prepareAttributes().build());
        event.put(EntityRegistry.SUMMONED_SWORD, SummonedSwordEntity.prepareAttributes().build());
        event.put(EntityRegistry.SUMMONED_CLAYMORE, SummonedClaymoreEntity.prepareAttributes().build());
        event.put(EntityRegistry.SUMMONED_RAPIER, SummonedRapierEntity.prepareAttributes().build());
        event.put(EntityRegistry.ICE_SPIDER, IceSpiderEntity.prepareAttributes().build());
        event.put(EntityRegistry.SCAPEGOAT, ScapegoatEntity.prepareAttributes().build());
    }

    @SubscribeEvent
    public static void spawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(EntityRegistry.NECROMANCER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, serverLevelAccessor, spawnType, blockPos, random) -> Utils.checkMonsterSpawnRules(serverLevelAccessor, spawnType, blockPos, random), RegisterSpawnPlacementsEvent.Operation.OR);
    }


}
