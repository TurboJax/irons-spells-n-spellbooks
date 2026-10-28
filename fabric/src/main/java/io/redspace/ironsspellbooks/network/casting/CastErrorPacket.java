package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

public record CastErrorPacket(CastErrorPacket.ErrorType errorType, String spellId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<CastErrorPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("cast_error"));

    public static final StreamCodec<RegistryFriendlyByteBuf,ErrorType> ERROR_TYPE_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ErrorType::ordinal, i -> ErrorType.values()[i]);
    public static final StreamCodec<RegistryFriendlyByteBuf, CastErrorPacket> STREAM_CODEC = StreamCodec.composite(ERROR_TYPE_STREAM_CODEC, CastErrorPacket::errorType, ByteBufCodecs.STRING_UTF8, CastErrorPacket::spellId, CastErrorPacket::new);

    public enum ErrorType {
        COOLDOWN,
        MANA
    }

    public static void handle(CastErrorPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleCastErrorMessage(packet);
    }

    @NotNull
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
