package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.util.CameraShakeData;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.List;

public record SyncAllCameraShakesPacket(List<CameraShakeData> cameraShakeData) implements CustomPacketPayload {
    public static final Type<SyncAllCameraShakesPacket> TYPE = new Type<>(IronsSpellbooks.id("sync_all_camera_shake"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncAllCameraShakesPacket> STREAM_CODEC = StreamCodec.composite(
            CameraShakeData.STREAM_CODEC.apply(ByteBufCodecs.list()),
            SyncAllCameraShakesPacket::cameraShakeData,
            SyncAllCameraShakesPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(SyncAllCameraShakesPacket packet, ClientPlayNetworking.Context context) {
        CameraShakeManager.cameraShakeData.clear();
        CameraShakeManager.cameraShakeData.addAll(packet.cameraShakeData);
    }
}