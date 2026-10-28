package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.VisualFallingBlockEntity;
import io.redspace.ironsspellbooks.entity.mobs.*;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.DeadKingBoss;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.DeadKingCorpseEntity;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.DeadKingSoulEntity;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.undead_spawner.UndeadRiftEntity;
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
import io.redspace.ironsspellbooks.entity.mobs.wizards.fire_boss.fire_orb.OminousFireOrbEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.priest.PriestEntity;
import io.redspace.ironsspellbooks.entity.mobs.wizards.pyromancer.PyromancerEntity;
import io.redspace.ironsspellbooks.entity.spells.*;
import io.redspace.ironsspellbooks.entity.spells.acid_orb.AcidOrb;
import io.redspace.ironsspellbooks.entity.spells.ball_lightning.BallLightning;
import io.redspace.ironsspellbooks.entity.spells.black_hole.BlackHole;
import io.redspace.ironsspellbooks.entity.spells.blood_needle.BloodNeedle;
import io.redspace.ironsspellbooks.entity.spells.blood_slash.BloodSlashProjectile;
import io.redspace.ironsspellbooks.entity.spells.comet.Comet;
import io.redspace.ironsspellbooks.entity.spells.cone_of_cold.ConeOfColdProjectile;
import io.redspace.ironsspellbooks.entity.spells.creeper_head.CreeperHeadProjectile;
import io.redspace.ironsspellbooks.entity.spells.devour_jaw.DevourJaw;
import io.redspace.ironsspellbooks.entity.spells.dragon_breath.DragonBreathPool;
import io.redspace.ironsspellbooks.entity.spells.dragon_breath.DragonBreathProjectile;
import io.redspace.ironsspellbooks.entity.spells.echoing_strikes.EchoingSword;
import io.redspace.ironsspellbooks.entity.spells.echoing_strikes.EchoingArrowProjectile;
import io.redspace.ironsspellbooks.entity.spells.eldritch_blast.EldritchBlastVisualEntity;
import io.redspace.ironsspellbooks.entity.spells.electrocute.ElectrocuteProjectile;
import io.redspace.ironsspellbooks.entity.spells.ender_chain.EnderChain;
import io.redspace.ironsspellbooks.entity.spells.ender_chain.ArcaneShackleProjectile;
import io.redspace.ironsspellbooks.entity.spells.fiery_dagger.FieryDaggerEntity;
import io.redspace.ironsspellbooks.entity.spells.fire_arrow.FireArrowProjectile;
import io.redspace.ironsspellbooks.entity.spells.fire_breath.FireBreathProjectile;
import io.redspace.ironsspellbooks.entity.spells.fireball.MagicFireball;
import io.redspace.ironsspellbooks.entity.spells.fireball.SmallMagicFireball;
import io.redspace.ironsspellbooks.entity.spells.firebolt.FireboltProjectile;
import io.redspace.ironsspellbooks.entity.spells.firefly_swarm.FireflySwarmProjectile;
import io.redspace.ironsspellbooks.entity.spells.guiding_bolt.GuidingBoltProjectile;
import io.redspace.ironsspellbooks.entity.spells.gust.GustCollider;
import io.redspace.ironsspellbooks.entity.spells.ice_block.IceBlockProjectile;
import io.redspace.ironsspellbooks.entity.spells.ice_spike.IceSpikeEntity;
import io.redspace.ironsspellbooks.entity.spells.ice_tomb.IceTombEntity;
import io.redspace.ironsspellbooks.entity.spells.icicle.IcicleProjectile;
import io.redspace.ironsspellbooks.entity.spells.lightning_lance.LightningLanceProjectile;
import io.redspace.ironsspellbooks.entity.spells.magic_arrow.MagicArrowProjectile;
import io.redspace.ironsspellbooks.entity.spells.magic_missile.MagicMissileProjectile;
import io.redspace.ironsspellbooks.entity.spells.magma_ball.FireBomb;
import io.redspace.ironsspellbooks.entity.spells.magma_ball.FireField;
import io.redspace.ironsspellbooks.entity.spells.poison_arrow.PoisonArrow;
import io.redspace.ironsspellbooks.entity.spells.poison_breath.PoisonBreathProjectile;
import io.redspace.ironsspellbooks.entity.spells.poison_cloud.PoisonCloud;
import io.redspace.ironsspellbooks.entity.spells.poison_cloud.PoisonSplash;
import io.redspace.ironsspellbooks.entity.spells.portal.PortalEntity;
import io.redspace.ironsspellbooks.entity.spells.ray_of_frost.RayOfFrostVisualEntity;
import io.redspace.ironsspellbooks.entity.spells.root.RootEntity;
import io.redspace.ironsspellbooks.entity.spells.scapegoat.ScapegoatEntity;
import io.redspace.ironsspellbooks.entity.spells.shield.ShieldEntity;
import io.redspace.ironsspellbooks.entity.spells.small_magic_arrow.SmallMagicArrow;
import io.redspace.ironsspellbooks.entity.spells.snowball.FrostField;
import io.redspace.ironsspellbooks.entity.spells.snowball.Snowball;
import io.redspace.ironsspellbooks.entity.spells.spectral_hammer.SpectralHammer;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedClaymoreEntity;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedRapierEntity;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedSwordEntity;
import io.redspace.ironsspellbooks.entity.spells.sunbeam.SunbeamEntity;
import io.redspace.ironsspellbooks.entity.spells.target_area.TargetedAreaEntity;
import io.redspace.ironsspellbooks.entity.spells.thrown_item.ThrownItemProjectile;
import io.redspace.ironsspellbooks.entity.spells.thrown_spear.ThrownSpear;
import io.redspace.ironsspellbooks.entity.spells.thunderstep.ThunderstepProjectile;
import io.redspace.ironsspellbooks.entity.spells.void_tentacle.VoidTentacle;
import io.redspace.ironsspellbooks.entity.spells.wall_of_fire.WallOfFireEntity;
import io.redspace.ironsspellbooks.entity.spells.wisp.WispEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;


