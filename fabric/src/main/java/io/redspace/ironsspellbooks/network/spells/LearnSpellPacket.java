package io.redspace.ironsspellbooks.network.spells;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public record LearnSpellPacket(InteractionHand hand, String spell) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<LearnSpellPacket> TYPE = new CustomPacketPayload.Type<>(IronsSpellbooks.id("learn_spell"));
    public static final StreamCodec<RegistryFriendlyByteBuf, LearnSpellPacket> STREAM_CODEC = CustomPacketPayload.codec(LearnSpellPacket::write, LearnSpellPacket::new);

    public LearnSpellPacket(FriendlyByteBuf buf) {
        this(InteractionHand.values()[buf.readByte()], buf.readUtf());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeByte((byte) hand.ordinal());
        buf.writeUtf(spell);
    }

    public static void handle(LearnSpellPacket packet, ServerPlayNetworking.Context context) {
        if (context.player() instanceof ServerPlayer serverPlayer) {
            ItemStack itemStack = serverPlayer.getItemInHand(packet.hand);
            AbstractSpell spell = SpellRegistry.getSpell(packet.spell);
            var data = MagicData.getPlayerMagicData(serverPlayer).getSyncedData();
            if (spell != SpellRegistry.none() && !data.isSpellLearned(spell) && itemStack.is(ItemRegistry.ELDRITCH_PAGE) && itemStack.getCount() > 0) {
                data.learnSpell(spell);
                if (!serverPlayer.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
            }
        }
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
