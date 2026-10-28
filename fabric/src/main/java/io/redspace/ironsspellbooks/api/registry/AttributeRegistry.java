package io.redspace.ironsspellbooks.api.registry;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.attribute.MagicPercentAttribute;
import io.redspace.ironsspellbooks.api.attribute.MagicRangedAttribute;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class AttributeRegistry {
    public static final Holder<Attribute> MAX_MANA = register("max_mana", new MagicRangedAttribute("attribute.irons_spellbooks.max_mana", 100.0D, 0.0D, 1000000.0D).setSyncable(true));
    public static final Holder<Attribute> MANA_REGEN = register("mana_regen", new MagicPercentAttribute("attribute.irons_spellbooks.mana_regen", 1.0D, 0.0D, 100.0D).setSyncable(true));
    public static final Holder<Attribute> COOLDOWN_REDUCTION = register("cooldown_reduction", new MagicPercentAttribute("attribute.irons_spellbooks.cooldown_reduction", 1.0D, -100.0D, 100.0D).setSyncable(true));
    public static final Holder<Attribute> SPELL_POWER = register("spell_power", new MagicPercentAttribute("attribute.irons_spellbooks.spell_power", 1.0D, -100, 100.0D).setSyncable(true));
    public static final Holder<Attribute> SPELL_RESIST = register("spell_resist", new MagicPercentAttribute("attribute.irons_spellbooks.spell_resist", 1.0D, -100, 100.0D).setSyncable(true));
    public static final Holder<Attribute> CAST_TIME_REDUCTION = register("cast_time_reduction", new MagicPercentAttribute("attribute.irons_spellbooks.cast_time_reduction", 1.0D, -100, 100.0D).setSyncable(true));
    public static final Holder<Attribute> SUMMON_DAMAGE = register("summon_damage", new MagicPercentAttribute("attribute.irons_spellbooks.summon_damage", 1.0D, -100, 100.0D).setSyncable(true));
    public static final Holder<Attribute> CASTING_MOVESPEED = register("casting_movespeed", new MagicPercentAttribute("attribute.irons_spellbooks.casting_movespeed", 1, 0, 100.0D).setSyncable(true));

    public static final Holder<Attribute> FIRE_MAGIC_RESIST = newResistanceAttribute("fire");
    public static final Holder<Attribute> ICE_MAGIC_RESIST = newResistanceAttribute("ice");
    public static final Holder<Attribute> LIGHTNING_MAGIC_RESIST = newResistanceAttribute("lightning");
    public static final Holder<Attribute> HOLY_MAGIC_RESIST = newResistanceAttribute("holy");
    public static final Holder<Attribute> ENDER_MAGIC_RESIST = newResistanceAttribute("ender");
    public static final Holder<Attribute> BLOOD_MAGIC_RESIST = newResistanceAttribute("blood");
    public static final Holder<Attribute> EVOCATION_MAGIC_RESIST = newResistanceAttribute("evocation");
    public static final Holder<Attribute> NATURE_MAGIC_RESIST = newResistanceAttribute("nature");
    public static final Holder<Attribute> ELDRITCH_MAGIC_RESIST = newResistanceAttribute("eldritch");

    public static final Holder<Attribute> FIRE_SPELL_POWER = newPowerAttribute("fire");
    public static final Holder<Attribute> ICE_SPELL_POWER = newPowerAttribute("ice");
    public static final Holder<Attribute> LIGHTNING_SPELL_POWER = newPowerAttribute("lightning");
    public static final Holder<Attribute> HOLY_SPELL_POWER = newPowerAttribute("holy");
    public static final Holder<Attribute> ENDER_SPELL_POWER = newPowerAttribute("ender");
    public static final Holder<Attribute> BLOOD_SPELL_POWER = newPowerAttribute("blood");
    public static final Holder<Attribute> EVOCATION_SPELL_POWER = newPowerAttribute("evocation");
    public static final Holder<Attribute> NATURE_SPELL_POWER = newPowerAttribute("nature");
    public static final Holder<Attribute> ELDRITCH_SPELL_POWER = newPowerAttribute("eldritch");

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent e) {
        e.getTypes().forEach(entity -> ATTRIBUTES.getEntries().forEach(attribute -> e.add(entity, attribute)));
    }

    private static Holder<Attribute> newResistanceAttribute(String id) {
        return register(id + "_magic_resist", new MagicPercentAttribute("attribute.irons_spellbooks." + id + "_magic_resist", 1.0D, -100, 100).setSyncable(true));
    }

    private static Holder<Attribute> newPowerAttribute(String id) {
        return register(id + "_spell_power", new MagicPercentAttribute("attribute.irons_spellbooks." + id + "_spell_power", 1.0D, -100, 100).setSyncable(true));
    }

    public static Holder<Attribute> register(String key, Attribute attribute) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return Registry.registerForHolder(BuiltInRegistries.ATTRIBUTE, id, attribute);
    }
}
