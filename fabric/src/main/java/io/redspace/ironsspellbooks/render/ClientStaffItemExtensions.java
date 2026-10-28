package io.redspace.ironsspellbooks.render;

import io.redspace.ironsspellbooks.mixin.HumanModel$ArmPoseMixin;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

public class ClientStaffItemExtensions implements IClientItemExtensions {
    @Nullable
    @Override
    public HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
        return (HumanoidModel.ArmPose) (Object) HumanModel$ArmPoseMixin.IRONS_SPELLBOOKS_STAFF_ARM;
    }
}
