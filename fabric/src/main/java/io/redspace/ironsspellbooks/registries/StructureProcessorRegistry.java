package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.worldgen.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

import java.util.function.Supplier;


public class StructureProcessorRegistry {

    public static <T extends StructureProcessor> Supplier<StructureProcessorType<T>> register(String key, Supplier<StructureProcessorType<T>> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return () -> Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, id, val.get());
    }

    public static final Supplier<StructureProcessorType<WeatherCopperProcessor>> WEATHER_COPPER = register("weather_copper", () -> () -> WeatherCopperProcessor.CODEC);
    public static final Supplier<StructureProcessorType<DegradeSlabsStairsProcessor>> DEGRADE_SLABS_STAIRS = register("degrade_slabs_stairs", () -> () -> DegradeSlabsStairsProcessor.CODEC);
    public static final Supplier<StructureProcessorType<StructureFoundationProcessor>> STRUCTURE_FOUNDATION_PROCESSOR = register("foundation", () -> () -> StructureFoundationProcessor.CODEC);
    public static final Supplier<StructureProcessorType<HandleLitBlocksProcessor>> HANDLE_LIT_BLOCKS_PROCESSOR = register("handle_lit_blocks", () -> () -> HandleLitBlocksProcessor.CODEC);
    public static final Supplier<StructureProcessorType<ClearPortalFrameDataProcessor>> CLEAR_PORTAL_FRAME_DATA = register("clear_portal_frame_data", () -> () -> ClearPortalFrameDataProcessor.CODEC);
    public static final Supplier<StructureProcessorType<ClearVaultDataProcessor>> CLEAR_VAULT_DATA = register("clear_vault_data", () -> () -> ClearVaultDataProcessor.CODEC);
}
