package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record OakskinParticlesPacket(Vec3 pos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<OakskinParticlesPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("oakskin_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OakskinParticlesPacket> STREAM_CODEC = StreamCodec.composite(SimpleCodecs.VEC3, OakskinParticlesPacket::pos, OakskinParticlesPacket::new);

    public static void handle(OakskinParticlesPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientboundOakskinParticles(packet.pos);
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
