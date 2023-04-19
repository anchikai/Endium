package net.anchikai.endium.item;

import net.anchikai.endium.EndiumMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class ModItemGroup {
    public static final ItemGroup ENDIUM = FabricItemGroup.builder(EndiumMod.id("the_endium_expansion"))
            .displayName(Text.translatable("itemgroup.endium"))
            .icon(() -> new ItemStack(EndiumItems.ENDIUM_INGOT))
            .build();
}