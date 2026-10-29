package io.redspace.ironsspellbooks.mixin;

import io.redspace.ironsspellbooks.config.ClientConfigs;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.turbojax.event.EventManager;
import org.turbojax.events.ClientTickEvent;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;clientTickCount:J", opcode = Opcodes.PUTFIELD, shift= At.Shift.AFTER))
    public void onTick(CallbackInfo ci) {
        EventManager.call(new ClientTickEvent());
    }

    @Inject(method = "shouldEntityAppearGlowing", at = @At(value = "RETURN"), cancellable = true)
    public void irons_spellbooks$changeGlowOutline(Entity pEntity, CallbackInfoReturnable<Boolean> cir) {
        if (Minecraft.getInstance().player == null || pEntity == null || cir.getReturnValue()) {
            return;
        }
        if (ClientConfigs.SUMMONS_GLOW.get() && ClientMagicData.getActiveSummons().contains(pEntity.getUUID())) {
            cir.setReturnValue(true);
        } else if (Minecraft.getInstance().player.hasEffect(MobEffectRegistry.PLANAR_SIGHT) && pEntity instanceof LivingEntity && Mth.abs((float) (pEntity.getY() - Minecraft.getInstance().player.getY())) < 18) {
            cir.setReturnValue(true);
        }
    }
}
