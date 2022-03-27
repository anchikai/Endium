package net.anchikai.endium.item.custom;

import net.anchikai.endium.misc.EndiumTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasEndiumArmorOn(player)) {
                    player.setNoGravity(player.isSneaking());
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasEndiumArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);
        return (boots.isIn(EndiumTag.ENDIUM_ITEM) && leggings.isIn(EndiumTag.ENDIUM_ITEM)) ||
                (boots.isIn(EndiumTag.ENDIUM_ITEM) && chestplate.isIn(EndiumTag.ENDIUM_ITEM)) ||
                (boots.isIn(EndiumTag.ENDIUM_ITEM) && helmet.isIn(EndiumTag.ENDIUM_ITEM)) ||
                (leggings.isIn(EndiumTag.ENDIUM_ITEM) && chestplate.isIn(EndiumTag.ENDIUM_ITEM)) ||
                (leggings.isIn(EndiumTag.ENDIUM_ITEM) && helmet.isIn(EndiumTag.ENDIUM_ITEM)) ||
                (chestplate.isIn(EndiumTag.ENDIUM_ITEM) && helmet.isIn(EndiumTag.ENDIUM_ITEM));
    }
}