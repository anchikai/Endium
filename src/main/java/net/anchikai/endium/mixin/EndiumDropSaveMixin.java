package net.anchikai.endium.mixin;

import net.anchikai.endium.misc.EndiumTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class EndiumDropSaveMixin extends Entity {

    @Shadow
    public abstract ItemStack getStack();

    protected EndiumDropSaveMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void damageItem(CallbackInfo info) {
        // Items in the void will be teleported up
        if (this.getY() < this.world.getBottomY()) {
            if (getStack().isIn(EndiumTag.ENDIUM_ITEM)) {
                this.unsetRemoved();
                this.requestTeleport(this.getX(), this.world.getBottomY()+1, this.getZ());
                this.setVelocity(0, 0, 0);
                this.setNoGravity(true);
            }
        }
    }
}