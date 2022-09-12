package net.anchikai.endium.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModPlacedFeatures {
    // Amaranth Tree
    public static final RegistryEntry<PlacedFeature> AMARANTH_PLACED = PlacedFeatures.register("amaranth_placed",
            ModConfiguredFeatures.AMARANTH_SPAWN, VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.0008f, 1)));
    // Lungwort Flower
    public static final RegistryEntry<PlacedFeature> LUNGWORT_PLACED = PlacedFeatures.register("lungwort_placed",
            ModConfiguredFeatures.LUNGWORT_FLOWER, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
}