package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record OnCastStartedPacket(String spellId, int spellLevel, UUID castingEntityId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<OnCastStartedPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("on_cast_started"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OnCastStartedPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, OnCastStartedPacket::spellId, ByteBufCodecs.VAR_INT, OnCastStartedPacket::spellLevel, SimpleCodecs.UNIQUE_ID, OnCastStartedPacket::castingEntityId, OnCastStartedPacket::new);

    public static void handle(OnCastStartedPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientBoundOnCastStarted(packet.castingEntityId, packet.spellId, packet.spellLevel);
    }

    @NotNull
    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
