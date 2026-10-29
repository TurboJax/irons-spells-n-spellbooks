package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.util.CameraShakeData;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record AddCameraShakePacket(CameraShakeData data) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<AddCameraShakePacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("add_camera_shake"));
    public static final StreamCodec<RegistryFriendlyByteBuf,AddCameraShakePacket> STREAM_CODEC = StreamCodec.composite(
            CameraShakeData.STREAM_CODEC,
            AddCameraShakePacket::data,
            AddCameraShakePacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(AddCameraShakePacket packet, ClientPlayNetworking.Context context) {
        CameraShakeManager.addClientCameraShake(packet.data());
    }
}
