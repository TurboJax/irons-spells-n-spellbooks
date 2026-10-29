package io.redspace.ironsspellbooks.api.magic;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.redspace.ironsspellbooks.api.events.ChangeManaEvent;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.capabilities.magic.PlayerCooldowns;
import io.redspace.ironsspellbooks.capabilities.magic.PlayerRecasts;
import io.redspace.ironsspellbooks.capabilities.magic.SyncedSpellData;
import io.redspace.ironsspellbooks.registries.DataAttachmentRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.turbojax.event.EventManager;

// TODO: Port
// This class is an enigmatic mess of unordered junk that I have no clue to handle at this point in time. (Lookin' at you, ICastData)
// It'll take some work.
// I think I have the proper starting point with the codec registry that lets you get codecs for an instance of ICastData.
public class MagicData {
    public static final Codec<MagicData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("mana").forGetter(m -> (int) m.getMana()),
            PlayerCooldowns.CODEC.fieldOf("cooldowns").forGetter(MagicData::getPlayerCooldowns), // Should probably remake these to be Optional
            PlayerRecasts.CODEC.fieldOf("recasts").forGetter(MagicData::getPlayerRecasts),
            SyncedSpellData.CODEC.fieldOf("data").forGetter(MagicData::getSyncedData)
    ).apply(instance, MagicData::new));

    private boolean isMob = false;

    public MagicData(boolean isMob) {
        this.isMob = isMob;
    }

    public MagicData() {
        this(false);
    }

    public MagicData(ServerPlayer serverPlayer) {
        this(false);
        this.serverPlayer = serverPlayer;
        this.playerRecasts = new PlayerRecasts(serverPlayer);
    }

    public void setServerPlayer(ServerPlayer serverPlayer) {
        if (this.serverPlayer == null && serverPlayer != null) {
            this.serverPlayer = serverPlayer;
            this.playerRecasts = new PlayerRecasts(serverPlayer);
        }
    }

    private ServerPlayer serverPlayer = null;
    public static final String MANA = "mana";
    public static final String COOLDOWNS = "cooldowns";
    public static final String RECASTS = "recasts";

    /********* MANA *******************************************************/

    private float mana;

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        // If the player is null, the event isn't called
        if (serverPlayer == null) {
            this.mana = mana;
            return;
        }

        // Calling a ChangeManaEvent
        ChangeManaEvent e = new ChangeManaEvent(this.serverPlayer, this, this.mana, mana);
        EventManager.call(e);
        if (!e.isCancelled()) {
            this.mana = e.getNewMana();
        }

        // Enforcing the max mana
        float maxMana = (float) serverPlayer.getAttributeValue(AttributeRegistry.MAX_MANA);
        if (this.mana > maxMana) {
            this.mana = maxMana;
        }
    }

    public void addMana(float mana) {
        setMana(this.mana + mana);
    }

    /********* SYNC DATA *******************************************************/

    private SyncedSpellData syncedSpellData;

    public SyncedSpellData getSyncedData() {
        if (syncedSpellData == null) {
            syncedSpellData = new SyncedSpellData(serverPlayer);
        }

        return syncedSpellData;
    }

    public void setSyncedData(SyncedSpellData syncedSpellData) {
        this.syncedSpellData = syncedSpellData;
    }

    /********* CASTING *******************************************************/

    private int castingSpellLevel = 0;
    private int castDuration = 0;
    private int castDurationRemaining = 0;
    private CastSource castSource;
    private CastType castType;
    private @Nullable ICastData additionalCastData;
    private int poisonedTimestamp; //Poison does not have a damage source, so we mark when we are poisoned to ignore if instead of cancelling our long cast

    private ItemStack castingItemStack = ItemStack.EMPTY;


    public void resetCastingState() {
        //Ironsspellbooks.logger.debug("PlayerMagicData.resetCastingState: serverPlayer:{}", serverPlayer);
        this.castingSpellLevel = 0;
        this.castDuration = 0;
        this.castDurationRemaining = 0;
        this.castSource = CastSource.NONE;
        this.castType = CastType.NONE;
        this.getSyncedData().setIsCasting(false, "", 0, getCastingEquipmentSlot());
        resetAdditionalCastData();

        if (serverPlayer != null) {
            serverPlayer.stopUsingItem();
        }
    }

    public void initiateCast(AbstractSpell spell, int spellLevel, int castDuration, CastSource castSource, String castingEquipmentSlot) {
        this.castingSpellLevel = spellLevel;
        this.castDuration = castDuration;
        this.castDurationRemaining = castDuration;
        this.castSource = castSource;
        this.castType = spell.getCastType();
        this.syncedSpellData.setIsCasting(true, spell.getSpellId(), spellLevel, castingEquipmentSlot);
    }

    public ICastData getAdditionalCastData() {
        return additionalCastData;
    }

    public void setAdditionalCastData(ICastData newCastData) {
        additionalCastData = newCastData;
    }

    public void resetAdditionalCastData() {
        if (additionalCastData != null) {
            additionalCastData.reset();
            additionalCastData = null;
        }
    }

    public boolean isCasting() {
        return getSyncedData().isCasting();
    }

    public String getCastingEquipmentSlot() {
        return getSyncedData().getCastingEquipmentSlot();
    }

    public String getCastingSpellId() {
        return getSyncedData().getCastingSpellId();
    }

    public SpellData getCastingSpell() {
        return new SpellData(SpellRegistry.getSpell(getSyncedData().getCastingSpellId()), castingSpellLevel);
    }

    public int getCastingSpellLevel() {
        return castingSpellLevel;
    }

    public CastSource getCastSource() {
        if (castSource == null) {
            return CastSource.NONE;
        }

        return castSource;
    }

    public CastType getCastType() {
        return castType;
    }

    public float getCastCompletionPercent() {
        if (castDuration == 0) {
            return 1;
        }

        return 1 - (castDurationRemaining / (float) castDuration);
    }

    public int getCastDurationRemaining() {
        return castDurationRemaining;
    }

    public int getCastDuration() {
        return castDuration;
    }

    public void handleCastDuration() {
        castDurationRemaining--;

        if (castDurationRemaining <= 0) {
            castDurationRemaining = 0;
        }
    }

    public void setPlayerCastingItem(ItemStack itemStack) {
        this.castingItemStack = itemStack;
    }

    public ItemStack getPlayerCastingItem() {
        return this.castingItemStack;
    }

    public void markPoisoned() {
        if (this.serverPlayer != null) {
            this.poisonedTimestamp = serverPlayer.tickCount;
        }
    }

    public boolean popMarkedPoison() {
        if (this.serverPlayer != null) {
            boolean poisoned = this.serverPlayer.tickCount - poisonedTimestamp <= 1;
            //reset so magic damage on the same tick does not get marked as poison
            poisonedTimestamp = 0;
            return poisoned;
        }
        return false;
    }

    /********* COOLDOWNS *******************************************************/

    private final PlayerCooldowns playerCooldowns = new PlayerCooldowns();

    public PlayerCooldowns getPlayerCooldowns() {
        return this.playerCooldowns;
    }

    /********* RECASTS *******************************************************/

    private PlayerRecasts playerRecasts = new PlayerRecasts();

    public PlayerRecasts getPlayerRecasts() {
        // mobs cannot support the more advanced state tracking of recasts, provide no-op data holder instead
        // preserves maximum functionality
        return isMob ? new PlayerRecasts() : this.playerRecasts;
    }

    // TODO: port
//    @OnlyIn(Dist.CLIENT)
//    public void setPlayerRecasts(PlayerRecasts playerRecasts) {
//        this.playerRecasts = playerRecasts;
//    }

    /********* SYSTEM *******************************************************/

    public static MagicData getPlayerMagicData(LivingEntity livingEntity) {
        return livingEntity.getAttached(DataAttachmentRegistry.MAGIC_DATA);
    }

    @Override
    public String toString() {
        return String.format("isCasting:%s, spellID:%s], spellLevel:%s, duration:%s, durationRemaining:%s, source:%s, type:%s",
                getSyncedData().isCasting(),
                getSyncedData().getCastingSpellId(),
                castingSpellLevel,
                castDuration,
                castDurationRemaining,
                castSource,
                castType);
    }
}
