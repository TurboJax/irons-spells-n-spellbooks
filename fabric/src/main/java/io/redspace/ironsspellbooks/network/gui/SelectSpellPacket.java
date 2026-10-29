package io.redspace.ironsspellbooks.network.gui;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.gui.overlays.SpellSelection;
import io.redspace.ironsspellbooks.util.Log;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record SelectSpellPacket(SpellSelection spellSelection) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SelectSpellPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("select_spell"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SelectSpellPacket> STREAM_CODEC = StreamCodec.composite(SpellSelection.STREAM_CODEC, SelectSpellPacket::spellSelection, SelectSpellPacket::new);

    public static void handle(SelectSpellPacket packet, ServerPlayNetworking.Context context) {
        if (Log.SPELL_SELECTION) {
            IronsSpellbooks.LOGGER.debug("ServerboundSelectSpell.handle {}", packet.spellSelection);
        }
        MagicData.getPlayerMagicData(context.player()).getSyncedData().setSpellSelection(packet.spellSelection);
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
