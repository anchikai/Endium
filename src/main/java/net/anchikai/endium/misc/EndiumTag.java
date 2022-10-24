package net.anchikai.endium.misc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndiumTag {
    public static final TagKey<Item> ENDIUM_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("endium", "endium_items"));
    public static final TagKey<Item> CHROMIUM_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("endium", "chromium_items"));
    public static final TagKey<Item> ENDIUM_ELYTRA = TagKey.of(Registry.ITEM_KEY, new Identifier("endium", "endium_elytra"));
    public static final TagKey<Item> CULMINITE_ELYTRA = TagKey.of(Registry.ITEM_KEY, new Identifier("endium", "culminite_elytra"));
    public static final TagKey<Block> AMARANTH_PLANTABLE = TagKey.of(Registry.BLOCK_KEY, new Identifier("endium", "amaranth_plantable"));
}