public class EntityRegistry {
    private static <T extends Entity> EntityType<T> register(String key, Supplier<EntityType<T>> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, val.get());
    }

    public static final EntityType<WispEntity> WISP =
            register("wisp", () -> EntityType.Builder.<WispEntity>of(WispEntity::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("wisp").toString()));

    public static final EntityType<SpectralHammer> SPECTRAL_HAMMER =
            register("spectral_hammer", () -> EntityType.Builder.<SpectralHammer>of(SpectralHammer::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("spectral_hammer").toString()));

    public static final EntityType<MagicMissileProjectile> MAGIC_MISSILE_PROJECTILE =
            register("magic_missile", () -> EntityType.Builder.<MagicMissileProjectile>of(MagicMissileProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("magic_missile").toString()));

    public static final EntityType<ThrownItemProjectile> THROWN_ITEM =
            register("thrown_item", () -> EntityType.Builder.<ThrownItemProjectile>of(ThrownItemProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("thrown_item").toString()));

    public static final EntityType<ConeOfColdProjectile> CONE_OF_COLD_PROJECTILE =
            register("cone_of_cold", () -> EntityType.Builder.<ConeOfColdProjectile>of(ConeOfColdProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("cone_of_cold").toString()));

    public static final EntityType<BloodSlashProjectile> BLOOD_SLASH_PROJECTILE =
            register("blood_slash", () -> EntityType.Builder.<BloodSlashProjectile>of(BloodSlashProjectile::new, MobCategory.MISC)
                    .sized(2f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("blood_slash").toString()));

    public static final EntityType<ElectrocuteProjectile> ELECTROCUTE_PROJECTILE =
            register("electrocute", () -> EntityType.Builder.<ElectrocuteProjectile>of(ElectrocuteProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("electrocute").toString()));

    public static final EntityType<FireboltProjectile> FIREBOLT_PROJECTILE =
            register("firebolt", () -> EntityType.Builder.<FireboltProjectile>of(FireboltProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("firebolt").toString()));

    public static final EntityType<IcicleProjectile> ICICLE_PROJECTILE =
            register("icicle", () -> EntityType.Builder.<IcicleProjectile>of(IcicleProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("icicle").toString()));

    public static final EntityType<FireBreathProjectile> FIRE_BREATH_PROJECTILE =
            register("fire_breath", () -> EntityType.Builder.<FireBreathProjectile>of(FireBreathProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("fire_breath").toString()));

    public static final EntityType<DragonBreathProjectile> DRAGON_BREATH_PROJECTILE =
            register("dragon_breath", () -> EntityType.Builder.<DragonBreathProjectile>of(DragonBreathProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("dragon_breath").toString()));

    public static final EntityType<DebugWizard> DEBUG_WIZARD =
            register("debug_wizard", () -> EntityType.Builder.<DebugWizard>of(DebugWizard::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("simple_wizard").toString()));

    public static final EntityType<SummonedHorse> SPECTRAL_STEED =
            register("spectral_steed", () -> EntityType.Builder.<SummonedHorse>of(SummonedHorse::new, MobCategory.CREATURE)
                    .sized(1.3964844F, 1.6F)
                    .clientTrackingRange(10)
                    .build(IronsSpellbooks.id("spectral_steed").toString()));

    public static final EntityType<ShieldEntity> SHIELD_ENTITY =
            register("shield", () -> EntityType.Builder.<ShieldEntity>of(ShieldEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("shield").toString()));

    public static final EntityType<WallOfFireEntity> WALL_OF_FIRE_ENTITY =
            register("wall_of_fire", () -> EntityType.Builder.<WallOfFireEntity>of(WallOfFireEntity::new, MobCategory.MISC)
                    .sized(10f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("wall_of_fire").toString()));

    public static final EntityType<SummonedVex> SUMMONED_VEX =
            register("summoned_vex", () -> EntityType.Builder.<SummonedVex>of(SummonedVex::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.8F)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("summoned_vex").toString()));

    public static final EntityType<PyromancerEntity> PYROMANCER =
            register("pyromancer", () -> EntityType.Builder.of(PyromancerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("pyromancer").toString()));

    public static final EntityType<CryomancerEntity> CRYOMANCER =
            register("cryomancer", () -> EntityType.Builder.of(CryomancerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("cryomancer").toString()));

    public static final EntityType<LightningLanceProjectile> LIGHTNING_LANCE_PROJECTILE =
            register("lightning_lance", () -> EntityType.Builder.<LightningLanceProjectile>of(LightningLanceProjectile::new, MobCategory.MISC)
                    .sized(1.25f, 1.25f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("lightning_lance").toString()));

    public static final EntityType<NecromancerEntity> NECROMANCER =
            register("necromancer", () -> EntityType.Builder.of(NecromancerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("necromancer").toString()));

    public static final EntityType<SummonedZombie> SUMMONED_ZOMBIE =
            register("summoned_zombie", () -> EntityType.Builder.<SummonedZombie>of(SummonedZombie::new, MobCategory.MISC)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("summoned_zombie").toString()));

    public static final EntityType<SummonedSkeleton> SUMMONED_SKELETON =
            register("summoned_skeleton", () -> EntityType.Builder.<SummonedSkeleton>of(SummonedSkeleton::new, MobCategory.MISC)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("summoned_skeleton").toString()));


    public static final EntityType<WitherSkullProjectile> WITHER_SKULL_PROJECTILE =
            register("wither_skull", () -> EntityType.Builder.<WitherSkullProjectile>of(WitherSkullProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("wither_skull").toString()));

    public static final EntityType<MagicArrowProjectile> MAGIC_ARROW_PROJECTILE =
            register("magic_arrow", () -> EntityType.Builder.<MagicArrowProjectile>of(MagicArrowProjectile::new, MobCategory.MISC)
                    .sized(.8f, .8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("magic_arrow").toString()));

    public static final EntityType<CreeperHeadProjectile> CREEPER_HEAD_PROJECTILE =
            register("creeper_head", () -> EntityType.Builder.<CreeperHeadProjectile>of(CreeperHeadProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("creeper_head").toString()));

    public static final EntityType<FrozenHumanoid> FROZEN_HUMANOID =
            register("frozen_humanoid", () -> EntityType.Builder.<FrozenHumanoid>of(FrozenHumanoid::new, MobCategory.MISC)
                    .sized(0.6F, 1.8F)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("frozen_humanoid").toString()));

    public static final EntityType<SmallMagicFireball> SMALL_FIREBALL_PROJECTILE =
            register("small_fireball", () -> EntityType.Builder.<SmallMagicFireball>of(SmallMagicFireball::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("small_fireball").toString()));

    public static final EntityType<MagicFireball> MAGIC_FIREBALL =
            register("fireball", () -> EntityType.Builder.<MagicFireball>of(MagicFireball::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(IronsSpellbooks.id("fireball").toString()));

    public static final EntityType<SummonedPolarBear> SUMMONED_POLAR_BEAR =
            register("summoned_polar_bear", () -> EntityType.Builder.<SummonedPolarBear>of(SummonedPolarBear::new, MobCategory.CREATURE)
                    .immuneTo(Blocks.POWDER_SNOW)
                    .sized(1.4F, 1.4F)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("summoned_polar_bear").toString()));

    public static final EntityType<DeadKingBoss> DEAD_KING =
            register("dead_king", () -> EntityType.Builder.<DeadKingBoss>of(DeadKingBoss::new, MobCategory.MONSTER)
                    .sized(.9f, 3.5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("dead_king").toString()));

    public static final EntityType<DeadKingCorpseEntity> DEAD_KING_CORPSE =
            register("dead_king_corpse", () -> EntityType.Builder.<DeadKingCorpseEntity>of(DeadKingCorpseEntity::new, MobCategory.MISC)
                    .sized(1.5f, .95f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("dead_king_corpse").toString()));

    public static final EntityType<DeadKingSoulEntity> DEAD_KING_SOUL =
            register("dead_king_soul", () -> EntityType.Builder.<DeadKingSoulEntity>of(DeadKingSoulEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("dead_king_soul").toString()));

    public static final EntityType<CatacombsZombie> CATACOMBS_ZOMBIE =
            register("catacombs_zombie", () -> EntityType.Builder.<CatacombsZombie>of(CatacombsZombie::new, MobCategory.MONSTER)
                    .sized(1.5f, .95f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("catacombs_zombie").toString()));

