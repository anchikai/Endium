package net.anchikai.endium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.block.ModBlocks;
import net.anchikai.endium.item.custom.*;
//import net.anchikai.endium.sound.ModSounds;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item ENDIUM_INGOT = registerItem("endium_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));

    public static final Item EMERALD_INFUSED_ENDER_PEARL = registerItem("emerald_infused_ender_pearl",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));

    public static final Item RAW_ENDIUM = registerItem("raw_endium",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));

    public static final Item ENDIUM_SCRAP = registerItem("endium_scrap",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));

    public static final Item ENDIUM_SWORD = registerItem("endium_sword",
            new SwordItem(ModToolMaterials.ENDIUM, 1, 2f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_AXE = registerItem("endium_axe",
            new ModAxeItem(ModToolMaterials.ENDIUM, 3, 1f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_HOE = registerItem("endium_hoe",
            new ModHoeItem(ModToolMaterials.ENDIUM, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_SHOVEL = registerItem("endium_shovel",
            new ShovelItem(ModToolMaterials.ENDIUM, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_PICKAXE = registerItem("endium_pickaxe",
            new ModPickaxeItem(ModToolMaterials.ENDIUM, 1, 0f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));

    public static final Item ENDIUM_HELMET = registerItem("endium_helmet",
            new ModArmorItem(ModArmorMaterials.ENDIUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_CHESTPLATE = registerItem("endium_chestplate",
            new ArmorItem(ModArmorMaterials.ENDIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_LEGGINGS = registerItem("endium_leggings",
            new ArmorItem(ModArmorMaterials.ENDIUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_BOOTS = registerItem("endium_boots",
            new ArmorItem(ModArmorMaterials.ENDIUM, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EndiumMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EndiumMod.LOGGER.info("Registering Mod Items for " + EndiumMod.MOD_ID);
    }
}
