package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record BloodSiphonParticlesPacket(Vec3 pos1, Vec3 pos2) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<BloodSiphonParticlesPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("blood_siphon_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, BloodSiphonParticlesPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.VEC3,
            BloodSiphonParticlesPacket::pos1,
            SimpleCodecs.VEC3,
            BloodSiphonParticlesPacket::pos2,
            BloodSiphonParticlesPacket::new);

    public static void handle(BloodSiphonParticlesPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientboundBloodSiphonParticles(packet.pos1, packet.pos2);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
