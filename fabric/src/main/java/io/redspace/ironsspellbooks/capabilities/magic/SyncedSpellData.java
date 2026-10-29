package io.redspace.ironsspellbooks.capabilities.magic;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.api.magic.LearnedSpellData;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.gui.overlays.SpellSelection;
import io.redspace.ironsspellbooks.network.casting.SyncEntityDataPacket;
import io.redspace.ironsspellbooks.network.casting.SyncPlayerDataPacket;
import io.redspace.ironsspellbooks.player.SpinAttackType;
import io.redspace.ironsspellbooks.util.Log;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class SyncedSpellData {
    public static final Codec<SyncedSpellData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("serverPlayerId").forGetter(SyncedSpellData::getServerPlayerId),
            Codec.BOOL.fieldOf("isCasting").forGetter(SyncedSpellData::isCasting),
            Codec.STRING.fieldOf("castingSpellId").forGetter(SyncedSpellData::getCastingSpellId),
            Codec.INT.fieldOf("castingSpellLevel").forGetter(SyncedSpellData::getCastingSpellLevel),
            Codec.FLOAT.fieldOf("heartStopAccumulatedDamage").forGetter(SyncedSpellData::getHeartstopAccumulatedDamage),
            Codec.INT.fieldOf("evasionHitsRemaining").forGetter(SyncedSpellData::getEvasionHitsRemaining),
            SpinAttackType.CODEC.fieldOf("spinAttackType").forGetter(SyncedSpellData::getSpinAttackType),
            Codec.STRING.fieldOf("castingEquipmentSlot").forGetter(SyncedSpellData::getCastingEquipmentSlot),
            LearnedSpellData.CODEC.fieldOf("learnedSpellData").forGetter(s -> s.learnedSpellData),
            SpellSelection.CODEC.fieldOf("spellSelection").forGetter(s -> s.spellSelection)
    ).apply(instance, SyncedSpellData::new));

    public static final StreamCodec<RegistryFriendlyByteBuf,SyncedSpellData> STREAM_CODEC = StreamCodec.of(
            (buf, data) -> {
                buf.writeInt(data.serverPlayerId);
                buf.writeBoolean(data.isCasting);
                buf.writeUtf(data.castingSpellId);
                buf.writeInt(data.castingSpellLevel);
                buf.writeFloat(data.heartStopAccumulatedDamage);
                buf.writeInt(data.evasionHitsRemaining);
                SpinAttackType.STREAM_CODEC.encode(buf, data.spinAttackType);
                buf.writeUtf(data.castingEquipmentSlot);
                LearnedSpellData.STREAM_CODEC.encode(buf, data.learnedSpellData);
                SpellSelection.STREAM_CODEC.encode(buf, data.spellSelection);
            },
            buf -> {
                int id = buf.readInt();
                SyncedSpellData data = new SyncedSpellData(id);
                data.isCasting = buf.readBoolean();
                data.castingSpellId = buf.readUtf();
                data.castingSpellLevel = buf.readInt();
                data.heartStopAccumulatedDamage = buf.readFloat();
                data.evasionHitsRemaining = buf.readInt();
                data.spinAttackType = SpinAttackType.STREAM_CODEC.decode(buf);
                data.castingEquipmentSlot = buf.readUtf();
                data.learnedSpellData = LearnedSpellData.STREAM_CODEC.decode(buf);
                data.spellSelection = SpellSelection.STREAM_CODEC.decode(buf);
                return data;
            });

    //TODO: may want to switch this to ServerPlayer.UUID
    private final int serverPlayerId;
    private @Nullable LivingEntity livingEntity;

    private boolean isCasting;
    private String castingSpellId;
    private int castingSpellLevel;
    private float heartStopAccumulatedDamage;
    private int evasionHitsRemaining;
    private SpinAttackType spinAttackType;
    private LearnedSpellData learnedSpellData;
    private SpellSelection spellSelection;

    private String castingEquipmentSlot;

    // Use this on the client
    // the rest of the values are populated after initialization by the codec
    public SyncedSpellData(int serverPlayerId) {
        this.livingEntity = null;
        this.serverPlayerId = serverPlayerId;
        this.isCasting = false;
        this.castingSpellId = "";
        this.castingEquipmentSlot = "";
        this.castingSpellLevel = 0;
        this.heartStopAccumulatedDamage = 0f;
        this.evasionHitsRemaining = 0;
        this.spinAttackType = SpinAttackType.RIPTIDE;
        this.learnedSpellData = new LearnedSpellData();
        this.spellSelection = new SpellSelection();
    }

    public SyncedSpellData(int serverPlayerId, boolean isCasting, String castingSpellId, int castingSpellLevel, float heartStopAccumulatedDamage, int evasionHitsRemaining, SpinAttackType spinAttackType, String castingEquipmentSlot, LearnedSpellData learnedSpellData, SpellSelection spellSelection) {
        this.serverPlayerId = serverPlayerId;
        this.isCasting = isCasting;
        this.castingSpellId = castingSpellId;
        this.castingSpellLevel = castingSpellLevel;
        this.heartStopAccumulatedDamage = heartStopAccumulatedDamage;
        this.evasionHitsRemaining = evasionHitsRemaining;
        this.spinAttackType = spinAttackType;
        this.castingEquipmentSlot = castingEquipmentSlot;
        this.learnedSpellData = learnedSpellData;
        this.spellSelection = spellSelection;
    }

    //Use this on the server
    public SyncedSpellData(@Nullable LivingEntity livingEntity) {
        this(livingEntity == null ? -1 : livingEntity.getId());
        this.livingEntity = livingEntity;
    }

    public int getServerPlayerId() {
        return serverPlayerId;
    }

    public String getCastingEquipmentSlot() {
        return castingEquipmentSlot;
    }

    public float getHeartstopAccumulatedDamage() {
        return heartStopAccumulatedDamage;
    }

    public void setHeartstopAccumulatedDamage(float damage) {
        heartStopAccumulatedDamage = damage;
        doSync();
    }

    public SpellSelection getSpellSelection() {
        return spellSelection;
    }

    public void setSpellSelection(SpellSelection spellSelection) {
        if (Log.SPELL_SELECTION) {
            IronsSpellbooks.LOGGER.debug("SyncedSpellData.setSpellSelection {}", spellSelection);
        }
        this.spellSelection = spellSelection;
        doSync();
    }

    public void learnSpell(AbstractSpell spell) {
        learnSpell(spell, true);
    }

    public void learnSpell(AbstractSpell spell, boolean sync) {
        this.learnedSpellData.learnedSpells().add(spell.getSpellResource());
        if (sync) {
            doSync();
        }
    }

    public void forgetAllSpells() {
        this.learnedSpellData.learnedSpells().clear();
        doSync();
    }

    public boolean isSpellLearned(AbstractSpell spell) {
        return !spell.requiresLearning() || this.learnedSpellData.learnedSpells().contains(spell.getSpellResource());
    }

    public SpinAttackType getSpinAttackType() {
        return spinAttackType;
    }

    public void setSpinAttackType(SpinAttackType spinAttackType) {
        this.spinAttackType = spinAttackType;
        doSync();
    }

    public int getEvasionHitsRemaining() {
        return evasionHitsRemaining;
    }

    public void subtractEvasionHit() {
        evasionHitsRemaining--;
        doSync();
    }

    public void setEvasionHitsRemaining(int hitsRemaining) {
        evasionHitsRemaining = hitsRemaining;
        doSync();
    }

    public void addHeartstopDamage(float damage) {
        heartStopAccumulatedDamage += damage;
        doSync();
    }

    public void doSync() {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            SyncPlayerDataPacket packet = new SyncPlayerDataPacket(this);
            PlayerLookup.tracking(serverPlayer).forEach(p -> ServerPlayNetworking.send(p, packet));
            // If the above doesn't send the packet to the player, uncomment the next line:
            //ServerPlayNetworking.send(serverPlayer, packet);
        } else if (livingEntity instanceof IMagicEntity abstractSpellCastingMob) {
            SyncEntityDataPacket packet = new SyncEntityDataPacket(this, abstractSpellCastingMob);
            PlayerLookup.tracking(livingEntity).forEach(p -> ServerPlayNetworking.send(p, packet));
        }
    }

    public void syncToPlayer(ServerPlayer serverPlayer) {
        ServerPlayNetworking.send(serverPlayer, new SyncPlayerDataPacket(this));
    }

    public void setIsCasting(boolean isCasting, String castingSpellId, int castingSpellLevel, String castingEquipmentSlot) {
        this.isCasting = isCasting;
        this.castingSpellId = castingSpellId;
        this.castingSpellLevel = castingSpellLevel;
        this.castingEquipmentSlot = castingEquipmentSlot;
        doSync();
    }

    public boolean isCasting() {
        return isCasting;
    }

    public String getCastingSpellId() {
        return castingSpellId;
    }

    public int getCastingSpellLevel() {
        return castingSpellLevel;
    }

    @Override
    protected SyncedSpellData clone() {
        return new SyncedSpellData(this.livingEntity);
    }

    @Override
    public String toString() {
        return String.format("isCasting:%s, spellID:%s, spellLevel:%d",
                isCasting,
                castingSpellId,
                castingSpellLevel);
    }

    /**
     * @param serverPlayer New entity to own the copied data
     * @return Retuns a copy of this SyncedSpellData, but with only data for things that should be persisted after death.
     */
    public SyncedSpellData getPersistentData(ServerPlayer serverPlayer) {
        //This updates the reference while keeping the id the same (because we are in the middle of cloning logic, where id has not been set yet)
        SyncedSpellData persistentData = new SyncedSpellData(livingEntity);
        persistentData.livingEntity = serverPlayer;
        persistentData.learnedSpellData.learnedSpells().addAll(this.learnedSpellData.learnedSpells());
        persistentData.spellSelection = this.spellSelection;
        return persistentData;
    }
}
