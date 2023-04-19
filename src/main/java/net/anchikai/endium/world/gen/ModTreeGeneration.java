package net.anchikai.endium.world.gen;

import net.anchikai.endium.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AMARANTH_PLACED_KEY);
    }
}
