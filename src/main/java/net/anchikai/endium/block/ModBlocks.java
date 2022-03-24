package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {
    public static final Block ENDIUM_BLOCK = registerBlock("endium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(50.0f, 1200.0f).requiresTool().sounds(BlockSoundGroup.NETHERITE)), ModItemGroup.ENDIUM);

    public static final Block ENDIUM_ORE = registerBlock("endium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(30.0f, 1200.0f).requiresTool(),
                    UniformIntProvider.create(1, 1)), ModItemGroup.ENDIUM);

    public static final Block RAW_ENDIUM_BLOCK = registerBlock("raw_endium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(40.0f, 1200.0f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)), ModItemGroup.ENDIUM);

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(EndiumMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(EndiumMod.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings().group(group)) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    tooltip.add(new TranslatableText(tooltipKey));
                }
            });
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(EndiumMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(EndiumMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(EndiumMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        EndiumMod.LOGGER.info("Registering ModBlocks for " + EndiumMod.MOD_ID);
    }
}
