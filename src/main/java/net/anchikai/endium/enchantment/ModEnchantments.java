package net.anchikai.endium.enchantment;

import net.anchikai.endium.EndiumMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static Enchantment REACH = register("reach", new ReachEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEARABLE, EquipmentSlot.CHEST));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(EndiumMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + EndiumMod.MOD_ID);
    }
}