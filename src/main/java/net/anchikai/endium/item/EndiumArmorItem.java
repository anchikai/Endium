package net.anchikai.endium.item;

import net.anchikai.endium.misc.EndiumModTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class EndiumArmorItem extends ArmorItem {

    public EndiumArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;
            if (getEndiumArmorCount(player) >= 2) {
                player.setNoGravity(player.isSneaking());
            }
        }
    }

    private int getEndiumArmorCount(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return (boots.isIn(EndiumModTags.ENDIUM_ITEM) ? 1 : 0) +
                (leggings.isIn(EndiumModTags.ENDIUM_ITEM) ? 1 : 0) +
                (chestplate.isIn(EndiumModTags.ENDIUM_ITEM) ? 1 : 0) +
                (helmet.isIn(EndiumModTags.ENDIUM_ITEM) ? 1 : 0);
    }
}