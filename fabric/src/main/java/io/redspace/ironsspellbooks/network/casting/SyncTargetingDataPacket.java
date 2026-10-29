package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.capabilities.magic.ClientSpellTargetingData;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;
import java.util.UUID;

public record SyncTargetingDataPacket(List<UUID> targetUUIDs, String spellId) implements CustomPacketPayload {
    public static final Type<SyncTargetingDataPacket> TYPE = new Type<>(IronsSpellbooks.id("sync_targeting_data"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncTargetingDataPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.UNIQUE_ID.apply(ByteBufCodecs.list()),
            SyncTargetingDataPacket::targetUUIDs,
            ByteBufCodecs.STRING_UTF8,
            SyncTargetingDataPacket::spellId,
            SyncTargetingDataPacket::new
    );

    public SyncTargetingDataPacket(LivingEntity entity, AbstractSpell spell) {
        // For some reason client level doesn't have generic get by UUID. players need uuid, mobs need "id"
        this(List.of(entity.getUUID()), spell.getSpellId());
    }

    public static void handle(SyncTargetingDataPacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.setTargetingData(new ClientSpellTargetingData(packet.spellId, packet.targetUUIDs));
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}