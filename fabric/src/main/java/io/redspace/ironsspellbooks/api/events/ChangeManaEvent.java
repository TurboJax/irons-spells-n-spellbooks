package io.redspace.ironsspellbooks.api.events;


import io.redspace.ironsspellbooks.api.magic.MagicData;
import net.minecraft.world.entity.player.Player;
import org.turbojax.event.Cancellable;


/**
 * ChangeManaEvent is fired whenever a {@link Player}'s mana is changed via {@link io.redspace.ironsspellbooks.api.magic.MagicData#setMana(float)}.<br>
 * <br>
 * This event is {@link Cancellable}.<br>
 * If this event is canceled, the player's mana does not change.<br>
 **/
public class ChangeManaEvent implements Cancellable {
    private final Player player;
    private final MagicData magicData;
    private final float oldMana;
    private float newMana;
    private boolean cancelled = false;

    public ChangeManaEvent(Player player, MagicData magicData, float oldMana, float newMana) {
        this.player = player;
        this.magicData = magicData;
        this.oldMana = oldMana;
        this.newMana = newMana;
    }

    public Player getPlayer() {
        return player;
    }

    public MagicData getMagicData() {
        return magicData;
    }

    public float getOldMana() {
        return oldMana;
    }

    public float getNewMana() {
        return newMana;
    }

    public void setNewMana(float newMana) {
        this.newMana = newMana;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
