package net.anchikai.endium.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.anchikai.endium.EndiumMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ENDIUM = FabricItemGroupBuilder.build(new Identifier(EndiumMod.MOD_ID, "endium"),
            () -> new ItemStack(ModItems.ENDIUM_INGOT));
}
