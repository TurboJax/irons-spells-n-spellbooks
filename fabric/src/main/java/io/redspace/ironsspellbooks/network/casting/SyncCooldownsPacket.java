package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.capabilities.magic.CooldownInstance;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.HashMap;
import java.util.Map;

public record SyncCooldownsPacket(Map<String,CooldownInstance> spellCooldowns) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncCooldownsPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_cooldowns"));

    public static final StreamCodec<RegistryFriendlyByteBuf, SyncCooldownsPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, CooldownInstance.STREAM_CODEC),
            SyncCooldownsPacket::spellCooldowns,
            SyncCooldownsPacket::new
    );

    public static void handle(SyncCooldownsPacket packet, ClientPlayNetworking.Context context) {
        var cooldowns = ClientMagicData.getCooldowns();
        cooldowns.clearCooldowns();
        packet.spellCooldowns.forEach((k, v) -> {
            cooldowns.addCooldown(k, v.getSpellCooldown(), v.getCooldownRemaining());
        });
        ClientMagicData.resetClientCastState(null);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}