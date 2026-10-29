package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record ShockwaveParticlesPacket(Vec3 pos, float radius, ParticleOptions particle) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ShockwaveParticlesPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("shockwave_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ShockwaveParticlesPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.VEC3,
            ShockwaveParticlesPacket::pos,
            ByteBufCodecs.FLOAT,
            ShockwaveParticlesPacket::radius,
            ParticleTypes.STREAM_CODEC,
            ShockwaveParticlesPacket::particle,
            ShockwaveParticlesPacket::new
    );

    public static void handle(ShockwaveParticlesPacket packet, ClientPlayNetworking.Context context) {
        try {
            ClientSpellCastHelper.handleClientboundShockwaveParticle(packet.pos, packet.radius, packet.particle);
        } catch (Exception ignored) {
        }
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
