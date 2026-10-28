package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

import java.util.function.Supplier;

public class PotionRegistry {
    public static Potion register(String key, Supplier<Potion> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return Registry.register(BuiltInRegistries.POTION, id, val.get());
    }

    public static final Potion INSTANT_MANA_ONE = register("instant_mana_one", () -> new Potion("mana", new MobEffectInstance(MobEffectRegistry.INSTANT_MANA)));
    public static final Potion INSTANT_MANA_TWO = register("instant_mana_two", () -> new Potion("mana", new MobEffectInstance(MobEffectRegistry.INSTANT_MANA, 0, 1)));
    public static final Potion INSTANT_MANA_THREE = register("instant_mana_three", () -> new Potion("mana", new MobEffectInstance(MobEffectRegistry.INSTANT_MANA, 0, 2)));
    public static final Potion INSTANT_MANA_FOUR = register("instant_mana_four", () -> new Potion("mana", new MobEffectInstance(MobEffectRegistry.INSTANT_MANA, 0, 3)));

    // TODO: Add potion recipes
    // Maybe w/ datapack
    @SubscribeEvent
    public static void addRecipes(RegisterBrewingRecipesEvent event) {
        //IronsSpellbooks.LOGGER.debug("adding potion recipes");

        event.getBuilder().addMix(Potions.AWKWARD, ItemRegistry.ARCANE_ESSENCE.get(), PotionRegistry.INSTANT_MANA_ONE);
        event.getBuilder().addMix(PotionRegistry.INSTANT_MANA_ONE, Items.GLOWSTONE_DUST, PotionRegistry.INSTANT_MANA_TWO);
        event.getBuilder().addMix(PotionRegistry.INSTANT_MANA_TWO, Items.AMETHYST_SHARD, PotionRegistry.INSTANT_MANA_THREE);
        event.getBuilder().addMix(PotionRegistry.INSTANT_MANA_THREE, Items.AMETHYST_CLUSTER, PotionRegistry.INSTANT_MANA_FOUR);
    }
}
