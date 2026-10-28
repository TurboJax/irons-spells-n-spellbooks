package io.redspace.ironsspellbooks.registries;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.item.UpgradeData;
import io.redspace.ironsspellbooks.api.item.WaywardCompassData;
import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.capabilities.magic.SpellContainer;
import io.redspace.ironsspellbooks.fluids.PotionFluid;
import io.redspace.ironsspellbooks.item.FurledMapItem;
import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.item.weapons.AutoloaderCrossbow;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Unit;

import java.util.function.UnaryOperator;

public class ComponentRegistry {
    private static <T> DataComponentType<T> register(String pName, UnaryOperator<DataComponentType.Builder<T>> pBuilder) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MOD_ID, pName);
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, id, pBuilder.apply(DataComponentType.builder()).build());
    }

    public static final DataComponentType<AffinityData> AFFINITY_COMPONENT = register("affinity_data", type -> type.persistent(AffinityData.CODEC).networkSynchronized(AffinityData.STREAM_CODEC).cacheEncoding());
    public static final DataComponentType<FurledMapItem.FurledMapData> FURLED_MAP_COMPONENT = register("furled_map_data", type -> type.persistent(FurledMapItem.FurledMapData.CODEC).networkSynchronized(FurledMapItem.FurledMapData.STREAM_CODEC).cacheEncoding());
    public static final DataComponentType<UpgradeData> UPGRADE_DATA = register("upgrade_data", type -> type.persistent(UpgradeData.CODEC).networkSynchronized(UpgradeData.STREAM_CODEC).cacheEncoding());
    public static final DataComponentType<ISpellContainer> SPELL_CONTAINER = register("spell_container", type -> type.persistent(SpellContainer.CODEC).networkSynchronized(SpellContainer.STREAM_CODEC).cacheEncoding());
    public static final DataComponentType<WaywardCompassData> WAYWARD_COMPASS = register("wayward_compass", type -> type.persistent(WaywardCompassData.CODEC).networkSynchronized(WaywardCompassData.STREAM_CODEC).cacheEncoding());
    public static final DataComponentType<AutoloaderCrossbow.LoadStateComponent> CROSSBOW_LOAD_STATE = register("crossbow_load_state", type -> type.persistent(AutoloaderCrossbow.LoadStateComponent.CODEC).networkSynchronized(AutoloaderCrossbow.LoadStateComponent.STREAM_CODEC).cacheEncoding());
    public static final DataComponentType<Unit> CASTING_IMPLEMENT = register("casting_implement", type -> type.persistent(Unit.CODEC).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)).cacheEncoding());
    public static final DataComponentType<Unit> MULTIHAND_WEAPON = register("multihand_weapon", type -> type.persistent(Unit.CODEC).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)).cacheEncoding());
    public static final DataComponentType<String> CLOTHING_VARIANT = register("clothing_variant", type -> type.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).cacheEncoding());
    public static final DataComponentType<ResourceKey<UpgradeOrbType>> UPGRADE_ORB_TYPE = register("upgrade_orb_type", type -> type.persistent(ResourceKey.codec(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY)).networkSynchronized(ByteBufCodecs.fromCodec(ResourceKey.codec(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY))).cacheEncoding());
    public static final DataComponentType<PotionFluid.BottleType> POTION_BOTTLE_TYPE = register("potion_bottle_type", type -> type.persistent(PotionFluid.BottleType.CODEC).networkSynchronized(PotionFluid.BottleType.STREAM_CODEC).cacheEncoding());
}
