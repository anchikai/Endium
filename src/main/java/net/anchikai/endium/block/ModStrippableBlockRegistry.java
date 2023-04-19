package net.anchikai.endium.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlockRegistry {
    public static void  registerStrippableBlocks() {
        StrippableBlockRegistry.register(AmaranthBlocks.AMARANTH_LOG, AmaranthBlocks.STRIPPED_AMARANTH_LOG);
        StrippableBlockRegistry.register(AmaranthBlocks.AMARANTH_WOOD, AmaranthBlocks.STRIPPED_AMARANTH_WOOD);
    }
}
