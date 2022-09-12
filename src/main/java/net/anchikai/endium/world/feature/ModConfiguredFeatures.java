package net.anchikai.endium.world.feature;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    // Amaranth Tree
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> AMARANTH_TREE =
            ConfiguredFeatures.register("amaranth_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.AMARANTH_LOG),
                    new BendingTrunkPlacer(6, 2, 4, 3, UniformIntProvider.create(1, 2)),
                    BlockStateProvider.of(ModBlocks.AMARANTH_LEAVES),
                    new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 50),
                    new TwoLayersFeatureSize(1, 0, 1)).dirtProvider(BlockStateProvider.of(Blocks.END_STONE)).build());

    public static final RegistryEntry<PlacedFeature> AMARANTH_CHECKED =
            PlacedFeatures.register("amaranth_checked", AMARANTH_TREE,
                    PlacedFeatures.wouldSurvive(ModBlocks.AMARANTH_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> AMARANTH_SPAWN =
            ConfiguredFeatures.register("amaranth_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(AMARANTH_CHECKED, 0.5f)),
                            AMARANTH_CHECKED));

    // Lungwort Flower
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> LUNGWORT_FLOWER =
            ConfiguredFeatures.register("lungwort_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUNGWORT_FLOWER)))));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + EndiumMod.MOD_ID);
    }
}