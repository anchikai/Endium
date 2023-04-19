package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static net.anchikai.endium.block.ModBlocks.registerBlock;

public class EndiumBlocks {
    public static final Block ENDIUM_BLOCK = registerBlock("endium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)), ModItemGroup.ENDIUM);
    public static final Block ENDIUM_ORE = registerBlock("endium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(30.0f, 1200.0f).requiresTool().mapColor(MapColor.PALE_YELLOW),
                    UniformIntProvider.create(1, 1)), ModItemGroup.ENDIUM);
    public static final Block RAW_ENDIUM_BLOCK = registerBlock("raw_endium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(40.0f, 1200.0f).requiresTool().mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.ANCIENT_DEBRIS)),
                    ModItemGroup.ENDIUM);


    public static void register() {
        EndiumMod.LOGGER.info("Registering EndiumBlocks for " + EndiumMod.MOD_ID);
    }
}
