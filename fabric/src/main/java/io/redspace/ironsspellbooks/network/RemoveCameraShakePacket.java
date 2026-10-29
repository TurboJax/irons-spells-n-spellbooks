package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record RemoveCameraShakePacket(int id) implements CustomPacketPayload {
    public static final Type<RemoveCameraShakePacket> TYPE = new Type<>(IronsSpellbooks.id("remove_camera_shake"));
    public static final StreamCodec<RegistryFriendlyByteBuf,RemoveCameraShakePacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, RemoveCameraShakePacket::id, RemoveCameraShakePacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(RemoveCameraShakePacket packet, ClientPlayNetworking.Context context) {
        CameraShakeManager.removeClientCameraShake(packet.id());
    }
}
