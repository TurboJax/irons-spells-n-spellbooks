package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record RemoveRecastPacket(String spellId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RemoveRecastPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("remove_recast"));
    public static final StreamCodec<RegistryFriendlyByteBuf, RemoveRecastPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, RemoveRecastPacket::spellId, RemoveRecastPacket::new);

    public static void handle(RemoveRecastPacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.getRecasts().removeRecast(packet.spellId);
        ClientMagicData.cacheClientSummons();
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}