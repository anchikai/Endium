package net.anchikai.endium.item.custom;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import net.anchikai.endium.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModShieldItem extends FabricBannerShieldItem {
    public ModShieldItem(Settings settings, int cooldownTicks, int enchantability, Item... repairItems) {
        super(settings, cooldownTicks, enchantability, repairItems);
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
        return currenthand.isOf(ModItems.CHROMIUM_SHIELD) || offhand.isOf(ModItems.CHROMIUM_SHIELD);
    }
}