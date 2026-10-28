package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.ICastData;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record OnClientCastPacket(String spellId, int level, CastSource castSource, ICastData castData) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<OnClientCastPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("on_client_cast"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OnClientCastPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, OnClientCastPacket::spellId, ByteBufCodecs.INT, OnClientCastPacket::level, CastSource.STREAM_CODEC, OnClientCastPacket::castSource, ICastData.STREAM_CODEC, OnClientCastPacket::castData, OnClientCastPacket::new);

    public OnClientCastPacket(String spellId, int level, CastSource castSource, ICastData castData) {
        this.spellId = spellId;
        this.level = level;
        this.castSource = castSource;
        this.castData = castData;
    }

    public static void handle(OnClientCastPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.handleClientboundOnClientCast(packet.spellId, packet.level, packet.castSource, packet.castData);
        //DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientSpellCastHelper.handleClientboundOnClientCast(spellId, level, castSource, castData));
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}