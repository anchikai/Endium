package net.anchikai.endium.enchantment;

import net.anchikai.endium.EndiumMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static Enchantment REACH = register("reach", new ReachEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEARABLE, EquipmentSlot.CHEST));
    public static Enchantment STASIS = register("stasis", new StasisEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEARABLE, EquipmentSlot.CHEST));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(EndiumMod.MOD_ID, name), enchantment);
    }

    public static void register() {
        System.out.println("Registering Enchantments for " + EndiumMod.MOD_ID);
    }
}