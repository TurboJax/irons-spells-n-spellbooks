package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.spells.CastDataType;
import io.redspace.ironsspellbooks.api.spells.ICastData;
import io.redspace.ironsspellbooks.spells.CastingMobAimingData;
import io.redspace.ironsspellbooks.spells.fire.WallOfFireSpell;
import net.minecraft.core.Registry;

public class CastDataTypes {
    public static final CastDataType<CastingMobAimingData> CASTING_MOB_AIMING_DATA = register("casting_mob_aiming_data", new CastDataType<>(CastingMobAimingData.MAP_CODEC));
    public static final CastDataType<WallOfFireSpell.FireWallData> FIRE_WALL_DATA = register("fire_wall_data", new CastDataType<>(WallOfFireSpell.FireWallData.MAP_CODEC));

    private static <T extends ICastData> CastDataType<T> register(String key, CastDataType<T> val) {
        return Registry.register(IronsRegistries.CAST_DATA_TYPE, IronsSpellbooks.id(key), val);
    }
}
