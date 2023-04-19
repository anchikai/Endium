package net.anchikai.endium.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlockRegistry {
    public static void  registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(AmaranthBlocks.AMARANTH_LOG, 5, 5);
        registry.add(AmaranthBlocks.AMARANTH_WOOD, 5, 5);
        registry.add(AmaranthBlocks.STRIPPED_AMARANTH_LOG, 5, 5);
        registry.add(AmaranthBlocks.STRIPPED_AMARANTH_WOOD, 5, 5);
        registry.add(AmaranthBlocks.AMARANTH_LEAVES, 30, 60);
        registry.add(AmaranthBlocks.AMARANTH_PLANKS, 5, 20);
    }
}
