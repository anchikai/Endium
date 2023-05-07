package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static net.anchikai.endium.block.ModBlocks.registerBlock;
import static net.anchikai.endium.block.ModBlocks.registerBlockItem;

public class ChromiumBlocks {
    private static ChromiumAnvilBlock registerChromiumAnvilBlock(ChromiumAnvilBlock block) {
        registerBlockItem("chromium_anvil", block, ModItemGroup.ENDIUM);
        return Registry.register(Registries.BLOCK, EndiumMod.id("chromium_anvil"), block);
    }

    public static final Block CHROMIUM_BLOCK = registerBlock("chromium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8.0f, 15.0f).requiresTool().mapColor(MapColor.IRON_GRAY).sounds(BlockSoundGroup.METAL)),
                    ModItemGroup.ENDIUM);
    public static final Block CHROMIUM_DOOR = registerBlock("chromium_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR).nonOpaque(), BlockSetType.IRON), ModItemGroup.ENDIUM);
    public static final Block CHROMIUM_TRAPDOOR = registerBlock("chromium_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque(), BlockSetType.IRON), ModItemGroup.ENDIUM);
    public static final ChromiumAnvilBlock CHROMIUM_ANVIL = registerChromiumAnvilBlock(
            new ChromiumAnvilBlock(FabricBlockSettings.copy(Blocks.ANVIL).strength(5.0f, 1200.0f)));
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
