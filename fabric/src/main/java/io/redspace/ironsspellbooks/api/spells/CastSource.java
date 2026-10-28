package io.redspace.ironsspellbooks.api.spells;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.config.ServerConfigs;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum CastSource implements StringRepresentable {
    SPELLBOOK,
    SCROLL,
    SWORD,
    MOB,
    COMMAND,
    NONE;

    public static final Codec<CastSource> CODEC = StringRepresentable.fromEnum(CastSource::values);
    public static final StreamCodec<RegistryFriendlyByteBuf, CastSource> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, CastSource::ordinal, i -> CastSource.values()[i]);

    public boolean consumesMana() {
        return this == SPELLBOOK || (this == SWORD && ServerConfigs.SWORDS_CONSUME_MANA.get());
    }

    public boolean respectsCooldown() {
        return this == SPELLBOOK || this == SWORD;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name();
    }
}
