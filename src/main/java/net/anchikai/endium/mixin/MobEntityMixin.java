package net.anchikai.endium.mixin;

import net.anchikai.endium.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class MobEntityMixin {

    @Inject(at = @At("HEAD"), method = "getPreferredEquipmentSlot", cancellable = true)
    private static void addPrefered(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> info) {
        Item item = stack.getItem();
        if (item == ModItems.ENDIUM_ELYTRA) {
            info.setReturnValue(EquipmentSlot.CHEST);
        }
    }
}