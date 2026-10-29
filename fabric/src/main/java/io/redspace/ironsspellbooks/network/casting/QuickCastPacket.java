package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

public record QuickCastPacket(int slot) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<QuickCastPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("quick_cast"));
    public static final StreamCodec<RegistryFriendlyByteBuf, QuickCastPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, QuickCastPacket::slot, QuickCastPacket::new);

    public static void handle(QuickCastPacket packet, ServerPlayNetworking.Context context) {
        if (context.player() instanceof ServerPlayer serverPlayer) {
            Utils.serverSideInitiateQuickCast(serverPlayer, packet.slot);
        }
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
