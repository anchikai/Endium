package net.anchikai.endium.world.gen.feature;

import com.mojang.serialization.Codec;
import net.anchikai.endium.EndiumMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public abstract class ModFeature extends Feature<DefaultFeatureConfig> {
    public static final EndIceSpikeFeature END_ICE_SPIKE = register("end_ice_spike", new EndIceSpikeFeature(DefaultFeatureConfig.CODEC));

    private static <C extends DefaultFeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registries.FEATURE, EndiumMod.id(name), feature);
    }

    public ModFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }
}