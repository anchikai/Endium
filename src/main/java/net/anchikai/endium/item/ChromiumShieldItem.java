package net.anchikai.endium.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.world.World;

public class ChromiumShieldItem extends ShieldItem {
    public ChromiumShieldItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                player.setNoGravity(isChromiumShield(player) && player.isBlocking());
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean isChromiumShield(PlayerEntity player) {
        ItemStack currenthand = player.getInventory().getMainHandStack();
        ItemStack offhand = player.getInventory().offHand.get(0);
        return currenthand.isOf(ChromiumItems.CHROMIUM_SHIELD) || offhand.isOf(ChromiumItems.CHROMIUM_SHIELD);
    }
}