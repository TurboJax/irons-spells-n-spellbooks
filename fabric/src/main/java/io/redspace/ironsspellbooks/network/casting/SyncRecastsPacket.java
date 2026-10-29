package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.capabilities.magic.PlayerRecasts;
import io.redspace.ironsspellbooks.capabilities.magic.RecastInstance;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.HashMap;
import java.util.Map;

public record SyncRecastsPacket(Map<String,RecastInstance> recastLookup) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncRecastsPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_recasts"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncRecastsPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, RecastInstance.STREAM_CODEC),
            SyncRecastsPacket::recastLookup,
            SyncRecastsPacket::new);

    public static void handle(SyncRecastsPacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.setRecasts(new PlayerRecasts(packet.recastLookup));
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}