package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.network.IClientEventEntity;
import io.redspace.ironsspellbooks.util.MinecraftInstanceHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;

public record EntityEventPacket<T extends Entity & IClientEventEntity>(int entityId, byte eventId) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<EntityEventPacket<?>> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("entity_event"));
    public static final StreamCodec<RegistryFriendlyByteBuf, EntityEventPacket<?>> STREAM_CODEC = CustomPacketPayload.codec(EntityEventPacket::write, EntityEventPacket::new);

    public EntityEventPacket(Entity pEntity, byte pEventId) {
        this(pEntity.getId(), pEventId);
    }

    public EntityEventPacket(FriendlyByteBuf pBuffer) {
        this(pBuffer.readInt(), pBuffer.readByte());
    }

    public void write(FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(this.entityId);
        pBuffer.writeByte(this.eventId);
    }

    public static void handle(EntityEventPacket<?> packet, ClientPlayNetworking.Context context) {
        MinecraftInstanceHelper.ifPlayerPresent(player -> {
            if (player.level().getEntity(packet.entityId) instanceof IClientEventEntity entity) {
                entity.handleClientEvent(packet.eventId);
            }
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}