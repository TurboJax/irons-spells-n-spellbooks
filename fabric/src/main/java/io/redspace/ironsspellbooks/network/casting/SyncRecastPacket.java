package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.capabilities.magic.RecastInstance;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record SyncRecastPacket(RecastInstance recastInstance) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncRecastPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_recast"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncRecastPacket> STREAM_CODEC = StreamCodec.composite(RecastInstance.STREAM_CODEC, SyncRecastPacket::recastInstance, SyncRecastPacket::new);

    public static void handle(SyncRecastPacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.getRecasts().forceAddRecast(packet.recastInstance);
        ClientMagicData.cacheClientSummons();
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}