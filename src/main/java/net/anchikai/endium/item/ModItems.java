package net.anchikai.endium.item;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.block.ModBlocks;
import net.anchikai.endium.item.custom.*;
import net.anchikai.endium.util.CustomBoatType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    // Amaranth Items
    public static final Item AMARANTH_SIGN = registerItem("amaranth_sign",
            new SignItem(new FabricItemSettings().group(ModItemGroup.ENDIUM).maxCount(16),
                    ModBlocks.AMARANTH_SIGN_BLOCK, ModBlocks.AMARANTH_WALL_SIGN_BLOCK));
    public static final Item AMARANTH_BOAT = registerItem("amaranth_boat",
            new BoatItem(false, CustomBoatType.AMARANTH, (new FabricItemSettings()).maxCount(1).group(ModItemGroup.ENDIUM)));
    public static final Item AMARANTH_CHEST_BOAT = registerItem("amaranth_chest_boat",
            new BoatItem(true, CustomBoatType.AMARANTH, (new FabricItemSettings()).maxCount(1).group(ModItemGroup.ENDIUM)));
    // Endium Items
    public static final Item ENDIUM_INGOT = registerItem("endium_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item RAW_ENDIUM = registerItem("raw_endium",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_SCRAP = registerItem("endium_scrap",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ECHOPEARL = registerItem("echopearl",
            new ModEnderPearlItem(new FabricItemSettings().maxCount(16).group(ModItemGroup.ENDIUM)));
    // Endium Tools
    public static final Item ENDIUM_SWORD = registerItem("endium_sword",
            new SwordItem(ModToolMaterials.ENDIUM, 3, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_AXE = registerItem("endium_axe",
            new ModAxeItem(ModToolMaterials.ENDIUM, 5, -3.0f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_HOE = registerItem("endium_hoe",
            new ModHoeItem(ModToolMaterials.ENDIUM, -4, 0.0f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_SHOVEL = registerItem("endium_shovel",
            new ShovelItem(ModToolMaterials.ENDIUM, 1.5f, -3.0f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_PICKAXE = registerItem("endium_pickaxe",
            new ModPickaxeItem(ModToolMaterials.ENDIUM, 1, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_TRIDENT = registerItem("endium_trident",
            new ModTridentItem(new Item.Settings().maxDamage(388).group(ModItemGroup.ENDIUM)));
    // Endium Armor
    public static final Item ENDIUM_HELMET = registerItem("endium_helmet",
            new ModArmorItem(ModArmorMaterials.ENDIUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_CHESTPLATE = registerItem("endium_chestplate",
            new ModArmorItem(ModArmorMaterials.ENDIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_LEGGINGS = registerItem("endium_leggings",
            new ModArmorItem(ModArmorMaterials.ENDIUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_BOOTS = registerItem("endium_boots",
            new ModArmorItem(ModArmorMaterials.ENDIUM, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item ENDIUM_ELYTRA = registerItem("endium_elytra",
            new ModElytraItem(new FabricItemSettings().maxDamage(281).group(ModItemGroup.ENDIUM).rarity(Rarity.UNCOMMON)));
    // Chromium Items
    public static final Item CHROMIUM_INGOT = registerItem("chromium_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item RAW_CHROMIUM = registerItem("raw_chromium",
            new Item(new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    // Chromium Tools
    public static final Item CHROMIUM_SWORD = registerItem("chromium_sword",
            new SwordItem(ModToolMaterials.CHROMIUM, 3, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item CHROMIUM_AXE = registerItem("chromium_axe",
            new ModAxeItem(ModToolMaterials.CHROMIUM, 6, -3.1f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item CHROMIUM_HOE = registerItem("chromium_hoe",
            new ModHoeItem(ModToolMaterials.CHROMIUM, -2, -1.0f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item CHROMIUM_SHOVEL = registerItem("chromium_shovel",
            new ShovelItem(ModToolMaterials.CHROMIUM, 1.5f, -3.0f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item CHROMIUM_PICKAXE = registerItem("chromium_pickaxe",
            new ModPickaxeItem(ModToolMaterials.CHROMIUM, 1, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item CHROMIUM_SHIELD =
            new ModShieldItem(new FabricItemSettings().maxDamage(1867).group(ModItemGroup.ENDIUM), 100, 16, ModItems.CHROMIUM_INGOT);


    // Chromium Armor
    public static final Item CHROMIUM_HELMET = registerItem("chromium_helmet",
            new ArmorItem(ModArmorMaterials.CHROMIUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item CHROMIUM_CHESTPLATE = registerItem("chromium_chestplate",
            new ArmorItem(ModArmorMaterials.CHROMIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item CHROMIUM_LEGGINGS = registerItem("chromium_leggings",
            new ArmorItem(ModArmorMaterials.CHROMIUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));
    public static final Item CHROMIUM_BOOTS = registerItem("chromium_boots",
            new ArmorItem(ModArmorMaterials.CHROMIUM, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ENDIUM)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EndiumMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EndiumMod.LOGGER.info("Registering Mod Items for " + EndiumMod.MOD_ID);
    }
}
