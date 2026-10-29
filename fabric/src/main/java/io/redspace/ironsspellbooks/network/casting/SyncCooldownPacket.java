package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record SyncCooldownPacket(String spellId, int duration) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncCooldownPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_cooldown"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncCooldownPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            SyncCooldownPacket::spellId,
            ByteBufCodecs.INT,
            SyncCooldownPacket::duration,
            SyncCooldownPacket::new
    );

    public static void handle(SyncCooldownPacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.getCooldowns().addCooldown(packet.spellId, packet.duration);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
