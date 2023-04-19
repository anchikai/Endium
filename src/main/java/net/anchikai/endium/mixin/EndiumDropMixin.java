package net.anchikai.endium.mixin;

import net.anchikai.endium.misc.EndiumModTags;
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
public abstract class EndiumDropMixin extends Entity {

    @Shadow
    public abstract ItemStack getStack();

    protected EndiumDropMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void dropItem(CallbackInfo info) {
        // If endium item entity has gravity, turn it off
        if (!hasNoGravity() && !world.isClient && !getStack().isEmpty()
                && (getStack().isIn(EndiumModTags.ENDIUM_ITEM))) {
            setNoGravity(true);
        }
        // Slow down endium item y velocity (to stop vertical spread)
        if ((getStack().isIn(EndiumModTags.ENDIUM_ITEM))) {
            this.setVelocity(this.getVelocity().multiply(1.0D, 0.96D, 1.0D));
        }
    }
}