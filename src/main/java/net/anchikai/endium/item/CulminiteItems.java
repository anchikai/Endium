package net.anchikai.endium.item;

import net.anchikai.endium.EndiumMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

import static net.anchikai.endium.item.ModItems.addToItemGroup;
import static net.anchikai.endium.item.ModItems.registerItem;

public class CulminiteItems {
    public static final Item CULMINITE_SHOVEL = registerItem("culminite_shovel",
            new ShovelItem(ModToolMaterials.CULMINITE, 1.5f, -3.0f, new FabricItemSettings().fireproof()));
    public static final Item CULMINITE_PICKAXE = registerItem("culminite_pickaxe",
            new PickaxeItem(ModToolMaterials.CULMINITE, 1, -2.8f, new FabricItemSettings().fireproof()));
    public static final Item CULMINITE_AXE = registerItem("culminite_axe",
            new AxeItem(ModToolMaterials.CULMINITE, 5.0f, -3.0f, new FabricItemSettings().fireproof()));
    public static final Item CULMINITE_HOE = registerItem("culminite_hoe",
            new HoeItem(ModToolMaterials.CULMINITE, -4, 0.0f, new FabricItemSettings().fireproof()));
    public static final Item CULMINITE_SWORD = registerItem("culminite_sword",
            new SwordItem(ModToolMaterials.CULMINITE, 3, -2.4f, new FabricItemSettings().fireproof()));

    public static final Item CULMINITE_HELMET = registerItem("culminite_helmet",
            new EndiumArmorItem(CulminiteArmorMaterials.CULMINITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item CULMINITE_CHESTPLATE = registerItem("culminite_chestplate",
            new EndiumArmorItem(CulminiteArmorMaterials.CULMINITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item CULMINITE_LEGGINGS = registerItem("culminite_leggings",
            new EndiumArmorItem(CulminiteArmorMaterials.CULMINITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item CULMINITE_BOOTS = registerItem("culminite_boots",
            new EndiumArmorItem(CulminiteArmorMaterials.CULMINITE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item CULMINITE_ELYTRA = registerItem("culminite_elytra",
            new EndiumElytraItem(new FabricItemSettings().maxDamage(484).fireproof().rarity(Rarity.RARE)));

    public static final Item CULMINITE_INGOT = registerItem("culminite_ingot",
            new Item(new FabricItemSettings().fireproof()));


    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_SHOVEL);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_PICKAXE);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_AXE);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_HOE);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_SWORD);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_HELMET);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_CHESTPLATE);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_LEGGINGS);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_BOOTS);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_ELYTRA);
        addToItemGroup(ModItemGroup.ENDIUM, CULMINITE_INGOT);
    }

    public static void register() {
        EndiumMod.LOGGER.info("Registering CulminiteItems for " + EndiumMod.MOD_ID);

        addItemsToItemGroup();
    }
}