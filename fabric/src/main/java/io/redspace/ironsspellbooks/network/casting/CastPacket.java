package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public class CastPacket implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<CastPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("cast"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CastPacket> STREAM_CODEC = StreamCodec.unit(new CastPacket());

    public static void handle(CastPacket packet, ServerPlayNetworking.Context context) {
        if (context.player() instanceof ServerPlayer serverPlayer) {
            Utils.serverSideInitiateCast(serverPlayer);
        }
    }

    @NotNull
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
