package net.anchikai.endium.block;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItemGroup;
import net.anchikai.endium.util.ModBlockSetType;
import net.anchikai.endium.util.ModWoodTypes;
import net.anchikai.endium.world.tree.AmaranthSaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;

import static net.anchikai.endium.block.ModBlocks.registerBlock;
import static net.anchikai.endium.block.ModBlocks.registerBlockWithoutBlockItem;

public class AmaranthBlocks {
    public static final Block AMARANTH_LOG = registerBlock("amaranth_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_WOOD = registerBlock("amaranth_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)), ModItemGroup.ENDIUM);
    public static final Block STRIPPED_AMARANTH_LOG = registerBlock("stripped_amaranth_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.ENDIUM);
    public static final Block STRIPPED_AMARANTH_WOOD = registerBlock("stripped_amaranth_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_PLANKS = registerBlock("amaranth_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_STAIRS = registerBlock("amaranth_stairs",
            new StairsBlock(AMARANTH_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_SLAB = registerBlock("amaranth_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)),ModItemGroup.ENDIUM);
    public static final Block AMARANTH_FENCE = registerBlock("amaranth_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_FENCE_GATE = registerBlock("amaranth_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE), ModWoodTypes.AMARANTH_TYPE), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_DOOR = registerBlock("amaranth_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque(), ModBlockSetType.AMARANTH), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_TRAPDOOR = registerBlock("amaranth_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque(), ModBlockSetType.AMARANTH), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_PRESSURE_PLATE = registerBlock("amaranth_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_BUTTON = registerBlock("amaranth_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), ModBlockSetType.AMARANTH, 30, true), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_LEAVES = registerBlock("amaranth_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_SAPLING = registerBlock("amaranth_sapling",
            new AmaranthSaplingBlock(new AmaranthSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModItemGroup.ENDIUM);
    public static final Block AMARANTH_SIGN = registerBlockWithoutBlockItem("amaranth_sign",
            new SignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN), ModWoodTypes.AMARANTH_TYPE));
    public static final Block AMARANTH_WALL_SIGN = registerBlockWithoutBlockItem("amaranth_wall_sign",
            new WallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN), ModWoodTypes.AMARANTH_TYPE));


    public static void register() {
        EndiumMod.LOGGER.info("Registering AmaranthBlocks for " + EndiumMod.MOD_ID);
    }
}
