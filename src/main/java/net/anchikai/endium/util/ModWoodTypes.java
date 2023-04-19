package net.anchikai.endium.util;

import net.anchikai.endium.EndiumMod;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.minecraft.block.WoodType;

public class ModWoodTypes {
    public static final WoodType AMARANTH_TYPE = WoodTypeRegistry.register(EndiumMod.id("amaranth"), ModBlockSetType.AMARANTH);
}
