package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class EquipmentChangedPacket implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<EquipmentChangedPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("equipment_changed"));
    public static final StreamCodec<RegistryFriendlyByteBuf, EquipmentChangedPacket> STREAM_CODEC = StreamCodec.unit(new EquipmentChangedPacket());

    public static void handle(EquipmentChangedPacket packet, ClientPlayNetworking.Context context) {
        ClientMagicData.updateSpellSelectionManager();
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}