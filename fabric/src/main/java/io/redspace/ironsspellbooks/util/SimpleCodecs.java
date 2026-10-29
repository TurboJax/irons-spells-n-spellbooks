package io.redspace.ironsspellbooks.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class SimpleCodecs {
    public static final StreamCodec<RegistryFriendlyByteBuf,UUID> UNIQUE_ID = StreamCodec.composite(ByteBufCodecs.VAR_LONG, UUID::getMostSignificantBits, ByteBufCodecs.VAR_LONG, UUID::getLeastSignificantBits, UUID::new);
    public static final StreamCodec<ByteBuf, Vec3> VEC3 = new StreamCodec<>() {
        public @NotNull Vec3 decode(final ByteBuf input) {
            return new Vec3(input.readDouble(), input.readDouble(), input.readDouble());
        }

        public void encode(final ByteBuf output, final Vec3 value) {
            output.writeDouble(value.x());
            output.writeDouble(value.y());
            output.writeDouble(value.z());
        }
    };
}
