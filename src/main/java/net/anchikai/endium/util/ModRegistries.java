package net.anchikai.endium.util;

import net.anchikai.endium.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerStrippables();
        registerFlammableBlock();
    }


    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.AMARANTH_LOG, ModBlocks.STRIPPED_AMARANTH_LOG);
        StrippableBlockRegistry.register(ModBlocks.AMARANTH_WOOD, ModBlocks.STRIPPED_AMARANTH_WOOD);
    }

    private static void registerFlammableBlock() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.AMARANTH_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_AMARANTH_LOG, 5, 5);
        instance.add(ModBlocks.AMARANTH_WOOD, 5, 5);
        instance.add(ModBlocks.STRIPPED_AMARANTH_WOOD, 5, 5);
        instance.add(ModBlocks.AMARANTH_PLANKS, 5, 20);
        instance.add(ModBlocks.AMARANTH_LEAVES, 30, 60);
    }
}