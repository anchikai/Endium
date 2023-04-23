package net.anchikai.endium.misc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class EndiumModTags {
    public static final TagKey<Item> ENDIUM_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier("endium", "endium_items"));
    public static final TagKey<Block> AMARANTH_PLANTABLE = TagKey.of(RegistryKeys.BLOCK, new Identifier("endium", "amaranth_plantable"));
    public static final TagKey<Block> END_ORE_REPLACEABLES = TagKey.of(RegistryKeys.BLOCK, new Identifier("endium", "end_ore_replaceables"));
}