package net.anchikai.endium.mixin;

import net.anchikai.endium.entity.ModEntities;
import net.anchikai.endium.item.AmaranthItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBoatEntity.class)
public abstract class AmaranthChestBoatEntityMixin extends BoatEntity {

    public AmaranthChestBoatEntityMixin(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
    private void thisIsNotAnOakBoat(CallbackInfoReturnable<Item> cir) {
        if (this.getVariant() != ModEntities.AMARANTH_BOAT) return;
        cir.setReturnValue(AmaranthItems.AMARANTH_CHEST_BOAT);
    }
}