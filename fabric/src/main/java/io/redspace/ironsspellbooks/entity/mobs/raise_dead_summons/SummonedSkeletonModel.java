package io.redspace.ironsspellbooks.entity.mobs.raise_dead_summons;


import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.mobs.SummonedSkeleton;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SummonedSkeletonModel extends GeoModel<SummonedSkeleton> {
    //public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("textures/entity/skeleton/skeleton.png");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "textures/entity/summoned_skeleton.png");

    public static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "geo/skeleton_mob.geo.json");
    public static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "animations/casting_animations.json");


    @Override
    public ResourceLocation getTextureResource(SummonedSkeleton object) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation getModelResource(SummonedSkeleton object) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, "geo/skeleton_mob.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(SummonedSkeleton animatable) {
        return ANIMATIONS;
    }

}