package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.entity.effect.StatusEffects;

import static net.anchikai.endium.block.ModBlocks.registerBlock;
import static net.anchikai.endium.block.ModBlocks.registerBlockWithoutBlockItem;

public class PlantBlocks {
    public static final Block LUNGWORT_FLOWER = registerBlock("lungwort_flower",
            new EndFlowerBlock(StatusEffects.LEVITATION, 12, FabricBlockSettings.copy(Blocks.DANDELION)), ModItemGroup.ENDIUM);
    public static final Block POTTED_LUNGWORT_FLOWER = registerBlockWithoutBlockItem("potted_lungwort_flower",
            new FlowerPotBlock(LUNGWORT_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));

    public static void register() {
        EndiumMod.LOGGER.info("Registering PlantBlocks for " + EndiumMod.MOD_ID);
    }
}
