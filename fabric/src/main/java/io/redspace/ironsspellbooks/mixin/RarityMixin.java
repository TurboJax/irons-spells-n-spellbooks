package io.redspace.ironsspellbooks.mixin;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Rarity.class)
public enum RarityMixin {
    IRONS_SPELLBOOKS_CINDEROUS(-1, "irons_spellbooks:cinderous", (ChatFormatting) (Object) ChatFormattingMixin.IRONS_SPELLBOOKS_CINDEROUS);

    @Shadow
    private RarityMixin(int id, String name, ChatFormatting color) {}

    @Unique
    public Rarity self() {
        return (Rarity) (Object) this;
    }
}