package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.item.FurledMapItem;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabRegistry {
    public static final Holder<CreativeModeTab> EQUIPMENT_TAB = register("spellbook_equipment", FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + IronsSpellbooks.MOD_ID + ".spell_equipment_tab"))
            .icon(() -> new ItemStack(ItemRegistry.IRON_SPELL_BOOK))
            .displayItems((params, output) -> {
                output.accept(ItemRegistry.NETHERITE_SPELL_BOOK);
                output.accept(ItemRegistry.DIAMOND_SPELL_BOOK);
                output.accept(ItemRegistry.GOLD_SPELL_BOOK);
                output.accept(ItemRegistry.IRON_SPELL_BOOK);
                output.accept(ItemRegistry.COPPER_SPELL_BOOK);
                output.accept(ItemRegistry.EVOKER_SPELL_BOOK);
                output.accept(ItemRegistry.NECRONOMICON);
                output.accept(ItemRegistry.ROTTEN_SPELL_BOOK);
                output.accept(ItemRegistry.BLAZE_SPELL_BOOK);
                output.accept(ItemRegistry.DRAGONSKIN_SPELL_BOOK);
                output.accept(ItemRegistry.VILLAGER_SPELL_BOOK);
                output.accept(ItemRegistry.DRUIDIC_SPELL_BOOK);
                output.accept(ItemRegistry.CURSED_DOLL_SPELLBOOK);
                output.accept(ItemRegistry.ICE_SPELL_BOOK);
                output.accept(ItemRegistry.BLOOD_STAFF);
                output.accept(ItemRegistry.GRAYBEARD_STAFF);
                output.accept(ItemRegistry.ICE_STAFF);
                output.accept(ItemRegistry.ARTIFICER_STAFF);
                output.accept(ItemRegistry.LIGHTNING_ROD_STAFF);
                output.accept(ItemRegistry.PYRIUM_STAFF);
                output.accept(ItemRegistry.MAGEHUNTER);
                output.accept(ItemRegistry.SPELLBREAKER);
                output.accept(ItemRegistry.AMETHYST_RAPIER);
                output.accept(ItemRegistry.ICE_GREATSWORD);
                output.accept(ItemRegistry.TWILIGHT_GALE);
                output.accept(ItemRegistry.KEEPER_FLAMBERGE);
                output.accept(ItemRegistry.LEGIONNAIRE_FLAMBERGE);
                output.accept(ItemRegistry.DECREPIT_SCYTHE);
                output.accept(ItemRegistry.HELLRAZOR);
                output.accept(ItemRegistry.AUTOLOADER_CROSSBOW);
                output.accept(ItemRegistry.WAYWARD_COMPASS);

                output.accept(ItemRegistry.WANDERING_MAGICIAN_HELMET);
                output.accept(ItemRegistry.WANDERING_MAGICIAN_CHESTPLATE);
                output.accept(ItemRegistry.WANDERING_MAGICIAN_LEGGINGS);
                output.accept(ItemRegistry.WANDERING_MAGICIAN_BOOTS);
                output.accept(ItemRegistry.PUMPKIN_HELMET);
                output.accept(ItemRegistry.PUMPKIN_CHESTPLATE);
                output.accept(ItemRegistry.PUMPKIN_LEGGINGS);
                output.accept(ItemRegistry.PUMPKIN_BOOTS);
                output.accept(ItemRegistry.PYROMANCER_HELMET);
                output.accept(ItemRegistry.PYROMANCER_CHESTPLATE);
                output.accept(ItemRegistry.PYROMANCER_LEGGINGS);
                output.accept(ItemRegistry.PYROMANCER_BOOTS);
                output.accept(ItemRegistry.ELECTROMANCER_HELMET);
                output.accept(ItemRegistry.ELECTROMANCER_CHESTPLATE);
                output.accept(ItemRegistry.ELECTROMANCER_LEGGINGS);
                output.accept(ItemRegistry.ELECTROMANCER_BOOTS);
                output.accept(ItemRegistry.ARCHEVOKER_HELMET);
                output.accept(ItemRegistry.ARCHEVOKER_CHESTPLATE);
                output.accept(ItemRegistry.ARCHEVOKER_LEGGINGS);
                output.accept(ItemRegistry.ARCHEVOKER_BOOTS);
                output.accept(ItemRegistry.CULTIST_HELMET);
                output.accept(ItemRegistry.CULTIST_CHESTPLATE);
                output.accept(ItemRegistry.CULTIST_LEGGINGS);
                output.accept(ItemRegistry.CULTIST_BOOTS);
                output.accept(ItemRegistry.CRYOMANCER_HELMET);
                output.accept(ItemRegistry.CRYOMANCER_CHESTPLATE);
                output.accept(ItemRegistry.CRYOMANCER_LEGGINGS);
                output.accept(ItemRegistry.CRYOMANCER_BOOTS);
                output.accept(ItemRegistry.SHADOWWALKER_HELMET);
                output.accept(ItemRegistry.SHADOWWALKER_CHESTPLATE);
                output.accept(ItemRegistry.SHADOWWALKER_LEGGINGS);
                output.accept(ItemRegistry.SHADOWWALKER_BOOTS);
                output.accept(ItemRegistry.PRIEST_HELMET);
                output.accept(ItemRegistry.PRIEST_CHESTPLATE);
                output.accept(ItemRegistry.PRIEST_LEGGINGS);
                output.accept(ItemRegistry.PRIEST_BOOTS);
                output.accept(ItemRegistry.PLAGUED_HELMET);
                output.accept(ItemRegistry.PLAGUED_CHESTPLATE);
                output.accept(ItemRegistry.PLAGUED_LEGGINGS);
                output.accept(ItemRegistry.PLAGUED_BOOTS);
                output.accept(ItemRegistry.NETHERITE_MAGE_HELMET);
                output.accept(ItemRegistry.NETHERITE_MAGE_CHESTPLATE);
                output.accept(ItemRegistry.NETHERITE_MAGE_LEGGINGS);
                output.accept(ItemRegistry.NETHERITE_MAGE_BOOTS);
                output.accept(ItemRegistry.WIZARD_HELMET);
                output.accept(ItemRegistry.WIZARD_HAT);
                output.accept(ItemRegistry.WIZARD_CHESTPLATE);
                output.accept(ItemRegistry.WIZARD_LEGGINGS);
                output.accept(ItemRegistry.WIZARD_BOOTS);
                output.accept(ItemRegistry.INFERNAL_SORCERER_CHESTPLATE);
                output.accept(ItemRegistry.PALADIN_CHESTPLATE);
                output.accept(ItemRegistry.BOOTS_OF_SPEED);
                output.accept(ItemRegistry.TARNISHED_CROWN);
                output.accept(ItemRegistry.HITHER_THITHER_WAND);

                output.accept(ItemRegistry.MANA_RING);
                output.accept(ItemRegistry.SILVER_RING);
                output.accept(ItemRegistry.COOLDOWN_RING);
                output.accept(ItemRegistry.CAST_TIME_RING);
                output.accept(ItemRegistry.HEAVY_CHAIN);
                output.accept(ItemRegistry.EMERALD_STONEPLATE_RING);
                output.accept(ItemRegistry.FIREWARD_RING);
                output.accept(ItemRegistry.FROSTWARD_RING);
                output.accept(ItemRegistry.POISONWARD_RING);
                output.accept(ItemRegistry.CONJURERS_TALISMAN);
                output.accept(ItemRegistry.GREATER_CONJURERS_TALISMAN);
                output.accept(ItemRegistry.AFFINITY_RING);
                output.accept(ItemRegistry.CONCENTRATION_AMULET);
                output.accept(ItemRegistry.AMETHYST_RESONANCE_NECKLACE);
                output.accept(ItemRegistry.EXPULSION_RING);
                output.accept(ItemRegistry.VISIBILITY_RING);
                output.accept(ItemRegistry.TELEPORTATION_AMULET);
                output.accept(ItemRegistry.SIGNET_OF_THE_BETRAYER);
                output.accept(ItemRegistry.WICKED_BONE_RING);
                output.accept(ItemRegistry.INVISIBILITY_RING);

            })
            .build());

    public static final Holder<CreativeModeTab> MATERIALS_TAB = register("spellbook_materials", FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + IronsSpellbooks.MOD_ID + ".spell_materials_tab"))
            .icon(() -> new ItemStack(ItemRegistry.DIVINE_PEARL))
            .displayItems((params, output) -> {
                output.accept(ItemRegistry.INK_COMMON);
                output.accept(ItemRegistry.INK_UNCOMMON);
                output.accept(ItemRegistry.INK_RARE);
                output.accept(ItemRegistry.INK_EPIC);
                output.accept(ItemRegistry.INK_LEGENDARY);

                output.accept(ItemRegistry.LESSER_SPELL_SLOT_UPGRADE);
                output.accept(ItemRegistry.UPGRADE_ORB);
                output.accept(ItemRegistry.FIRE_UPGRADE_ORB);
                output.accept(ItemRegistry.ICE_UPGRADE_ORB);
                output.accept(ItemRegistry.LIGHTNING_UPGRADE_ORB);
                output.accept(ItemRegistry.HOLY_UPGRADE_ORB);
                output.accept(ItemRegistry.ENDER_UPGRADE_ORB);
                output.accept(ItemRegistry.BLOOD_UPGRADE_ORB);
                output.accept(ItemRegistry.EVOCATION_UPGRADE_ORB);
                output.accept(ItemRegistry.NATURE_UPGRADE_ORB);
                output.accept(ItemRegistry.MANA_UPGRADE_ORB);
                output.accept(ItemRegistry.COOLDOWN_UPGRADE_ORB);
                output.accept(ItemRegistry.PROTECTION_UPGRADE_ORB);

                output.accept(ItemRegistry.LIGHTNING_BOTTLE);
                output.accept(ItemRegistry.FROZEN_BONE_SHARD);
                output.accept(ItemRegistry.BLOOD_VIAL);
                output.accept(ItemRegistry.ICE_VENOM_VIAL);
                output.accept(ItemRegistry.DIVINE_PEARL);

                output.accept(ItemRegistry.MAGIC_CLOTH);
                output.accept(ItemRegistry.HOGSKIN);
                output.accept(ItemRegistry.BLOODY_VELLUM);
                output.accept(ItemRegistry.DRAGONSKIN);
                output.accept(ItemRegistry.ARCANE_ESSENCE);
                output.accept(ItemRegistry.RUINED_BOOK);
                output.accept(ItemRegistry.CHAINED_BOOK);
                output.accept(ItemRegistry.THE_CHRONICLE);
                output.accept(ItemRegistry.CINDER_ESSENCE);
                output.accept(ItemRegistry.TIMELESS_SLURRY);
                output.accept(ItemRegistry.MITHRIL_INGOT);
                output.accept(ItemRegistry.MITHRIL_SCRAP);
                output.accept(ItemRegistry.RAW_MITHRIL);
                output.accept(ItemRegistry.WEAPON_PARTS);
                output.accept(ItemRegistry.MITHRIL_WEAVE);
                output.accept(ItemRegistry.DIVINE_SOULSHARD);
                output.accept(ItemRegistry.PYRIUM_INGOT);
                output.accept(ItemRegistry.ARCANE_INGOT);
                output.accept(ItemRegistry.SHRIVING_STONE);
                output.accept(ItemRegistry.ELDRITCH_PAGE);
                output.accept(ItemRegistry.LOST_KNOWLEDGE_FRAGMENT);
                output.accept(ItemRegistry.ICY_FANG);
                output.accept(ItemRegistry.PREPARED_ICE_SPIDER_EGG);
                output.accept(ItemRegistry.COOKED_ICE_SPIDER_EGG_BLOCK_ITEM);
                output.accept(ItemRegistry.ICE_CRYSTAL);
                output.accept(ItemRegistry.FROSTED_HELVE);
                output.accept(ItemRegistry.ENERGIZED_CORE);
                output.accept(FurledMapItem.of(IronsSpellbooks.id("evoker_fort"),
                        ResourceKey.create(Registries.DIMENSION, ResourceLocation.withDefaultNamespace("overworld")), Component.translatable("item.irons_spellbooks.evoker_fort_battle_plans"), false));
                output.accept(FurledMapItem.of(IronsSpellbooks.id("mangrove_hut"),
                        ResourceKey.create(Registries.DIMENSION, ResourceLocation.withDefaultNamespace("overworld")), Component.translatable("item.irons_spellbooks.alchemical_trade_route"), false));
                output.accept(ItemRegistry.ICE_SPIDER_FURLED_MAP);
                output.accept(ItemRegistry.CITADEL_FURLED_MAP);

                output.accept(ItemRegistry.DECREPIT_KEY);
                output.accept(ItemRegistry.CINDEROUS_SOULCALLER);

                output.accept(ItemRegistry.BONE_KEY);
                output.accept(ItemRegistry.DEAD_KING_PHYLACTERY);
                output.accept(ItemRegistry.DEAD_KING_PHYLACTERY_SHARD);

                output.accept(ItemRegistry.BLANK_RUNE);
                output.accept(ItemRegistry.FIRE_RUNE);
                output.accept(ItemRegistry.ICE_RUNE);
                output.accept(ItemRegistry.LIGHTNING_RUNE);
                output.accept(ItemRegistry.ENDER_RUNE);
                output.accept(ItemRegistry.HOLY_RUNE);
                output.accept(ItemRegistry.BLOOD_RUNE);
                output.accept(ItemRegistry.EVOCATION_RUNE);
                output.accept(ItemRegistry.MANA_RUNE);
                output.accept(ItemRegistry.COOLDOWN_RUNE);
                output.accept(ItemRegistry.PROTECTION_RUNE);
                output.accept(ItemRegistry.NATURE_RUNE);

                output.accept(ItemRegistry.OAKSKIN_ELIXIR);
                output.accept(ItemRegistry.GREATER_OAKSKIN_ELIXIR);
                output.accept(ItemRegistry.GREATER_HEALING_POTION);
                output.accept(ItemRegistry.INVISIBILITY_ELIXIR);
                output.accept(ItemRegistry.GREATER_INVISIBILITY_ELIXIR);
                output.accept(ItemRegistry.EVASION_ELIXIR);
                output.accept(ItemRegistry.GREATER_EVASION_ELIXIR);
                output.accept(ItemRegistry.FIRE_ALE);
                output.accept(ItemRegistry.NETHERWARD_TINCTURE);
                output.accept(ItemRegistry.TINCTURE_OF_FORGETFULNESS);

                output.accept(ItemRegistry.MUSIC_DISC_DEAD_KING_LULLABY);
                output.accept(ItemRegistry.MUSIC_DISC_FLAME_STILL_BURNS);
                output.accept(ItemRegistry.FLAME_STILL_BURNS_FRAGMENT);
                output.accept(ItemRegistry.MUSIC_DISC_WHISPERS_OF_ICE);

                output.accept(ItemRegistry.KEEPER_SPAWN_EGG);
                output.accept(ItemRegistry.DEAD_KING_CORPSE_SPAWN_EGG);
                output.accept(ItemRegistry.ARCHEVOKER_SPAWN_EGG);
                output.accept(ItemRegistry.NECROMANCER_SPAWN_EGG);
                output.accept(ItemRegistry.CRYOMANCER_SPAWN_EGG);
                output.accept(ItemRegistry.PYROMANCER_SPAWN_EGG);
                output.accept(ItemRegistry.PRIEST_SPAWN_EGG);
                output.accept(ItemRegistry.APOTHECARIST_SPAWN_EGG);
                output.accept(ItemRegistry.ICE_SPIDER_SPAWN_EGG);
            })
            .build());

    public static final Holder<CreativeModeTab> BLOCKS_TAB = register("spellbook_blocks", FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + IronsSpellbooks.MOD_ID + ".blocks_tab"))
            .icon(() -> new ItemStack(ItemRegistry.INSCRIPTION_TABLE_BLOCK_ITEM))
            .displayItems((enabledFeatures, entries) -> {
                ItemRegistry.getIronsItems().forEach(holder -> {
                    if (holder instanceof BlockItem) {
                        entries.accept(holder);
                    }
                });
            })
            .build());

    public static final Holder<CreativeModeTab> SCROLLS_TAB = register("spellbook_scrolls", FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + IronsSpellbooks.MOD_ID + ".spellbook_scrolls_tab"))
            .icon(() -> new ItemStack(ItemRegistry.SCROLL))
            .displayItems((params, output) -> {
                SpellRegistry.getEnabledSpells().stream()
                        .filter(spell -> spell != SpellRegistry.none())
                        .forEach(spell -> {
                            for (int i = spell.getMinLevel(); i <= spell.getMaxLevel(); i++) {
                                ItemStack base = new ItemStack(ItemRegistry.SCROLL);
                                ISpellContainer.createScrollContainer(spell, i, base);
                                output.accept(base);
                            }
                        });
            })
            .build());

    public static Holder<CreativeModeTab> register(String key, CreativeModeTab tab) {
        return Registry.registerForHolder(BuiltInRegistries.CREATIVE_MODE_TAB, IronsSpellbooks.id(key), tab);
    }
}
