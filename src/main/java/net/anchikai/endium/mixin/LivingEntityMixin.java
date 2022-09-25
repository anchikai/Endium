package net.anchikai.endium.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends EntityMixin {
    private @Nullable Consumer<ItemStack> endium$dropSink;

    @Inject(method = "drop", at = @At("RETURN"))
    private void endDrop(DamageSource source, CallbackInfo ci) {
        this.endium$dropSink = null;
    }

    @Override
    protected void endium$dropStack(ItemStack stack, float yOffset, CallbackInfoReturnable<ItemEntity> cir) {
        if (this.endium$dropSink != null) {
            this.endium$dropSink.accept(stack);
            cir.setReturnValue(null);
        }
    }
}