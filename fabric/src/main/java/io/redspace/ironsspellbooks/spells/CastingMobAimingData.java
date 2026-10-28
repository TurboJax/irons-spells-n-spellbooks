package io.redspace.ironsspellbooks.spells;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.redspace.ironsspellbooks.api.spells.CastDataType;
import io.redspace.ironsspellbooks.api.spells.ICastDataSerializable;
import io.redspace.ironsspellbooks.registries.CastDataTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class CastingMobAimingData implements ICastDataSerializable {
    public static final Vector3f ZERO = new Vector3f();
    public static MapCodec<CastingMobAimingData> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(Codec.INT.fieldOf("hi")).apply(instance, ));

    public static StreamCodec<RegistryFriendlyByteBuf,CastingMobAimingData> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VECTOR3F, CastingMobAimingData::aimPosition, ByteBufCodecs.VECTOR3F, CastingMobAimingData::lastAimPosition, CastingMobAimingData::fromNetwork);

    private Vector3f aimPosition = ZERO;
    private Vector3f lastAimPosition = ZERO;
    private float lastPartialTick = 0;

    public Vector3f aimPosition() {
        return aimPosition;
    }

    public Vector3f lastAimPosition() {
        return lastAimPosition;
    }

    public void updateAim(Entity target, float strength) {
        Vector3f wanted = target.getBoundingBox().getCenter().toVector3f();
        if (aimPosition.equals(ZERO)) {
            aimPosition = wanted;
            lastAimPosition = wanted;
        } else {
            lastAimPosition = aimPosition;
            aimPosition = aimPosition.add(wanted.sub(aimPosition).mul(strength));
        }
    }

    @Override
    public CastDataType<?> getCastDataType() {
        return CastDataTypes.CASTING_MOB_AIMING_DATA;
    }

    public static CastingMobAimingData fromNetwork(Vector3f aimPosition, Vector3f lastAimPosition) {
        CastingMobAimingData data = new CastingMobAimingData();
        data.aimPosition =aimPosition;
        data.lastAimPosition = lastAimPosition;
        return data;
    }

    public Vec3 getAimPosition(float partialTick) {
        // create "lock" on partial tick so that packet delay doesn't leave the renderer snapping to the last old pos when partial tick loops back to 0
        if(partialTick > lastPartialTick ){
            lastPartialTick = partialTick;
        }
        return new Vec3(lastAimPosition.lerp(aimPosition, lastPartialTick));
    }

    public Vec3 getForward(Entity host) {
        return new Vec3(aimPosition).subtract(host.getEyePosition()).normalize();
    }

    @Override
    public void reset() {

    }
}
