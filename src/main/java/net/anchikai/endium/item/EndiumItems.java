package net.anchikai.endium.item;

import net.anchikai.endium.EndiumMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

import static net.anchikai.endium.item.ModItems.addToItemGroup;
import static net.anchikai.endium.item.ModItems.registerItem;

public class EndiumItems {
    public static final Item ENDIUM_SHOVEL = registerItem("endium_shovel",
            new ShovelItem(ModToolMaterials.ENDIUM, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item ENDIUM_PICKAXE = registerItem("endium_pickaxe",
            new PickaxeItem(ModToolMaterials.ENDIUM, 1, -2.8f, new FabricItemSettings()));
    public static final Item ENDIUM_AXE = registerItem("endium_axe",
            new AxeItem(ModToolMaterials.ENDIUM, 5.0f, -3.0f, new FabricItemSettings()));
    public static final Item ENDIUM_HOE = registerItem("endium_hoe",
            new HoeItem(ModToolMaterials.ENDIUM, -4, 0.0f, new FabricItemSettings()));
    public static final Item ENDIUM_SWORD = registerItem("endium_sword",
            new SwordItem(ModToolMaterials.ENDIUM, 3, -2.4f, new FabricItemSettings()));
    public static final Item ENDIUM_TRIDENT = registerItem("endium_trident",
            new EndiumTridentItem(new FabricItemSettings().maxDamage(388)));

    public static final Item ENDIUM_HELMET = registerItem("endium_helmet",
            new EndiumArmorItem(EndiumArmorMaterials.ENDIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ENDIUM_CHESTPLATE = registerItem("endium_chestplate",
            new EndiumArmorItem(EndiumArmorMaterials.ENDIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ENDIUM_LEGGINGS = registerItem("endium_leggings",
            new EndiumArmorItem(EndiumArmorMaterials.ENDIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ENDIUM_BOOTS = registerItem("endium_boots",
            new EndiumArmorItem(EndiumArmorMaterials.ENDIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item ENDIUM_ELYTRA = registerItem("endium_elytra",
            new EndiumElytraItem(new FabricItemSettings().maxDamage(281).rarity(Rarity.UNCOMMON)));

    public static final Item RAW_ENDIUM = registerItem("raw_endium",
            new Item(new FabricItemSettings()));
    public static final Item ENDIUM_SCRAP = registerItem("endium_scrap",
            new Item(new FabricItemSettings()));
    public static final Item ENDIUM_INGOT = registerItem("endium_ingot",
            new Item(new FabricItemSettings()));
    public static final Item ECHOPEARL = registerItem("echopearl",
            new EchoPearlItem(new FabricItemSettings().maxCount(16)));


    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_SHOVEL);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_PICKAXE);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_AXE);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_HOE);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_SWORD);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_TRIDENT);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_HELMET);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_CHESTPLATE);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_LEGGINGS);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_BOOTS);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_ELYTRA);
        addToItemGroup(ModItemGroup.ENDIUM, RAW_ENDIUM);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_SCRAP);
        addToItemGroup(ModItemGroup.ENDIUM, ENDIUM_INGOT);
        addToItemGroup(ModItemGroup.ENDIUM, ECHOPEARL);
    }

    public static void register() {
        EndiumMod.LOGGER.info("Registering EndiumItems for " + EndiumMod.MOD_ID);

        addItemsToItemGroup();
    }
}