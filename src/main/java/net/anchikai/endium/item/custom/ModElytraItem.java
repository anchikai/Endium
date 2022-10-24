package net.anchikai.endium.item.custom;

import net.anchikai.endium.item.ModArmorMaterials;
import net.anchikai.endium.item.ModToolMaterials;
import net.anchikai.endium.misc.EndiumTag;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ModElytraItem extends ElytraItem implements FabricElytraItem {
    public ModElytraItem(Settings settings) {
        super(settings);
    }

    public EquipmentSlot getSlotType() {
        return EquipmentSlot.CHEST;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasEndiumElytraOn(player)) {
                    if(player.isFallFlying()) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1, 0));
                    }
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasEndiumElytraOn(PlayerEntity player) {
        ItemStack elytra = player.getInventory().getArmorStack(2);
        return elytra.isIn(EndiumTag.ENDIUM_ELYTRA) || elytra.isIn(EndiumTag.CULMINITE_ELYTRA);
    }


    @Override
    public int getEnchantability() {
        return ModArmorMaterials.ENDIUM.getEnchantability();
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ModToolMaterials.ENDIUM.getRepairIngredient().test(ingredient);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        EquipmentSlot equipmentSlot = getSlotType();
        ItemStack itemStack2 = user.getEquippedStack(equipmentSlot);
        if (itemStack2.isEmpty()) {
            user.equipStack(equipmentSlot, itemStack.copy());
            itemStack.setCount(0);
            return TypedActionResult.success(itemStack);
        } else {
            return TypedActionResult.fail(itemStack);
        }
    }
}