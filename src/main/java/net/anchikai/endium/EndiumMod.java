package net.anchikai.endium;

import net.anchikai.endium.block.ModBlocks;
import net.anchikai.endium.item.ModItems;
import net.anchikai.endium.screen.EndiumModScreenHandlers;
import net.anchikai.endium.util.ModRegistries;
import net.anchikai.endium.world.feature.ModConfiguredFeatures;
import net.anchikai.endium.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class EndiumMod implements ModInitializer {
	public static final String MOD_ID = "endium";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	// Endium Ore
	private static final ConfiguredFeature<?, ?> ENDIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
			(Feature.ORE, new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.END_STONE),
					ModBlocks.ENDIUM_ORE.getDefaultState(),
					4)); // Vein size

	public static PlacedFeature ENDIUM_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(ENDIUM_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(2),  // Number of veins per chunk
					SquarePlacementModifier.of(), // Spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(32)))); // Y Level
	// Chromium Ore
	private static final ConfiguredFeature<?, ?> CHROMIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
			(Feature.ORE, new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.END_STONE),
					ModBlocks.CHROMIUM_ORE.getDefaultState(),
					8)); // Vein size

	public static PlacedFeature CHROMIUM_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(CHROMIUM_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(2),  // Number of veins per chunk
					SquarePlacementModifier.of(), // Spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(54)))); // Y Level

	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();
		// Endium Ore
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("endium", "endium_ore"), ENDIUM_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("endium", "endium_ore"),
				ENDIUM_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("endium", "endium_ore")));
		// Chromium Ore
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("endium", "chromium_ore"), CHROMIUM_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("endium", "chromium_ore"),
				CHROMIUM_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("endium", "chromium_ore")));

		Registry.register(Registry.ITEM, new Identifier("endium", "chromium_shield"), ModItems.CHROMIUM_SHIELD);

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
		ModWorldGen.generateModWorldGen();
		EndiumModScreenHandlers.init();
	}
	public static Identifier id(String id) {
		return new Identifier(MOD_ID, id);
	}
}
