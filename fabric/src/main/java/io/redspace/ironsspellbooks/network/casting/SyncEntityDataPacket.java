package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.capabilities.magic.SyncedSpellData;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;

public record SyncEntityDataPacket(SyncedSpellData syncedSpellData, int entityId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncEntityDataPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_entity_data"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncEntityDataPacket> STREAM_CODEC = StreamCodec.composite(
            SyncedSpellData.STREAM_CODEC,
            SyncEntityDataPacket::syncedSpellData,
            ByteBufCodecs.INT,
            SyncEntityDataPacket::entityId,
            SyncEntityDataPacket::new);

    public SyncEntityDataPacket(SyncedSpellData syncedSpellData, IMagicEntity entity) {
        this(syncedSpellData, ((Entity) entity).getId());
    }

    public static void handle(SyncEntityDataPacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.handleAbstractCastingMobSyncedData(packet.entityId, packet.syncedSpellData);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
