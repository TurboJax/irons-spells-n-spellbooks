package io.redspace.ironsspellbooks.gui.overlays;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class SpellSelection {
    public static final Codec<SpellSelection> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("equipmentSlot").forGetter(SpellSelection::equipmentSlot),
            Codec.INT.fieldOf("index").forGetter(SpellSelection::index),
            Codec.STRING.fieldOf("lastEquipmentSlot").forGetter(SpellSelection::lastEquipmentSlot),
            Codec.INT.fieldOf("lastIndex").forGetter(SpellSelection::lastIndex)
    ).apply(instance, SpellSelection::new));

    public static final StreamCodec<ByteBuf,SpellSelection> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            SpellSelection::equipmentSlot,
            ByteBufCodecs.INT,
            SpellSelection::index,
            ByteBufCodecs.STRING_UTF8,
            SpellSelection::lastEquipmentSlot,
            ByteBufCodecs.INT,
            SpellSelection::lastIndex,
            SpellSelection::new
    );

    private String equipmentSlot;
    private int index;
    private String lastEquipmentSlot;
    private int lastIndex;

    public SpellSelection() {
        equipmentSlot = "";
        index = -1;
        lastEquipmentSlot = "";
        lastIndex = -1;
    }

    public SpellSelection(String equipmentSlot, int index, String lastEquipmentSlot, int lastIndex) {
        this.equipmentSlot = equipmentSlot;
        this.index = index;
        this.lastEquipmentSlot = lastEquipmentSlot;
        this.lastIndex = lastIndex;
    }

    public String equipmentSlot() {
        return equipmentSlot;
    }

    public int index() {
        return index;
    }

    public String lastEquipmentSlot() {
        return lastEquipmentSlot;
    }

    public int lastIndex() {
        return lastIndex;
    }

    public boolean isEmpty() {
        return index < 0;
    }

    public void makeSelection(String equipmentSlot, int index) {
        if (equipmentSlot != null && index >= 0) {
            this.lastEquipmentSlot = this.equipmentSlot;
            this.lastIndex = this.index;
            this.equipmentSlot = equipmentSlot;
            this.index = index;
        }
    }

    @Override
    public String toString() {
        return String.format("equipmentSlot:%s, index:%d, lastEquipmentSlot:%s, lastIndex:%d", equipmentSlot, index, lastEquipmentSlot, lastIndex);
    }
}