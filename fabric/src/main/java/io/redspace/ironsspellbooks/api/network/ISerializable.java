package io.redspace.ironsspellbooks.api.network;

import io.redspace.ironsspellbooks.api.spells.SerializableType;
import io.redspace.ironsspellbooks.registries.IronsRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public interface ISerializable {
    StreamCodec<RegistryFriendlyByteBuf, ISerializable> STREAM_CODEC = ByteBufCodecs.registry(IronsRegistries.SERIALIZABLE_TYPE_KEY).dispatch(ISerializable::getSerializableType, SerializableType::codec);

    SerializableType<?> getSerializableType();
}
