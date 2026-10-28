package io.redspace.ironsspellbooks.setup;

import io.redspace.ironslib.statue.block.statue_block.decorative.DecorativeStatueItemClientExtensions;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.block.alchemist_cauldron.AlchemistCauldronRenderer;
import io.redspace.ironsspellbooks.block.pedestal.PedestalRenderer;
import io.redspace.ironsspellbooks.block.portal_frame.PortalFrameRenderer;
import io.redspace.ironsspellbooks.block.scroll_forge.ScrollForgeRenderer;
import io.redspace.ironsspellbooks.block.statue.tyros_statue.TyrosStatueBlockRenderer;
import io.redspace.ironsspellbooks.effect.PlanarSightEffect;
import io.redspace.ironsspellbooks.entity.VisualFallingBlockRenderer;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.DeadKingRenderer;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.DeadKingSoulRenderer;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.undead_spawner.UndeadRiftRenderer;
import io.redspace.ironsspellbooks.entity.mobs.debug_wizard.DebugWizardRenderer;
import io.redspace.ironsspellbooks.entity.mobs.frozen_humanoid.FrozenHumanoidRenderer;
import io.redspace.ironsspellbooks.entity.mobs.horse.SpectralSteedRenderer;
import io.redspace.ironsspellbooks.entity.mobs.ice_spider.IceSpiderRenderer;
import io.redspace.ironsspellbooks.entity.mobs.keeper.KeeperRenderer;
import io.redspace.ironsspellbooks.entity.mobs.necromancer.NecromancerRenderer;
import io.redspace.ironsspellbooks.entity.mobs.raise_dead_summons.SummonedSkeletonMultiRenderer;
import io.redspace.ironsspellbooks.entity.mobs.raise_dead_summons.SummonedZombieMultiRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.alchemist.ApothecaristRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.archevoker.ArchevokerRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.cryomancer.CryomancerRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.cultist.CultistRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.cursed_armor_stand.CursedArmorStandRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.fire_boss.FireBossRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.fire_boss.fire_orb.OminousFireOrbRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.priest.PriestRenderer;
import io.redspace.ironsspellbooks.entity.mobs.wizards.pyromancer.PyromancerRenderer;
import io.redspace.ironsspellbooks.entity.spells.acid_orb.AcidOrbRenderer;
import io.redspace.ironsspellbooks.entity.spells.ball_lightning.BallLightningRenderer;
import io.redspace.ironsspellbooks.entity.spells.black_hole.BlackHoleRenderer;
import io.redspace.ironsspellbooks.entity.spells.blood_needle.BloodNeedleRenderer;
import io.redspace.ironsspellbooks.entity.spells.blood_slash.BloodSlashRenderer;
import io.redspace.ironsspellbooks.entity.spells.comet.CometRenderer;
import io.redspace.ironsspellbooks.entity.spells.devour_jaw.DevourJawRenderer;
import io.redspace.ironsspellbooks.entity.spells.echoing_strikes.EchoingMagicArrowRenderer;
import io.redspace.ironsspellbooks.entity.spells.echoing_strikes.EchoingSwordModel;
import io.redspace.ironsspellbooks.entity.spells.echoing_strikes.MagicSwordRenderer;
import io.redspace.ironsspellbooks.entity.spells.eldritch_blast.EldritchBlastRenderer;
import io.redspace.ironsspellbooks.entity.spells.electrocute.ElectrocuteRenderer;
import io.redspace.ironsspellbooks.entity.spells.ender_chain.ArcaneShackleRenderer;
import io.redspace.ironsspellbooks.entity.spells.ender_chain.EnderChainRenderer;
import io.redspace.ironsspellbooks.entity.spells.fiery_dagger.FieryDaggerRenderer;
import io.redspace.ironsspellbooks.entity.spells.fire_arrow.FireArrowRenderer;
import io.redspace.ironsspellbooks.entity.spells.fireball.FireballRenderer;
import io.redspace.ironsspellbooks.entity.spells.firebolt.FireboltRenderer;
import io.redspace.ironsspellbooks.entity.spells.guiding_bolt.GuidingBoltRenderer;
import io.redspace.ironsspellbooks.entity.spells.gust.GustRenderer;
import io.redspace.ironsspellbooks.entity.spells.ice_block.IceBlockRenderer;
import io.redspace.ironsspellbooks.entity.spells.ice_spike.IceSpikeRenderer;
import io.redspace.ironsspellbooks.entity.spells.ice_tomb.IceTombRenderer;
import io.redspace.ironsspellbooks.entity.spells.icicle.IcicleRenderer;
import io.redspace.ironsspellbooks.entity.spells.lightning_lance.LightningLanceRenderer;
import io.redspace.ironsspellbooks.entity.spells.magic_arrow.MagicArrowRenderer;
import io.redspace.ironsspellbooks.entity.spells.magic_missile.MagicMissileRenderer;
import io.redspace.ironsspellbooks.entity.spells.magma_ball.MagmaBallRenderer;
import io.redspace.ironsspellbooks.entity.spells.poison_arrow.PoisonArrowRenderer;
import io.redspace.ironsspellbooks.entity.spells.portal.PortalRenderer;
import io.redspace.ironsspellbooks.entity.spells.ray_of_frost.RayOfFrostRenderer;
import io.redspace.ironsspellbooks.entity.spells.root.RootRenderer;
import io.redspace.ironsspellbooks.entity.spells.scapegoat.ScapegoatRenderer;
import io.redspace.ironsspellbooks.entity.spells.shield.ShieldModel;
import io.redspace.ironsspellbooks.entity.spells.shield.ShieldRenderer;
import io.redspace.ironsspellbooks.entity.spells.shield.ShieldTrimModel;
import io.redspace.ironsspellbooks.entity.spells.skull_projectile.SkullProjectileRenderer;
import io.redspace.ironsspellbooks.entity.spells.small_magic_arrow.SmallMagicArrowRenderer;
import io.redspace.ironsspellbooks.entity.spells.snowball.SnowballRenderer;
import io.redspace.ironsspellbooks.entity.spells.spectral_hammer.SpectralHammerRenderer;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedClaymoreModel;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedRapierModel;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedSwordModel;
import io.redspace.ironsspellbooks.entity.spells.summoned_weapons.SummonedSwordRenderer;
import io.redspace.ironsspellbooks.entity.spells.sunbeam.SunbeamRenderer;
import io.redspace.ironsspellbooks.entity.spells.target_area.TargetAreaRenderer;
import io.redspace.ironsspellbooks.entity.spells.thrown_item.ThrownItemRenderer;
import io.redspace.ironsspellbooks.entity.spells.thrown_spear.ThrownSpearRenderer;
import io.redspace.ironsspellbooks.entity.spells.thunderstep.ThunderstepProjectileRenderer;
import io.redspace.ironsspellbooks.entity.spells.void_tentacle.VoidTentacleRenderer;
import io.redspace.ironsspellbooks.entity.spells.wisp.WispRenderer;
import io.redspace.ironsspellbooks.fluids.PotionClientFluidType;
import io.redspace.ironsspellbooks.fluids.SimpleClientFluidType;
import io.redspace.ironsspellbooks.fluids.SimpleTintedClientFluidType;
import io.redspace.ironsspellbooks.gui.arcane_anvil.ArcaneAnvilScreen;
import io.redspace.ironsspellbooks.gui.inscription_table.InscriptionTableScreen;
import io.redspace.ironsspellbooks.gui.scroll_forge.ScrollForgeScreen;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.WaywardCompass;
import io.redspace.ironsspellbooks.item.curios.AffinityRing;
import io.redspace.ironsspellbooks.item.weapons.AutoloaderCrossbow;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.item.weapons.pyrium_staff.PyriumStaffClientExtensions;
import io.redspace.ironsspellbooks.item.weapons.pyrium_staff.PyriumStaffHeadModel;
import io.redspace.ironsspellbooks.item.weapons.pyrium_staff.PyriumStaffOrbModel;
import io.redspace.ironsspellbooks.particle.AcidBubbleParticle;
import io.redspace.ironsspellbooks.particle.AcidParticle;
import io.redspace.ironsspellbooks.particle.BlastwaveParticle;
import io.redspace.ironsspellbooks.particle.BloodGroundParticle;
import io.redspace.ironsspellbooks.particle.BloodParticle;
import io.redspace.ironsspellbooks.particle.CleanseParticle;
import io.redspace.ironsspellbooks.particle.DragonFireParticle;
import io.redspace.ironsspellbooks.particle.ElectricityParticle;
import io.redspace.ironsspellbooks.particle.EmberParticle;
import io.redspace.ironsspellbooks.particle.EmberousAshParticle;
import io.redspace.ironsspellbooks.particle.EnderSlashParticle;
import io.redspace.ironsspellbooks.particle.FallingBlockParticle;
import io.redspace.ironsspellbooks.particle.FallingSparkleParticle;
import io.redspace.ironsspellbooks.particle.FierySmokeParticle;
import io.redspace.ironsspellbooks.particle.FireParticle;
import io.redspace.ironsspellbooks.particle.FireflyParticle;
import io.redspace.ironsspellbooks.particle.FlameStrikeParticle;
import io.redspace.ironsspellbooks.particle.FogParticle;
import io.redspace.ironsspellbooks.particle.PortalFrameParticle;
import io.redspace.ironsspellbooks.particle.RingSmokeParticle;
import io.redspace.ironsspellbooks.particle.ShockwaveParticle;
import io.redspace.ironsspellbooks.particle.SiphonParticle;
import io.redspace.ironsspellbooks.particle.SnowDustParticle;
import io.redspace.ironsspellbooks.particle.SnowflakeParticle;
import io.redspace.ironsspellbooks.particle.SoulfireRayParticle;
import io.redspace.ironsspellbooks.particle.SparkParticle;
import io.redspace.ironsspellbooks.particle.SwirlingParticle;
import io.redspace.ironsspellbooks.particle.TintedBubblePopParticle;
import io.redspace.ironsspellbooks.particle.TraceParticle;
import io.redspace.ironsspellbooks.particle.UnstableEnderParticle;
import io.redspace.ironsspellbooks.particle.WispParticle;
import io.redspace.ironsspellbooks.particle.ZapParticle;
import io.redspace.ironsspellbooks.registries.BlockRegistry;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.registries.EntityRegistry;
import io.redspace.ironsspellbooks.registries.FluidRegistry;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.registries.MenuRegistry;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.registries.ParticleRegistry;
import io.redspace.ironsspellbooks.render.AffinityRingRenderer;
import io.redspace.ironsspellbooks.render.AngelWingsLayer;
import io.redspace.ironsspellbooks.render.AngelWingsModel;
import io.redspace.ironsspellbooks.render.ArmorCapeLayer;
import io.redspace.ironsspellbooks.render.ChargeSpellLayer;
import io.redspace.ironsspellbooks.render.ClientStaffItemExtensions;
import io.redspace.ironsspellbooks.render.EchoingStrikesHologramLayer;
import io.redspace.ironsspellbooks.render.EnergySwirlLayer;
import io.redspace.ironsspellbooks.render.GlowingEyesLayer;
import io.redspace.ironsspellbooks.render.PocketDimensionEffects;
import io.redspace.ironsspellbooks.render.ReplacedFireballRenderer;
import io.redspace.ironsspellbooks.render.ScrollModel;
import io.redspace.ironsspellbooks.render.SpectralItemModel;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import io.redspace.ironsspellbooks.render.SpellTargetingLayer;
import io.redspace.ironsspellbooks.render.animation.AnimationHelper;
import io.redspace.ironsspellbooks.util.IMinecraftInstanceHelper;
import io.redspace.ironsspellbooks.util.MinecraftInstanceHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.client.renderer.entity.PolarBearRenderer;
import net.minecraft.client.renderer.entity.VexRenderer;
import net.minecraft.client.renderer.item.CompassItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import static io.redspace.ironsspellbooks.render.EnergySwirlLayer.CHARGE_TEXTURE;
import static io.redspace.ironsspellbooks.render.EnergySwirlLayer.EVASION_TEXTURE;

