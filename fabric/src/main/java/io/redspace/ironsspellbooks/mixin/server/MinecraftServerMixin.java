package io.redspace.ironsspellbooks.mixin.server;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.fabricmc.api.EnvType;
import net.minecraft.server.MinecraftServer;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.turbojax.event.EventManager;
import org.turbojax.events.ServerTickEvent;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method="tickServer", at = @At(value = "FIELD", target = "Lnet/minecraft/server/MinecraftServer;tickCount:I", opcode = Opcodes.PUTFIELD, shift= At.Shift.AFTER))
    public void onTick(BooleanSupplier booleanSupplier, CallbackInfo ci) {
        // Only calling ServerTickEvent from a dedicated server
        if (IronsSpellbooks.ENV == EnvType.CLIENT) return;

        EventManager.call(new ServerTickEvent());
    }
}
