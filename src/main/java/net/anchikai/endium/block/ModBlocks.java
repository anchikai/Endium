package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.block.custom.*;
import net.anchikai.endium.item.ModItemGroup;
import net.anchikai.endium.world.feature.tree.AmaranthSaplingGenorator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {
    // Endium Blocks
    public static final Block ENDIUM_BLOCK = registerBlock("endium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(50.0f, 1200.0f).requiresTool().mapColor(MapColor.TERRACOTTA_PURPLE).sounds(BlockSoundGroup.NETHERITE)),
                ModItemGroup.ENDIUM);
    public static final Block ENDIUM_ORE = registerBlock("endium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(30.0f, 1200.0f).requiresTool().mapColor(MapColor.PALE_YELLOW),
                    UniformIntProvider.create(1, 1)), ModItemGroup.ENDIUM);
    public static final Block RAW_ENDIUM_BLOCK = registerBlock("raw_endium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(40.0f, 1200.0f).requiresTool().mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.ANCIENT_DEBRIS)),
                ModItemGroup.ENDIUM);
    // Chromium Blocks
    public static final Block CHROMIUM_BLOCK = registerBlock("chromium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8.0f, 15.0f).requiresTool().mapColor(MapColor.IRON_GRAY).sounds(BlockSoundGroup.METAL)),
                ModItemGroup.ENDIUM);
    public static final Block CHROMIUM_ORE = registerBlock("chromium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(5.0f, 15.0f).requiresTool().mapColor(MapColor.PALE_YELLOW),
                    UniformIntProvider.create(1, 1)), ModItemGroup.ENDIUM);
    public static final Block RAW_CHROMIUM_BLOCK = registerBlock("raw_chromium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8.0f, 15.0f).requiresTool().mapColor(MapColor.IRON_GRAY).sounds(BlockSoundGroup.METAL)),
            ModItemGroup.ENDIUM);
    // Cobbled End Stone
    public static final Block COBBLED_END_STONE = registerBlock("cobbled_end_stone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.5f, 9.0f).requiresTool().mapColor(MapColor.PALE_YELLOW)),
                ModItemGroup.ENDIUM);
    public static final Block COBBLED_END_STONE_WALL = registerBlock("cobbled_end_stone_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_WALL)),
                ModItemGroup.ENDIUM);
    public static final Block COBBLED_END_STONE_SLAB = registerBlock("cobbled_end_stone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.COBBLESTONE_SLAB)),
                ModItemGroup.ENDIUM);
    public static final Block COBBLED_END_STONE_STAIRS = registerBlock("cobbled_end_stone_stairs",
            new ModStairsBlock(ModBlocks.COBBLED_END_STONE.getDefaultState(), FabricBlockSettings.copy(Blocks.COBBLESTONE_STAIRS)),
                ModItemGroup.ENDIUM);
    // Amaranth Wood
    public static final Block AMARANTH_LOG = registerBlock("amaranth_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.PALE_PURPLE)),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_WOOD = registerBlock("amaranth_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.PALE_PURPLE)),
                ModItemGroup.ENDIUM);
    public static final Block STRIPPED_AMARANTH_LOG = registerBlock("stripped_amaranth_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.PALE_PURPLE)),
                ModItemGroup.ENDIUM);
    public static final Block STRIPPED_AMARANTH_WOOD = registerBlock("stripped_amaranth_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.PALE_PURPLE)),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_PLANKS = registerBlock("amaranth_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.PALE_PURPLE)),
                ModItemGroup.ENDIUM);
    // More Amaranth
    public static final Block AMARANTH_BUTTON = registerBlock("amaranth_button",
            new ModWoodenButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).noCollision()),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_PRESSURE_PLATE = registerBlock("amaranth_pressure_plate",
            new ModPresssurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE)),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_FENCE = registerBlock("amaranth_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_FENCE_GATE = registerBlock("amaranth_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE)),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_SLAB = registerBlock("amaranth_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_STAIRS = registerBlock("amaranth_stairs",
            new ModStairsBlock(ModBlocks.AMARANTH_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_DOOR = registerBlock("amaranth_door",
            new ModDoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).nonOpaque()),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_TRAPDOOR = registerBlock("amaranth_trapdoor",
            new ModTrapDoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).nonOpaque()),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_LEAVES = registerBlock("amaranth_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()),
                ModItemGroup.ENDIUM);
    public static final Block AMARANTH_SAPLING = registerBlock("amaranth_sapling",
            new ModSaplingBlock(new AmaranthSaplingGenorator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_SIGN = registerBlock("amaranth_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), SignType.CRIMSON),
                ModItemGroup.ENDIUM);
    // Lungwort Flower
    public static final Block LUNGWORT_FLOWER = registerBlock("lungwort_flower",
            new ModFlowerBlock(StatusEffects.LEVITATION, 12,
                    FabricBlockSettings.copy(Blocks.DANDELION)), ModItemGroup.ENDIUM);
    public static final Block POTTED_LUNGWORT_FLOWER = registerBlockWithoutBlockItem("potted_lungwort_flower",
            new FlowerPotBlock(ModBlocks.LUNGWORT_FLOWER,
                    FabricBlockSettings.copy(Blocks.POTTED_ALLIUM).nonOpaque()), ModItemGroup.ENDIUM);


    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(EndiumMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(EndiumMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
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
