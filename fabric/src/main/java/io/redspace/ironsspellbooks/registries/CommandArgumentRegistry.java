package io.redspace.ironsspellbooks.registries;

import com.mojang.brigadier.arguments.ArgumentType;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.command.SpellArgument;
import net.minecraft.commands.synchronization.SingletonArgumentInfo;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class CommandArgumentRegistry {
    private static <T extends ArgumentType<?>> SingletonArgumentInfo<T> registerSingleton(String key, Supplier<SingletonArgumentInfo<T>> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);

        return Registry.register(BuiltInRegistries.COMMAND_ARGUMENT_TYPE, id, val.get());
    }

    private static final Supplier<SingletonArgumentInfo<SpellArgument>> SPELL_COMMAND_ARGUMENT_TYPE = () -> registerSingleton("spell", () -> SingletonArgumentInfo.contextFree(SpellArgument::spellArgument));
}
