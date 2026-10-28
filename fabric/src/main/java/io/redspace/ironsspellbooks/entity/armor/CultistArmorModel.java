package io.redspace.ironsspellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.item.armor.CultistArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class CultistArmorModel extends DefaultedItemGeoModel<CultistArmorItem> {

    public CultistArmorModel() {
        super(IronsSpellbooks.id(""));
    }

    @Override
    public ResourceLocation getModelResource(CultistArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "geo/cultist_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CultistArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "textures/models/armor/cultist.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CultistArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "animations/wizard_armor_animation.json");
    }
}