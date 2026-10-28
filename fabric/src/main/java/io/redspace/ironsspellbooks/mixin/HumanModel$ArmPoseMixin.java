package io.redspace.ironsspellbooks.mixin;

import net.minecraft.client.model.HumanoidModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HumanoidModel.ArmPose.class)
public enum HumanModel$ArmPoseMixin {
    IRONS_SPELLBOOKS_STAFF_ARM(false);

    @Shadow
    HumanModel$ArmPoseMixin(boolean twoHanded) {}
}