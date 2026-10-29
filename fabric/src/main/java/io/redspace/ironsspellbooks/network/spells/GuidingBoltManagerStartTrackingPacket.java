package io.redspace.ironsspellbooks.network.spells;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.effect.guiding_bolt.GuidingBoltManager;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;

import java.util.List;
import java.util.UUID;

public record GuidingBoltManagerStartTrackingPacket(UUID entity, List<Integer> projectileIds) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<GuidingBoltManagerStartTrackingPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("guiding_bolt_manager_start_tracking"));
    public static final StreamCodec<RegistryFriendlyByteBuf, GuidingBoltManagerStartTrackingPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.UNIQUE_ID,
            GuidingBoltManagerStartTrackingPacket::entity,
            ByteBufCodecs.INT.apply(ByteBufCodecs.list()),
            GuidingBoltManagerStartTrackingPacket::projectileIds,
            GuidingBoltManagerStartTrackingPacket::new);

    public GuidingBoltManagerStartTrackingPacket(Entity entity, List<Projectile> projectiles) {
        this(entity.getUUID(), projectiles.stream().map(Entity::getId).toList());
    }

    public static void handle(GuidingBoltManagerStartTrackingPacket packet, ClientPlayNetworking.Context context) {
        GuidingBoltManager.handleClientboundStartTracking(packet.entity, packet.projectileIds);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}