package io.redspace.ironsspellbooks.api.magic;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record LearnedSpellData(Set<ResourceLocation> learnedSpells) {
    public static final Codec<LearnedSpellData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.listOf().fieldOf("learnedSpells").forGetter(LearnedSpellData::learnedList)
    ).apply(instance, LearnedSpellData::new));

    public static final StreamCodec<RegistryFriendlyByteBuf,LearnedSpellData> STREAM_CODEC = StreamCodec.composite(
            ResourceLocation.STREAM_CODEC.apply(ByteBufCodecs.list()),
            LearnedSpellData::learnedList,
            LearnedSpellData::new);

    // Making the collection mutable
    public LearnedSpellData(Collection<ResourceLocation> learnedSpells) {
        this(new HashSet<>(learnedSpells));
    }

    public LearnedSpellData() {
        this(new HashSet<>());
    }

    // There isn't a Set type for serialization, so we need to make a list copy
    private List<ResourceLocation> learnedList() {
        return List.copyOf(learnedSpells);
    }
}
