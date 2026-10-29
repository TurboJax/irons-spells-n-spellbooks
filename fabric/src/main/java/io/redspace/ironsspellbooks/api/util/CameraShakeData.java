package io.redspace.ironsspellbooks.api.util;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.fabricmc.api.EnvType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class CameraShakeData {
    private final int id;
    private final Vec3 origin;
    private final ResourceKey<Level> dimension;
    private final float radius;
    private final int duration;
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
