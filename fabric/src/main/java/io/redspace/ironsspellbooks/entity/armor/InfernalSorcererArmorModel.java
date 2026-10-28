package io.redspace.ironsspellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.item.armor.InfernalSorcererArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class InfernalSorcererArmorModel extends DefaultedItemGeoModel<InfernalSorcererArmorItem> {

    public InfernalSorcererArmorModel() {
        super(IronsSpellbooks.id(""));
    }

    @Override
    public ResourceLocation getModelResource(InfernalSorcererArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "geo/infernal_sorcerer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(InfernalSorcererArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "textures/models/armor/infernal_sorcerer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(InfernalSorcererArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "animations/wizard_armor_animation.json");
    }
}