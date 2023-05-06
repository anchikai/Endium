package net.anchikai.endium.world.gen;

import net.anchikai.endium.world.ModPlacedFeatures;
import net.anchikai.endium.world.biome.ModBiomeKeys;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.EndPlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.UndergroundPlacedFeatures;

public class ModFeatureGen {
    public static void generateFeatures() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeKeys.DUSTY_WASTES),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.END_DUST_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeKeys.DUSTY_WASTES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, UndergroundPlacedFeatures.FOSSIL_UPPER);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeKeys.MELANCHO),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.END_ICE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeKeys.MELANCHO),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.END_ICE_SPIKE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeKeys.MELANCHO),
                GenerationStep.Feature.SURFACE_STRUCTURES, EndPlacedFeatures.END_GATEWAY_RETURN);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.THE_END, BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LUNGWORT_FLOWER_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.CHROMIUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ENDIUM_ORE_PLACED_KEY);
    }
}
