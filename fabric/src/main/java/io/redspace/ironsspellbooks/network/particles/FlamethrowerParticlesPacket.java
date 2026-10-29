package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record FlamethrowerParticlesPacket(Vec3 position, Vec3 forward) implements CustomPacketPayload {
    public static final Type<FlamethrowerParticlesPacket> TYPE = new Type<>(IronsSpellbooks.id("flamethrower_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, FlamethrowerParticlesPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.VEC3,
            FlamethrowerParticlesPacket::position,
            SimpleCodecs.VEC3,
            FlamethrowerParticlesPacket::forward,
            FlamethrowerParticlesPacket::new);

    public static void handle(FlamethrowerParticlesPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientboundFlamethrowerParticles(packet.position, packet.forward);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
