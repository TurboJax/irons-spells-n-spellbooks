package io.redspace.ironsspellbooks.capabilities.magic;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.redspace.ironsspellbooks.api.network.ISerializable;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.ICastData;
import io.redspace.ironsspellbooks.api.spells.ICastDataSerializable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class RecastInstance implements ICastDataSerializable {
    public static final Codec<RecastInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.STRING.fieldOf("spellId").forGetter(RecastInstance::getSpellId), Codec.INT.fieldOf("spellLevel").forGetter(RecastInstance::getSpellLevel), Codec.INT.fieldOf("remainingRecasts").forGetter(RecastInstance::getRemainingRecasts), Codec.INT.fieldOf("totalRecasts").forGetter(RecastInstance::getTotalRecasts), Codec.INT.fieldOf("ticksToLive").forGetter(RecastInstance::getTicksToLive), Codec.INT.fieldOf("remainingTicks").forGetter(RecastInstance::getTicksRemaining), CastSource.CODEC.fieldOf("castSource").forGetter(RecastInstance::getCastSource), ICastData.CODEC.optionalFieldOf("castData").forGetter(RecastInstance::castData)).apply(instance, RecastInstance::new));
    public static final StreamCodec<RegistryFriendlyByteBuf,RecastInstance> STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistries(CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf,RecastInstance> STREAM_CODEC2 = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, RecastInstance::getSpellId, ByteBufCodecs.INT, RecastInstance::getSpellLevel, ByteBufCodecs.INT, RecastInstance::getRemainingRecasts, ByteBufCodecs.INT, RecastInstance::getTotalRecasts, ByteBufCodecs.INT, RecastInstance::getTicksToLive, ByteBufCodecs.INT, RecastInstance::getTicksRemaining, CastSource.STREAM_CODEC, RecastInstance::getCastSource, ISerializable.STREAM_CODEC, RecastInstance::getCastData, RecastInstance::new);

    protected String spellId;
    protected int spellLevel;
    protected int remainingRecasts;
    protected int totalRecasts;
    protected @Nullable ICastDataSerializable castData;
    protected int ticksToLive;
    protected int remainingTicks;
    protected CastSource castSource;

    public RecastInstance() {}

    public RecastInstance(String spellId, int spellLevel, int totalRecasts, int ticksToLive, CastSource castSource, @Nullable ICastDataSerializable castData) {
        this.spellId = spellId;
        this.spellLevel = spellLevel;
        this.remainingRecasts = totalRecasts - 1;
        this.totalRecasts = totalRecasts;
        this.ticksToLive = ticksToLive;
        this.remainingTicks = ticksToLive;
        this.castSource = castSource;
        this.castData = castData;
    }

    public RecastInstance(String spellId, Integer spellLevel, Integer remainingRecasts, Integer totalRecasts, Integer ticksToLive, Integer remainingTicks, CastSource castSource, Optional<ISerializable> castData) {
        this.spellId = spellId;
        this.spellLevel = spellLevel;
        this.remainingRecasts = remainingRecasts;
        this.totalRecasts = totalRecasts;
        this.ticksToLive = ticksToLive;
        this.remainingTicks = remainingTicks;
        this.castSource = castSource;
        this.castData = castData.orElse(null);
    }

    public String getSpellId() {
        return spellId;
    }

    public int getSpellLevel() {
        return spellLevel;
    }

    public int getRemainingRecasts() {
        return remainingRecasts;
    }

    public int getTotalRecasts() {
        return totalRecasts;
    }

    public int getTicksToLive() {
        return ticksToLive;
    }

    public int getTicksRemaining() {
        return remainingTicks;
    }

    public CastSource getCastSource() {
        return castSource;
    }

    @Nullable
    public ICastDataSerializable getCastData() {
        return castData;
    }

    public Optional<ISerializable> castData() {
        return Optional.ofNullable(castData);
    }

    // TODO: Remove bytebufs and use proper Codecs
    @Override
    public void writeToBuffer(FriendlyByteBuf buffer) {
        buffer.writeUtf(spellId);
        buffer.writeInt(spellLevel);
        buffer.writeInt(remainingRecasts);
        buffer.writeInt(totalRecasts);
        buffer.writeInt(ticksToLive);
        buffer.writeInt(remainingTicks);
        buffer.writeEnum(castSource);

        if (castData.isPresent()) {
            buffer.writeBoolean(true);
            castData.get().writeToBuffer(buffer);
        } else {
            buffer.writeBoolean(false);
        }
    }

    @Override
    public void readFromBuffer(FriendlyByteBuf buffer) {
        spellId = buffer.readUtf();
        spellLevel = buffer.readInt();
        remainingRecasts = buffer.readInt();
        totalRecasts = buffer.readInt();
        ticksToLive = buffer.readInt();
        remainingTicks = buffer.readInt();
        castSource = buffer.readEnum(CastSource.class);

        var hasCastData = buffer.readBoolean();
        if (hasCastData) {
            var tmpCastData = SpellRegistry.getSpell(spellId).getEmptyCastData();
            tmpCastData.readFromBuffer(buffer);
            castData = Optional.of(tmpCastData);
        }
    }

    //FIXME: 1.21: cannot serialized nbt without level access (unless we assume no cast data utilizes the holder lookup provider and pass in null)
//    @Override
//    public String toString() {
//        var cd = castData == null ? "" : castData.serializeNBT(this.).toString();
//        return String.format("spellId:%s, spellLevel:%d, remainingRecasts:%d, totalRecasts:%d, ticksToLive:%d, ticksRemaining:%d, castData:%s", spellId, spellLevel, remainingRecasts, totalRecasts, ticksToLive, remainingTicks, cd);
//    }
}
