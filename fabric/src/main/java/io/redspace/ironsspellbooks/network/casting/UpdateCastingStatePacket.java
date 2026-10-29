package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record UpdateCastingStatePacket(String spellId, int spellLevel, int castTime, CastSource castSource, String castingEquipmentSlot) implements CustomPacketPayload {
    public static final Type<UpdateCastingStatePacket> TYPE = new Type<>(IronsSpellbooks.id("update_casting_state"));
    public static final StreamCodec<RegistryFriendlyByteBuf, UpdateCastingStatePacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            UpdateCastingStatePacket::spellId,
            ByteBufCodecs.INT,
            UpdateCastingStatePacket::spellLevel,
            ByteBufCodecs.INT,
            UpdateCastingStatePacket::castTime,
            CastSource.STREAM_CODEC,
            UpdateCastingStatePacket::castSource,
            ByteBufCodecs.STRING_UTF8,
            UpdateCastingStatePacket::castingEquipmentSlot,
            UpdateCastingStatePacket::new
    );

    public static void handle(UpdateCastingStatePacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.setClientCastState(
                packet.spellId,
                packet.spellLevel,
                packet.castTime,
                packet.castSource,
                packet.castingEquipmentSlot);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
