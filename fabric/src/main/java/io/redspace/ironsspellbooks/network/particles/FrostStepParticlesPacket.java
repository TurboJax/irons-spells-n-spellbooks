package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record FrostStepParticlesPacket(Vec3 pos1, Vec3 pos2) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<FrostStepParticlesPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("frost_step_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, FrostStepParticlesPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.VEC3,
            FrostStepParticlesPacket::pos1,
            SimpleCodecs.VEC3,
            FrostStepParticlesPacket::pos2,
            FrostStepParticlesPacket::new);

    public static void handle(FrostStepParticlesPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientboundFrostStep(packet.pos1, packet.pos2);
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