//    public static final EntityType<CatacombsSkeletonHorse> CATACOMBS_SKELETON_HORSE =
//            register("catacombs_skeleton_horse", () -> EntityType.Builder.<CatacombsSkeletonHorse>of(CatacombsSkeletonHorse::new, MobCategory.MONSTER)
//                    .sized(1.5f, .95f)
//                    .clientTrackingRange(64)
//                    .build(ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "catacombs_skeleton_horse").toString()));

    public static final EntityType<ArchevokerEntity> ARCHEVOKER =
            register("archevoker", () -> EntityType.Builder.of(ArchevokerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("archevoker").toString()));

    public static final EntityType<MagehunterVindicator> MAGEHUNTER_VINDICATOR =
            register("magehunter_vindicator", () -> EntityType.Builder.<MagehunterVindicator>of(MagehunterVindicator::new, MobCategory.MONSTER)
                    .sized(1.5f, .95f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("magehunter_vindicator").toString()));

    public static final EntityType<KeeperEntity> KEEPER =
            register("citadel_keeper", () -> EntityType.Builder.<KeeperEntity>of(KeeperEntity::new, MobCategory.MONSTER)
                    .sized(.85f, 2.3f)
                    .clientTrackingRange(64)
                    .eyeHeight(2.3f)
                    .build(IronsSpellbooks.id("citadel_keeper").toString()));

    public static final EntityType<FireBossEntity> FIRE_BOSS =
            register("fire_boss", () -> EntityType.Builder.<FireBossEntity>of(FireBossEntity::new, MobCategory.MONSTER)
                    .sized(.85f, 2.1f)
                    .clientTrackingRange(64)
                    .fireImmune()
                    .build(IronsSpellbooks.id("fire_boss").toString()));

    public static final EntityType<VoidTentacle> SCULK_TENTACLE =
            register("sculk_tentacle", () -> EntityType.Builder.<VoidTentacle>of(VoidTentacle::new, MobCategory.MISC)
                    .sized(2.5f, 5.5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("sculk_tentacle").toString()));

    public static final EntityType<IceBlockProjectile> ICE_BLOCK_PROJECTILE =
            register("ice_block_projectile", () -> EntityType.Builder.<IceBlockProjectile>of(IceBlockProjectile::new, MobCategory.MISC)
                    .sized(1.25f, 1)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("ice_block_projectile").toString()));

    public static final EntityType<PoisonCloud> POISON_CLOUD =
            register("poison_cloud", () -> EntityType.Builder.<PoisonCloud>of(PoisonCloud::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("poison_cloud").toString()));

    public static final EntityType<SunbeamEntity> SUNBEAM =
            register("sunbeam", () -> EntityType.Builder.<SunbeamEntity>of(SunbeamEntity::new, MobCategory.MISC)
                    .sized(1.5f, 14f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("sunbeam").toString()));

    public static final EntityType<DragonBreathPool> DRAGON_BREATH_POOL =
            register("dragon_breath_pool", () -> EntityType.Builder.<DragonBreathPool>of(DragonBreathPool::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("dragon_breath_pool").toString()));

    public static final EntityType<PoisonBreathProjectile> POISON_BREATH_PROJECTILE =
            register("poison_breath", () -> EntityType.Builder.<PoisonBreathProjectile>of(PoisonBreathProjectile::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("poison_breath").toString()));

    public static final EntityType<PoisonArrow> POISON_ARROW =
            register("poison_arrow", () -> EntityType.Builder.<PoisonArrow>of(PoisonArrow::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("poison_arrow").toString()));

    public static final EntityType<SmallMagicArrow> SMALL_MAGIC_ARROW =
            register("small_magic_arrow", () -> EntityType.Builder.<SmallMagicArrow>of(SmallMagicArrow::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("small_magic_arrow").toString()));

    public static final EntityType<PoisonSplash> POISON_SPLASH =
            register("poison_splash", () -> EntityType.Builder.<PoisonSplash>of(PoisonSplash::new, MobCategory.MISC)
                    .sized(3.5f, 4f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("poison_splash").toString()));

    public static final EntityType<AcidOrb> ACID_ORB =
            register("acid_orb", () -> EntityType.Builder.<AcidOrb>of(AcidOrb::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("acid_orb").toString()));

    public static final EntityType<RootEntity> ROOT =
            register("root", () -> EntityType.Builder.<RootEntity>of(RootEntity::new, MobCategory.MISC)
                    .sized(1, 1)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("root").toString()));

    public static final EntityType<BlackHole> BLACK_HOLE =
            register("black_hole", () -> EntityType.Builder.<BlackHole>of(BlackHole::new, MobCategory.MISC)
                    .sized(11, 11)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("black_hole").toString()));

    public static final EntityType<BloodNeedle> BLOOD_NEEDLE =
            register("blood_needle", () -> EntityType.Builder.<BloodNeedle>of(BloodNeedle::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("blood_needle").toString()));

    public static final EntityType<FireField> FIRE_FIELD =
            register("fire_field", () -> EntityType.Builder.<FireField>of(FireField::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("fire_field").toString()));

    public static final EntityType<FireBomb> FIRE_BOMB =
            register("magma_ball", () -> EntityType.Builder.<FireBomb>of(FireBomb::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("magma_ball").toString()));

    public static final EntityType<Comet> COMET =
            register("comet", () -> EntityType.Builder.<Comet>of(Comet::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("comet").toString()));

    public static final EntityType<TargetedAreaEntity> TARGET_AREA_ENTITY =
            register("target_area", () -> EntityType.Builder.<TargetedAreaEntity>of(TargetedAreaEntity::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("target_area").toString()));

    public static final EntityType<HealingAoe> HEALING_AOE =
            register("healing_aoe", () -> EntityType.Builder.<HealingAoe>of(HealingAoe::new, MobCategory.MISC)
                    .sized(4f, .8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("healing_aoe").toString()));

    public static final EntityType<EarthquakeAoe> EARTHQUAKE_AOE =
            register("earthquake_aoe", () -> EntityType.Builder.<EarthquakeAoe>of(EarthquakeAoe::new, MobCategory.MISC)
                    .sized(4f, .8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("earthquake_aoe").toString()));

    public static final EntityType<BlizzardAoe> BLIZZARD_AOE =
            register("blizzard_aoe", () -> EntityType.Builder.<BlizzardAoe>of(BlizzardAoe::new, MobCategory.MISC)
                    .sized(4f, BlizzardAoe.HEIGHT)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("blizzard_aoe").toString()));

    public static final EntityType<PriestEntity> PRIEST =
            register("priest", () -> EntityType.Builder.of(PriestEntity::new, MobCategory.CREATURE)
                    .sized(.6f, 2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("priest").toString()));


    public static final EntityType<VisualFallingBlockEntity> FALLING_BLOCK =
            register("visual_falling_block", () -> EntityType.Builder.<VisualFallingBlockEntity>of(VisualFallingBlockEntity::new, MobCategory.MISC)
                    .sized(0.98F, 0.98F)
                    .clientTrackingRange(10)
                    .updateInterval(20)
                    .build(IronsSpellbooks.id("visual_falling_block").toString()));

    public static final EntityType<GuidingBoltProjectile> GUIDING_BOLT =
            register("guiding_bolt", () -> EntityType.Builder.<GuidingBoltProjectile>of(GuidingBoltProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("guiding_bolt").toString()));

    public static final EntityType<GustCollider> GUST_COLLIDER =
            register("gust", () -> EntityType.Builder.<GustCollider>of(GustCollider::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("gust").toString()));

    public static final EntityType<ChainLightning> CHAIN_LIGHTNING =
            register("chain_lightning", () -> EntityType.Builder.<ChainLightning>of(ChainLightning::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("chain_lightning").toString()));

    public static final EntityType<RayOfFrostVisualEntity> RAY_OF_FROST_VISUAL_ENTITY =
            register("ray_of_frost", () -> EntityType.Builder.<RayOfFrostVisualEntity>of(RayOfFrostVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("ray_of_frost").toString()));

    public static final EntityType<EldritchBlastVisualEntity> ELDRITCH_BLAST_VISUAL_ENTITY =
            register("eldritch_blast", () -> EntityType.Builder.<EldritchBlastVisualEntity>of(EldritchBlastVisualEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("eldritch_blast").toString()));

    public static final EntityType<DevourJaw> DEVOUR_JAW =
            register("devour_jaw", () -> EntityType.Builder.<DevourJaw>of(DevourJaw::new, MobCategory.MISC)
                    .sized(2f, 2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("devour_jaw").toString()));

    public static final EntityType<FireflySwarmProjectile> FIREFLY_SWARM =
            register("firefly_swarm", () -> EntityType.Builder.<FireflySwarmProjectile>of(FireflySwarmProjectile::new, MobCategory.MISC)
                    .sized(.9f, .9f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("firefly_swarm").toString()));

    public static final EntityType<ArrowVolleyEntity> ARROW_VOLLEY_ENTITY =
            register("arrow_volley", () -> EntityType.Builder.<ArrowVolleyEntity>of(ArrowVolleyEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("arrow_volley").toString()));

    public static final EntityType<PortalEntity> PORTAL =
            register("portal", () -> EntityType.Builder.<PortalEntity>of(PortalEntity::new, MobCategory.MISC)
                    .sized(.8f, 2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("portal").toString()));

    public static final EntityType<StompAoe> STOMP_AOE =
            register("stomp_aoe", () -> EntityType.Builder.<StompAoe>of(StompAoe::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("stomp_aoe").toString()));

    public static final EntityType<LightningStrike> LIGHTNING_STRIKE =
            register("lightning_strike", () -> EntityType.Builder.<LightningStrike>of(LightningStrike::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("lightning_strike").toString()));

    public static final EntityType<ApothecaristEntity> APOTHECARIST =
            register("apothecarist", () -> EntityType.Builder.of(ApothecaristEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("apothecarist").toString()));

    public static final EntityType<EchoingStrikeEntity> ECHOING_STRIKE =
            register("echoing_strike", () -> EntityType.Builder.<EchoingStrikeEntity>of(EchoingStrikeEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("echoing_strike").toString()));

    public static final EntityType<CultistEntity> CULTIST =
            register("cultist", () -> EntityType.Builder.of(CultistEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("cultist").toString()));

    public static final EntityType<BallLightning> BALL_LIGHTNING =
            register("ball_lightning", () -> EntityType.Builder.<BallLightning>of(BallLightning::new, MobCategory.MISC)
                    .sized(1.1f, 1.1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("ball_lightning").toString()));

    public static final EntityType<IceSpikeEntity> ICE_SPIKE =
            register("ice_spike", () -> EntityType.Builder.<IceSpikeEntity>of(IceSpikeEntity::new, MobCategory.MISC)
                    .sized(1f, 2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("ice_spike").toString()));

    public static final EntityType<FireArrowProjectile> FIRE_ARROW_PROJECTILE =
            register("fire_arrow", () -> EntityType.Builder.<FireArrowProjectile>of(FireArrowProjectile::new, MobCategory.MISC)
                    .sized(.8f, .8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("fire_arrow").toString()));

    public static final EntityType<FireEruptionAoe> FIRE_ERUPTION_AOE =
            register("fire_eruption", () -> EntityType.Builder.<FireEruptionAoe>of(FireEruptionAoe::new, MobCategory.MISC)
                    .sized(4f, .8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("fire_eruption").toString()));

    public static final EntityType<FieryDaggerEntity> FIERY_DAGGER_PROJECTILE =
            register("fiery_dagger", () -> EntityType.Builder.<FieryDaggerEntity>of(FieryDaggerEntity::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("fiery_dagger").toString()));

    public static final EntityType<CursedArmorStandEntity> CURSED_ARMOR_STAND =
            register("cursed_armor_stand", () -> EntityType.Builder.of(CursedArmorStandEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("cursed_armor_stand").toString()));

    public static final EntityType<ThunderstepProjectile> THUNDERSTEP_PROJECTILE =
            register("thunderstep_orb", () -> EntityType.Builder.<ThunderstepProjectile>of(ThunderstepProjectile::new, MobCategory.MISC)
                    .sized(.5f, .5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("thunderstep_orb").toString()));

    public static final EntityType<SummonedSwordEntity> SUMMONED_SWORD =
            register("summoned_sword", () -> EntityType.Builder.<SummonedSwordEntity>of(SummonedSwordEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("summoned_sword").toString()));

    public static final EntityType<SummonedClaymoreEntity> SUMMONED_CLAYMORE =
            register("summoned_claymore", () -> EntityType.Builder.<SummonedClaymoreEntity>of(SummonedClaymoreEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("summoned_claymore").toString()));

    public static final EntityType<SummonedRapierEntity> SUMMONED_RAPIER =
            register("summoned_rapier", () -> EntityType.Builder.<SummonedRapierEntity>of(SummonedRapierEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("summoned_rapier").toString()));

    public static final EntityType<IceSpiderEntity> ICE_SPIDER =
            register("ice_spider", () -> EntityType.Builder.<IceSpiderEntity>of(IceSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.75f, 1.9f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("ice_spider").toString()));

    public static final EntityType<IceTombEntity> ICE_TOMB =
            register("ice_tomb", () -> EntityType.Builder.<IceTombEntity>of(IceTombEntity::new, MobCategory.MISC)
                    .sized(1, 2.2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("ice_tomb").toString()));

    public static final EntityType<Snowball> SNOWBALL =
            register("snowball", () -> EntityType.Builder.<Snowball>of(Snowball::new, MobCategory.MISC)
                    .sized(0.75F, 0.75F)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("snowball").toString()));

    public static final EntityType<FrostField> FROST_FIELD =
            register("frost_field", () -> EntityType.Builder.<FrostField>of(FrostField::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("frost_field").toString()));

    public static final EntityType<ThrownSpear> THROWN_SPEAR =
            register("spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("spear").toString()));

    public static final EntityType<OminousFireOrbEntity> OMINOUS_FIRE_ORB =
            register("ominous_fire_orb", () -> EntityType.Builder.<OminousFireOrbEntity>of(OminousFireOrbEntity::new, MobCategory.MISC)
                    .sized(1.2f, 2.6f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("ominous_fire_orb").toString()));

    public static final EntityType<UndeadRiftEntity> UNDEAD_RIFT =
            register("undead_rift", () -> EntityType.Builder.<UndeadRiftEntity>of(UndeadRiftEntity::new, MobCategory.MISC)
                    .sized(.8f, 2f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("undead_rift").toString()));

    public static final EntityType<FangSwirlEntity> FANG_SWIRL =
            register("fang_swirl", () -> EntityType.Builder.<FangSwirlEntity>of(FangSwirlEntity::new, MobCategory.MISC)
                    .sized(4f, .8f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("fang_swirl").toString()));

    public static final EntityType<ArcaneShackleProjectile> ARCANE_SHACKLE =
            register("arcane_shackle", () -> EntityType.Builder.<ArcaneShackleProjectile>of(ArcaneShackleProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("arcane_shackle").toString()));

    public static final EntityType<EnderChain> ENDER_CHAIN =
            register("ender_chain", () -> EntityType.Builder.<EnderChain>of(EnderChain::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("ender_chain").toString()));

    public static final EntityType<EchoingSword> ECHOING_SWORD =
            register("echoing_sword", () -> EntityType.Builder.<EchoingSword>of(EchoingSword::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("echoing_sword").toString()));

    public static final EntityType<EchoingArrowProjectile> ECHOING_ARROW =
            register("echoing_arrow", () -> EntityType.Builder.<EchoingArrowProjectile>of(EchoingArrowProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("echoing_arrow").toString()));

    public static final EntityType<ScapegoatEntity> SCAPEGOAT =
            register("scapegoat", () -> EntityType.Builder.<ScapegoatEntity>of(ScapegoatEntity::new, MobCategory.MISC)
                    .sized(0.9F, 1.3F)
                    .clientTrackingRange(64)
                    .build(IronsSpellbooks.id("scapegoat").toString()));
}

