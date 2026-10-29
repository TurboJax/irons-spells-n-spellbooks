package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.spells.ICastDataSerializable;
import io.redspace.ironsspellbooks.api.spells.SerializableCastDataType;
import io.redspace.ironsspellbooks.spells.CastingMobAimingData;
import net.minecraft.core.Registry;

public class SerializableCastDataTypes {
    public static final SerializableCastDataType<CastingMobAimingData> CASTING_MOB_AIMING_DATA = register("casting_mob_aiming_data", new SerializableCastDataType<>(CastingMobAimingData.STREAM_CODEC));

    private static <T extends ICastDataSerializable> SerializableCastDataType<T> register(String key, SerializableCastDataType<T> val) {
        return Registry.register(IronsRegistries.SERIALIZABLE_CAST_DATA_TYPE, IronsSpellbooks.id(key), val);
    }
}
