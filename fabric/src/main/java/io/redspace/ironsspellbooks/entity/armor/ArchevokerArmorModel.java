package io.redspace.ironsspellbooks.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.item.armor.ArchevokerArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ArchevokerArmorModel extends DefaultedItemGeoModel<ArchevokerArmorItem> {

    public ArchevokerArmorModel() {
        super(IronsSpellbooks.id(""));
    }

    @Override
    public ResourceLocation getModelResource(ArchevokerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "geo/archevoker_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArchevokerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "textures/models/armor/archevoker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ArchevokerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "animations/wizard_armor_animation.json");
    }
//    public static String listOfBonesToString(List<IBone> list){
//        String s = "";
//        for (IBone o:list)
//            s += o.getName()+", ";
//        return s;
//    }
}