package net.rose.sbwd.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.rose.sbwd.block.ModBlocks;
import net.rose.sbwd.sbwd;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_LEAD_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.getDefaultState())
    );

    public static final List<OreFeatureConfig.Target> OVERWORLD_SULFUR_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SULFUR_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SULFUR_ORE.getDefaultState())
    );
    public static final List<OreFeatureConfig.Target> NETHER_SULFUR_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, ModBlocks.NETHER_SULFUR_ORE.getDefaultState())
    );


    public static final List<OreFeatureConfig.Target> OVERWORLD_URANIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.URANIUM_ORE.getDefaultState())
    );












    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LEAD_ORE =
            ConfiguredFeatures.register("lead_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_LEAD_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SULFUR_ORE =
            ConfiguredFeatures.register("sulfur_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_SULFUR_ORES, 14));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> DEEPSLATE_SULFUR_ORE =
            ConfiguredFeatures.register("deepslate_sulfur_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_SULFUR_ORES, 14));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> NETHER_SULFUR_ORE =
            ConfiguredFeatures.register("nether_sulfur_ore", Feature.ORE, new OreFeatureConfig(NETHER_SULFUR_ORES, 14));


    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> URANIUM_ORE =
            ConfiguredFeatures.register("uranium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_URANIUM_ORES, 5));





    public static void registerConfiguredFeatures() {
        sbwd.LOGGER.debug("Registering the ModConfiguredFeatures for " + sbwd.MOD_ID);


    }
}
