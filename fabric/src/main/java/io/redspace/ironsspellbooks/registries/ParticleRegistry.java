package io.redspace.ironsspellbooks.registries;

import com.mojang.serialization.MapCodec;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.particle.*;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class ParticleRegistry {
    public static <T extends ParticleOptions> Supplier<ParticleType<T>> register(String key, Supplier<ParticleType<T>> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return () -> Registry.register(BuiltInRegistries.PARTICLE_TYPE, id, val.get());
    }

    public static Supplier<SimpleParticleType> registerSimple(String key, Supplier<SimpleParticleType> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return () -> Registry.register(BuiltInRegistries.PARTICLE_TYPE, id, val.get());
    }

    /*
    To Create Particle:
    - textures + json
    - particle class
    - register it here
    - add it to particle helper
    - register it in client setup
     */

    public static final Supplier<SimpleParticleType> BLOOD_PARTICLE = registerSimple("blood", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> WISP_PARTICLE = registerSimple("wisp", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> BLOOD_GROUND_PARTICLE = registerSimple("blood_ground", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> SNOWFLAKE_PARTICLE = registerSimple("snowflake", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> ELECTRICITY_PARTICLE = registerSimple("electricity", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> UNSTABLE_ENDER_PARTICLE = registerSimple("unstable_ender", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> DRAGON_FIRE_PARTICLE = registerSimple("dragon_fire", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> FIRE_PARTICLE = registerSimple("fire", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> EMBER_PARTICLE = registerSimple("embers", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> SIPHON_PARTICLE = registerSimple("spell", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> ACID_PARTICLE = registerSimple("acid", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> ACID_BUBBLE_PARTICLE = registerSimple("acid_bubble", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> SNOW_DUST = registerSimple("snow_dust", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> RING_SMOKE_PARTICLE = registerSimple("ring_smoke", FabricParticleTypes::simple);
    public static final Supplier<ParticleType<FogParticleOptions>> FOG_PARTICLE = register("fog", () -> new ParticleType<>(true) {
        public MapCodec<FogParticleOptions> codec() {
            return FogParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, FogParticleOptions> streamCodec() {
            return FogParticleOptions.STREAM_CODEC;
        }
    });
    public static final Supplier<ParticleType<ShockwaveParticleOptions>> SHOCKWAVE_PARTICLE = register("shockwave", () -> new ParticleType<>(false) {
        public MapCodec<ShockwaveParticleOptions> codec() {
            return ShockwaveParticleOptions.CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, ShockwaveParticleOptions> streamCodec() {
            return ShockwaveParticleOptions.STREAM_CODEC;
        }
    });
    public static final Supplier<ParticleType<ZapParticleOption>> ZAP_PARTICLE = register("zap", () -> new ParticleType<>(false) {
        public MapCodec<ZapParticleOption> codec() {
            return ZapParticleOption.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, ZapParticleOption> streamCodec() {
            return ZapParticleOption.STREAM_CODEC;
        }
    });
    public static final Supplier<SimpleParticleType> FIREFLY_PARTICLE = registerSimple("firefly", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> PORTAL_FRAME_PARTICLE = registerSimple("portal_frame", FabricParticleTypes::simple);
    public static final Supplier<ParticleType<BlastwaveParticleOptions>> BLASTWAVE_PARTICLE = register("blastwave", () -> new ParticleType<>(true) {
        public MapCodec<BlastwaveParticleOptions> codec() {
            return BlastwaveParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, BlastwaveParticleOptions> streamCodec() {
            return BlastwaveParticleOptions.STREAM_CODEC;
        }
    });
    public static final Supplier<ParticleType<SparkParticleOptions>> SPARK_PARTICLE = register("spark", () -> new ParticleType<>(true) {
        public MapCodec<SparkParticleOptions> codec() {
            return SparkParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, SparkParticleOptions> streamCodec() {
            return SparkParticleOptions.STREAM_CODEC;
        }
    });
    public static final Supplier<SimpleParticleType> CLEANSE_PARTICLE = registerSimple("cleanse", FabricParticleTypes::simple);
    public static final Supplier<ParticleType<FlameStrikeParticleOptions>> FLAME_STRIKE_PARTICLE = register("flame_strike", () -> new ParticleType<>(true) {
        public MapCodec<FlameStrikeParticleOptions> codec() {
            return FlameStrikeParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, FlameStrikeParticleOptions> streamCodec() {
            return FlameStrikeParticleOptions.STREAM_CODEC;
        }
    });
    public static final Supplier<SimpleParticleType> EMBEROUS_ASH_PARTICLE = registerSimple("emberous_ash", FabricParticleTypes::simple);
    public static final Supplier<SimpleParticleType> FIERY_SMOKE_PARTICLE = registerSimple("fiery_smoke", () -> FabricParticleTypes.simple(true));
    public static final Supplier<ParticleType<EnderSlashParticleOptions>> ENDER_SLASH_PARTICLE = register("ender_slash", () -> new ParticleType<>(true) {
        public MapCodec<EnderSlashParticleOptions> codec() {
            return EnderSlashParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, EnderSlashParticleOptions> streamCodec() {
            return EnderSlashParticleOptions.STREAM_CODEC;
        }
    });

    public static final Supplier<ParticleType<TraceParticleOptions>> TRACE_PARTICLE = register("trace", () -> new ParticleType<>(true) {
        public MapCodec<TraceParticleOptions> codec() {
            return TraceParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, TraceParticleOptions> streamCodec() {
            return TraceParticleOptions.STREAM_CODEC;
        }

    });
    public static final Supplier<SimpleParticleType> FALLING_SPARKLE_PARTICLE = registerSimple("falling_sparkle", () -> FabricParticleTypes.simple(true));

    public static final Supplier<ParticleType<FallingBlockParticleOption>> FALLING_BLOCK_PARTICLE = register("falling_block", () -> new ParticleType<>(true) {
        public MapCodec<FallingBlockParticleOption> codec() {
            return FallingBlockParticleOption.codec((ParticleType<FallingBlockParticleOption>) this);
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, FallingBlockParticleOption> streamCodec() {
            return FallingBlockParticleOption.streamCodec((ParticleType<FallingBlockParticleOption>) this);
        }
    });

    public static final Supplier<ParticleType<SwirlingParticleOptions>> SWIRLING_PARTICLE = register("swirling_particle", () -> new ParticleType<>(false) {
        public MapCodec<SwirlingParticleOptions> codec() {
            return SwirlingParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, SwirlingParticleOptions> streamCodec() {
            return SwirlingParticleOptions.STREAM_CODEC;
        }
    });

    public static final Supplier<ParticleType<SoulfireRayParticleOptions>> SOULFIRE_RAY_PARTICLE = register("soulfire_ray", () -> new ParticleType<>(false) {
        public MapCodec<SoulfireRayParticleOptions> codec() {
            return SoulfireRayParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, SoulfireRayParticleOptions> streamCodec() {
            return SoulfireRayParticleOptions.STREAM_CODEC;
        }
    });
    public static final Supplier<SimpleParticleType> SOUL_FIRE_PARTICLE = registerSimple("soul_fire", FabricParticleTypes::simple);
    public static final Supplier<ParticleType<TintedBubblePopParticleOptions>> TINTED_BUBBLE_POP_PARTICLE = register("tinted_bubble_pop", () -> new ParticleType<>(false) {
        public MapCodec<TintedBubblePopParticleOptions> codec() {
            return TintedBubblePopParticleOptions.MAP_CODEC;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, TintedBubblePopParticleOptions> streamCodec() {
            return TintedBubblePopParticleOptions.STREAM_CODEC;
        }
    });

}
