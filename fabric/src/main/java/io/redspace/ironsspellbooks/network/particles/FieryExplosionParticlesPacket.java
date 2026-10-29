package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record FieryExplosionParticlesPacket(Vec3 pos1, float radius) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<FieryExplosionParticlesPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("fiery_explosion_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, FieryExplosionParticlesPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.VEC3,
            FieryExplosionParticlesPacket::pos1,
            ByteBufCodecs.FLOAT,
            FieryExplosionParticlesPacket::radius,
            FieryExplosionParticlesPacket::new);

    public static void handle(FieryExplosionParticlesPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientboundFieryExplosion(packet.pos1, packet.radius);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
