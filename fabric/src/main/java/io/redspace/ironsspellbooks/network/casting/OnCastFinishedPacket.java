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

public record OnCastFinishedPacket(String spellId, UUID castingEntityId, boolean cancelled) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<OnCastFinishedPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("on_cast_finished"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OnCastFinishedPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, OnCastFinishedPacket::spellId, SimpleCodecs.UNIQUE_ID, OnCastFinishedPacket::castingEntityId, ByteBufCodecs.BOOL, OnCastFinishedPacket::cancelled, OnCastFinishedPacket::new);

    public static void handle(OnCastFinishedPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientBoundOnCastFinished(packet.castingEntityId, packet.spellId, packet.cancelled);
    }

    @NotNull
    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
