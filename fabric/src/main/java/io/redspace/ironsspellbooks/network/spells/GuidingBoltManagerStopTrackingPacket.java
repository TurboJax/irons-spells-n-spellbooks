package io.redspace.ironsspellbooks.network.spells;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.effect.guiding_bolt.GuidingBoltManager;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public record GuidingBoltManagerStopTrackingPacket(UUID entity) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<GuidingBoltManagerStopTrackingPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("guiding_bolt_manager_stop_tracking"));
    public static final StreamCodec<RegistryFriendlyByteBuf, GuidingBoltManagerStopTrackingPacket> STREAM_CODEC = StreamCodec.composite(SimpleCodecs.UNIQUE_ID, GuidingBoltManagerStopTrackingPacket::entity, GuidingBoltManagerStopTrackingPacket::new);

    public GuidingBoltManagerStopTrackingPacket(Entity entity) {
        this(entity.getUUID());
    }

    public static void handle(GuidingBoltManagerStopTrackingPacket packet, ClientPlayNetworking.Context context) {
        GuidingBoltManager.handleClientboundStopTracking(packet.entity);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}