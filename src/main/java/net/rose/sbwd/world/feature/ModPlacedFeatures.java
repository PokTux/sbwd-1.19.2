package net.rose.sbwd.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> LEAD_ORE_PLACED = PlacedFeatures.register("lead_ore_placed",
            ModConfiguredFeatures.LEAD_ORE, modifiersWithCount(5,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(80))));

    public static final RegistryEntry<PlacedFeature> URANIUM_ORE_PLACED = PlacedFeatures.register("uranium_ore_placed",
            ModConfiguredFeatures.URANIUM_ORE, modifiersWithCount(1,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(-40))));

    public static final RegistryEntry<PlacedFeature> SULFUR_ORE_PLACED = PlacedFeatures.register("sulfur_ore_placed",
            ModConfiguredFeatures.SULFUR_ORE, modifiersWithCount(6,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(60))));
    public static final RegistryEntry<PlacedFeature> NETHER_SULFUR_ORE_PLACED = PlacedFeatures.register("nether_sulfur_ore_placed",
            ModConfiguredFeatures.NETHER_SULFUR_ORE, modifiersWithCount(9,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(120))));








    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
