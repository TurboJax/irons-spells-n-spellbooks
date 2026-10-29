package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientSpellCastHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.InteractionHand;

public record OpenEldritchScreenPacket(InteractionHand hand) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<OpenEldritchScreenPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("open_eldritch_screen"));
    public static final StreamCodec<RegistryFriendlyByteBuf, OpenEldritchScreenPacket> STREAM_CODEC = CustomPacketPayload.codec(OpenEldritchScreenPacket::write, OpenEldritchScreenPacket::new);

    public OpenEldritchScreenPacket(FriendlyByteBuf buf) {
        this(buf.readEnum(InteractionHand.class));
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeEnum(this.hand);
    }

    public static void handle(OpenEldritchScreenPacket packet, ClientPlayNetworking.Context context) {
        ClientSpellCastHelper.openEldritchResearchScreen(packet.hand);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}