package io.redspace.ironsspellbooks.api.spells;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import io.redspace.ironsspellbooks.registries.IronsRegistries;

public record CastDataType<T extends ICastData>(MapCodec<T> codec) {
    public static final Codec<CastDataType<?>> CODEC = IronsRegistries.CAST_DATA_TYPE.byNameCodec();
}
