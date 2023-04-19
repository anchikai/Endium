package net.anchikai.endium.util;

import net.anchikai.endium.EndiumMod;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeRegistry;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class ModBlockSetType {
    public static final BlockSetType AMARANTH = BlockSetTypeRegistry.registerWood(EndiumMod.id("amaranth"));
}
