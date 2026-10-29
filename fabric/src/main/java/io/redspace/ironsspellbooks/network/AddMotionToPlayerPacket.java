package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record AddMotionToPlayerPacket(double x, double y, double z, boolean preserveMomentum) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<AddMotionToPlayerPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("add_motion_to_player"));
    public static final StreamCodec<RegistryFriendlyByteBuf, AddMotionToPlayerPacket> STREAM_CODEC = CustomPacketPayload.codec(AddMotionToPlayerPacket::write, AddMotionToPlayerPacket::new);

    private AddMotionToPlayerPacket(RegistryFriendlyByteBuf buf) {
        this(buf.readDouble(),
                buf.readDouble(),
                buf.readDouble(),
                buf.readBoolean());
    }

    private void write(RegistryFriendlyByteBuf buf) {
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
        buf.writeBoolean(preserveMomentum);
    }

    public static void handle(AddMotionToPlayerPacket packet, ClientPlayNetworking.Context context) {
        var player = Minecraft.getInstance().player;
        if (player == null) return;

        if (packet.preserveMomentum)
            player.push(packet.x, packet.y, packet.z);
        else
            player.setDeltaMovement(packet.x, packet.y, packet.z);
    }

    @NotNull
    @Override
    public CustomPacketPayload.Type<AddMotionToPlayerPacket> type() {
        return TYPE;
    }
}
