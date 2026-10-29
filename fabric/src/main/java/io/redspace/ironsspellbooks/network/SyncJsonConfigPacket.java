package io.redspace.ironsspellbooks.network;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.config.SpellConfigManager;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

/*
 * Would it be more efficient to sync the config itself, and not the json? Most certainly.
 * Is it dangerous to send just the json? Not really.
 * - A maximally configured spell is ~450 bytes.
 * - Assuming double the vanilla spells (200) which are all maximally configured, this is a size of 90,000 bytes
 * - Packet max size is orders of magnitude larger
 */
public record SyncJsonConfigPacket(Map<ResourceLocation,byte[]> data) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<SyncJsonConfigPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("sync_config"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SyncJsonConfigPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.map(HashMap::new, ResourceLocation.STREAM_CODEC, ByteBufCodecs.BYTE_ARRAY), SyncJsonConfigPacket::data, SyncJsonConfigPacket::new);

    public static void handle(SyncJsonConfigPacket packet, ClientPlayNetworking.Context context) {
        for (AbstractSpell spell : SpellRegistry.REGISTRY) {
            spell.resetRarityWeights();
        }
        SpellConfigManager.INSTANCE.handleClientSync(packet);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
