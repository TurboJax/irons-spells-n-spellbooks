package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.util.ModTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ArmorMaterialRegistry {
    public static Holder<ArmorMaterial> TARNISHED = register("tarnished",
            makeArmorMap(0, 0, 0, 0),
            15,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(ConventionalItemTags.IRON_INGOTS),
            0,
            0);

    public static Holder<ArmorMaterial> WANDERING_MAGICIAN = register("wandering_magician",
            makeArmorMap(2, 6, 5, 2),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ConventionalItemTags.LEATHERS),
            0,
            0);

    public static Holder<ArmorMaterial> PUMPKIN = register("pumpkin",
            schoolArmorMap(),
            15,
            SoundEvents.ARMOR_EQUIP_TURTLE,
            () -> Ingredient.of(Items.HAY_BLOCK),
            0,
            0);

    public static Holder<ArmorMaterial> SCHOOL = register("school_armor",
            schoolArmorMap(),
            20,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.asItem()),
            0,
            0);

    public static Holder<ArmorMaterial> NETHERITE_BATTLEMAGE = register("netherite_battlemage",
            schoolArmorMap(),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ConventionalItemTags.NETHERITE_INGOTS),
            3,
            0);

    public static Holder<ArmorMaterial> PALADIN = register("paladin",
            schoolArmorMap(),
            40,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModTags.MITHRIL_INGOT),
            4,
            0.4f);

    public static Holder<ArmorMaterial> INFERNAL_SORCERER = register("infernal_sorcerer",
            schoolArmorMap(),
            40,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ModTags.MITHRIL_INGOT),
            0,
            0f);

    public static Holder<ArmorMaterial> BOOTS_OF_SPEED = register("speed_boots",
            schoolArmorMap(),
            40,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ModTags.MITHRIL_INGOT),
            0,
            0f);

    public static Holder<ArmorMaterial> DEV = register("dev",
            makeArmorMap(20, 20, 20, 20),
            20,
            SoundEvents.ARMOR_EQUIP_GOLD,
            () -> Ingredient.of(ConventionalItemTags.GOLD_INGOTS),
            20,
            20);

    private static Holder<ArmorMaterial> register(
            String name,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantmentValue,
            Holder<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredient,
            float toughness,
            float knockbackResistance
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(IronsSpellbooks.id(name)));

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, name);
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, id, new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, list, toughness, knockbackResistance));
    }

    static public EnumMap<ArmorItem.Type, Integer> makeArmorMap(int helmet, int chestplate, int leggings, int boots) {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266655_) -> {
            p_266655_.put(ArmorItem.Type.BOOTS, boots);
            p_266655_.put(ArmorItem.Type.LEGGINGS, leggings);
            p_266655_.put(ArmorItem.Type.CHESTPLATE, chestplate);
            p_266655_.put(ArmorItem.Type.HELMET, helmet);
        });
    }

    static public EnumMap<ArmorItem.Type, Integer> schoolArmorMap() {
        return makeArmorMap(3, 8, 6, 3);
    }
}
