package io.redspace.ironsspellbooks.api.util;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.network.AddCameraShakePacket;
import io.redspace.ironsspellbooks.network.RemoveCameraShakePacket;
import io.redspace.ironsspellbooks.network.SyncAllCameraShakesPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import org.turbojax.event.Listener;
import org.turbojax.event.Subscribe;
import org.turbojax.events.ClientTickEvent;
import org.turbojax.events.ComputeCameraAnglesEvent;
import org.turbojax.events.ServerTickEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class CameraShakeManager implements Listener {
    // Lists for client and server data.
    // Not sure why they're separate.  Probably helps with clarity.
    public static final ArrayList<CameraShakeData> cameraShakeData = new ArrayList<>();
    public static final ArrayList<CameraShakeData> clientCameraShakeData = new ArrayList<>();

    private static final int fadeoutDuration = 20;
    private static final float fadeoutMultiplier = 1f / fadeoutDuration;

    private static int nextId = 0;

    public static int getNextId() {
        return nextId++;
    }

    @Subscribe
    public static void serverTick(ServerTickEvent event) {
        tick(cameraShakeData);
    }

    @Subscribe
    public static void clientTick(ClientTickEvent event) {
        tick(clientCameraShakeData);
    }

    private static void tick(ArrayList<CameraShakeData> shakeData) {
        if (shakeData.isEmpty()) return;

        var iter = shakeData.iterator();
        while (iter.hasNext()) {
            CameraShakeData data = iter.next();

            data.incrTick();
            if (data.isDone()) {
                iter.remove();

                // Sync packets are not sent by the client.
                if (IronsSpellbooks.ENV == EnvType.CLIENT) continue;
                IronsSpellbooks.broadcast(new RemoveCameraShakePacket(data.id()));
            }
        }
    }

    public static void addCameraShake(CameraShakeData data) {
        cameraShakeData.add(data);
        IronsSpellbooks.broadcast(new AddCameraShakePacket(data));
    }

    public static void removeCameraShake(CameraShakeData data) {
        if (cameraShakeData.removeIf(instance -> instance.id() == data.id())) {
            IronsSpellbooks.broadcast(new RemoveCameraShakePacket(data.id()));
        }
    }

    public static void addClientCameraShake(CameraShakeData data) {
        clientCameraShakeData.add(data);
    }

    public static void removeClientCameraShake(CameraShakeData data) {
        clientCameraShakeData.removeIf(instance -> instance.id() == data.id());
    }

    public static void removeClientCameraShake(int id) {
        clientCameraShakeData.removeIf(instance -> instance.id() == id);
    }

    public static void sendAll(ServerPlayer serverPlayer) {
        ServerPlayNetworking.send(serverPlayer, new SyncAllCameraShakesPacket(cameraShakeData));
    }

    @Subscribe
    public static void handleCameraShake(ComputeCameraAnglesEvent event) {
        if (clientCameraShakeData.isEmpty()) return;

        // Getting the camera shake to apply to the player
        var player = event.getCamera().getEntity();
        Optional<CameraShakeData> sortedActiveCameraShakes = clientCameraShakeData.stream()
                .filter(data -> data.dimension().equals(player.level().dimension()))
                .min(Comparator.comparingDouble(o -> o.origin().distanceToSqr(player.position())));

        if (sortedActiveCameraShakes.isEmpty()) return;

        CameraShakeData cameraShake = sortedActiveCameraShakes.get();
        var closestPos = cameraShake.origin();

        float distanceMultiplier = 1 / (cameraShake.radius() * cameraShake.radius());
        float fadeout = (cameraShake.duration() - cameraShake.tick()) >= fadeoutDuration ? 1f
                : ((cameraShake.duration() - cameraShake.tick()) * fadeoutMultiplier);
        fadeout = Math.clamp(fadeout, 0, 1); // additional safeguard against negative values
        float intensity = (float) Mth.clampedLerp(1, 0, closestPos.distanceToSqr(player.position()) * distanceMultiplier) * fadeout;

        float f = (float) (player.tickCount + event.getPartialTick());
        float yaw = Mth.cos(f * 1.5f) * intensity * .5f;
        float pitch = Mth.cos(f * 2f) * intensity * .5f;
        float roll = Mth.sin(f * 2.2f) * intensity * .5f;
        event.setYaw(event.getYaw() + yaw);
        event.setRoll(event.getRoll() + roll);
        event.setPitch(event.getPitch() + pitch);
    }
}
