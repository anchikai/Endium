package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import static net.anchikai.endium.block.ModBlocks.registerBlock;

public class CulminiteBlocks {
    public static final Block CULMINITE_BLOCK = registerBlock("culminite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)), ModItemGroup.ENDIUM);


    public static void register() {
        EndiumMod.LOGGER.info("Registering CulminiteBlocks for " + EndiumMod.MOD_ID);
    }
}
