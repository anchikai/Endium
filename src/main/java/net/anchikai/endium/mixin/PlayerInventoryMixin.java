package net.anchikai.endium.mixin;

import net.anchikai.endium.event.callback.InventoryUpdateCallback;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
    @Inject(at = @At(value = "INVOKE"), method = "updateItems", cancellable = true)
    public void updateItems(CallbackInfo info) {
        ActionResult result = InventoryUpdateCallback.EVENT.invoker().interact((PlayerInventory)(Object)this);
        if(result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}