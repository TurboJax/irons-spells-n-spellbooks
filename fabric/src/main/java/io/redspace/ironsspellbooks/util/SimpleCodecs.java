package io.redspace.ironsspellbooks.util;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.UUID;

public class SimpleCodecs {
    public static final StreamCodec<RegistryFriendlyByteBuf,UUID> UNIQUE_ID = StreamCodec.composite(ByteBufCodecs.VAR_LONG, UUID::getMostSignificantBits, ByteBufCodecs.VAR_LONG, UUID::getLeastSignificantBits, UUID::new);
}
