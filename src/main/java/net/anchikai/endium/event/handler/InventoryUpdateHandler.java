package net.anchikai.endium.event.handler;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.anchikai.endium.enchantment.ModEnchantments;
import net.anchikai.endium.event.callback.InventoryUpdateCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class InventoryUpdateHandler implements InventoryUpdateCallback {
    PlayerEntity player;
    boolean reachActive = false;

    public ActionResult interact(PlayerInventory inventory) {
        player = inventory.player;
        World world = inventory.player.world;
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);

        if (!world.isClient) {
            if (chestplate.isEmpty()) {
                SetReach(false);
                reachActive = false;
            } else if (reachActive != chestplate.hasEnchantments() && EnchantmentHelper.getLevel(ModEnchantments.REACH, chestplate) > 0) {
                SetReach(chestplate.hasEnchantments() && EnchantmentHelper.getLevel(ModEnchantments.REACH, chestplate) > 0);
                reachActive = chestplate.hasEnchantments() && EnchantmentHelper.getLevel(ModEnchantments.REACH, chestplate) > 0;
            }
        }
        return ActionResult.PASS;
    }

    public void SetReach(boolean changeReach) {
        if (changeReach) {
            ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
            player.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(EnchantmentHelper.getLevel(ModEnchantments.REACH, chestplate));
            player.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(EnchantmentHelper.getLevel(ModEnchantments.REACH, chestplate));
        } else {
            player.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(0.0);
            player.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(0.0);
        }
    }
}