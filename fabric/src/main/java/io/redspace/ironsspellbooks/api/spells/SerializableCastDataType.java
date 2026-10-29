package io.redspace.ironsspellbooks.api.spells;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.registries.IronsRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public record SerializableCastDataType<T extends ICastDataSerializable>(StreamCodec<RegistryFriendlyByteBuf,T> codec) {
    public static final Codec<SerializableCastDataType<?>> CODEC = IronsRegistries.SERIALIZABLE_CAST_DATA_TYPE.byNameCodec();
}
