package net.anchikai.endium;

import net.anchikai.endium.world.ModConfiguredFeatures;
import net.anchikai.endium.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.anchikai.endium.data.ModLootTableGenerator;
import net.anchikai.endium.data.ModModelProvider;
import net.anchikai.endium.data.ModRecipeGenerator;
import net.anchikai.endium.data.ModWorldGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class EndiumModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModLootTableGenerator::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
