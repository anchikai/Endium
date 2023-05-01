package net.anchikai.endium.world.biome;

import fr.hugman.dawn.Registrar;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;

public class EndBiomeRegistry {
    public static void register(Registrar r) {
        TheEndBiomes.addHighlandsBiome(ModBiomeKeys.DUSTY_WASTES, 1.0);
        TheEndBiomes.addHighlandsBiome(ModBiomeKeys.MELANCHO, 1.0);
    }
}