@EventBusSubscriber(modid = IronsSpellbooks.MOD_ID, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void registerDimensionEffects(RegisterDimensionSpecialEffectsEvent event) {
        event.register(IronsSpellbooks.id("pocket_dimension"), new PocketDimensionEffects());
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new ClientStaffItemExtensions(), ItemRegistry.getIronsItems().stream().filter(item -> item.get() instanceof StaffItem staffItem && !staffItem.hasCustomRendering()).map(holder -> (Item) holder.get()).toArray(Item[]::new));
        event.registerItem(new PyriumStaffClientExtensions(), ItemRegistry.PYRIUM_STAFF.get());
        event.registerItem(new AffinityRing.ClientExtension(), ItemRegistry.AFFINITY_RING.get());
        event.registerItem(new DecorativeStatueItemClientExtensions(BlockRegistry.TYROS_STATUE_BLOCK::get, BlockRegistry.TYROS_STATUE_BLOCK_ENTITY), ItemRegistry.TYROS_STATUE_BLOCK_ITEM.get());
    }

    @SubscribeEvent
    public static void registerDyeables(RegisterColorHandlersEvent.Item event) {
        // Wizard Armor (default blue)
        event.register(
                (stack, layer) -> layer > 0 ? -1 : DyedItemColor.getOrDefault(stack, 0xFFb8e5f3),
                ItemRegistry.WIZARD_BOOTS.get(), ItemRegistry.WIZARD_LEGGINGS.get(), ItemRegistry.WIZARD_CHESTPLATE.get(), ItemRegistry.WIZARD_HELMET.get(), ItemRegistry.WIZARD_HAT.get());
        // Netherite Armor (default red)
        event.register(
                (stack, layer) -> layer > 0 ? -1 : DyedItemColor.getOrDefault(stack, 0xFF8c4141),
                ItemRegistry.NETHERITE_MAGE_BOOTS.get(), ItemRegistry.NETHERITE_MAGE_LEGGINGS.get(), ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get(), ItemRegistry.NETHERITE_MAGE_HELMET.get());
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        //LayerDefinition basicHumanLayer = LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64);

        //See LayerDefinitions.createRoots
        LayerDefinition energyOverlayLayer = LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.5F), 0.0F), 64, 64);
        LayerDefinition outerLayer = LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32);
        LayerDefinition innerLayer = LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.INNER_ARMOR_DEFORMATION, 0.0F), 64, 32);

        event.registerLayerDefinition(ShieldModel.LAYER_LOCATION, ShieldModel::createBodyLayer);
        event.registerLayerDefinition(AcidOrbRenderer.MODEL_LAYER_LOCATION, AcidOrbRenderer::createBodyLayer);
        event.registerLayerDefinition(GustRenderer.MODEL_LAYER_LOCATION, GustRenderer::createBodyLayer);
        event.registerLayerDefinition(RayOfFrostRenderer.MODEL_LAYER_LOCATION, RayOfFrostRenderer::createBodyLayer);
        event.registerLayerDefinition(EldritchBlastRenderer.MODEL_LAYER_LOCATION, EldritchBlastRenderer::createBodyLayer);
        event.registerLayerDefinition(FireballRenderer.MODEL_LAYER_LOCATION, FireballRenderer::createBodyLayer);
        event.registerLayerDefinition(FireboltRenderer.MODEL_LAYER_LOCATION, FireboltRenderer::createBodyLayer);
        event.registerLayerDefinition(GuidingBoltRenderer.MODEL_LAYER_LOCATION, GuidingBoltRenderer::createBodyLayer);
        event.registerLayerDefinition(IcicleRenderer.MODEL_LAYER_LOCATION, IcicleRenderer::createBodyLayer);
        event.registerLayerDefinition(ShieldTrimModel.LAYER_LOCATION, ShieldTrimModel::createBodyLayer);
        event.registerLayerDefinition(AngelWingsModel.ANGEL_WINGS_LAYER, AngelWingsModel::createLayer);
        event.registerLayerDefinition(EnergySwirlLayer.Vanilla.ENERGY_LAYER, () -> energyOverlayLayer);
        event.registerLayerDefinition(BallLightningRenderer.MODEL_LAYER_LOCATION, BallLightningRenderer::createBodyLayer);
        event.registerLayerDefinition(SkullProjectileRenderer.MODEL_LAYER_LOCATION, SkullProjectileRenderer::createBodyLayer);
        event.registerLayerDefinition(ArmorCapeLayer.ARMOR_CAPE_LAYER, ArmorCapeLayer::createBodyLayer);
        event.registerLayerDefinition(IceSpikeRenderer.IceSpikeModel.LAYER_LOCATION, IceSpikeRenderer.IceSpikeModel::createBodyLayer);
        event.registerLayerDefinition(IceTombRenderer.IceTombModel.LAYER_LOCATION, IceTombRenderer.IceTombModel::createBodyLayer);
        event.registerLayerDefinition(PyriumStaffHeadModel.LAYER_LOCATION, PyriumStaffHeadModel::createBodyLayer);
        event.registerLayerDefinition(PyriumStaffOrbModel.LAYER_LOCATION, PyriumStaffOrbModel::createBodyLayer);
        event.registerLayerDefinition(DeadKingSoulRenderer.MODEL_LAYER_LOCATION, DeadKingSoulRenderer::createBodyLayer);
        event.registerLayerDefinition(DeadKingSoulRenderer.CROWN_CUBE_LAYER_LOCATION, DeadKingSoulRenderer::createCrownCubeLayer);
    }

    @SubscribeEvent
    public static void registerMenuScreen(RegisterMenuScreensEvent event) {
        event.register(MenuRegistry.INSCRIPTION_TABLE_MENU.get(), InscriptionTableScreen::new);
        event.register(MenuRegistry.SCROLL_FORGE_MENU.get(), ScrollForgeScreen::new);
        event.register(MenuRegistry.ARCANE_ANVIL_MENU.get(), ArcaneAnvilScreen::new);
    }

    @SubscribeEvent
    public static void replaceRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityType.SMALL_FIREBALL, (context) -> new ReplacedFireballRenderer(context, 0.75f, .75f));
        event.registerEntityRenderer(EntityType.FIREBALL, (context) -> new ReplacedFireballRenderer(context, 1.25f, 3f));
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.AddLayers event) {
        addLayerToPlayerSkin(event, PlayerSkin.Model.SLIM);
        addLayerToPlayerSkin(event, PlayerSkin.Model.WIDE);
        for (EntityType type : event.getEntityTypes()) {
            var renderer = event.getRenderer(type);
            if (renderer instanceof LivingEntityRenderer livingRenderer) {
                livingRenderer.addLayer(new SpellTargetingLayer.Vanilla<>(livingRenderer));
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void addLayerToPlayerSkin(EntityRenderersEvent.AddLayers event, PlayerSkin.Model skinName) {
        EntityRenderer<? extends Player> render = event.getSkin(skinName);
        if (render instanceof LivingEntityRenderer livingRenderer) {
            livingRenderer.addLayer(new EchoingStrikesHologramLayer.Vanilla(livingRenderer));
            livingRenderer.addLayer(new AngelWingsLayer<>(livingRenderer));
            livingRenderer.addLayer(new ArmorCapeLayer(livingRenderer));
            livingRenderer.addLayer(new EnergySwirlLayer.Vanilla(livingRenderer, EVASION_TEXTURE, MobEffectRegistry.EVASION));
            livingRenderer.addLayer(new EnergySwirlLayer.Vanilla(livingRenderer, CHARGE_TEXTURE, MobEffectRegistry.CHARGED));
            livingRenderer.addLayer(new ChargeSpellLayer.Vanilla<>(livingRenderer));
            livingRenderer.addLayer(new GlowingEyesLayer.Vanilla<>(livingRenderer));
            livingRenderer.addLayer(new SpellTargetingLayer.Vanilla<>(livingRenderer));
        }


    /*.valu((entityType)->{
            if(entityType. instanceof EntityType<LivingEntity> livingType)
            if(event.getRenderer(entityType) instanceof EntityRenderer<? extends LivingEntity> livingRenderer)
                livingRenderer.addlayer
        });*/
//        EntityRenderer<? extends LivingEntity> genericRender = event.getRenderer()
        //EntityRenderer<? extends AbstractSpellCastingMob> renderer = event.getRenderer(EntityRegistry.PYROMANCER);
    }

    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.MAGIC_MISSILE_PROJECTILE, MagicMissileRenderer::new);
        event.registerEntityRenderer(EntityRegistry.CONE_OF_COLD_PROJECTILE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BLOOD_SLASH_PROJECTILE, BloodSlashRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ELECTROCUTE_PROJECTILE, ElectrocuteRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIREBOLT_PROJECTILE, FireboltRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ICICLE_PROJECTILE, IcicleRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIRE_BREATH_PROJECTILE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.POISON_BREATH_PROJECTILE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.DRAGON_BREATH_PROJECTILE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.DEBUG_WIZARD, (renderManager) -> new DebugWizardRenderer(renderManager));
        event.registerEntityRenderer(EntityRegistry.PYROMANCER, PyromancerRenderer::new);
        event.registerEntityRenderer(EntityRegistry.APOTHECARIST, ApothecaristRenderer::new);
        event.registerEntityRenderer(EntityRegistry.NECROMANCER, NecromancerRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SPECTRAL_STEED, SpectralSteedRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SHIELD_ENTITY, ShieldRenderer::new);
        event.registerEntityRenderer(EntityRegistry.WALL_OF_FIRE_ENTITY, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.WISP, WispRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SPECTRAL_HAMMER, SpectralHammerRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SUMMONED_VEX, VexRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SUMMONED_ZOMBIE, SummonedZombieMultiRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SUMMONED_SKELETON, SummonedSkeletonMultiRenderer::new);
        event.registerEntityRenderer(EntityRegistry.LIGHTNING_LANCE_PROJECTILE, LightningLanceRenderer::new);
        event.registerEntityRenderer(EntityRegistry.WITHER_SKULL_PROJECTILE, (context) -> new SkullProjectileRenderer(context, IronsSpellbooks.id("textures/entity/wither_skull.png")));
        event.registerEntityRenderer(EntityRegistry.CREEPER_HEAD_PROJECTILE, (context) -> new SkullProjectileRenderer(context, IronsSpellbooks.id("textures/entity/creeper_head.png")));
        event.registerEntityRenderer(EntityRegistry.MAGIC_ARROW_PROJECTILE, MagicArrowRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIRE_ARROW_PROJECTILE, FireArrowRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIERY_DAGGER_PROJECTILE, FieryDaggerRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIRE_ERUPTION_AOE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FROZEN_HUMANOID, FrozenHumanoidRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SMALL_FIREBALL_PROJECTILE, (context) -> new FireballRenderer(context, 0.75f));
        event.registerEntityRenderer(EntityRegistry.COMET, (context) -> new CometRenderer(context, 0.75f));
        event.registerEntityRenderer(EntityRegistry.MAGIC_FIREBALL, (context) -> new FireballRenderer(context, 1.25f));
        event.registerEntityRenderer(EntityRegistry.SUMMONED_POLAR_BEAR, PolarBearRenderer::new);
        event.registerEntityRenderer(EntityRegistry.DEAD_KING, DeadKingRenderer::new);
        event.registerEntityRenderer(EntityRegistry.DEAD_KING_CORPSE, DeadKingRenderer::new);
        event.registerEntityRenderer(EntityRegistry.DEAD_KING_SOUL, DeadKingSoulRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ARCHEVOKER, ArchevokerRenderer::new);
        event.registerEntityRenderer(EntityRegistry.KEEPER, KeeperRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SCULK_TENTACLE, VoidTentacleRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ROOT, RootRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ICE_BLOCK_PROJECTILE, IceBlockRenderer::new);
        event.registerEntityRenderer(EntityRegistry.CRYOMANCER, CryomancerRenderer::new);
        event.registerEntityRenderer(EntityRegistry.POISON_CLOUD, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SUNBEAM, SunbeamRenderer::new);
        event.registerEntityRenderer(EntityRegistry.DRAGON_BREATH_POOL, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.POISON_ARROW, PoisonArrowRenderer::new);
        event.registerEntityRenderer(EntityRegistry.POISON_SPLASH, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ACID_ORB, AcidOrbRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BLACK_HOLE, BlackHoleRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BLOOD_NEEDLE, BloodNeedleRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIRE_FIELD, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIRE_BOMB, MagmaBallRenderer::new);
        event.registerEntityRenderer(EntityRegistry.TARGET_AREA_ENTITY, TargetAreaRenderer::new);
        event.registerEntityRenderer(EntityRegistry.HEALING_AOE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.PRIEST, PriestRenderer::new);
        event.registerEntityRenderer(EntityRegistry.GUIDING_BOLT, GuidingBoltRenderer::new);
        event.registerEntityRenderer(EntityRegistry.GUST_COLLIDER, GustRenderer::new);
        event.registerEntityRenderer(EntityRegistry.CHAIN_LIGHTNING, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.DEVOUR_JAW, DevourJawRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIREFLY_SWARM, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.EARTHQUAKE_AOE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BLIZZARD_AOE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FALLING_BLOCK, VisualFallingBlockRenderer::new);
        event.registerEntityRenderer(EntityRegistry.RAY_OF_FROST_VISUAL_ENTITY, RayOfFrostRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ELDRITCH_BLAST_VISUAL_ENTITY, EldritchBlastRenderer::new);
        event.registerEntityRenderer(EntityRegistry.PORTAL, PortalRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SMALL_MAGIC_ARROW, SmallMagicArrowRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ARROW_VOLLEY_ENTITY, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.STOMP_AOE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ECHOING_STRIKE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.LIGHTNING_STRIKE, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.CULTIST, CultistRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BALL_LIGHTNING, BallLightningRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ICE_SPIKE, IceSpikeRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FIRE_BOSS, FireBossRenderer::new);
        event.registerEntityRenderer(EntityRegistry.CURSED_ARMOR_STAND, CursedArmorStandRenderer::new);
        event.registerEntityRenderer(EntityRegistry.THUNDERSTEP_PROJECTILE, ThunderstepProjectileRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SUMMONED_SWORD, (e) -> new SummonedSwordRenderer(e, SummonedSwordModel::new));
        event.registerEntityRenderer(EntityRegistry.SUMMONED_CLAYMORE, (e) -> new SummonedSwordRenderer(e, SummonedClaymoreModel::new));
        event.registerEntityRenderer(EntityRegistry.SUMMONED_RAPIER, (e) -> new SummonedSwordRenderer(e, SummonedRapierModel::new));
        event.registerEntityRenderer(EntityRegistry.ICE_SPIDER, IceSpiderRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ICE_TOMB, IceTombRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FROST_FIELD, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SNOWBALL, SnowballRenderer::new);
        event.registerEntityRenderer(EntityRegistry.THROWN_SPEAR, ThrownSpearRenderer::new);
        event.registerEntityRenderer(EntityRegistry.THROWN_ITEM, ThrownItemRenderer::new);
        event.registerEntityRenderer(EntityRegistry.OMINOUS_FIRE_ORB, OminousFireOrbRenderer::new);
        event.registerEntityRenderer(EntityRegistry.UNDEAD_RIFT, UndeadRiftRenderer::new);
        event.registerEntityRenderer(EntityRegistry.FANG_SWIRL, NoopRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ARCANE_SHACKLE, ArcaneShackleRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ENDER_CHAIN, EnderChainRenderer::new);
        event.registerEntityRenderer(EntityRegistry.ECHOING_SWORD, c -> new MagicSwordRenderer<>(c, EchoingSwordModel::new));
        event.registerEntityRenderer(EntityRegistry.ECHOING_ARROW, EchoingMagicArrowRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SCAPEGOAT, ScapegoatRenderer::new);

        event.registerBlockEntityRenderer(BlockRegistry.SCROLL_FORGE_TILE.get(), ScrollForgeRenderer::new);
        event.registerBlockEntityRenderer(BlockRegistry.PEDESTAL_TILE.get(), PedestalRenderer::new);
        event.registerBlockEntityRenderer(BlockRegistry.ALCHEMIST_CAULDRON_TILE.get(), AlchemistCauldronRenderer::new);
        event.registerBlockEntityRenderer(BlockRegistry.PORTAL_FRAME_BLOCK_ENTITY.get(), PortalFrameRenderer::new);
        event.registerBlockEntityRenderer(BlockRegistry.TYROS_STATUE_BLOCK_ENTITY.get(), TyrosStatueBlockRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleRegistry.WISP_PARTICLE.get(), WispParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.BLOOD_PARTICLE.get(), BloodParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.BLOOD_GROUND_PARTICLE.get(), BloodGroundParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SNOWFLAKE_PARTICLE.get(), SnowflakeParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.ELECTRICITY_PARTICLE.get(), ElectricityParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.UNSTABLE_ENDER_PARTICLE.get(), UnstableEnderParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.DRAGON_FIRE_PARTICLE.get(), DragonFireParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.FIRE_PARTICLE.get(), FireParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.EMBER_PARTICLE.get(), EmberParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SIPHON_PARTICLE.get(), SiphonParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.FOG_PARTICLE.get(), FogParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SHOCKWAVE_PARTICLE.get(), ShockwaveParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.ACID_PARTICLE.get(), AcidParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.ACID_BUBBLE_PARTICLE.get(), AcidBubbleParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.ZAP_PARTICLE.get(), ZapParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.FIREFLY_PARTICLE.get(), FireflyParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.RING_SMOKE_PARTICLE.get(), RingSmokeParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.PORTAL_FRAME_PARTICLE.get(), PortalFrameParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.BLASTWAVE_PARTICLE.get(), BlastwaveParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SPARK_PARTICLE.get(), SparkParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SNOW_DUST.get(), SnowDustParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.CLEANSE_PARTICLE.get(), CleanseParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.FLAME_STRIKE_PARTICLE.get(), FlameStrikeParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.EMBEROUS_ASH_PARTICLE.get(), EmberousAshParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.FIERY_SMOKE_PARTICLE.get(), FierySmokeParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.ENDER_SLASH_PARTICLE.get(), EnderSlashParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.TRACE_PARTICLE.get(), TraceParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SOULFIRE_RAY_PARTICLE.get(), SoulfireRayParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.SOUL_FIRE_PARTICLE.get(), DragonFireParticle.Provider::new);
        event.registerSpriteSet(ParticleRegistry.TINTED_BUBBLE_POP_PARTICLE.get(), TintedBubblePopParticle.Provider::new);

        event.registerSpecial(ParticleRegistry.FALLING_BLOCK_PARTICLE.get(), new FallingBlockParticle.Provider());
        event.registerSpecial(ParticleRegistry.SWIRLING_PARTICLE.get(), new SwirlingParticle.Provider());
        event.registerSpriteSet(ParticleRegistry.FALLING_SPARKLE_PARTICLE.get(), FallingSparkleParticle.Provider::new);
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent e) {
        //Item Properties
        e.enqueueWork(() -> {
            // Allow use of attack damage attribute in client spell tooltips
            Attributes.ATTACK_DAMAGE.value().setSyncable(true);
            // Instantiate client side abstraction
            MinecraftInstanceHelper.instance = new IMinecraftInstanceHelper() {
                @Nullable
                @Override
                public Player player() {
                    return Minecraft.getInstance().player;
                }
            };
            // Register Item Properties
            ItemProperties.register(ItemRegistry.WAYWARD_COMPASS.get(), ResourceLocation.withDefaultNamespace("angle"),
                    new CompassItemPropertyFunction((level, itemStack, entity) -> WaywardCompass.getCatacombsLocation(entity, itemStack)));

            ItemProperties.register(ItemRegistry.AUTOLOADER_CROSSBOW.get(), ResourceLocation.withDefaultNamespace("pull"), (itemStack, clientLevel, livingEntity, i) -> CrossbowItem.isCharged(itemStack) ? 0.0F : AutoloaderCrossbow.getLoadingTicks(itemStack) / (float) AutoloaderCrossbow.getChargeDuration(itemStack, livingEntity));
            ItemProperties.register(ItemRegistry.AUTOLOADER_CROSSBOW.get(), ResourceLocation.withDefaultNamespace("pulling"), (itemStack, clientLevel, livingEntity, i) -> AutoloaderCrossbow.isLoading(itemStack) && !CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F);
            ItemProperties.register(ItemRegistry.AUTOLOADER_CROSSBOW.get(), ResourceLocation.withDefaultNamespace("charged"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F);
            ItemProperties.register(ItemRegistry.AUTOLOADER_CROSSBOW.get(), ResourceLocation.withDefaultNamespace("firework"), (itemStack, clientLevel, livingEntity, i) -> {
                ChargedProjectiles chargedprojectiles = itemStack.get(DataComponents.CHARGED_PROJECTILES);
                return chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
            });
            ItemProperties.register(ItemRegistry.WIZARD_HELMET.get(), IronsSpellbooks.id("hat"), (itemStack, clientLevel, livingEntity, i) -> itemStack.getOrDefault(ComponentRegistry.CLOTHING_VARIANT, "").equals("hat") ? 1.0f : 0f);
            ItemProperties.register(ItemRegistry.TWILIGHT_GALE.get(), ResourceLocation.withDefaultNamespace("throwing"), (p_234996_, p_234997_, p_234998_, p_234999_) -> p_234998_ != null && p_234998_.isUsingItem() && p_234998_.getUseItem() == p_234996_ ? 1.0F : 0.0F);
            // Register Fog mob effects
            FogRenderer.MOB_EFFECT_FOG.add(new PlanarSightEffect.EcholocationBlindnessFogFunction());
            // Register Curio renderers for vanilla spellbooks
            ItemRegistry.getIronsItems().stream().filter(item -> item.get() instanceof SpellBook).forEach((item) -> CuriosRendererRegistry.register(item.get(), SpellBookCurioRenderer::new));
            // Init player animation stuff
            AnimationHelper.initializePlayerAnimationFactory();
        });


    }

    @SubscribeEvent
    public static void registerSpecialModels(ModelEvent.RegisterAdditional event) {
        for (SchoolType schoolType : SchoolRegistry.REGISTRY) {
            event.register(ModelResourceLocation.standalone(AffinityRingRenderer.getAffinityRingModelLocation(schoolType)));
            event.register(ModelResourceLocation.standalone(ScrollModel.getScrollModelLocation(schoolType)));
        }
        event.register(ModelResourceLocation.standalone(IronsSpellbooks.id("item/template_open_spell_book_model")));
        event.register(ModelResourceLocation.standalone(IronsSpellbooks.id("item/pyrium_staff_haft")));
        event.register(ModelResourceLocation.standalone(IronsSpellbooks.id("item/fiery_dagger")));
        event.register(ModelResourceLocation.standalone(IronsSpellbooks.id("item/stone_scythe")));
    }

    @SubscribeEvent
    public static void replaceItemModels(ModelEvent.ModifyBakingResult event) {
        var key = new ModelResourceLocation(IronsSpellbooks.id("scroll"), "inventory");
        BakedModel model = event.getModels().get(key);
        IronsSpellbooks.LOGGER.debug("replaceItemModels {}: {}", key, model.getClass());
        event.getModels().computeIfPresent(key, (k, oldModel) -> new ScrollModel(oldModel, event.getModelBakery()));
        event.getModels().computeIfPresent(ModelResourceLocation.standalone(IronsSpellbooks.id("item/fiery_dagger")), (k, oldModel) -> new SpectralItemModel(oldModel));
    }
}

