package io.redspace.ironsspellbooks.api.spells;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.api.network.ISerializable;
import io.redspace.ironsspellbooks.registries.IronsRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public record SerializableType<T extends ISerializable>(StreamCodec<RegistryFriendlyByteBuf,T> codec) {
    public static final Codec<SerializableType<?>> CODEC = IronsRegistries.SERIALIZABLE_TYPE.byNameCodec();
}
