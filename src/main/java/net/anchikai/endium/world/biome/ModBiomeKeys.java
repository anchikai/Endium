package net.anchikai.endium.world.biome;

import fr.hugman.dawn.DawnFactory;
import net.anchikai.endium.EndiumMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public abstract class ModBiomeKeys {
    public static final RegistryKey<Biome> DUSTY_WASTES = DawnFactory.biome(EndiumMod.id("dusty_wastes"));
    public static final RegistryKey<Biome> MELANCHO = DawnFactory.biome(EndiumMod.id("melencho"));
}