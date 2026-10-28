package io.redspace.ironsspellbooks.registries;

import com.google.common.collect.ImmutableSet;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;
import java.util.function.Supplier;

public class PoiTypeRegistry {
    public static PoiType register(String key, Supplier<PoiType> val) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, key);
        return Registry.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, id, val.get());
    }

    public static final PoiType CINDEROUS_KEYSTONE_POI = register("cinderous_soul_rune", () -> new PoiType(getBlockStates(BlockRegistry.CINDEROUS_KEYSTONE)), 1, 1);

    private static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
    }
}
