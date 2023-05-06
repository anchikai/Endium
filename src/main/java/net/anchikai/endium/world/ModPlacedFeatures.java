package net.anchikai.endium.world;

import fr.hugman.dawn.DawnFactory;
import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.block.AmaranthBlocks;
import net.anchikai.endium.misc.EndiumModTags;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> AMARANTH_PLACED_KEY = DawnFactory.placedFeature(EndiumMod.id("amaranth_placed"));

    public static final RegistryKey<PlacedFeature> END_DUST_PLACED_KEY = DawnFactory.placedFeature(EndiumMod.id("end_dust"));
    public static final RegistryKey<PlacedFeature> END_ICE_PLACED_KEY = DawnFactory.placedFeature(EndiumMod.id("end_ice_patch"));
    public static final RegistryKey<PlacedFeature> END_ICE_SPIKE_PLACED_KEY = DawnFactory.placedFeature(EndiumMod.id("end_ice_spike"));

    public static final RegistryKey<PlacedFeature> LUNGWORT_FLOWER_PLACED_KEY = DawnFactory.placedFeature(EndiumMod.id("lungwort_flower"));

    public static final RegistryKey<PlacedFeature> CHROMIUM_ORE_PLACED_KEY = DawnFactory.placedFeature(EndiumMod.id("chromium_ore_placed"));
    public static final RegistryKey<PlacedFeature> ENDIUM_ORE_PLACED_KEY = DawnFactory.placedFeature(EndiumMod.id("endium_ore_placed"));

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, AMARANTH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AMARANTH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.0008f, 1), AmaranthBlocks.AMARANTH_SAPLING));

        register(context, CHROMIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHROMIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(54))));
        register(context, ENDIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(32))));

        register(context, END_ICE_SPIKE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_ICE_SPIKE_KEY),
                CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(-1)), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(EndiumModTags.BASE_STONE_END)), BiomePlacementModifier.of());
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}