package net.anchikai.endium.item;

import net.anchikai.endium.EndiumMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;

import static net.anchikai.endium.item.ModItems.addToItemGroup;
import static net.anchikai.endium.item.ModItems.registerItem;

public class ChromiumItems {
    public static final Item CHROMIUM_SHOVEL = registerItem("chromium_shovel",
            new ShovelItem(ModToolMaterials.CHROMIUM, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item CHROMIUM_PICKAXE = registerItem("chromium_pickaxe",
            new PickaxeItem(ModToolMaterials.CHROMIUM, 1, -2.8f, new FabricItemSettings()));
    public static final Item CHROMIUM_AXE = registerItem("chromium_axe",
            new AxeItem(ModToolMaterials.CHROMIUM, 6.0f, -3.1f, new FabricItemSettings()));
    public static final Item CHROMIUM_HOE = registerItem("chromium_hoe",
            new HoeItem(ModToolMaterials.CHROMIUM, -2, -1.0f, new FabricItemSettings()));
    public static final Item CHROMIUM_SWORD = registerItem("chromium_sword",
            new SwordItem(ModToolMaterials.CHROMIUM, 3, -2.4f, new FabricItemSettings()));
    public static final Item CHROMIUM_SHIELD = registerItem("chromium_shield",
            new ShieldItem(new FabricItemSettings().maxDamage(1867)));

    public static final Item CHROMIUM_HELMET = registerItem("chromium_helmet",
            new EndiumArmorItem(ChromiumArmorMaterials.CHROMIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item CHROMIUM_CHESTPLATE = registerItem("chromium_chestplate",
            new EndiumArmorItem(ChromiumArmorMaterials.CHROMIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item CHROMIUM_LEGGINGS = registerItem("chromium_leggings",
            new EndiumArmorItem(ChromiumArmorMaterials.CHROMIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item CHROMIUM_BOOTS = registerItem("chromium_boots",
            new EndiumArmorItem(ChromiumArmorMaterials.CHROMIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item RAW_CHROMIUM = registerItem("raw_chromium",
            new Item(new FabricItemSettings()));
    public static final Item CHROMIUM_INGOT = registerItem("chromium_ingot",
            new Item(new FabricItemSettings()));


    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_SHOVEL);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_PICKAXE);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_AXE);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_HOE);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_SWORD);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_SHIELD);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_HELMET);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_CHESTPLATE);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_LEGGINGS);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_BOOTS);
        addToItemGroup(ModItemGroup.ENDIUM, RAW_CHROMIUM);
        addToItemGroup(ModItemGroup.ENDIUM, CHROMIUM_INGOT);
    }

    public static void register() {
        EndiumMod.LOGGER.info("Registering ChromiumItems for " + EndiumMod.MOD_ID);

        addItemsToItemGroup();
    }
}