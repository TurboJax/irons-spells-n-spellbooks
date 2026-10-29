package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.block.scroll_forge.ScrollForgeTile;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record ScrollForgeSelectSpellPacket(BlockPos pos, String spellId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ScrollForgeSelectSpellPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("scroll_forge_select_spell"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ScrollForgeSelectSpellPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC,
            ScrollForgeSelectSpellPacket::pos,
            ByteBufCodecs.STRING_UTF8,
            ScrollForgeSelectSpellPacket::spellId,
            ScrollForgeSelectSpellPacket::new
    );

    public static void handle(ScrollForgeSelectSpellPacket packet, ServerPlayNetworking.Context context) {
        if (context.player().level().getBlockEntity(packet.pos) instanceof ScrollForgeTile scrollForgeTile) {
            scrollForgeTile.setRecipeSpell(packet.spellId);
        }
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
