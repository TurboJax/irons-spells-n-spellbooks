package io.redspace.ironsspellbooks.capabilities.magic;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class CooldownInstance {
    public static final Codec<CooldownInstance> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("scd").forGetter(CooldownInstance::getSpellCooldown),
                    Codec.INT.fieldOf("cdr").forGetter(CooldownInstance::getCooldownRemaining)
            ).apply(instance, CooldownInstance::new));

    public static final StreamCodec<ByteBuf, CooldownInstance> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            CooldownInstance::getSpellCooldown,
            ByteBufCodecs.INT,
            CooldownInstance::getCooldownRemaining,
            CooldownInstance::new
    );

    private final int spellCooldown;
    private int cooldownRemaining;

    public CooldownInstance(int spellCooldown) {
        this.spellCooldown = spellCooldown;
        this.cooldownRemaining = spellCooldown;
    }

    public CooldownInstance(int spellCooldown, int cooldownRemaining) {
        this.spellCooldown = spellCooldown;
        this.cooldownRemaining = cooldownRemaining;
    }

    public void decrement() {
        cooldownRemaining--;
    }

    public void decrementBy(int amount) {
        cooldownRemaining -= amount;
    }

    public int getCooldownRemaining() {
        return cooldownRemaining;
    }

    public int getSpellCooldown() {
        return spellCooldown;
    }

    public float getCooldownPercent() {
        if (cooldownRemaining == 0) {
            return 0;
        }

        return cooldownRemaining / (float) spellCooldown;
    }
}