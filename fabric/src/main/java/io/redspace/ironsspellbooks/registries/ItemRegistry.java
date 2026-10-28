package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.compat.Curios;
import io.redspace.ironsspellbooks.item.ArchevokerLogbookItem;
import io.redspace.ironsspellbooks.item.ChronicleItem;
import io.redspace.ironsspellbooks.item.CinderousSoulcallerItem;
import io.redspace.ironsspellbooks.item.CursedDollSpellbookItem;
import io.redspace.ironsspellbooks.item.DragonskinItem;
import io.redspace.ironsspellbooks.item.EldritchManuscript;
import io.redspace.ironsspellbooks.item.EnergizedCoreItem;
import io.redspace.ironsspellbooks.item.FurledMapCraftableItem;
import io.redspace.ironsspellbooks.item.FurledMapItem;
import io.redspace.ironsspellbooks.item.InkItem;
import io.redspace.ironsspellbooks.item.NecronomiconSpellBook;
import io.redspace.ironsspellbooks.item.PortalFrameBlockItem;
import io.redspace.ironsspellbooks.item.RuinedBookItem;
import io.redspace.ironsspellbooks.item.Scroll;
import io.redspace.ironsspellbooks.item.ShrivingStoneItem;
import io.redspace.ironsspellbooks.item.SimpleDescriptiveBlockItem;
import io.redspace.ironsspellbooks.item.SimpleDescriptiveItem;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.SpellSlotUpgradeItem;
import io.redspace.ironsspellbooks.item.UnchainedBookItem;
import io.redspace.ironsspellbooks.item.UniqueSpellBook;
import io.redspace.ironsspellbooks.item.UpgradeOrbItem;
import io.redspace.ironsspellbooks.item.WaywardCompass;
import io.redspace.ironsspellbooks.item.armor.ArchevokerArmorItem;
import io.redspace.ironsspellbooks.item.armor.BootsOfSpeedArmorItem;
import io.redspace.ironsspellbooks.item.armor.CryomancerArmorItem;
import io.redspace.ironsspellbooks.item.armor.CultistArmorItem;
import io.redspace.ironsspellbooks.item.armor.ElectromancerArmorItem;
import io.redspace.ironsspellbooks.item.armor.GoldCrownArmorItem;
import io.redspace.ironsspellbooks.item.armor.InfernalSorcererArmorItem;
import io.redspace.ironsspellbooks.item.armor.NetheriteMageArmorItem;
import io.redspace.ironsspellbooks.item.armor.PaladinArmorItem;
import io.redspace.ironsspellbooks.item.armor.PlaguedArmorItem;
import io.redspace.ironsspellbooks.item.armor.PriestArmorItem;
import io.redspace.ironsspellbooks.item.armor.PumpkinArmorItem;
import io.redspace.ironsspellbooks.item.armor.PyromancerArmorItem;
import io.redspace.ironsspellbooks.item.armor.ShadowwalkerArmorItem;
import io.redspace.ironsspellbooks.item.armor.TarnishedCrownArmorItem;
import io.redspace.ironsspellbooks.item.armor.WanderingMagicianArmorItem;
import io.redspace.ironsspellbooks.item.armor.WizardArmorItem;
import io.redspace.ironsspellbooks.item.consumables.FireAleItem;
import io.redspace.ironsspellbooks.item.consumables.NetherwardTinctureItem;
import io.redspace.ironsspellbooks.item.consumables.OakskinElixir;
import io.redspace.ironsspellbooks.item.consumables.SimpleElixir;
import io.redspace.ironsspellbooks.item.consumables.TinctureOfForgetfulnessItem;
import io.redspace.ironsspellbooks.item.curios.AffinityRing;
import io.redspace.ironsspellbooks.item.curios.BetrayerSignetRingItem;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.curios.ExpulsionRing;
import io.redspace.ironsspellbooks.item.curios.FirewardRing;
import io.redspace.ironsspellbooks.item.curios.FrostwardRing;
import io.redspace.ironsspellbooks.item.curios.InvisibiltyRing;
import io.redspace.ironsspellbooks.item.curios.LurkerRing;
import io.redspace.ironsspellbooks.item.curios.PoisonwardRing;
import io.redspace.ironsspellbooks.item.curios.SimpleDescriptiveCurio;
import io.redspace.ironsspellbooks.item.curios.TeleportationAmuletItem;
import io.redspace.ironsspellbooks.item.curios.VisibilityRing;
import io.redspace.ironsspellbooks.item.curios.WickedBoneRingItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.AutoloaderCrossbow;
import io.redspace.ironsspellbooks.item.weapons.ExtendedWeaponTier;
import io.redspace.ironsspellbooks.item.weapons.HitherThitherWand;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.item.weapons.StaffOfTheNines;
import io.redspace.ironsspellbooks.item.weapons.StaffTier;
import io.redspace.ironsspellbooks.item.weapons.TwilightGaleItem;
import io.redspace.ironsspellbooks.item.weapons.pyrium_staff.PyriumStaffItem;
import io.redspace.ironsspellbooks.mixin.RarityMixin;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemRegistry {
    private static final Set<Item> ITEMS = new HashSet<>();

    /**
     * Spell items
     */
    public static final Item WIMPY_SPELL_BOOK = registerItem("wimpy_spell_book", (properties) -> new SpellBook(0, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant())/*ItemPropertiesHelper.of().with(Item.Properties::stacksTo, 1).with(Item.Properties::rarity, Rarity.UNCOMMON).build()*/);

    public static final Item LEGENDARY_SPELL_BOOK = registerItem("legendary_spell_book", (properties) -> new SpellBook(12, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item NETHERITE_SPELL_BOOK = registerItem("netherite_spell_book", (properties) -> new SpellBook(12, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, .20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE)));
    public static final Item DIAMOND_SPELL_BOOK = registerItem("diamond_spell_book", (properties) -> new SpellBook(10, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.MAX_MANA, 100, AttributeModifier.Operation.ADD_VALUE)));
    public static final Item GOLD_SPELL_BOOK = registerItem("gold_spell_book", (properties) -> new SpellBook(8, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 50, AttributeModifier.Operation.ADD_VALUE)));
    public static final Item IRON_SPELL_BOOK = registerItem("iron_spell_book", (properties) -> new SpellBook(6, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item COPPER_SPELL_BOOK = registerItem("copper_spell_book", (properties) -> new SpellBook(5, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item ROTTEN_SPELL_BOOK = registerItem("rotten_spell_book", (properties) -> new SpellBook(8, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.SPELL_RESIST, -.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 100, AttributeModifier.Operation.ADD_VALUE)));
    public static final Item BLAZE_SPELL_BOOK = registerItem("blaze_spell_book", (properties) -> new SpellBook(10, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE)));
    public static final Item DRAGONSKIN_SPELL_BOOK = registerItem("dragonskin_spell_book", (properties) -> new SpellBook(12, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE)));
    public static final Item DRUIDIC_SPELL_BOOK = registerItem("druidic_spell_book", (properties) -> new SpellBook(10, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE)));
    public static final Item VILLAGER_SPELL_BOOK = registerItem("villager_spell_book", (properties) -> new SpellBook(10, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE)));
    public static final Item ICE_SPELL_BOOK = registerItem("ice_spell_book", (properties) -> new SpellBook(12, properties.stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE)));

    public static final Item GRAYBEARD_STAFF = registerItem("graybeard_staff", (properties) -> new StaffItem(properties.stacksTo(1).fireResistant().attributes(ExtendedSwordItem.createAttributes(StaffTier.GRAYBEARD))));
    public static final Item PYRIUM_STAFF = registerItem("pyrium_staff", (properties) -> new PyriumStaffItem(properties.stacksTo(1).attributes(ExtendedSwordItem.createAttributes(StaffTier.PYRIUM_STAFF)).rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self()).fireResistant()));
    public static final Item ARTIFICER_STAFF = registerItem("artificer_cane", (properties) -> new StaffItem(properties.stacksTo(1).fireResistant().attributes(ExtendedSwordItem.createAttributes(StaffTier.ARTIFICER))));
    public static final Item ICE_STAFF = registerItem("ice_staff", (properties) -> new StaffItem(properties.stacksTo(1).fireResistant().attributes(ExtendedSwordItem.createAttributes(StaffTier.ICE_STAFF)).rarity(Rarity.RARE)));
    public static final Item LIGHTNING_ROD_STAFF = registerItem("lightning_rod", (properties) -> new StaffItem(properties.stacksTo(1).fireResistant().attributes(ExtendedSwordItem.createAttributes(StaffTier.LIGHTNING_ROD)).rarity(Rarity.UNCOMMON)));
    public static final Item BLOOD_STAFF = registerItem("blood_staff", (properties) -> new StaffItem(properties.stacksTo(1).fireResistant().attributes(ExtendedSwordItem.createAttributes(StaffTier.BLOOD_STAFF)).rarity(Rarity.UNCOMMON)));

    public static final Item EVOKER_SPELL_BOOK = registerItem("evoker_spell_book", (properties) -> new UniqueSpellBook(
                    new SpellDataRegistryHolder[]{
                            new SpellDataRegistryHolder(SpellRegistry.FANG_STRIKE_SPELL, 6),
                            new SpellDataRegistryHolder(SpellRegistry.FANG_WARD_SPELL, 4),
                            new SpellDataRegistryHolder(SpellRegistry.SUMMON_VEX_SPELL, 4)},
                    7, properties.fireResistant().stacksTo(1).rarity(Rarity.UNCOMMON)).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE))
    );
    public static final Item NECRONOMICON = registerItem("necronomicon_spell_book", (properties) -> new NecronomiconSpellBook(properties.stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final Item CURSED_DOLL_SPELLBOOK = registerItem("cursed_doll_spell_book", (properties) -> new CursedDollSpellbookItem(properties.stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON)));

    public static final Item MAGEHUNTER = registerItem("magehunter", (properties) -> new ExtendedSwordItem(ExtendedWeaponTier.METAL_MAGEHUNTER, properties.fireResistant().attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.METAL_MAGEHUNTER))));
    public static final Item SPELLBREAKER = registerItem("spellbreaker", (properties) -> new MagicSwordItem(ExtendedWeaponTier.SPELLBREAKER, properties.rarity(Rarity.EPIC).fireResistant().attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.SPELLBREAKER)), SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.COUNTERSPELL_SPELL, 1))));
    public static final Item TEST_CLAYMORE = registerItem("claymore", (properties) -> new ExtendedSwordItem(ExtendedWeaponTier.CLAYMORE, properties.attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.CLAYMORE))));
    public static final Item KEEPER_FLAMBERGE = registerItem("keeper_flamberge", (properties) -> new ExtendedSwordItem(ExtendedWeaponTier.DECREPIT_FLAMBERGE, properties.rarity(Rarity.UNCOMMON).fireResistant().attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.DECREPIT_FLAMBERGE))));
    public static final Item LEGIONNAIRE_FLAMBERGE = registerItem("legionnaire_flamberge", (properties) -> new ExtendedSwordItem(ExtendedWeaponTier.LEGIONNAIRE_FLAMBERGE, properties.rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self()).fireResistant().attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.LEGIONNAIRE_FLAMBERGE))));
    public static final Item AMETHYST_RAPIER = registerItem("amethyst_rapier", (properties) -> new MagicSwordItem(ExtendedWeaponTier.AMETHYST_RAPIER, properties.rarity(Rarity.EPIC).fireResistant().attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.AMETHYST_RAPIER)), SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.ECHOING_STRIKES_SPELL, 5))));
    public static final Item MISERY = registerItem("misery", (properties) -> new MagicSwordItem(ExtendedWeaponTier.MISERY, properties.attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.MISERY)), SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.WITHER_SKULL_SPELL, 8))));
    public static final Item SCROLL = registerItem("scroll", (properties) -> new Scroll(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final Item AUTOLOADER_CROSSBOW = registerItem("autoloader_crossbow", (properties) -> new AutoloaderCrossbow(properties.stacksTo(1).durability(465)));
    public static final Item HITHER_THITHER_WAND = registerItem("hither_thither_wand", (properties) -> new HitherThitherWand(properties.stacksTo(1).rarity(Rarity.EPIC)));
    public static final Item STAFF_OF_THE_NINES = registerItem("staff_of_the_nines", (properties) -> new StaffOfTheNines(properties.stacksTo(1).rarity(Rarity.EPIC)));
    public static final Item HELLRAZOR = registerItem("hellrazor", (properties) -> new MagicSwordItem(ExtendedWeaponTier.HELLRAZOR, properties.attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.HELLRAZOR)).rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self()).fireResistant(), SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.RAISE_HELL_SPELL, 3))));
    public static final Item DECREPIT_SCYTHE = registerItem("decrepit_scythe", (properties) -> new ExtendedSwordItem(ExtendedWeaponTier.DECREPIT_SCYTHE, properties.attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.DECREPIT_SCYTHE)).rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item ICE_GREATSWORD = registerItem("boreal_blade", (properties) -> new MagicSwordItem(ExtendedWeaponTier.ICE_GREATSWORD,
                    properties.attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.ICE_GREATSWORD))
                            .rarity(Rarity.RARE)
                            .fireResistant(), SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.FROSTBITE_SPELL, 3))));
    public static final Item TWILIGHT_GALE = registerItem("twilight_gale", (properties) -> new TwilightGaleItem(ExtendedWeaponTier.TWILIGHT_GALE,
                    properties.attributes(ExtendedSwordItem.createAttributes(ExtendedWeaponTier.TWILIGHT_GALE))
                            .rarity(Rarity.RARE)
                            .fireResistant(), SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.VOLT_STRIKE_SPELL, 5))));

    /**
     * Ink
     */
    public static final Item INK_COMMON = registerItem("common_ink", (properties) -> new InkItem(SpellRarity.COMMON, FluidRegistry.COMMON_INK, properties));
    public static final Item INK_UNCOMMON = registerItem("uncommon_ink", (properties) -> new InkItem(SpellRarity.UNCOMMON, FluidRegistry.UNCOMMON_INK, properties));
    public static final Item INK_RARE = registerItem("rare_ink", (properties) -> new InkItem(SpellRarity.RARE, FluidRegistry.RARE_INK, properties));
    public static final Item INK_EPIC = registerItem("epic_ink", (properties) -> new InkItem(SpellRarity.EPIC, FluidRegistry.EPIC_INK, properties));
    public static final Item INK_LEGENDARY = registerItem("legendary_ink", (properties) -> new InkItem(SpellRarity.LEGENDARY, FluidRegistry.LEGENDARY_INK, properties));

    /**
     * Potions
     */
    public static final Item OAKSKIN_ELIXIR = registerItem("oakskin_elixir", (properties) -> new OakskinElixir(properties.stacksTo(4), () -> new MobEffectInstance(MobEffectRegistry.OAKSKIN, 1200, 2)));
    public static final Item GREATER_OAKSKIN_ELIXIR = registerItem("greater_oakskin_elixir", (properties) -> new OakskinElixir(properties.stacksTo(4), () -> new MobEffectInstance(MobEffectRegistry.OAKSKIN, 2400, 6), true));
    public static final Item GREATER_HEALING_POTION = registerItem("greater_healing_potion", (properties) -> new SimpleElixir(properties.stacksTo(4), () -> new MobEffectInstance(MobEffects.HEAL, 1, 2)));
    public static final Item INVISIBILITY_ELIXIR = registerItem("invisibility_elixir", (properties) -> new SimpleElixir(properties.stacksTo(4), () -> new MobEffectInstance(MobEffectRegistry.TRUE_INVISIBILITY, 20 * 15, 0, false, false, true)));
    public static final Item GREATER_INVISIBILITY_ELIXIR = registerItem("greater_invisibility_elixir", (properties) -> new SimpleElixir(properties.stacksTo(4), () -> new MobEffectInstance(MobEffectRegistry.TRUE_INVISIBILITY, 20 * 40, 0, false, false, true), true));
    public static final Item EVASION_ELIXIR = registerItem("evasion_elixir", (properties) -> new SimpleElixir(properties.stacksTo(4), () -> new MobEffectInstance(MobEffectRegistry.EVASION, 20 * 60, 1, false, false, true)));
    public static final Item GREATER_EVASION_ELIXIR = registerItem("greater_evasion_elixir", (properties) -> new SimpleElixir(properties.stacksTo(4), () -> new MobEffectInstance(MobEffectRegistry.EVASION, 20 * 60, 3, false, false, true), true));
    public static final Item FIRE_ALE = registerItem("fire_ale", (properties) -> new FireAleItem(properties.stacksTo(4).fireResistant()));
    public static final Item NETHERWARD_TINCTURE = registerItem("netherward_tincture", (properties) -> new NetherwardTinctureItem(properties.stacksTo(16)));
    public static final Item TINCTURE_OF_FORGETFULNESS = registerItem("tincture_of_forgetfulness", (properties) -> new TinctureOfForgetfulnessItem(properties.stacksTo(16)));

    /**
     * Upgrade Orbs
     */
    public static final Item UPGRADE_ORB = registerItem("upgrade_orb", (properties) -> new Item(properties.rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item FIRE_UPGRADE_ORB = registerItem("fire_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.FIRE_SPELL_POWER)));
    public static final Item ICE_UPGRADE_ORB = registerItem("ice_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.ICE_SPELL_POWER)));
    public static final Item LIGHTNING_UPGRADE_ORB = registerItem("lightning_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.LIGHTNING_SPELL_POWER)));
    public static final Item HOLY_UPGRADE_ORB = registerItem("holy_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.HOLY_SPELL_POWER)));
    public static final Item ENDER_UPGRADE_ORB = registerItem("ender_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.ENDER_SPELL_POWER)));
    public static final Item BLOOD_UPGRADE_ORB = registerItem("blood_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.BLOOD_SPELL_POWER)));
    public static final Item EVOCATION_UPGRADE_ORB = registerItem("evocation_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.EVOCATION_SPELL_POWER)));
    public static final Item NATURE_UPGRADE_ORB = registerItem("nature_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.NATURE_SPELL_POWER)));
    public static final Item MANA_UPGRADE_ORB = registerItem("mana_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.MANA)));
    public static final Item COOLDOWN_UPGRADE_ORB = registerItem("cooldown_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.COOLDOWN)));
    public static final Item PROTECTION_UPGRADE_ORB = registerItem("protection_upgrade_orb", (properties) -> new UpgradeOrbItem(properties.rarity(Rarity.UNCOMMON).fireResistant().component(ComponentRegistry.UPGRADE_ORB_TYPE, UpgradeOrbTypeRegistry.SPELL_RESISTANCE)));

    /**
     * Generic Items
     */
    public static final Item LIGHTNING_BOTTLE = registerItem("lightning_bottle", (properties) -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item FROZEN_BONE_SHARD = registerItem("frozen_bone", Item::new);
    public static final Item BLOOD_VIAL = registerItem("blood_vial", Item::new);
    public static final Item ICE_VENOM_VIAL = registerItem("ice_venom_vial", Item::new);
    public static final Item DIVINE_PEARL = registerItem("divine_pearl", Item::new);
    public static final Item FURLED_MAP = registerItem("furled_map", (properties) -> new FurledMapItem(properties.stacksTo(1)));
    public static final Item ANCIENT_FURLED_MAP = registerItem("furled_map_ancient", (properties) -> new FurledMapItem(properties.stacksTo(1)));
    public static final Item CITADEL_FURLED_MAP = registerItem("furled_map_citadel", (properties) -> new FurledMapCraftableItem(true, new FurledMapItem.FurledMapData(IronsSpellbooks.id("citadel"), Optional.of(FurledMapItem.NETHER), Optional.of(Component.translatable("item.irons_spellbooks.furled_map_descriptor_framing", Component.translatable("item.irons_spellbooks.citadel_map")).setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)))), properties.stacksTo(1)));
    public static final Item ICE_SPIDER_FURLED_MAP = registerItem("furled_map_ice_spider_den", (properties) -> new FurledMapCraftableItem(false, new FurledMapItem.FurledMapData(IronsSpellbooks.id("ice_spider_den"), Optional.of(FurledMapItem.OVERWORLD), Optional.of(Component.translatable("item.irons_spellbooks.furled_map_descriptor_framing", Component.translatable("item.irons_spellbooks.ice_spider_den_map")).setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)))), properties.stacksTo(1)));
    public static final Item HOGSKIN = registerItem("hogskin", Item::new);
    public static final Item DRAGONSKIN = registerItem("dragonskin", DragonskinItem::new);
    public static final Item ARCANE_ESSENCE = registerItem("arcane_essence", Item::new);
    public static final Item MAGIC_CLOTH = registerItem("magic_cloth", Item::new);
    public static final Item BLANK_RUNE = registerItem("blank_rune", Item::new);
    public static final Item FIRE_RUNE = registerItem("fire_rune", Item::new);
    public static final Item ICE_RUNE = registerItem("ice_rune", Item::new);
    public static final Item LIGHTNING_RUNE = registerItem("lightning_rune", Item::new);
    public static final Item ENDER_RUNE = registerItem("ender_rune", Item::new);
    public static final Item HOLY_RUNE = registerItem("holy_rune", Item::new);
    public static final Item BLOOD_RUNE = registerItem("blood_rune", Item::new);
    public static final Item EVOCATION_RUNE = registerItem("evocation_rune", Item::new);
    public static final Item MANA_RUNE = registerItem("arcane_rune", Item::new);
    public static final Item COOLDOWN_RUNE = registerItem("cooldown_rune", Item::new);
    public static final Item PROTECTION_RUNE = registerItem("protection_rune", Item::new);
    public static final Item NATURE_RUNE = registerItem("nature_rune", Item::new);
    public static final Item WAYWARD_COMPASS = registerItem("wayward_compass", WaywardCompass::new);
    public static final Item RUINED_BOOK = registerItem("ruined_book", (properties) -> new RuinedBookItem(properties.rarity(Rarity.EPIC)));
    public static final Item CINDER_ESSENCE = registerItem("cinder_essence", Item::new);
    public static final Item ARCANE_INGOT = registerItem("arcane_ingot", Item::new);
    public static final Item SHRIVING_STONE = registerItem("shriving_stone", ShrivingStoneItem::new);
    public static final Item LESSER_SPELL_SLOT_UPGRADE = registerItem("lesser_spell_slot_upgrade", (properties) -> new SpellSlotUpgradeItem(12, properties.rarity(Rarity.RARE)));
    public static final Item ELDRITCH_PAGE = registerItem("eldritch_manuscript", (properties) -> new EldritchManuscript(properties.rarity(Rarity.EPIC)));
    public static final Item LOST_KNOWLEDGE_FRAGMENT = registerItem("ancient_knowledge_fragment", (properties) -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item FROSTED_HELVE = registerItem("frosted_helve", (properties) -> new Item(properties.rarity(Rarity.COMMON)));
    public static final Item ICE_CRYSTAL = registerItem("permafrost_shard", (properties) -> new Item(properties.rarity(Rarity.RARE)));
    public static final Item ENERGIZED_CORE = registerItem("energized_core", (properties) -> new EnergizedCoreItem(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item CHAINED_BOOK = registerItem("chained_book", Item::new);
    public static final Item BLOODY_VELLUM = registerItem("bloody_vellum", Item::new);
    public static final Item ICY_FANG = registerItem("icy_fang", Item::new);
    public static final Item PREPARED_ICE_SPIDER_EGG = registerItem("prepared_ice_spider_egg", Item::new);
    public static final Item UNCHAINED_BOOK = registerItem("unchained_book", (properties) -> new UnchainedBookItem(properties.stacksTo(1).rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self()).component(DataComponents.WRITTEN_BOOK_CONTENT, UnchainedBookItem.CONTENTS)));

    public static final Item TIMELESS_SLURRY = registerItem("timeless_slurry", (properties) -> new Item(properties.rarity(Rarity.UNCOMMON)));
    public static final Item PYRIUM_INGOT = registerItem("pyrium_ingot", (properties) -> new Item(properties.rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self()).fireResistant()));
    public static final Item RAW_MITHRIL = registerItem("raw_mithril", (properties) -> new Item(properties.rarity(Rarity.RARE).fireResistant()));
    public static final Item MITHRIL_SCRAP = registerItem("mithril_scrap", (properties) -> new Item(properties.rarity(Rarity.RARE).fireResistant()));
    public static final Item MITHRIL_INGOT = registerItem("mithril_ingot", (properties) -> new Item(properties.rarity(Rarity.RARE).fireResistant()));
    public static final Item MITHRIL_WEAVE = registerItem("mithril_weave", (properties) -> new Item(properties.rarity(Rarity.RARE).fireResistant()));
    public static final Item WEAPON_PARTS = registerItem("weapon_parts", (properties) -> new Item(properties.rarity(Rarity.RARE).fireResistant()));
    public static final Item DIVINE_SOULSHARD = registerItem("divine_soulshard", (properties) -> new Item(properties.rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true).fireResistant()));

    public static final Item TRANSLATED_ARCHEVOKER_LOGBOOK = registerItem("archevoker_logbook_translated", (properties) -> new ArchevokerLogbookItem(true, new Item.Properties().component(DataComponents.WRITTEN_BOOK_CONTENT, ArchevokerLogbookItem.TRANSLATED_CONTENTS)));
    public static final Item UNTRANSLATED_ARCHEVOKER_LOGBOOK = registerItem("archevoker_logbook_untranslated", (properties) -> new ArchevokerLogbookItem(false, new Item.Properties().component(DataComponents.WRITTEN_BOOK_CONTENT, ArchevokerLogbookItem.UNTRANSLATED_CONTENTS)));
    public static final Item THE_CHRONICLE = registerItem("chronicle", (properties) -> new ChronicleItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final Item CINDEROUS_SOULCALLER = registerItem("cinderous_soulcaller", (properties) -> new CinderousSoulcallerItem(properties.stacksTo(1).rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self()).fireResistant()));
    public static final Item DECREPIT_KEY = registerItem("decrepit_key", (properties) -> new SimpleDescriptiveItem(properties.rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item BONE_KEY = registerItem("bone_key", (properties) -> new SimpleDescriptiveItem(properties.rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item DEAD_KING_PHYLACTERY = registerItem("dead_king_phylactery", (properties) -> new SimpleDescriptiveItem(properties.rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Item DEAD_KING_PHYLACTERY_SHARD = registerItem("dead_king_phylactery_shard", (properties) -> new Item(properties.rarity(Rarity.UNCOMMON).fireResistant()));


    /**
     * Block Items
     */
    public static final Item INSCRIPTION_TABLE_BLOCK_ITEM = registerItem("inscription_table", (properties) -> new BlockItem(BlockRegistry.INSCRIPTION_TABLE_BLOCK, new Item.Properties()));
    public static final Item ACANE_ANVIL_BLOCK_ITEM = registerItem("arcane_anvil", (properties) -> new BlockItem(BlockRegistry.ARCANE_ANVIL_BLOCK, new Item.Properties().rarity(Rarity.EPIC)));
    public static final Item SCROLL_FORGE_BLOCK = registerItem("scroll_forge", (properties) -> new BlockItem(BlockRegistry.SCROLL_FORGE_BLOCK, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final Item PEDESTAL_BLOCK_ITEM = registerItem("pedestal", (properties) -> new BlockItem(BlockRegistry.PEDESTAL_BLOCK, new Item.Properties()));
    public static final Item ARMOR_PILE_BLOCK_ITEM = registerItem("armor_pile", (properties) -> new BlockItem(BlockRegistry.ARMOR_PILE_BLOCK, new Item.Properties()));
    public static final Item MITHRIL_ORE_BLOCK_ITEM = registerItem("mithril_ore", (properties) -> new BlockItem(BlockRegistry.MITHRIL_ORE, new Item.Properties()));
    public static final Item MITHRIL_ORE_DEEPSLATE_BLOCK_ITEM = registerItem("deepslate_mithril_ore", (properties) -> new BlockItem(BlockRegistry.MITHRIL_ORE_DEEPSLATE, new Item.Properties()));
    public static final Item ALCHEMIST_CAULDRON_BLOCK_ITEM = registerItem("alchemist_cauldron", (properties) -> new BlockItem(BlockRegistry.ALCHEMIST_CAULDRON, new Item.Properties()));
    public static final Item FIREFLY_JAR_ITEM = registerItem("firefly_jar", (properties) -> new BlockItem(BlockRegistry.FIREFLY_JAR, new Item.Properties()));
    public static final Item PORTAL_FRAME_ITEM = registerItem("portal_frame", (properties) -> new PortalFrameBlockItem(new Item.Properties().fireResistant().rarity(Rarity.RARE)));
    public static final Item BRAZIER_ITEM = registerItem("brazier", (properties) -> new BlockItem(BlockRegistry.BRAZIER_FIRE, new Item.Properties()));
    public static final Item SOUL_BRAZIER_ITEM = registerItem("brazier_soul", (properties) -> new BlockItem(BlockRegistry.BRAZIER_SOUL, new Item.Properties()));
    public static final Item CINDEROUS_KEYSTONE_BLOCK_ITEM = registerItem("cinderous_soul_rune", (properties) -> new BlockItem(BlockRegistry.CINDEROUS_KEYSTONE, new Item.Properties().rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self())));
    public static final Item ICE_SPIDER_EGG_BLOCK_ITEM = registerItem("ice_spider_egg", (properties) -> new BlockItem(BlockRegistry.ICE_SPIDER_EGG, new Item.Properties().rarity(Rarity.RARE)));
    public static final Item COOKED_ICE_SPIDER_EGG_BLOCK_ITEM = registerItem("cooked_ice_spider_egg", (properties) -> new BlockItem(BlockRegistry.COOKED_ICE_SPIDER_EGG, new Item.Properties().stacksTo(1)));
    public static final Item BOOK_STACK_BLOCK_ITEM = registerItem("book_stack", (properties) -> new SimpleDescriptiveBlockItem(BlockRegistry.BOOK_STACK, new Item.Properties()));
    public static final Item WISEWOOD_BOOKSHELF_BLOCK_ITEM = registerItem("wisewood_bookshelf", (properties) -> new BlockItem(BlockRegistry.WISEWOOD_BOOKSHELF, new Item.Properties()));
    public static final Item WISEWOOD_CHISELED_BOOKSHELF_BLOCK_ITEM = registerItem("wisewood_chiseled_bookshelf", (properties) -> new BlockItem(BlockRegistry.WISEWOOD_CHISELLED_BOOKSHELF, new Item.Properties()));
    public static final Item NETHER_BRICK_PILLAR_BLOCK_ITEM = registerItem("nether_brick_pillar", (properties) -> new BlockItem(BlockRegistry.NETHER_BRICK_PILLAR, new Item.Properties()));
//    public static final Item TYROS_STATUE_BLOCK_ITEM = registerItem("tyros_statue", (properties) -> new BlockItem(BlockRegistry.TYROS_STATUE_BLOCK.get(), new Item.Properties()));
    public static final Item BONE_VAULT_BLOCK_ITEM = registerItem("bone_vault", (properties) -> new BlockItem(BlockRegistry.BONE_VAULT_BLOCK, new Item.Properties()));
    public static final Item CINDEROUS_VAULT_BLOCK_ITEM = registerItem("cinderous_vault", (properties) -> new BlockItem(BlockRegistry.CINDEROUS_VAULT_BLOCK, new Item.Properties().rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self())));

    /**
     * Armor
     */
    public static final Item WANDERING_MAGICIAN_HELMET = registerItem("wandering_magician_helmet", (properties) -> new WanderingMagicianArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(22))));
    public static final Item WANDERING_MAGICIAN_CHESTPLATE = registerItem("wandering_magician_chestplate", (properties) -> new WanderingMagicianArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(22))));
    public static final Item WANDERING_MAGICIAN_LEGGINGS = registerItem("wandering_magician_leggings", (properties) -> new WanderingMagicianArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(22))));
    public static final Item WANDERING_MAGICIAN_BOOTS = registerItem("wandering_magician_boots", (properties) -> new WanderingMagicianArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(22))));

    public static final Item PUMPKIN_HELMET = registerItem("pumpkin_helmet", (properties) -> new PumpkinArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(26))));
    public static final Item PUMPKIN_CHESTPLATE = registerItem("pumpkin_chestplate", (properties) -> new PumpkinArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(26))));
    public static final Item PUMPKIN_LEGGINGS = registerItem("pumpkin_leggings", (properties) -> new PumpkinArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(26))));
    public static final Item PUMPKIN_BOOTS = registerItem("pumpkin_boots", (properties) -> new PumpkinArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(26))));

    public static final Item PYROMANCER_HELMET = registerItem("pyromancer_helmet", (properties) -> new PyromancerArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item PYROMANCER_CHESTPLATE = registerItem("pyromancer_chestplate", (properties) -> new PyromancerArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item PYROMANCER_LEGGINGS = registerItem("pyromancer_leggings", (properties) -> new PyromancerArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item PYROMANCER_BOOTS = registerItem("pyromancer_boots", (properties) -> new PyromancerArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item ELECTROMANCER_HELMET = registerItem("electromancer_helmet", (properties) -> new ElectromancerArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item ELECTROMANCER_CHESTPLATE = registerItem("electromancer_chestplate", (properties) -> new ElectromancerArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item ELECTROMANCER_LEGGINGS = registerItem("electromancer_leggings", (properties) -> new ElectromancerArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item ELECTROMANCER_BOOTS = registerItem("electromancer_boots", (properties) -> new ElectromancerArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item ARCHEVOKER_HELMET = registerItem("archevoker_helmet", (properties) -> new ArchevokerArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item ARCHEVOKER_CHESTPLATE = registerItem("archevoker_chestplate", (properties) -> new ArchevokerArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item ARCHEVOKER_LEGGINGS = registerItem("archevoker_leggings", (properties) -> new ArchevokerArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item ARCHEVOKER_BOOTS = registerItem("archevoker_boots", (properties) -> new ArchevokerArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item CULTIST_HELMET = registerItem("cultist_helmet", (properties) -> new CultistArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item CULTIST_CHESTPLATE = registerItem("cultist_chestplate", (properties) -> new CultistArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item CULTIST_LEGGINGS = registerItem("cultist_leggings", (properties) -> new CultistArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item CULTIST_BOOTS = registerItem("cultist_boots", (properties) -> new CultistArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item CRYOMANCER_HELMET = registerItem("cryomancer_helmet", (properties) -> new CryomancerArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item CRYOMANCER_CHESTPLATE = registerItem("cryomancer_chestplate", (properties) -> new CryomancerArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item CRYOMANCER_LEGGINGS = registerItem("cryomancer_leggings", (properties) -> new CryomancerArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item CRYOMANCER_BOOTS = registerItem("cryomancer_boots", (properties) -> new CryomancerArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item SHADOWWALKER_HELMET = registerItem("shadowwalker_helmet", (properties) -> new ShadowwalkerArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item SHADOWWALKER_CHESTPLATE = registerItem("shadowwalker_chestplate", (properties) -> new ShadowwalkerArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item SHADOWWALKER_LEGGINGS = registerItem("shadowwalker_leggings", (properties) -> new ShadowwalkerArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item SHADOWWALKER_BOOTS = registerItem("shadowwalker_boots", (properties) -> new ShadowwalkerArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item PRIEST_HELMET = registerItem("priest_helmet", (properties) -> new PriestArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item PRIEST_CHESTPLATE = registerItem("priest_chestplate", (properties) -> new PriestArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item PRIEST_LEGGINGS = registerItem("priest_leggings", (properties) -> new PriestArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item PRIEST_BOOTS = registerItem("priest_boots", (properties) -> new PriestArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item PLAGUED_HELMET = registerItem("plagued_helmet", (properties) -> new PlaguedArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item PLAGUED_CHESTPLATE = registerItem("plagued_chestplate", (properties) -> new PlaguedArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item PLAGUED_LEGGINGS = registerItem("plagued_leggings", (properties) -> new PlaguedArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item PLAGUED_BOOTS = registerItem("plagued_boots", (properties) -> new PlaguedArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item NETHERITE_MAGE_HELMET = registerItem("netherite_mage_helmet", (properties) -> new NetheriteMageArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item NETHERITE_MAGE_CHESTPLATE = registerItem("netherite_mage_chestplate", (properties) -> new NetheriteMageArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item NETHERITE_MAGE_LEGGINGS = registerItem("netherite_mage_leggings", (properties) -> new NetheriteMageArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item NETHERITE_MAGE_BOOTS = registerItem("netherite_mage_boots", (properties) -> new NetheriteMageArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item WIZARD_HELMET = registerItem("wizard_helmet", (properties) -> new WizardArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final Item WIZARD_HAT = registerItem("wizard_hat", (properties) -> new WizardArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(37)).component(ComponentRegistry.CLOTHING_VARIANT, "hat")));
    public static final Item WIZARD_CHESTPLATE = registerItem("wizard_chestplate", (properties) -> new WizardArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item WIZARD_LEGGINGS = registerItem("wizard_leggings", (properties) -> new WizardArmorItem(ArmorItem.Type.LEGGINGS, properties.stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final Item WIZARD_BOOTS = registerItem("wizard_boots", (properties) -> new WizardArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));

    public static final Item PALADIN_CHESTPLATE = registerItem("paladin_chestplate", (properties) -> new PaladinArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).rarity(Rarity.EPIC).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final Item BOOTS_OF_SPEED = registerItem("speed_boots", (properties) -> new BootsOfSpeedArmorItem(ArmorItem.Type.BOOTS, properties.stacksTo(1).rarity(Rarity.EPIC).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(37))));
    public static final Item INFERNAL_SORCERER_CHESTPLATE = registerItem("infernal_sorcerer_chestplate", (properties) -> new InfernalSorcererArmorItem(ArmorItem.Type.CHESTPLATE, properties.stacksTo(1).rarity(Rarity.EPIC).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));

    public static final Item TARNISHED_CROWN = registerItem("tarnished_helmet", (properties) -> new TarnishedCrownArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).rarity(Rarity.UNCOMMON).durability(ArmorItem.Type.HELMET.getDurability(26))));
    public static final Item DEV_CROWN = registerItem("gold_crown", (properties) -> new GoldCrownArmorItem(ArmorItem.Type.HELMET, properties.stacksTo(1).rarity(Rarity.EPIC)));

    /**
     * Curios
     */
    public static final CurioBaseItem MANA_RING = registerItem("mana_ring", (properties) -> new CurioBaseItem(properties.stacksTo(1)).withAttributes(Curios.RING_SLOT, new AttributeContainer(AttributeRegistry.MAX_MANA, 100, AttributeModifier.Operation.ADD_VALUE)));
    public static final CurioBaseItem SILVER_RING = registerItem("silver_ring", (properties) -> new CurioBaseItem(properties.stacksTo(1)).withAttributes(Curios.RING_SLOT, new AttributeContainer(AttributeRegistry.MAX_MANA, 25, AttributeModifier.Operation.ADD_VALUE)));
    public static final CurioBaseItem COOLDOWN_RING = registerItem("cooldown_ring", (properties) -> new CurioBaseItem(properties.stacksTo(1)).withAttributes(Curios.RING_SLOT, new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)));
    public static final CurioBaseItem CAST_TIME_RING = registerItem("cast_time_ring", (properties) -> new CurioBaseItem(properties.stacksTo(1)).withAttributes(Curios.RING_SLOT, new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)));
    public static final CurioBaseItem HEAVY_CHAIN = registerItem("heavy_chain_necklace", (properties) -> new CurioBaseItem(properties.stacksTo(1)).withAttributes(Curios.NECKLACE_SLOT, new AttributeContainer(AttributeRegistry.SPELL_RESIST, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)));
    public static final CurioBaseItem EMERALD_STONEPLATE_RING = registerItem("emerald_stoneplate_ring", (properties) -> new SimpleDescriptiveCurio(properties.stacksTo(1), Curios.RING_SLOT));
    public static final CurioBaseItem FIREWARD_RING = registerItem("fireward_ring", (properties) -> new FirewardRing(properties.stacksTo(1)));
    public static final CurioBaseItem FROSTWARD_RING = registerItem("frostward_ring", (properties) -> new FrostwardRing(properties.stacksTo(1)));
    public static final CurioBaseItem POISONWARD_RING = registerItem("poisonward_ring", (properties) -> new PoisonwardRing(properties.stacksTo(1)));
    public static final CurioBaseItem CONJURERS_TALISMAN = registerItem("conjurers_talisman", (properties) -> new CurioBaseItem(properties.stacksTo(1)).withAttributes(Curios.NECKLACE_SLOT, new AttributeContainer(AttributeRegistry.SUMMON_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)));
    public static final CurioBaseItem GREATER_CONJURERS_TALISMAN = registerItem("greater_conjurers_talisman", (properties) -> new SimpleDescriptiveCurio(properties.stacksTo(1)).withAttributes(Curios.NECKLACE_SLOT, new AttributeContainer(AttributeRegistry.SUMMON_DAMAGE, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)));
    public static final CurioBaseItem AFFINITY_RING = registerItem("affinity_ring", (properties) -> new AffinityRing(properties.stacksTo(1)));
    public static final CurioBaseItem CONCENTRATION_AMULET = registerItem("concentration_amulet", properties -> new SimpleDescriptiveCurio(properties.stacksTo(1), Curios.NECKLACE_SLOT));
    public static final CurioBaseItem LURKER_RING = registerItem("lurker_ring", _ -> new LurkerRing(new Item.Properties().stacksTo(1)));
    public static final CurioBaseItem AMETHYST_RESONANCE_NECKLACE = registerItem("amethyst_resonance_charm", (properties) -> new CurioBaseItem(properties.stacksTo(1)).withAttributes(Curios.NECKLACE_SLOT, new AttributeContainer(AttributeRegistry.MANA_REGEN, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)));
    public static final CurioBaseItem INVISIBILITY_RING = registerItem("invisibility_ring", (properties) -> new InvisibiltyRing(properties.stacksTo(1)));
    public static final CurioBaseItem EXPULSION_RING = registerItem("expulsion_ring", (properties) -> new ExpulsionRing(new Item.Properties().stacksTo(1)));
    public static final CurioBaseItem VISIBILITY_RING = registerItem("visibility_ring", (properties) -> new VisibilityRing(properties.stacksTo(1)));
    public static final CurioBaseItem TELEPORTATION_AMULET = registerItem("teleportation_amulet", (properties) -> new TeleportationAmuletItem(properties.stacksTo(1).fireResistant()));
    public static final CurioBaseItem SIGNET_OF_THE_BETRAYER = registerItem("betrayer_signet", (properties) -> new BetrayerSignetRingItem(new Item.Properties().stacksTo(1).rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self()).fireResistant()).withAttributes(Curios.RING_SLOT, new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)));
    public static final CurioBaseItem WICKED_BONE_RING = registerItem("wicked_bone_ring", (properties) -> new WickedBoneRingItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()));

    /**
     * Music Discs
     */
    public static final Item MUSIC_DISC_DEAD_KING_LULLABY = registerItem("music_disc_dead_king_lullaby", (properties) -> new Item(properties.stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, IronsSpellbooks.id("dead_king_lullaby")))));
    public static final Item MUSIC_DISC_FLAME_STILL_BURNS = registerItem("music_disc_flame_still_burns", (properties) -> new Item(properties.stacksTo(1).rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self()).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, IronsSpellbooks.id("flame_still_burns")))));
    public static final Item FLAME_STILL_BURNS_FRAGMENT = registerItem("disc_fragment_flame_still_burns", (properties) -> new DiscFragmentItem(properties.rarity(RarityMixin.IRONS_SPELLBOOKS_CINDEROUS.self())));
    public static final Item MUSIC_DISC_WHISPERS_OF_ICE = registerItem("music_disc_whispers_of_ice", (properties) -> new Item(properties.stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, IronsSpellbooks.id("whispers_of_ice")))));

    /**
     * Spawn eggs
     */
    public static final SpawnEggItem KEEPER_SPAWN_EGG = registerItem("keeper_spawn_egg", p -> new SpawnEggItem(EntityRegistry.KEEPER, 0x352d2d, 0x766a76, p.stacksTo(64)));
    public static final SpawnEggItem DEAD_KING_CORPSE_SPAWN_EGG = registerItem("dead_king_corpse_spawn_egg", p -> new SpawnEggItem(EntityRegistry.DEAD_KING_CORPSE, 6842447, 15066584, p.stacksTo(64)));
    public static final SpawnEggItem ARCHEVOKER_SPAWN_EGG = registerItem("archevoker_spawn_egg", p -> new SpawnEggItem(EntityRegistry.ARCHEVOKER, 0x0C0C0C, 0xCCA858, p.stacksTo(64)));
    public static final SpawnEggItem NECROMANCER_SPAWN_EGG = registerItem("necromancer_spawn_egg", p -> new SpawnEggItem(EntityRegistry.NECROMANCER, 0x3E2B20, 0x515937, p.stacksTo(64)));
    public static final SpawnEggItem CRYOMANCER_SPAWN_EGG = registerItem("cryomancer_spawn_egg", p -> new SpawnEggItem(EntityRegistry.CRYOMANCER, 0xFFFFFF, 0x97ffed, p.stacksTo(64)));
    public static final SpawnEggItem PYROMANCER_SPAWN_EGG = registerItem("pyromancer_spawn_egg", p -> new SpawnEggItem(EntityRegistry.PYROMANCER, 0x7A1010, 0x262525, p.stacksTo(64)));
    public static final SpawnEggItem PRIEST_SPAWN_EGG = registerItem("priest_spawn_egg", p -> new SpawnEggItem(EntityRegistry.PRIEST, 0xFFFFFF, 0xffde58, p.stacksTo(64)));
    public static final SpawnEggItem APOTHECARIST_SPAWN_EGG = registerItem("apothecarist_spawn_egg", p -> new SpawnEggItem(EntityRegistry.APOTHECARIST, 0x37542a, 0xd49277, p.stacksTo(64)));
    public static final SpawnEggItem ICE_SPIDER_SPAWN_EGG = registerItem("ice_spider_spawn_egg", p -> new SpawnEggItem(EntityRegistry.ICE_SPIDER, 0x828192, 0xf5f5eb, p.stacksTo(64)));

    public static Collection<Item> getIronsItems() {
        return Set.copyOf(ITEMS);
    }

    private static <T extends Item> T registerItem(String name, Function<Item.Properties, T> itemFactory) {
        // Creating the item id
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, name);


        // Registering the item
        T registered = Registry.register(BuiltInRegistries.ITEM, itemID, itemFactory.apply(new Item.Properties()));

        // Storing the registered item separately
        ITEMS.add(registered);

        return registered;
    }
}
