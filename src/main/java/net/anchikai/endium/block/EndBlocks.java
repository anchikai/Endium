package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TransparentBlock;

import static net.anchikai.endium.block.ModBlocks.registerBlock;

public class EndBlocks {
    public static final Block END_DUST = registerBlock("end_dust",
            new ModDustBlock(14406560, FabricBlockSettings.copy(Blocks.SAND).strength(0.8f).dynamicBounds()), ModItemGroup.ENDIUM);
    public static final Block END_ICE = registerBlock("end_ice",
            new TransparentBlock(FabricBlockSettings.copy(Blocks.BLUE_ICE).slipperiness(0.998f)), ModItemGroup.ENDIUM);


    public static void register() {
        EndiumMod.LOGGER.info("Registering EndBlocks for " + EndiumMod.MOD_ID);
    }
}
