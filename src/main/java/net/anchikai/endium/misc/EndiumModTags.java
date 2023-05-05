package net.anchikai.endium.misc;

import net.anchikai.endium.EndiumMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class EndiumModTags {
    public static final TagKey<Item> ENDIUM_ITEM = TagKey.of(RegistryKeys.ITEM, EndiumMod.id("endium_items"));
    public static final TagKey<Block> AMARANTH_PLANTABLE = TagKey.of(RegistryKeys.BLOCK, EndiumMod.id("amaranth_plantable"));
    public static final TagKey<Block> END_ORE_REPLACEABLES = TagKey.of(RegistryKeys.BLOCK, EndiumMod.id("end_ore_replaceables"));
    public static final TagKey<Block> BASE_STONE_END = TagKey.of(RegistryKeys.BLOCK, EndiumMod.id("base_stone_end"));
}