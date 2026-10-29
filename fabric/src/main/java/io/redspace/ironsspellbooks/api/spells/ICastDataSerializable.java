package io.redspace.ironsspellbooks.api.spells;

import io.redspace.ironsspellbooks.registries.IronsRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public interface ICastDataSerializable extends ICastData {
    StreamCodec<RegistryFriendlyByteBuf,ICastDataSerializable> STREAM_CODEC = ByteBufCodecs.registry(IronsRegistries.SERIALIZABLE_CAST_DATA_TYPE_KEY).dispatch(ICastDataSerializable::getSerializableType, SerializableCastDataType::codec);

    void reset();

    SerializableCastDataType<?> getSerializableType();
}
