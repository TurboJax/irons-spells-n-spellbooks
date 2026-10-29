package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record RegenCloudParticlesPacket(Vec3 pos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RegenCloudParticlesPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("regen_cloud_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, RegenCloudParticlesPacket> STREAM_CODEC = StreamCodec.composite(SimpleCodecs.VEC3, RegenCloudParticlesPacket::pos, RegenCloudParticlesPacket::new);

    public static void handle(RegenCloudParticlesPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientsideRegenCloudParticles(packet.pos);
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
