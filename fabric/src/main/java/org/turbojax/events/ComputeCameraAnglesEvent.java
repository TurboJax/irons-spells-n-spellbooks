package org.turbojax.events;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import org.turbojax.event.Event;

public class ComputeCameraAnglesEvent implements Event {
    private final GameRenderer renderer;
    private final Camera camera;
    private final double partialTick;
    private float roll;
    private float pitch;
    private float yaw;

    public ComputeCameraAnglesEvent(Camera camera, double partialTick, float roll, float pitch, float yaw) {
        this.renderer = Minecraft.getInstance().gameRenderer;
        this.camera = camera;
        this.partialTick = partialTick;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public GameRenderer getRenderer() {
        return renderer;
    }

    public Camera getCamera() {
        return camera;
    }

    public double getPartialTick() {
        return partialTick;
    }

    public float getRoll() {
        return roll;
    }

    public void setRoll(float roll) {
        this.roll = roll;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }
}