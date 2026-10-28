package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.spells.CastingMobAimingData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record SyncCastingMobAimingDataPacket(int entityId, CastingMobAimingData aimingData) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncCastingMobAimingDataPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_casting_mob_aiming_data"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncCastingMobAimingDataPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, SyncCastingMobAimingDataPacket::entityId, CastingMobAimingData.STREAM_CODEC, SyncCastingMobAimingDataPacket::aimingData, SyncCastingMobAimingDataPacket::new);

    public static void handle(SyncCastingMobAimingDataPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleCastingMobAimingData(packet.entityId, packet.aimingData);
    }

    @NotNull
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
