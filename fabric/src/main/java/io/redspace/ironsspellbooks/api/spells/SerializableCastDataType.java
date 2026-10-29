package io.redspace.ironsspellbooks.api.spells;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import io.redspace.ironsspellbooks.registries.IronsRegistries;
import net.minecraft.network.codec.StreamCodec;

public record SerializableCastDataType<T extends ICastDataSerializable>(StreamCodec<ByteBuf,T> codec) {
    public static final Codec<SerializableCastDataType<?>> CODEC = IronsRegistries.SERIALIZABLE_CAST_DATA_TYPE.byNameCodec();
}
