package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class EquipmentChangedPacket implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<EquipmentChangedPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("equipment_changed"));
    public static final StreamCodec<RegistryFriendlyByteBuf, EquipmentChangedPacket> STREAM_CODEC = CustomPacketPayload.codec(EquipmentChangedPacket::write, EquipmentChangedPacket::new);

    public EquipmentChangedPacket() {
    }

    public EquipmentChangedPacket(FriendlyByteBuf buf) {
    }

    public void write(FriendlyByteBuf buf) {
    }

    public static void handle(EquipmentChangedPacket packet, ClientPlayNetworking.Context context) {
        context.enqueueWork(() -> ClientMagicData.updateSpellSelectionManager());
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}