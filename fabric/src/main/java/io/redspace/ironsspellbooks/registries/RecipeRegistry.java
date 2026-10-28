package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.recipe_types.NoAdditionSmithingTransformRecipe;
import io.redspace.ironsspellbooks.recipe_types.alchemist_cauldron.BrewAlchemistCauldronRecipe;
import io.redspace.ironsspellbooks.recipe_types.alchemist_cauldron.EmptyAlchemistCauldronRecipe;
import io.redspace.ironsspellbooks.recipe_types.alchemist_cauldron.FillAlchemistCauldronRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Function;
import java.util.function.Supplier;

public class RecipeRegistry {
    public static <T extends Recipe<?>> RecipeSerializer<T> registerSerializer(String key, Supplier<RecipeSerializer<T>> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, id, val.get());
    }

    public static <T extends Recipe<?>> RecipeType<T> registerType(String key, Function<Registry<RecipeType<?>>,RecipeType<T>> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, id, val.apply(BuiltInRegistries.RECIPE_TYPE));
    }

    public static final RecipeSerializer<FillAlchemistCauldronRecipe> ALCHEMIST_CAULDRON_FILL_SERIALIZER = registerSerializer("alchemist_cauldron_fill", FillAlchemistCauldronRecipe.Serializer::new);
    public static final RecipeType<FillAlchemistCauldronRecipe> ALCHEMIST_CAULDRON_FILL_TYPE = registerType("alchemist_cauldron_fill",
            // weird syntax, see https://docs.neoforged.net/docs/resources/server/recipes/custom/#the-recipe-type
            registry -> new RecipeType<FillAlchemistCauldronRecipe>() {
                @Override
                public String toString() {
                    return registry.toString();
                }
            });

    public static final RecipeSerializer<EmptyAlchemistCauldronRecipe> ALCHEMIST_CAULDRON_EMPTY_SERIALIZER = registerSerializer("alchemist_cauldron_empty", EmptyAlchemistCauldronRecipe.Serializer::new);
    public static final RecipeType<EmptyAlchemistCauldronRecipe> ALCHEMIST_CAULDRON_EMPTY_TYPE = registerType("alchemist_cauldron_empty",
            registry -> new RecipeType<>() {
                @Override
                public String toString() {
                    return registry.toString();
                }
            });

    public static final RecipeSerializer<BrewAlchemistCauldronRecipe> ALCHEMIST_CAULDRON_BREW_SERIALIZER
            = registerSerializer("alchemist_cauldron_brew", BrewAlchemistCauldronRecipe.Serializer::new);
    public static final RecipeType<BrewAlchemistCauldronRecipe> ALCHEMIST_CAULDRON_BREW_TYPE
            = registerType("alchemist_cauldron_brew", registry -> new RecipeType<>() {
        @Override
        public String toString() {
            return registry.toString();
        }
    });
    public static final RecipeSerializer<NoAdditionSmithingTransformRecipe> SMITHING_TRANSFORM_NO_ADDITION_SERIALIZER =
            registerSerializer("smithing_transform_no_addition", NoAdditionSmithingTransformRecipe.Serializer::new);

}
