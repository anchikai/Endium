package net.anchikai.endium.mixin;

import net.anchikai.endium.entity.ModEntities;
import net.anchikai.endium.item.AmaranthItems;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatEntity.class)
public abstract class AmaranthBoatEntityMixin {

    @Shadow
    public abstract BoatEntity.Type getVariant();

    @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
    private void thisIsNotAnOakBoat(CallbackInfoReturnable<Item> cir) {
        if (this.getVariant() != ModEntities.AMARANTH_BOAT) return;
        cir.setReturnValue(AmaranthItems.AMARANTH_BOAT);
    }
}