package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record TeleportParticlesPacket(Vec3 pos1, Vec3 pos2) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<TeleportParticlesPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("teleport_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, TeleportParticlesPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.VEC3,
            TeleportParticlesPacket::pos1,
            SimpleCodecs.VEC3,
            TeleportParticlesPacket::pos2,
            TeleportParticlesPacket::new
    );

    public static void handle(TeleportParticlesPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientboundTeleport(packet.pos1, packet.pos2);
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
