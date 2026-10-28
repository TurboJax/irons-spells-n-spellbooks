package io.redspace.ironsspellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.item.armor.ElectromancerArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ElectromancerArmorModel extends DefaultedItemGeoModel<ElectromancerArmorItem> {

    public ElectromancerArmorModel() {
        super(IronsSpellbooks.id(""));
    }

    @Override
    public ResourceLocation getModelResource(ElectromancerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "geo/electromancer_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ElectromancerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "textures/models/armor/electromancer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ElectromancerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "animations/wizard_armor_animation.json");
    }
}