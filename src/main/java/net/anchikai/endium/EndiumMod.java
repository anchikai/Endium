package net.anchikai.endium;

import fr.hugman.dawn.Registrar;
import net.anchikai.endium.block.*;
import net.anchikai.endium.enchantment.ModEnchantments;
import net.anchikai.endium.entity.ModEntities;
import net.anchikai.endium.init.ModEvents;
import net.anchikai.endium.item.AmaranthItems;
import net.anchikai.endium.item.ChromiumItems;
import net.anchikai.endium.item.CulminiteItems;
import net.anchikai.endium.item.EndiumItems;
import net.anchikai.endium.screen.EndiumModScreenHandlers;
import net.anchikai.endium.world.biome.EndBiomeRegistry;
import net.anchikai.endium.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndiumMod implements ModInitializer {
	public static final String MOD_ID = "endium";
	public static final Registrar REGISTRAR = new Registrar(MOD_ID);
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
		EndBlocks.register();

		PlantBlocks.register();

		ModEntities.registerModEntities();

		ModWorldGen.generateModWorldGen();

		ModFlammableBlockRegistry.registerFlammableBlocks();
		ModStrippableBlockRegistry.registerStrippableBlocks();

		EndiumModScreenHandlers.init();
		ModEnchantments.register();
		ModEvents.register();

		EndBiomeRegistry.register(REGISTRAR);
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}