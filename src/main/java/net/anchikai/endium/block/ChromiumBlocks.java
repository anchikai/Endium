package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static net.anchikai.endium.block.ModBlocks.registerBlock;

public class ChromiumBlocks {
    public static final Block CHROMIUM_BLOCK = registerBlock("chromium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8.0f, 15.0f).requiresTool().mapColor(MapColor.IRON_GRAY).sounds(BlockSoundGroup.METAL)),
                    ModItemGroup.ENDIUM);
    public static final Block CHROMIUM_ORE = registerBlock("chromium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(5.0f, 15.0f).requiresTool().mapColor(MapColor.PALE_YELLOW),
                    UniformIntProvider.create(1, 1)), ModItemGroup.ENDIUM);
    public static final Block RAW_CHROMIUM_BLOCK = registerBlock("raw_chromium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8.0f, 15.0f).requiresTool().mapColor(MapColor.IRON_GRAY).sounds(BlockSoundGroup.METAL)),
                    ModItemGroup.ENDIUM);


    public static void register() {
        EndiumMod.LOGGER.info("Registering ChromiumBlocks for " + EndiumMod.MOD_ID);
    }
}
