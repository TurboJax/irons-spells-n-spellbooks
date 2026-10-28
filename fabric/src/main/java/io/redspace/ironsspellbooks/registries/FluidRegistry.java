package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.fluids.NoopFluid;
import io.redspace.ironsspellbooks.fluids.PotionFluid;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class FluidRegistry {
    public static final Holder<Fluid> BLOOD = register("blood");
    public static final Holder<Fluid> COMMON_INK = register("common_ink");
    public static final Holder<Fluid> UNCOMMON_INK = register("uncommon_ink");
    public static final Holder<Fluid> RARE_INK = register("rare_ink");
    public static final Holder<Fluid> EPIC_INK = register("epic_ink");
    public static final Holder<Fluid> LEGENDARY_INK = register("legendary_ink");
    public static final Holder<Fluid> POTION_FLUID = register("potion", PotionFluid::new); // TODO: implement
    public static final Holder<Fluid> OAKSKIN_ELIXIR_FLUID = register("oakskin_elixir");
    public static final Holder<Fluid> GREATER_OAKSKIN_ELIXIR_FLUID = register("greater_oakskin_elixir");
    public static final Holder<Fluid> INVISIBILITY_ELIXIR_FLUID = register("invisibility_elixir");
    public static final Holder<Fluid> GREATER_INVISIBILITY_ELIXIR_FLUID = register("greater_invisibility_elixir");
    public static final Holder<Fluid> EVASION_ELIXIR_FLUID = register("evasion_elixir");
    public static final Holder<Fluid> GREATER_EVASION_ELIXIR_FLUID = register("greater_evasion_elixir");
    public static final Holder<Fluid> GREATER_HEALING_ELIXIR_FLUID = register("greater_healing_elixir");
    public static final Holder<Fluid> TIMELESS_SLURRY_FLUID = register("timeless_slurry");
    public static final Holder<Fluid> ICE_VENOM_FLUID = register("ice_venom");
    //todo: reimplement ice spider lure mechanics
//    public static final Holder<Fluid> ICE_SPIDER_PHEROMONE_FLUID = registerNoop("ice_spider_pheromone");


    private static Holder<Fluid> register(String name) {
        return register(name, NoopFluid::new);
    }

    private static Holder<Fluid> register(String name, Supplier<Fluid> val) {
        return Registry.registerForHolder(BuiltInRegistries.FLUID, IronsSpellbooks.id(name), val.get());
    }
}
