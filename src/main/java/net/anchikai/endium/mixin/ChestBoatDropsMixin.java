package net.anchikai.endium.mixin;


import net.anchikai.endium.item.ModItems;
import net.anchikai.endium.util.CustomBoatType;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBoatEntity.class)
public class ChestBoatDropsMixin {
    @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
    public void asItem(CallbackInfoReturnable<Item> ci) {
        if (((ChestBoatEntity) (Object) this).getBoatType() == CustomBoatType.AMARANTH) {
            ci.setReturnValue(ModItems.AMARANTH_CHEST_BOAT);
            ci.cancel();
        }
    }
}