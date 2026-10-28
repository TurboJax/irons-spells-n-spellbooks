package io.redspace.ironsspellbooks.api.spells;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.registries.IronsRegistries;

public interface ICastData {
    Codec<ICastData> CODEC = IronsRegistries.CAST_DATA_TYPE.byNameCodec().dispatch("type", ICastData::getCastDataType, CastDataType::codec);

    void reset();

    CastDataType<?> getCastDataType();
}
