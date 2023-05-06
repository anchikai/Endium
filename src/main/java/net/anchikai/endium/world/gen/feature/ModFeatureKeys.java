package net.anchikai.endium.world.gen.feature;

import net.anchikai.endium.EndiumMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class ModFeatureKeys {
    public static final EndIceSpikeFeature END_ICE_SPIKE = Registry.register(Registries.FEATURE, EndiumMod.id("end_ice_spike"), new EndIceSpikeFeature(DefaultFeatureConfig.CODEC));
}