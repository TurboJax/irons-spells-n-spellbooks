package io.redspace.ironsspellbooks.spells;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.redspace.ironsspellbooks.api.spells.CastDataType;
import io.redspace.ironsspellbooks.api.spells.ICastDataSerializable;
import io.redspace.ironsspellbooks.api.spells.SerializableCastDataType;
import io.redspace.ironsspellbooks.registries.CastDataTypes;
import io.redspace.ironsspellbooks.registries.SerializableCastDataTypes;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class CastingMobAimingData implements ICastDataSerializable {
    public static MapCodec<CastingMobAimingData> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Vec3.CODEC.fieldOf("aimPosition").forGetter(CastingMobAimingData::aimPosition),
            Vec3.CODEC.fieldOf("lastAimPosition").forGetter(CastingMobAimingData::lastAimPosition)
        ).apply(instance, CastingMobAimingData::new));

    public static StreamCodec<RegistryFriendlyByteBuf,CastingMobAimingData> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.VEC3,
            CastingMobAimingData::aimPosition,
            SimpleCodecs.VEC3,
            CastingMobAimingData::lastAimPosition,
            CastingMobAimingData::new);

    private Vec3 aimPosition = Vec3.ZERO;
    private Vec3 lastAimPosition = Vec3.ZERO;
    private float lastPartialTick = 0;

    public CastingMobAimingData() {}

    public CastingMobAimingData(Vec3 aimPosition, Vec3 lastAimPositon) {
        this.aimPosition = aimPosition;
        this.lastAimPosition = lastAimPositon;
    }

    public Vec3 aimPosition() {
        return aimPosition;
    }

    public Vec3 lastAimPosition() {
        return lastAimPosition;
    }

    public void updateAim(Entity target, float strength) {
        Vec3 wanted = target.getBoundingBox().getCenter();
        if (aimPosition.equals(Vec3.ZERO)) {
            aimPosition = wanted;
            lastAimPosition = wanted;
        } else {
            lastAimPosition = aimPosition;
            aimPosition = aimPosition.add(wanted.subtract(aimPosition).scale(strength));
        }
    }

    public Vec3 getAimPosition(float partialTick) {
        // create "lock" on partial tick so that packet delay doesn't leave the renderer snapping to the last old pos when partial tick loops back to 0
        if (partialTick > lastPartialTick) {
            lastPartialTick = partialTick;
        }

        return lastAimPosition.lerp(aimPosition, lastPartialTick);
    }

    public Vec3 getForward(Entity host) {
        return aimPosition.subtract(host.getEyePosition()).normalize();
    }

    @Override
    public void reset() {}

    @Override
    public CastDataType<?> getCastDataType() {
        return CastDataTypes.CASTING_MOB_AIMING_DATA;
    }

    @Override
    public SerializableCastDataType<?> getSerializableType() {
        return SerializableCastDataTypes.CASTING_MOB_AIMING_DATA;
    }
}
