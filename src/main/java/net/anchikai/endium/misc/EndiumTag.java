package net.anchikai.endium.misc;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndiumTag {
    public static final TagKey<Item> ENDIUM_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("endium", "endium_items"));
    public static final TagKey<Item> ENDIUM_ELYTRA = TagKey.of(Registry.ITEM_KEY, new Identifier("endium", "endium_elytra"));
}