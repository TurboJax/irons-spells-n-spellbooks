package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.spells.CastDataType;
import io.redspace.ironsspellbooks.api.spells.SerializableType;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class IronsRegistries {
    // Keys
    public static final ResourceKey<Registry<CastDataType<?>>> CAST_DATA_TYPE_KEY = ResourceKey.createRegistryKey(IronsSpellbooks.id("cast_data_type"));
    public static final ResourceKey<Registry<SerializableType<?>>> SERIALIZABLE_TYPE_KEY = ResourceKey.createRegistryKey(IronsSpellbooks.id("serializable_type"));

    // Registries
    public static final Registry<CastDataType<?>> CAST_DATA_TYPE = registerSimple(CAST_DATA_TYPE_KEY);
    public static final Registry<SerializableType<?>> SERIALIZABLE_TYPE = registerSimple(SERIALIZABLE_TYPE_KEY);

    public static <T> Registry<T> registerSimple(ResourceKey<Registry<T>> key, RegistryAttribute... attributes) {
        var builder = FabricRegistryBuilder.createSimple(key);
        for (RegistryAttribute attr : attributes) builder.attribute(attr);
        return builder.buildAndRegister();
    }
}
