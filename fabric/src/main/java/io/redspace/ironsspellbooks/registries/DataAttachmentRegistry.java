package io.redspace.ironsspellbooks.registries;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.effect.EchoingStrikesData;
import io.redspace.ironsspellbooks.effect.OakskinData;
import io.redspace.ironsspellbooks.item.armor.IArmorCapeProvider;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;

public class DataAttachmentRegistry {
    public static final AttachmentType<MagicData> MAGIC_DATA = AttachmentRegistry.createPersistent(IronsSpellbooks.id("magic_data"), MagicData.CODEC);
    public static final AttachmentType<IArmorCapeProvider.CapeData> CAPE_DATA = ATTACHMENT_TYPES.register("cape_data",
            () -> AttachmentType.builder((holder) -> new IArmorCapeProvider.CapeData()).build());
    public static final AttachmentType<EchoingStrikesData> ECHOING_STRIKES_DATA = ATTACHMENT_TYPES.register("echoing_strikes_data",
            () -> AttachmentType.builder(EchoingStrikesData::new).serialize(Codec.INT.xmap(EchoingStrikesData::new, EchoingStrikesData::getHitCount), EchoingStrikesData::hasHitsRemaining).build());
    public static final AttachmentType<OakskinData> OAKSKIN_FROM_ELIXIR = ATTACHMENT_TYPES.register("oakskin_data",
            () -> AttachmentType.builder(holder -> OakskinData.INSTANCE).serialize(OakskinData.CODEC).build());
}
