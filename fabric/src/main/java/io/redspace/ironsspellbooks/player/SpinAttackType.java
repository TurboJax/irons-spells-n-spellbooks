package io.redspace.ironsspellbooks.player;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record SpinAttackType(ResourceLocation textureId, boolean fullbright) {
    public static final Codec<SpinAttackType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("textureId").forGetter(SpinAttackType::textureId),
            Codec.BOOL.fieldOf("fullbright").forGetter(SpinAttackType::fullbright)
    ).apply(instance, SpinAttackType::new));

    public static final StreamCodec<ByteBuf,SpinAttackType> STREAM_CODEC = StreamCodec.composite(
            ResourceLocation.STREAM_CODEC,
            SpinAttackType::textureId,
            ByteBufCodecs.BOOL,
            SpinAttackType::fullbright,
            SpinAttackType::new);

    public static final SpinAttackType FIRE = new SpinAttackType(ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "textures/entity/fire_riptide.png"), true);
    public static final SpinAttackType LIGHTNING = new SpinAttackType(ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "textures/entity/lightning_riptide.png"), true);
    public static final SpinAttackType RIPTIDE = new SpinAttackType(ResourceLocation.withDefaultNamespace("textures/entity/trident_riptide.png"), false);
}
