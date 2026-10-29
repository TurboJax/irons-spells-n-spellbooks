package io.redspace.ironsspellbooks.network.casting;


import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.capabilities.magic.SyncedSpellData;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record SyncPlayerDataPacket(SyncedSpellData syncedSpellData) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncPlayerDataPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_player_data"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncPlayerDataPacket> STREAM_CODEC = StreamCodec.composite(SyncedSpellData.STREAM_CODEC, SyncPlayerDataPacket::syncedSpellData, SyncPlayerDataPacket::new);

    public static void handle(SyncPlayerDataPacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.handlePlayerSyncedData(packet.syncedSpellData);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}