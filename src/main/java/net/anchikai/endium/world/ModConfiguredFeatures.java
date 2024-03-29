package net.anchikai.endium.world;

import fr.hugman.dawn.DawnFactory;
import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.block.AmaranthBlocks;
import net.anchikai.endium.block.ChromiumBlocks;
import net.anchikai.endium.block.EndiumBlocks;
import net.anchikai.endium.misc.EndiumModTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMARANTH_KEY = DawnFactory.configuredFeature(EndiumMod.id("amaranth"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHROMIUM_ORE_KEY = DawnFactory.configuredFeature(EndiumMod.id("chromium_ore"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDIUM_ORE_KEY = DawnFactory.configuredFeature(EndiumMod.id("endium_ore"));
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_ICE_SPIKE_KEY = DawnFactory.configuredFeature(EndiumMod.id("end_ice_spike"));

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest endstoneReplaceables = new TagMatchRuleTest(EndiumModTags.END_ORE_REPLACEABLES);

        register(context, AMARANTH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(AmaranthBlocks.AMARANTH_LOG),
                new BendingTrunkPlacer(6,
                        2,
                        4,
                        3,
                        UniformIntProvider.create(1, 2)),
                BlockStateProvider.of(AmaranthBlocks.AMARANTH_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 50),
                new TwoLayersFeatureSize(1, 0, 1)).dirtProvider(BlockStateProvider.of(Blocks.END_STONE)).build());

        List<OreFeatureConfig.Target> endChromiumOres =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, ChromiumBlocks.CHROMIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endEndiumOres =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, EndiumBlocks.ENDIUM_ORE.getDefaultState()));

        register(context, CHROMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endChromiumOres, 8));
        register(context, ENDIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endEndiumOres, 4));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}