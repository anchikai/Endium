package net.anchikai.endium;

import net.anchikai.endium.block.*;
import net.anchikai.endium.entity.ModEntities;
import net.anchikai.endium.item.AmaranthItems;
import net.anchikai.endium.item.ChromiumItems;
import net.anchikai.endium.item.CulminiteItems;
import net.anchikai.endium.item.EndiumItems;
import net.anchikai.endium.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndiumMod implements ModInitializer {
	public static final String MOD_ID = "endium";
	public static final Logger LOGGER = LoggerFactory.getLogger("endium");

	@Override
	public void onInitialize() {
		ChromiumBlocks.register();
		ChromiumItems.register();
		EndiumBlocks.register();
		EndiumItems.register();
		CulminiteBlocks.register();
		CulminiteItems.register();

		AmaranthBlocks.register();
		AmaranthItems.register();

		EndStoneBlocks.register();

		ModEntities.registerModEntities();

		ModWorldGeneration.generateModWorldGen();

		ModFlammableBlockRegistry.registerFlammableBlocks();
		ModStrippableBlockRegistry.registerStrippableBlocks();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
