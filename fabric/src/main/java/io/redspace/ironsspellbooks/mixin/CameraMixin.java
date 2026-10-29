package io.redspace.ironsspellbooks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.turbojax.event.EventManager;
import org.turbojax.events.ComputeCameraAnglesEvent;

@Mixin(Camera.class)
public class CameraMixin {
    @Shadow
    private float partialTickTime;

    @WrapOperation(method="setup",at=@At(value="INVOKE",target="Lnet/minecraft/client/Camera;setRotation(FF)V"))
    public void computeCameraAnglesEvent(Camera instance, float yRot, float xRot, Operation<Void> original) {
        ComputeCameraAnglesEvent event = new ComputeCameraAnglesEvent(instance, partialTickTime, 0, xRot, yRot);
        EventManager.call(event);

        original.call(instance, event.getYaw(), event.getPitch());
    }
}
