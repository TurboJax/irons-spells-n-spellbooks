package io.redspace.ironsspellbooks.network.particles;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;

public record AbsorptionParticlesPacket(Vec3 pos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<AbsorptionParticlesPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("absorption_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, AbsorptionParticlesPacket> STREAM_CODEC = CustomPacketPayload.codec(AbsorptionParticlesPacket::write, AbsorptionParticlesPacket::new);

    public AbsorptionParticlesPacket(FriendlyByteBuf buf) {
        this(buf.readVec3());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeVec3(pos);
    }

    public static void handle(AbsorptionParticlesPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientsideAbsorptionParticles(packet.pos);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
