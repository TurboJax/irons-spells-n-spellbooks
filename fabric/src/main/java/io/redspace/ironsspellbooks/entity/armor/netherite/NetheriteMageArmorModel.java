package io.redspace.ironsspellbooks.entity.armor.netherite;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.item.armor.NetheriteMageArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class NetheriteMageArmorModel extends DefaultedItemGeoModel<NetheriteMageArmorItem> {

    public NetheriteMageArmorModel() {
        super(IronsSpellbooks.id(""));
    }

    @Override
    public ResourceLocation getModelResource(NetheriteMageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "geo/netherite_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteMageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "textures/models/armor/netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteMageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "animations/wizard_armor_animation.json");
    }
}