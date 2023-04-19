package net.anchikai.endium.item;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.block.AmaranthBlocks;
import net.anchikai.endium.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;

import static net.anchikai.endium.item.ModItems.addToItemGroup;
import static net.anchikai.endium.item.ModItems.registerItem;

public class AmaranthItems {
    public static final Item AMARANTH_SIGN = registerItem("amaranth_sign",
            new SignItem(new FabricItemSettings().maxCount(16), AmaranthBlocks.AMARANTH_SIGN, AmaranthBlocks.AMARANTH_WALL_SIGN));
    public static final Item AMARANTH_BOAT = registerItem("amaranth_boat",
            new BoatItem(false, ModEntities.AMARANTH_BOAT, new FabricItemSettings().maxCount(1)));
    public static final Item AMARANTH_CHEST_BOAT = registerItem("amaranth_chest_boat",
            new BoatItem(true, ModEntities.AMARANTH_BOAT, new FabricItemSettings().maxCount(1)));


    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.ENDIUM, AMARANTH_SIGN);
        addToItemGroup(ModItemGroup.ENDIUM, AMARANTH_BOAT);
        addToItemGroup(ModItemGroup.ENDIUM, AMARANTH_CHEST_BOAT);
    }

    public static void register() {
        EndiumMod.LOGGER.info("Registering AmaranthItems for " + EndiumMod.MOD_ID);

        addItemsToItemGroup();
    }
}
