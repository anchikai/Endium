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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class InventoryUpdateHandler implements InventoryUpdateCallback {
    PlayerEntity player;
    boolean reachActive = false;
    boolean stasisActive = false;
    Vec3d playerPosition;

    public ActionResult interact(PlayerInventory inventory) {
        player = inventory.player;
        World world = inventory.player.world;
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);

        if (!world.isClient) {
            // Reach Enchantment
            if (chestplate.isEmpty()) {
                SetReach(false);
                reachActive = false;
            } else if (reachActive != chestplate.hasEnchantments() && EnchantmentHelper.getLevel(ModEnchantments.REACH, chestplate) > 0) {
                SetReach(chestplate.hasEnchantments() && EnchantmentHelper.getLevel(ModEnchantments.REACH, chestplate) > 0);
                reachActive = chestplate.hasEnchantments() && EnchantmentHelper.getLevel(ModEnchantments.REACH, chestplate) > 0;
            }

            // Stasis Enchantment
            if (!player.isSneaking()) {
                playerPosition = player.getPos();
                stasisActive = false;
            } else if (stasisActive != chestplate.hasEnchantments() && EnchantmentHelper.getLevel(ModEnchantments.STASIS, chestplate) > 0 && player.isFallFlying() && player.isSneaking()) {
                stasisActive = chestplate.hasEnchantments() && EnchantmentHelper.getLevel(ModEnchantments.STASIS, chestplate) > 0;
            }
            if (stasisActive) {
                player.teleport(playerPosition.x, playerPosition.y, playerPosition.z);
            }
        }
        return ActionResult.PASS;
    }

    // Reach Enchantment
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