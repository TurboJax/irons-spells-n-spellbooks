package io.redspace.ironsspellbooks.network.casting;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.magic.MagicHelper;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.item.Scroll;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public record CancelCastPacket(boolean triggerCooldown) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<CancelCastPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("cancel_cast"));
    public static final StreamCodec<RegistryFriendlyByteBuf, CancelCastPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, CancelCastPacket::triggerCooldown, CancelCastPacket::new);

    public static void cancelCast(ServerPlayer serverPlayer, boolean triggerCooldown) {
        if (serverPlayer == null) return;

        var playerMagicData = MagicData.getPlayerMagicData(serverPlayer);
        if (playerMagicData.isCasting()) {
            var spellData = playerMagicData.getCastingSpell();

            if (triggerCooldown) {
                MagicHelper.MAGIC_MANAGER.addCooldown(serverPlayer, spellData.getSpell(), playerMagicData.getCastSource());
            }
            if (playerMagicData.getCastSource() == CastSource.SCROLL && spellData.getSpell().getCastType() == CastType.CONTINUOUS) {
                Scroll.attemptRemoveScrollAfterCast(serverPlayer);
            }
            playerMagicData.getCastingSpell().getSpell().onServerCastComplete(serverPlayer.level, spellData.getLevel(), serverPlayer, playerMagicData, true);
        }
    }

    public static void handle(CancelCastPacket packet, ServerPlayNetworking.Context context) {
        if (context.player() instanceof ServerPlayer serverPlayer) {
            cancelCast(serverPlayer, packet.triggerCooldown);
        }
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
