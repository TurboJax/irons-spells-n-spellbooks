package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.worldgen.IndividualTerrainStructurePoolElement;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;

import java.util.function.Supplier;

public class StructureElementRegistry {

    public static <T extends StructurePoolElement> Supplier<StructurePoolElementType<T>> register(String key, Supplier<StructurePoolElementType<T>> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return () -> Registry.register(BuiltInRegistries.STRUCTURE_POOL_ELEMENT, id, val.get());
    }

    public static final Supplier<StructurePoolElementType<IndividualTerrainStructurePoolElement>> INDIVIDUAL_TERRAIN_ELEMENT = register("individual_terrain_element", () -> () -> IndividualTerrainStructurePoolElement.CODEC);
}
