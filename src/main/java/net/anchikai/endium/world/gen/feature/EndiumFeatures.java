package net.anchikai.endium.world.gen.feature;

import net.anchikai.endium.EndiumMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public abstract class EndiumFeatures {
    public static final EndIceSpikeFeature END_ICE_SPIKE = new EndIceSpikeFeature(EndIceSpikeFeatureConfig.CODEC);

    public static void register() {
        Registry.register(Registries.FEATURE, EndiumMod.id("end_ice_spike"), END_ICE_SPIKE);
    }
}