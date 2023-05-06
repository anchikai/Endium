package net.anchikai.endium.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.FeatureConfig;

public record EndIceSpikeFeatureConfig(Identifier blockState) implements FeatureConfig {
    public static final Codec<EndIceSpikeFeatureConfig> CODEC = RecordCodecBuilder.create((instance) ->
        instance.group(
                Identifier.CODEC.fieldOf("block").forGetter(EndIceSpikeFeatureConfig::blockState)
        ).apply(instance, EndIceSpikeFeatureConfig::new));
}