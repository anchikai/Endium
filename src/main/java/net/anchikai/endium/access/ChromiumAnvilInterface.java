package net.anchikai.endium.access;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface ChromiumAnvilInterface {
    //    @Inject(method = "updateResult()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/Property;set(I)V", shift = At.Shift.AFTER))
    void updateResult(CallbackInfo info);

    void setChromiumAnvil(String string);
}