package io.redspace.ironsspellbooks.api.util;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.api.EnvType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class CameraShakeData {
    public static final StreamCodec<RegistryFriendlyByteBuf, CameraShakeData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            CameraShakeData::id,
            SimpleCodecs.VEC3,
            CameraShakeData::origin,
            ResourceKey.streamCodec(Registries.DIMENSION),
            CameraShakeData::dimension,
            ByteBufCodecs.FLOAT,
            CameraShakeData::radius,
            ByteBufCodecs.INT,
            CameraShakeData::duration,
            CameraShakeData::new
    );

    private final int id;
    private final Vec3 origin;
    private final ResourceKey<Level> dimension;
    private final float radius;
    private final int duration;

    // Ignored by packets, omitted from codec.
    private int tick = 0;

    // Server-only
    public CameraShakeData(Vec3 origin, ResourceKey<Level> dimension, float radius, int duration) {
        if (IronsSpellbooks.ENV == EnvType.CLIENT) throw new RuntimeException("The client cannot create its own CameraShakeData ids");
        this(CameraShakeManager.getNextId(), origin, dimension, radius, duration);
    }

    // Client-only
    public CameraShakeData(int id, Vec3 origin, ResourceKey<Level> dimension, float radius, int duration) {
        this.id = id;
        this.origin = origin;
        this.dimension = dimension;
        this.radius = radius;
        this.duration = duration;
    }

    public int id() {
        return id;
    }

    public Vec3 origin() {
        return origin;
    }

    public ResourceKey<Level> dimension() {
        return dimension;
    }

    public float radius() {
        return radius;
    }

    public int duration() {
        return duration;
    }

    public int tick() {
        return tick;
    }

    public void incrTick() {
        tick++;
    }

    public boolean isDone() {
        return tick >= duration;
    }
}
