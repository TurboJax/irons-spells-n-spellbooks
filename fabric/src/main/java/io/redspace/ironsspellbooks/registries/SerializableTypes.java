package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.network.ISerializable;
import io.redspace.ironsspellbooks.api.spells.SerializableType;
import io.redspace.ironsspellbooks.spells.CastingMobAimingData;
import io.redspace.ironsspellbooks.spells.fire.WallOfFireSpell;
import net.minecraft.core.Registry;

public class SerializableTypes {
    public static final SerializableType<CastingMobAimingData> CASTING_MOB_AIMING_DATA = register("casting_mob_aiming_data", new SerializableType<>(CastingMobAimingData.STREAM_CODEC));
    public static final SerializableType<WallOfFireSpell.FireWallData> FIRE_WALL_DATA = register("fire_wall_data", new SerializableType<>(WallOfFireSpell.FireWallData.STREAM_CODEC));

    private static <T extends ISerializable> SerializableType<T> register(String key, SerializableType<T> val) {
        return Registry.register(IronsRegistries.SERIALIZABLE_TYPE, IronsSpellbooks.id(key), val);
    }
}
