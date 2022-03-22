package net.anchikai.endium;

import net.fabricmc.api.ModInitializer;
import net.anchikai.endium.block.ModBlocks;
import net.anchikai.endium.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EndiumMod implements ModInitializer {
	public static final String MOD_ID = "endium";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

	//	ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	//	ModRegistries.registerModStuffs();

	//	ModWorldGen.generateModWorldGen();
	}
}
