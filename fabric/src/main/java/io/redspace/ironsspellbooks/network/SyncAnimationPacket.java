package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.mobs.IAnimatedAttacker;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;

public record SyncAnimationPacket<T extends Entity & IAnimatedAttacker>(int entityId, String animationId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncAnimationPacket<?>> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_animation"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncAnimationPacket<?>> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            SyncAnimationPacket::entityId,
            ByteBufCodecs.STRING_UTF8,
            SyncAnimationPacket::animationId,
            SyncAnimationPacket::new);

    public SyncAnimationPacket(String animationId, T entity) {
        this(entity.getId(), animationId);
    }

    public static void handle(SyncAnimationPacket<?> packet, ClientPlayNetworking.Context context) {
        var level = Minecraft.getInstance().level;
        if (level == null) return;

        var entity = level.getEntity(packet.entityId);
        if (entity instanceof IAnimatedAttacker animatedAttacker) {
            animatedAttacker.playAnimation(packet.animationId);
        }
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
