package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.util.CameraShakeData;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public record AddCameraShakePacket(int id, Vec3 origin, ResourceKey<Level> dimension, float radius, int duration) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<AddCameraShakePacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("add_camera_shake"));
    public static final StreamCodec<RegistryFriendlyByteBuf,AddCameraShakePacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            AddCameraShakePacket::id,
            SimpleCodecs.VEC3,
            AddCameraShakePacket::origin,
            ResourceKey.streamCodec(Registries.DIMENSION),
            AddCameraShakePacket::dimension,
            ByteBufCodecs.FLOAT,
            AddCameraShakePacket::radius,
            ByteBufCodecs.INT,
            AddCameraShakePacket::duration,
            AddCameraShakePacket::new
    );

    public AddCameraShakePacket(CameraShakeData data) {
        this(data.id(), data.origin(), data.dimension(), data.radius(), data.duration());
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(AddCameraShakePacket packet, ClientPlayNetworking.Context context) {
        CameraShakeManager.addClientCameraShake(new CameraShakeData(packet.id(), packet.origin(), packet.dimension(), packet.radius(), packet.duration()));
    }
}
