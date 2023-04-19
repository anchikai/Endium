package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;

import static net.anchikai.endium.block.ModBlocks.registerBlock;

public class EndStoneBlocks {
    public static final Block COBBLED_END_STONE = registerBlock("cobbled_end_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)), ModItemGroup.ENDIUM);
    public static final Block COBBLED_END_STONE_STAIRS = registerBlock("cobbled_end_stone_stairs",
            new StairsBlock(COBBLED_END_STONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.COBBLESTONE_STAIRS)), ModItemGroup.ENDIUM);
    public static final Block COBBLED_END_STONE_SLAB = registerBlock("cobbled_end_stone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE_SLAB)), ModItemGroup.ENDIUM);
    public static final Block COBBLED_END_STONE_WALL = registerBlock("cobbled_end_stone_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.COBBLESTONE_WALL)), ModItemGroup.ENDIUM);


    public static void register() {
        EndiumMod.LOGGER.info("Registering EndStoneBlocks for " + EndiumMod.MOD_ID);
    }
}
