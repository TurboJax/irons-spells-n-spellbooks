package io.redspace.ironsspellbooks.util;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;

public class ModTags {
    public static final TagKey<Item> SCHOOL_FOCUS = ItemTags.create(IronsSpellbooks.id("school_focus"));
    public static final TagKey<Item> FIRE_FOCUS = ItemTags.create(IronsSpellbooks.id("fire_focus"));
    public static final TagKey<Item> ICE_FOCUS = ItemTags.create(IronsSpellbooks.id("ice_focus"));
    public static final TagKey<Item> LIGHTNING_FOCUS = ItemTags.create(IronsSpellbooks.id("lightning_focus"));
    public static final TagKey<Item> ENDER_FOCUS = ItemTags.create(IronsSpellbooks.id("ender_focus"));
    public static final TagKey<Item> HOLY_FOCUS = ItemTags.create(IronsSpellbooks.id("holy_focus"));
    public static final TagKey<Item> BLOOD_FOCUS = ItemTags.create(IronsSpellbooks.id("blood_focus"));
    public static final TagKey<Item> EVOCATION_FOCUS = ItemTags.create(IronsSpellbooks.id("evocation_focus"));
    public static final TagKey<Item> ELDRITCH_FOCUS = ItemTags.create(IronsSpellbooks.id("eldritch_focus"));
    public static final TagKey<Item> NATURE_FOCUS = ItemTags.create(IronsSpellbooks.id("nature_focus"));
    public static final TagKey<Item> INSCRIBED_RUNES = ItemTags.create(IronsSpellbooks.id("inscribed_rune"));
    public static final TagKey<Item> MITHRIL_INGOT = ItemTags.create(ResourceLocation.parse("c:ingots/mithril"));
    public static final TagKey<Item> CAN_BE_UPGRADED = ItemTags.create(IronsSpellbooks.id("upgrade_whitelist"));
    public static final TagKey<Item> CAN_BE_IMBUED = ItemTags.create(IronsSpellbooks.id("imbue_whitelist"));
    public static final TagKey<Item> BASE_WIZARD_HELMET = ItemTags.create(IronsSpellbooks.id("wizard_base_helmet"));
    public static final TagKey<Item> BASE_WIZARD_CHESTPLATE = ItemTags.create(IronsSpellbooks.id("wizard_base_chestplate"));
    public static final TagKey<Item> BASE_WIZARD_LEGGINGS = ItemTags.create(IronsSpellbooks.id("wizard_base_leggings"));
    public static final TagKey<Item> BASE_WIZARD_BOOTS = ItemTags.create(IronsSpellbooks.id("wizard_base_boots"));
    public static final TagKey<Item> DEAD_KING_RESPAWNABLE = ItemTags.create(IronsSpellbooks.id("dead_king_respawnable"));
    public static final TagKey<Item> SPELLBOOK_CURIO = ItemTags.create(ResourceLocation.fromNamespaceAndPath("curios", "spellbook"));
    public static final TagKey<Block> SPECTRAL_HAMMER_MINEABLE = BlockTags.create(IronsSpellbooks.id("spectral_hammer_mineable"));
    public static final TagKey<Block> GUARDED_BY_WIZARDS = BlockTags.create(IronsSpellbooks.id("guarded_by_wizards"));
    public static final TagKey<Block> PREVENT_POCKET_DIMENSION_PLACEMENT = BlockTags.create(IronsSpellbooks.id("pocket_dimension_prevent_placement"));

    public static final TagKey<MobEffect> CLEANSE_IMMUNE = TagKey.create(Registries.MOB_EFFECT, IronsSpellbooks.id("cleanse_immune"));
    public static final TagKey<MobEffect> AFFECTED_BY_SPIDER_ASPECT = TagKey.create(Registries.MOB_EFFECT, IronsSpellbooks.id("affected_by_spider_aspect"));

    public static final TagKey<Structure> WAYWARD_COMPASS_LOCATOR = TagKey.create(Registries.STRUCTURE, IronsSpellbooks.id("wayward_compass_locator"));

    public static final TagKey<EntityType<?>> ALWAYS_HEAL = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("always_heal"));
    public static final TagKey<EntityType<?>> CANT_ROOT = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("cant_root"));
    public static final TagKey<EntityType<?>> VILLAGE_ALLIES = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("village_allies"));
    public static final TagKey<EntityType<?>> CANT_USE_PORTAL = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("cant_use_portal"));
    public static final TagKey<EntityType<?>> INFERNAL_ALLIES = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("infernal_allies"));
    public static final TagKey<EntityType<?>> GUIDING_BOLT_IMMUNE = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("guiding_bolt_immune"));
    public static final TagKey<EntityType<?>> CANT_PRODUCE_BLOOD = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("cant_produce_blood"));
    public static final TagKey<EntityType<?>> CANT_PARRY = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("cant_parry"));
    public static final TagKey<EntityType<?>> CANT_RICOCHET = TagKey.create(Registries.ENTITY_TYPE, IronsSpellbooks.id("cant_ricochet"));

    public static final TagKey<Biome> ICE_SPIDER_PATROLS = TagKey.create(Registries.BIOME, IronsSpellbooks.id("ice_spider_patrols"));

    public static final TagKey<Fluid> CAULDRON_FLUID_DISALLOW = TagKey.create(Registries.FLUID, IronsSpellbooks.id("alchemist_cauldron_disallow"));

    private static TagKey<DamageType> create(String tag) {
        return TagKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, tag));
    }
}
