package io.redspace.ironsspellbooks.network.debug;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.render.animation.AnimationHelper;
import io.redspace.ironsspellbooks.util.SimpleCodecs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public record PlayPlayerAnimationPacket(UUID playerId, ResourceLocation animation) implements CustomPacketPayload {
    public static final Type<PlayPlayerAnimationPacket> TYPE = new Type<>(IronsSpellbooks.id("play_player_animation"));
    public static final StreamCodec<RegistryFriendlyByteBuf, PlayPlayerAnimationPacket> STREAM_CODEC = StreamCodec.composite(
            SimpleCodecs.UNIQUE_ID,
            PlayPlayerAnimationPacket::playerId,
            ResourceLocation.STREAM_CODEC,
            PlayPlayerAnimationPacket::animation,
            PlayPlayerAnimationPacket::new);

    public static void handle(PlayPlayerAnimationPacket packet, ClientPlayNetworking.Context context) {
        var level = Minecraft.getInstance().level;
        if (level == null) return;

        var player = level.getPlayerByUUID(packet.playerId);
        if (player == null) return;

        AnimationHelper.animatePlayerStart(player, packet.animation);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
