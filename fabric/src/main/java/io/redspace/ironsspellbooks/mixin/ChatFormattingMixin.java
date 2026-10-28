package io.redspace.ironsspellbooks.mixin;

import net.minecraft.ChatFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChatFormatting.class)
enum ChatFormattingMixin {
    IRONS_SPELLBOOKS_CINDEROUS("CINDEROUS", 'z', 82934, 0xF2552E);

    @Shadow
    private ChatFormattingMixin(String name, char code, int id, Integer color) {}
}